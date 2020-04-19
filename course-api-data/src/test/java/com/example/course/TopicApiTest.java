package com.example.course;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.course.service.CourseService;
import com.example.course.topic.bo.Topic;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicApiTest {
	
	Logger log = LoggerFactory.getLogger(CourseService.class);
	
	private MockMvc mockMvc;
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	 void initilize() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getTopicTest() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/topics").content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
		String data = result.getResponse().getContentAsString();
		log.info("Topics are :- {}",data);
		
		assertTrue(result.getResponse().getStatus() == 200);
		
	}
	
	@Test
	public void addTopicTest() throws Exception {
		
		Topic topic = new Topic();
		topic.setId("1");
		topic.setName("Java");
		topic.setDescription("JAVAjava");
		
		MvcResult result = mockMvc.perform(post("/addTopics").content(mapper.writeValueAsString(topic)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		//String data = result.getResponse().getContentAsString();
		//log.info("Topics are :- {}",data);
		
		assertTrue(result.getResponse().getStatus() == 200);
		
       MvcResult result2 = mockMvc.perform(get("/topics").content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		
		String data = result.getResponse().getContentAsString();
		log.info("Topics are :- {}",data);
		
		assertTrue(result.getResponse().getStatus() == 200);
		
	}
	

}
