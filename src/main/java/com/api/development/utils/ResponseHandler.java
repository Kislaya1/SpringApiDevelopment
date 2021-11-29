package com.api.development.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(
      final boolean success,
      final String statusMessage,
      final String message,
      final Object responseObj,
      final HttpStatus statusCode) {
    LinkedHashMap<String, Object> map =
        new LinkedHashMap<String, Object>() {
          {
            put("success", success);
            put("statusMessage", statusMessage);
            put("message", message);
            put("data", responseObj);
            put("status", statusCode);
          }
        };
    return new ResponseEntity<Object>(map, statusCode);
  }
}
