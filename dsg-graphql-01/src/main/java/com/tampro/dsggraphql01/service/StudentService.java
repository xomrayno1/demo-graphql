package com.tampro.dsggraphql01.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.model.request.StudentSearchPagination;

public interface StudentService {
	Page<Student> findAll(StudentSearchPagination ssp);
	
	void deleteStudent(Student student);
	
	Student saveStudent(Student student);
	
	List<Student> getAll();
	
	Student findById(long id);
	
	boolean emailIsExists(String email);
}
