package com.api.development.entity;

import com.api.development.enums.GenderType;
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

  @Column(nullable = false, unique = true)
  private String firstName;

  @Column
  private String middleName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private String academicDetails;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false, unique = true)
  private String contactNumber;

  @Column(nullable = false)
  private GenderType gender;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private Integer age;

  @Column(nullable = false)
  private Boolean isActive;
}
