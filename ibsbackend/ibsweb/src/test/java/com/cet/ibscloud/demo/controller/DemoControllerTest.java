package com.cet.ibscloud.demo.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void should_redirect_to_test() throws Exception {
		
		MockHttpSession session=new MockHttpSession();
		session.setAttribute("name", "hyman");
		
		
		this.mockMvc.perform(get("/api/"))
		.andDo(print())
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("/ibsweb/api/test"));
	}
	
	@Test
	public void should_get_from_session() throws Exception {
		
		MockHttpSession session=new MockHttpSession();
		session.setAttribute("name", "hyman");
		this.mockMvc.perform(get("/api/name").session(session))
		.andDo(print())
		.andExpect(status().isOk());
	}

}
