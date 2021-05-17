package com.tampro.dsggraphql01.processor;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.model.APIResponse;
import com.tampro.dsggraphql01.model.response.StudentResponse;
import com.tampro.dsggraphql01.request.CreateStudentRequest;
import com.tampro.dsggraphql01.response.APIStatus;
import com.tampro.dsggraphql01.service.StudentService;
import com.tampro.dsggraphql01.utils.ResponseUtil;

@DgsComponent
public class Mutation {

	@Autowired
	StudentService studentService;
	
	@DgsMutation
	public APIResponse createStudent(@InputArgument(value = "csr") CreateStudentRequest csr) throws Exception {
		try {
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			Student student = mapper.map(csr, Student.class);
		
			Student studentSaved = studentService.saveStudent(student);
			
			StudentResponse studentResponse = mapper.map(studentSaved, StudentResponse.class);
//			return ResponseUtil.responseSuccess("tc");
			//return "success";
			return ResponseUtil.buildResponse(APIStatus.SUCCESS_CREATE_STUDENT, studentResponse);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("create failed");
		}
	}
	
}
