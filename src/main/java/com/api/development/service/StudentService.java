package com.api.development.service;

import com.api.development.entity.Student;
import com.api.development.repository.StudentRepository;
import com.api.development.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

import static com.api.development.enums.ResponseMsg.*;
import static com.api.development.enums.StatusMsg.*;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public ResponseEntity<Object> getPersonalData(final long studentId) {
    Optional<Student> studentOptional = studentRepository.findById(studentId);
    if (!studentOptional.isPresent()) {
      return ResponseHandler.generateResponse(
          false, NOT_FOUND.getMsg(), STUDENT_NOT_PRESENT.getMsg(), null, HttpStatus.NOT_FOUND);
    }
    return ResponseHandler.generateResponse(
        true, SUCCESS.getMsg(), DATA_FETCHED_SUCCESS.getMsg(), studentOptional, HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<Object> modifyPersonalData(
      final long studentId,
      final String firstName,
      final String lastName,
      final String contactNumber,
      final String email) {
    int counter = 0;
    Optional<Student> studentData = studentRepository.findById(studentId);
    Student student = studentData.get();
    if (Objects.isNull(studentData)) {
      return ResponseHandler.generateResponse(
          false, NOT_FOUND.getMsg(), STUDENT_NOT_PRESENT.getMsg(), null, HttpStatus.NOT_FOUND);
    }
    if (!Objects.isNull(firstName)
        && firstName.length() > 0
        && !Objects.equals(student.getFirstName(), firstName)) {
      student.setFirstName(firstName);
      counter++;
    }
    if (!Objects.isNull(lastName)
        && lastName.length() > 0
        && !Objects.equals(student.getLastName(), lastName)) {
      student.setLastName(lastName);
      counter++;
    }
    if (!Objects.isNull(contactNumber)
        && contactNumber.length() > 0
        && !Objects.equals(student.getContactNumber(), contactNumber)) {
      student.setContactNumber(contactNumber);
      counter++;
    }
    if (!Objects.isNull(email)
        && email.length() > 0
        && !Objects.equals(student.getEmail(), email)) {
      Optional<Student> studentOptional = studentRepository.findByEmail(email);
      if (studentOptional.isPresent()) {
        return ResponseHandler.generateResponse(
            false,
            BAD_REQUEST.getMsg(),
            EMAIL_ALREADY_TAKEN.getMsg(),
            null,
            HttpStatus.BAD_REQUEST);
      }
      student.setEmail(email);
      counter++;
    }
    if (counter == 0)
      return ResponseHandler.generateResponse(
          false, BAD_REQUEST.getMsg(), NOTHING_TO_UPDATE.getMsg(), null, HttpStatus.BAD_REQUEST);
    else
      return ResponseHandler.generateResponse(
          true, CREATED.getMsg(), UPDATE_SUCCESS.getMsg(), student, HttpStatus.CREATED);
  }
}
