package com.tampro.dsggraphql01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tampro.dsggraphql01.entity.Student;
import com.tampro.dsggraphql01.model.request.StudentSearchPagination;
import com.tampro.dsggraphql01.repository.StudentRepository;
import com.tampro.dsggraphql01.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Page<Student> findAll(StudentSearchPagination ssp) {
		// TODO Auto-generated method stub
		PageRequest pageRequest = PageRequest.of(ssp.getCurrentPage() - 1 , ssp.getLimit());
		return studentRepo.findAll(pageRequest);
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepo.delete(student);
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public boolean emailIsExists(String email) {
		// TODO Auto-generated method stub
		return studentRepo.findByEmail(email) != null ? true : false;
	}

}
