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
  @Column(name = "registration_id")
  private Long id;

  @Column(name = "first_name", columnDefinition = "varchar(255) default '0'", unique = true, nullable = false)
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "contact_number", columnDefinition = "varchar(255) default '0'", unique = true, nullable = false)
  private String contactNumber;

  @Column(name = "current_year")
  private Integer currentYear;

  @Column(name = "current_semester")
  private Integer currentSemester;

  @Column(name = "total_attendance")
  private Integer totalAttendance;

  @Column(name = "marks_obtained")
  private Double marksObtained;

  @Column(name = "percentage")
  private Double percentage;

  @Column(name = "result")
  private ResultType result;

  @Column(name = "gender", nullable = false)
  private GenderType gender;

  @Column(name = "email", columnDefinition = "varchar(255) default '0'", unique = true, nullable = false)
  private String email;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;
}
