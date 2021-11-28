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
  public ResponseEntity<Object> getPersonalData(@PathVariable("studentId") final Long studentId) {
    return studentService.getPersonalData(studentId);
  }

  @PostMapping(path = "/record/{studentId}")
  public ResponseEntity<Object> modifyPersonalInfo(
      @PathVariable("studentId") final Long studentId,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String contactNumber,
      @RequestParam(required = false) String email) {
    return studentService.modifyPersonalInfo(studentId, firstName, lastName, contactNumber, email);
  }

  @GetMapping(path = "/academic/record/{studentId}")
  public void getPersonalAcademicData(
      @PathVariable("studentId") final Long studentId,
      @RequestParam(required = false) String name,
      @RequestParam String email) {
    studentService.getAcademicData(studentId, email);
  }
}
