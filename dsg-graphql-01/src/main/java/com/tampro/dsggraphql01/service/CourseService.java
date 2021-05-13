package com.tampro.dsggraphql01.service;

import org.springframework.data.domain.Page;

import com.tampro.dsggraphql01.entity.Course;
import com.tampro.dsggraphql01.model.request.CourseSearchPagination;

public interface CourseService {

	Page<Course> findAll(CourseSearchPagination courseSearchPagination);
	
	void deleteCourse(Course course);
	
	void saveCourse(Course course);

	
}
