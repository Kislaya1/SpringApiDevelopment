package com.api.development.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMsg {
  STUDENT_NOT_PRESENT("Student data not present. Please contact your admin"),
  DATA_FETCHED_SUCCESS("Data successfully fetched"),
  EMAIL_ALREADY_TAKEN("Email is already taken. Please use different email id"),
  SQL_ERROR("Duplicate Entry for either Contact Number, Email or First Name"),
  NOTHING_TO_UPDATE("Nothing to update. Please provide different values."),
  UPDATE_SUCCESS("Successfully updated !"),
  CREATED_STUDENT_SUCCESS("Student data created successfully!"),
  DATA_NOT_PRESENT("Student data not present for the operation."),
  DELETE_SUCCESS("Successfully deleted student Id : "),
  DELETE_FAILURE("Can not delete the entry ! Student is In-Active."),
  FAILED_REQUEST("Please check your request");
  private String msg;
}
