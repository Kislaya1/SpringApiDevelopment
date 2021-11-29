package com.api.development.repository;

import com.api.development.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  Student findByIdAndEmail(long id, String email);

  Optional<Student> findByEmail(String email);
}
