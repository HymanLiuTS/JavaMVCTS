package com.cet.ibs.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cet.ibs.cloud.demo.domain.Student;
import com.cet.ibs.cloud.util.SpringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IBSCloudApplicationTests {

	@Test
	public void contextLoads() {
		Student student = (Student) SpringUtil.getBean("student");
		System.out.println(student.toString());
	}

}
