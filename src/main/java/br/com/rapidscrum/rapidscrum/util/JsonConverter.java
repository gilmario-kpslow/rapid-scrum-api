/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rapidscrum.rapidscrum.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class JsonConverter {

    private final ObjectMapper objectMapper;

    public JsonConverter() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public <T> List<T> fromJsonList(String json, Class<T> classe) throws IOException {
        if (Objects.isNull(json) || "".equals(json)) {
            return Collections.EMPTY_LIST;
        }
        CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, classe);
        log("fromjsonlist", json);
        return objectMapper.readValue(json, javaType);
    }

    public <T> T fromJson(String json, Class<T> classe) throws IOException {
        if (Objects.isNull(json) || "".equals(json)) {
            return null;
        }
        log("fromjson", json);
        return objectMapper.readValue(json, classe);
    }

    public String toJson(Object o) throws IOException {
        String dados = objectMapper.writeValueAsString(o);
        log("tojson", dados);
        return dados;
    }

    private void log(String metodo, String dados) throws IOException {
//            LocalDateTime local = LocalDateTime.now();
//            String filename = Integer.toString(local.getYear())
//                    .concat(Integer.toString(local.getMonthValue()))
//                    .concat(Integer.toString(local.getDayOfYear()))
//                    .concat(Integer.toString(local.getHour()))
//                    .concat(Integer.toString(local.getMinute()))
//                    .concat(Integer.toString(local.getSecond()))
//                    .concat(Integer.toString(local.getNano()))
//                    .concat(".json");
//            Files.write(Paths.get(".", metodo.concat(filename)), dados.getBytes());
    }
}
