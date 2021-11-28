package com.api.development.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;

public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(
      final String message, final HttpStatus status, final Object responseObj) {
    LinkedHashMap<String, Object> map =
        new LinkedHashMap<String, Object>() {
          {
            put("message", message);
            put("status", status);
            put("data", responseObj);
          }
        };
    return new ResponseEntity<Object>(map, status);
  }
}
