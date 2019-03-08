package com.cet.ibscloud.demo.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cet.ibscloud.ibsdao.business.model.Student;
import com.cet.ibscloud.ibsutil.LogUtil;

public interface StudentsService {
	
	Student getStudents(int id); 

	Student getStudents2(@RequestParam(defaultValue = "1") int id); 
	
	int insertStudent(@RequestBody Student student); 

	int deleteStudent(@RequestBody Integer[] ids) throws Exception; 

}
