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

import static com.api.development.enums.StatusMsg.*;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public ResponseEntity<Object> getPersonalData(final Long studentId) {
    Optional<Student> studentOptional = studentRepository.findById(studentId);
    if (!studentOptional.isPresent()) {
      return ResponseHandler.generateResponse(
          STUDENT_NOT_PRESENT.getMsg(), HttpStatus.NOT_FOUND, null);
    }
    return ResponseHandler.generateResponse(
        DATA_FETCHED_SUCCESS.getMsg(), HttpStatus.OK, studentOptional);
  }

  @Transactional
  public ResponseEntity<Object> modifyPersonalInfo(
      final Long studentId,
      final String firstName,
      final String lastName,
      final String contactNumber,
      final String email) {
    int counter = 0;
    Student studentData = studentRepository.findByIdAndEmail(studentId, email);
    if (studentData == null) {
      return ResponseHandler.generateResponse(
          STUDENT_NOT_PRESENT.getMsg(), HttpStatus.NOT_FOUND, null);
    }
    if (firstName != null
        && firstName.length() > 0
        && !Objects.equals(studentData.getFirstName(), firstName)) {
      studentData.setFirstName(firstName);
      counter++;
    }
    if (lastName != null
        && lastName.length() > 0
        && !Objects.equals(studentData.getLastName(), lastName)) {
      studentData.setLastName(lastName);
      counter++;
    }
    if (contactNumber != null
        && contactNumber.length() > 0
        && !Objects.equals(studentData.getContactNumber(), contactNumber)) {
      studentData.setContactNumber(contactNumber);
      counter++;
    }
    if (email != null && email.length() > 0 && !Objects.equals(studentData.getEmail(), email)) {
      Optional<Student> studentOptional = studentRepository.findByEmail(email);
      if (studentOptional.isPresent()) {
        return ResponseHandler.generateResponse(
            EMAIL_ALREADY_TAKEN.getMsg(), HttpStatus.BAD_REQUEST, null);
      }
      studentData.setEmail(email);
      counter++;
    }
    if (counter == 0)
      return ResponseHandler.generateResponse(
          NOTHING_TO_UPDATE.getMsg(), HttpStatus.BAD_REQUEST, null);
    else
      return ResponseHandler.generateResponse(
          UPDATE_SUCCESS.getMsg(), HttpStatus.CREATED, studentData);
  }

  public ResponseEntity<Object> getAcademicData(final Long studentId, final String email) {
    Student studentData = studentRepository.findByIdAndEmail(studentId, email);
    if (studentData == null || studentData.getAcademicDetails() == null) {
      return ResponseHandler.generateResponse(
          STUDENT_NOT_PRESENT.getMsg(), HttpStatus.NOT_FOUND, null);
    }
    return ResponseHandler.generateResponse(
        DATA_FETCHED_SUCCESS.getMsg(), HttpStatus.OK, studentData.getAcademicDetails());
  }
}
