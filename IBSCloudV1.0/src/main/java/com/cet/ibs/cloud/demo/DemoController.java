package com.cet.ibs.cloud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cet.ibs.cloud.common.Result;
import com.cet.ibs.cloud.demo.domain.Student;


@RestController
public class DemoController {
	
	@Autowired
	private Student student;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Result> test() {
		Result result=new Result(true,"Hello Springboot",student);
		ResponseEntity<Result> re = new ResponseEntity<Result>(result, HttpStatus.OK);
		return re;
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public Result test2() {
		Result result=new Result(true,"Hello Springboot",student);
		return result;
	}


}
