package com.tampro.dsggraphql01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tampro.dsggraphql01.entity.Course;
import com.tampro.dsggraphql01.model.request.CourseSearchPagination;
import com.tampro.dsggraphql01.repository.CourseRepository;
import com.tampro.dsggraphql01.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Page<Course> findAll(CourseSearchPagination courseSearchPagination) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = 
				PageRequest.of(courseSearchPagination.getCurrentPage() - 1, courseSearchPagination.getLimit());
		return courseRepo.findAll(pageRequest);
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.delete(course);
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);
	}

}
