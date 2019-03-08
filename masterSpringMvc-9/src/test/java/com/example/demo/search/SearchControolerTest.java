package com.example.demo.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.MasterSpringMvc9Application;
import com.example.demo.domain.Tweet;
import com.example.demo.user.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MasterSpringMvc9Application.class,StubTwitterSearchConfig.class})
public class SearchControolerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private UserRepository userRepository;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void should_search() throws Exception {
		
		MockHttpSession session=new MockHttpSession();
		session.setAttribute("name", "hyman");
		
		this.mockMvc.perform(get("/api/search/popular;keywords=java"))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_search2() throws Exception {
		this.mockMvc.perform(get("/api/search/popular;keywords=java"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name",is("name1")))
		.andExpect(jsonPath("$[1].name",is("name2")))
		;
		assertThat(userRepository.findOne("name")).extracting(Tweet::getName).asList().containsOnly("name1","name2");
	}

}
