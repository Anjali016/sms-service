package com.marketplaces.www.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;

public class JsonUtil {

  static ObjectMapper objectMapper = new ObjectMapper();

  //    public static<T> String toJson(T input, Class<T> clazz) {
  //        return objectMapper.readValue(input, clazz);
  //    }

  public static String toJson(Object input) {
    try {
      return objectMapper.writeValueAsString(input);
    } catch (JsonProcessingException e) {
      return StringUtil.EMPTY_STRING;
    }
  }
}
