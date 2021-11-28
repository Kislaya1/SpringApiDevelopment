package com.api.development.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusMsg {
  STUDENT_NOT_PRESENT("Student data not present. Please contact your admin"),
  DATA_FETCHED_SUCCESS("Data successfully fetched"),
  EMAIL_ALREADY_TAKEN("Email is already taken. Please use different email id"),
  NOTHING_TO_UPDATE("Nothing to update. Please provide different values."),
  UPDATE_SUCCESS("Successfully updated !");
  private String msg;
}
