package com.tampro.dsggraphql01.processor;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.exception.ApplicationException;
import com.tampro.dsggraphql01.model.APIResponse;
import com.tampro.dsggraphql01.model.response.StudentResponse;
import com.tampro.dsggraphql01.request.CreateStudentRequest;
import com.tampro.dsggraphql01.request.UpdateStudentRequest;
import com.tampro.dsggraphql01.response.APIStatus;
import com.tampro.dsggraphql01.service.StudentService;
import com.tampro.dsggraphql01.utils.ResponseUtil;

@DgsComponent
public class Mutation {

	@Autowired
	StudentService studentService;
	
	
	private static final Logger log = LoggerFactory.getLogger(Mutation.class);

	
	@DgsMutation
	public APIResponse createStudent(@InputArgument(value = "csr") CreateStudentRequest csr) throws Exception {
		boolean checkEmailExist = studentService.emailIsExists(csr.getEmail());
		if(checkEmailExist) {
			log.error("student email conflict {}", csr.getEmail());
			throw new ApplicationException(APIStatus.ERR_STUDENT_EMAIL_CONFLICT);
		}
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
	
	@DgsData(field = "updateStudent", parentType = "Mutation")
	public APIResponse updateStudent(@InputArgument("usr") UpdateStudentRequest usr) throws Exception {
		try {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			Student student = studentService.findById(usr.getId());
			
			if(usr.getAddress() != null) {
				student.setAddress(usr.getAddress());
			}
			if(usr.getCodeStudent() != null) {
				student.setCodeStudent(usr.getCodeStudent());
			}
			if(usr.getEmail() != null) {
				student.setEmail(usr.getEmail());
			}
			if(usr.getName() != null) {
				student.setName(usr.getName());
			}
			 
			Student studentUpdated = studentService.saveStudent(student);
			
			StudentResponse response = modelMapper.map(studentUpdated, StudentResponse.class);
			
			return ResponseUtil.buildResponse(APIStatus.SUCCESS_UPDATE_STUDENT, response);
		} catch (Exception e) {
			throw new Exception("update failed");
		}
	}
	
	@DgsData(field = "deleteStudent"	, parentType = "Mutation")
	//@DgsEnableDataFetcherInstrumentation(false)
	public APIResponse deleteStudent(@InputArgument("id") int id) throws Exception {
		try {
			Student student = studentService.findById(id);
			
			studentService.deleteStudent(student);
			
			return ResponseUtil.buildResponse(APIStatus.SUCCESS_DELETE_STUDENT, null);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("delete failed");
	 
		}
	}
	
}
