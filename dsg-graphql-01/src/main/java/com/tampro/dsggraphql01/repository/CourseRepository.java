package com.tampro.dsggraphql01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tampro.dsggraphql01.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
