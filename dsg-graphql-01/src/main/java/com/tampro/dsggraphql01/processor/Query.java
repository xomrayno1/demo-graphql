package com.tampro.dsggraphql01.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.exception.StudentNotFoundException;
import com.tampro.dsggraphql01.model.APIResponse;
import com.tampro.dsggraphql01.model.Pagination;
import com.tampro.dsggraphql01.model.request.StudentSearchPagination;
import com.tampro.dsggraphql01.model.response.StudentResponse;
import com.tampro.dsggraphql01.service.StudentService;
import com.tampro.dsggraphql01.utils.ResponseUtil;

import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class Query {
	
	@Autowired
	private StudentService studentService;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	@DgsQuery
	public List<Student> getStudentAll(@InputArgument String name){
		System.out.println(name);
		return studentService.getAll();
	}

	@DgsQuery
	public APIResponse getStudentSearchPagination(@InputArgument("ssp") StudentSearchPagination ssp){
		
		Page<Student> students =	studentService.findAll(ssp);
		
		List<StudentResponse> data =  students.getContent()
					.stream().map(item -> mapper.map(item, StudentResponse.class))
					.collect(Collectors.toList());
		
		Map<String, Object> response = new HashMap<>();
		response.put("data", data);
		response.put("pagination", new Pagination(students.getTotalElements(), students.getNumber() + 1));
		
		return ResponseUtil.responseSuccess(response);
	}
		
	@DgsData(field = "getStudent", parentType = "Query" )
	public StudentResponse getStudent(@InputArgument("id") long id){
		try {
			Student student	=	studentService.findById(id);
			return mapper.map(student, StudentResponse.class);
		} catch (Exception e) {
			throw new StudentNotFoundException("Student not found exception with id : "+ id);
		}
	}
  
	@DgsQuery
	public List<String> loadArray(@InputArgument(collectionType = String.class, value = "loads") List<String> loads) {
		loads.forEach(System.out::println);
		return loads;
	}
	
	

}
