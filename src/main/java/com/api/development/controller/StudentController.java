package com.api.development.controller;

import com.api.development.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path = "/record/{studentId}")
  public ResponseEntity<Object> getPersonalData(@PathVariable("studentId") final long studentId) {
    return studentService.getPersonalData(studentId);
  }

  @PutMapping(path = "/record/{studentId}")
  public ResponseEntity<Object> modifyPersonalData(
      @PathVariable("studentId") final long studentId,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String contactNumber,
      @RequestParam(required = false) String email) {
    return studentService.modifyPersonalData(studentId, firstName, lastName, contactNumber, email);
  }
}
