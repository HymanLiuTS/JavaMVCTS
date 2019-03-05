package com.cet.ibscloud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cet.ibscloud.demo.domain.Teacher;
import com.cet.ibscloud.ibsdao.business.mapper.StudentMapper;
import com.cet.ibscloud.ibsdao.business.model.Student;
import com.cet.ibscloud.ibsutil.LogUtil;

@Service
public class DemoService {

	@Autowired
	private Teacher teacher;

	@Autowired
	StudentMapper businessStudentMapper;

	@Autowired
	StudentMapper activitiStudentMapper;

	@Autowired
	StudentMapper pecconfigStudentMapper;

	@Autowired
	StudentMapper pecdataStudentMapper;

	public Student getStudents(@PathVariable int id) {
		Student student = businessStudentMapper.selectByPrimaryKey(id);
		return student;
	}

	public Student getStudents2(@RequestParam(defaultValue = "1") int id) {
		Student student = businessStudentMapper.selectByPrimaryKey(id);
		return student;
	}

	public int insertStudent(@RequestBody Student student) {
		int i = businessStudentMapper.insert(student);
		LogUtil.info(DemoService.class, "ceshi");
		return i;
	}

	@Transactional(rollbackFor = Exception.class)
	public int deleteStudent(@RequestBody Integer[] ids) throws Exception {
		for (Integer id : ids) {
			businessStudentMapper.deleteByPrimaryKey(id);
			if (id == 9) {
				throw new Exception("出现异常");
			}
		}
		return 1;
	}

}
