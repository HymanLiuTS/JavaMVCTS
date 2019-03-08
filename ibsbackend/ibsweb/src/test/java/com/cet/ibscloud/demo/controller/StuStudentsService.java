package com.cet.ibscloud.demo.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cet.ibscloud.demo.service.StudentsService;
import com.cet.ibscloud.ibsdao.business.model.Student;

@Primary
@Service
public class StuStudentsService implements StudentsService {

	public StuStudentsService() {
		
	}
	@Override
	public Student getStudents(int id) {
		Student student=new Student();
		student.setId(1);
		student.setName("Hyman");
		student.setAge(18);
		return student;
	}

	@Override
	public Student getStudents2(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(Integer[] ids) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
