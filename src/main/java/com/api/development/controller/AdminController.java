package com.api.development.controller;

import com.api.development.entity.Student;
import com.api.development.service.AdminService;
import com.api.development.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.api.development.enums.ResponseMsg.FAILED_REQUEST;
import static com.api.development.enums.StatusMsg.BAD_REQUEST;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {
  private final AdminService adminService;

  @Autowired
  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @PostMapping(path = "/create/student/record")
  public ResponseEntity<Object> createStudent(@RequestBody Student student) {
    if (Objects.isNull(student))
      return ResponseHandler.generateResponse(
          false, BAD_REQUEST.getMsg(), FAILED_REQUEST.getMsg(), null, HttpStatus.BAD_REQUEST);
    else return adminService.createStudent(student);
  }

  @GetMapping(path = "/view/student/records")
  public ResponseEntity<Object> viewAllStudents() {
    return adminService.getAllStudents();
  }

  @GetMapping(path = "/view/student/record/{studentId}")
  public ResponseEntity<Object> viewSingleStudent(@PathVariable("studentId") long studentId) {
    return adminService.getSingleStudent(studentId);
  }

  @DeleteMapping(path = "/remove/student/record/{studentId}")
  public ResponseEntity<Object> deleteStudent(
      @PathVariable("studentId") long studentId, @RequestParam String email) {
    return adminService.removeStudent(studentId, email);
  }
}
