package com.film.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.List;
/**
 * Class for Common Util
 */

public class CommonUtil {

    private CommonUtil() {

    }

    public static String convertListToJson(List<?> li) throws IOException {
        final ObjectMapper mapper = new JsonMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(li);
    }

    public static String convertListToXml(List<?> lil) throws JsonProcessingException {
        ObjectMapper mapper = new XmlMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lil);
    }
}
