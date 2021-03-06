package com.cet.ibscloud.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cet.ibscloud.common.Result;
import com.cet.ibscloud.demo.domain.Teacher;
import com.cet.ibscloud.demo.service.DemoService;
import com.cet.ibscloud.demo.service.StudentsService;
import com.cet.ibscloud.ibsdao.business.model.Student;

@RestController
@RequestMapping(value = "/api")
public class DemoController {

	@Autowired
	StudentsService studentsService;

	@Autowired
	private Teacher teacher;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void index(HttpServletResponse response) throws IOException {
		response.sendRedirect("/ibsweb/api/name");
	}

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public ResponseEntity<Result> getFromSession(HttpSession session) {
		if (session.getAttribute("name") != null) {
			Result result = new Result(true, "Hello Springboot", session.getAttribute("name"));
			ResponseEntity<Result> re = new ResponseEntity<Result>(result, HttpStatus.OK);
			return re;
		}
		return null;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Result> test() {
		Result result = new Result(true, "Hello Springboot", teacher);
		ResponseEntity<Result> re = new ResponseEntity<Result>(result, HttpStatus.OK);
		return re;
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Result getStudents(@PathVariable int id) {
		Student student = studentsService.getStudents(id);
		Result result = new Result(true, "Hello Springboot", student);
		return result;
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Result getStudents2(@RequestParam(defaultValue = "1") int id) {
		Student student = studentsService.getStudents(id);
		Result result = new Result(true, "Hello Springboot", student);
		return result;
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Result insertStudent(@RequestBody Student student) {

		Result result = new Result(true, "Hello Springboot", studentsService.insertStudent(student));
		return result;
	}

	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public Result insertStudent(@RequestParam Integer[] ids) throws Exception {

		Result result = new Result(true, "Hello Springboot", studentsService.deleteStudent(ids));
		return result;
	}

}
