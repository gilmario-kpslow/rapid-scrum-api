package br.com.rapidscrum.core.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author 008647c6
 */
public class GenericUtils {

    public static <M> M queryParaModel(Map<String, String> queryMap, Class<M> classModel) throws Exception {

        Field[] campos = classModel.getDeclaredFields();
        M model = classModel.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, String> parametro : queryMap.entrySet()) {
            if (parametro.getKey().contains(".")) {
                String[] objetoParametro = parametro.getKey().split("\\.");
                Field campo = classModel.getDeclaredField(objetoParametro[0]);

                Object sub = campo.getType().getDeclaredConstructor().newInstance();
                Field subField = campo.getType().getField(objetoParametro[1]);
                Method subMethod = createSetMethod(campo.getType(), subField);

                subMethod.invoke(sub, subField.getType().getConstructor(String.class).newInstance(parametro.getValue()));

                Method metodoSet = createSetMethod(classModel, campo);
                metodoSet.invoke(model, sub);
            }
        }

        for (Field campo : campos) {
            if (queryMap.containsKey(campo.getName())) {
                Method metodo = createSetMethod(classModel, campo);
                if (campo.getType().equals(LocalDate.class)) {
                    metodo.invoke(model, prepareLocalDate(queryMap.get(campo.getName())));
                } else {
                    metodo.invoke(model, campo.getType().getConstructor(String.class).newInstance(queryMap.get(campo.getName())));
                }
            }
        }

        return model;
    }

    private static LocalDate prepareLocalDate(String stringJson) {
        return LocalDate.parse(stringJson, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public static <M> Method createSetMethod(Class<M> classModel, Field field) throws Exception {
        return classModel.getMethod("set".concat(capitalise(field.getName())), field.getType());
    }

    public static String capitalise(String value) {
        if (Objects.isNull(value) || value.length() < 1) {
            return "";
        }
        return value.substring(0, 1).toUpperCase().concat(value.substring(1));
    }

    public static <M, N> Class<M> getClassModel(Class<N> objectsClass) {
        return (Class<M>) ((ParameterizedType) objectsClass.getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
