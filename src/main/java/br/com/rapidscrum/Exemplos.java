/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class Exemplos {

    public static void main(String[] args) throws Exception {

        // [ConstraintViolationImpl{interpolatedMessage='Campo Bairro do Sócio/Administrador é obrigatório.', propertyPath=socios[0].bairro, rootBeanClass=class br.gov.ce.sefaz.redesim.dto.RegistroRedesimValidatorDTO, messageTemplate='Campo Bairro do Sócio/Administrador é obrigatório.'}]
        String entrada = "socios[0].bairro";

        System.err.println(entrada.contains("socios"));

//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//
//        System.out.println(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        System.out.println(java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
//        Map<String, String> params = new HashMap<>();
//        params.put("id", "2");
//        params.put("nome", "Nome");
//        params.put("descricao", "Descrição");
//        Modulo modulo = createByParams(Modulo.class, params);
//        System.out.println(modulo.getId());
//        System.out.println(modulo.getNome());
//        System.out.println(modulo.getDescricao());
//        System.out.println(modulo.getSistema());
    }

    public static <T> T createByParams(Class<T> classe, Map<String, String> params) throws InstantiationException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<String, Method> methodField = getMethodFields(classe);
        Object objeto = classe.newInstance();
        for (Map.Entry<String, String> me : params.entrySet()) {
            if (methodField.containsKey(me.getKey())) {
                Method exec = methodField.get(me.getKey());
                Object param = exec.getParameters()[0].getType().getConstructor(String.class).newInstance(me.getValue());
                methodField.get(me.getKey()).invoke(objeto, param);
            }
        }
        return (T) objeto;
    }

    public static Map<String, Method> getMethodFields(Class classe) {
        Map<String, Method> retorno = new HashMap<>();
        Field[] campos = classe.getDeclaredFields();
        Method[] metodos = classe.getMethods();

        for (Field f : campos) {
            for (Method m : metodos) {
                if (m.getName().toLowerCase().equals("set" + f.getName())) {
                    retorno.put(f.getName(), m);
                }
            }
        }
        return retorno;
    }

}
