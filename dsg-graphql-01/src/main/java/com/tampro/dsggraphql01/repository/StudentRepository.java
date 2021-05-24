package com.tampro.dsggraphql01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tampro.dsggraphql01.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByEmail(String email);
}
