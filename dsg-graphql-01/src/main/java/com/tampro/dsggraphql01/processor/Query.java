package com.tampro.dsggraphql01.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.service.StudentService;

@DgsComponent
public class Query {
	
	@Autowired
	private StudentService studentService;
	
	@DgsQuery
	public List<Student> getStudentAll(){
		return studentService.getAll();
	}

}
