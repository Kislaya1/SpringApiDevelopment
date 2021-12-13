package com.api.development.service;

import com.api.development.entity.Student;
import com.api.development.repository.StudentRepository;
import com.api.development.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.api.development.enums.ResponseMsg.*;
import static com.api.development.enums.StatusMsg.*;

@Service
public class AdminService {
  private final StudentRepository studentRepository;

  public AdminService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public ResponseEntity<Object> createStudent(final Student student) {
    Optional<Student> emailStd = studentRepository.findByEmail(student.getEmail());
    Optional<Student> contactNumStd =
        studentRepository.findByContactNumber(student.getContactNumber());
    Optional<Student> firstNameStd = studentRepository.findByFirstName(student.getFirstName());

    try {
      if (emailStd.isPresent() || contactNumStd.isPresent() || firstNameStd.isPresent()) {
        return ResponseHandler.generateResponse(
            false, BAD_REQUEST.getMsg(), SQL_ERROR.getMsg(), null, HttpStatus.BAD_REQUEST);
      }
      studentRepository.save(student);
      return ResponseHandler.generateResponse(
          true, CREATED.getMsg(), CREATED_STUDENT_SUCCESS.getMsg(), student, HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ResponseEntity<Object> getAllStudents() {
    List<Student> studentList = studentRepository.findAll();
    if (studentList.isEmpty()) {
      return ResponseHandler.generateResponse(
          false, NOT_FOUND.getMsg(), DATA_NOT_PRESENT.getMsg(), null, HttpStatus.NOT_FOUND);
    }
    return ResponseHandler.generateResponse(
        true, SUCCESS.getMsg(), DATA_FETCHED_SUCCESS.getMsg(), studentList, HttpStatus.OK);
  }

  public ResponseEntity<Object> getSingleStudent(final long studentId) {
    Optional<Student> studentOptional = studentRepository.findById(studentId);
    if (!studentOptional.isPresent()) {
      return ResponseHandler.generateResponse(
          false, NOT_FOUND.getMsg(), STUDENT_NOT_PRESENT.getMsg(), null, HttpStatus.NOT_FOUND);
    }
    return ResponseHandler.generateResponse(
        true, SUCCESS.getMsg(), DATA_FETCHED_SUCCESS.getMsg(), studentOptional, HttpStatus.OK);
  }

  public ResponseEntity<Object> removeStudent(final long studentId, final String email) {
    Student student = studentRepository.findByIdAndEmail(studentId, email);
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      return ResponseHandler.generateResponse(
          false, NOT_FOUND.getMsg(), DATA_NOT_PRESENT.getMsg(), null, HttpStatus.NOT_FOUND);
    }
    if (!student.getAvailable()) {
      return ResponseHandler.generateResponse(
          false, FORBIDDEN.getMsg(), DELETE_FAILURE.getMsg(), null, HttpStatus.FORBIDDEN);
    }
    studentRepository.deleteById(studentId);
    return ResponseHandler.generateResponse(
        true, SUCCESS.getMsg(), DELETE_SUCCESS.getMsg() + studentId, null, HttpStatus.OK);
  }
}
