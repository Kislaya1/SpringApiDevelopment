package com.api.development.entity;

import com.api.development.enums.GenderType;
import com.api.development.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
  @Id
  @Column(name = "registrationId")
  private Long id;

  @Column(unique = true, nullable = false)
  private String firstName;

  @Column private String middleName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String address;

  @Column(unique = true, nullable = false)
  private String contactNumber;

  @Column private Integer currentYear;

  @Column private Integer currentSemester;

  @Column private Integer totalAttendance;

  @Column private Double marksObtained;

  @Column private Double percentage;

  @Column private ResultType result;

  @Column(nullable = false)
  private GenderType gender;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  private Integer age;

  @Column(nullable = false)
  private Boolean isActive;
}
