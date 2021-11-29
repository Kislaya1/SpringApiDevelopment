package com.api.development.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusMsg {
  SUCCESS("200 : OK"),
  BAD_REQUEST("400 : Bad Request"),
  FORBIDDEN("403 : Forbidden"),
  NOT_FOUND("404 : Not Found"),
  SERVER_ERROR("500 : Internal Server Error"),
  CREATED("201 : Created");
  private String msg;
}
