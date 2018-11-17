package com.example.bugs;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.bugs.mapper.UserStoryMapper;
import com.example.bugs.services.BusinessLogicService;
import com.example.bugs.tracker.ExceptionHandlerAdvice;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = Controller.class)
public class ControllerTest {
	
	private MockMvc mvc;
	
	@Mock
	private BusinessLogicService service;
	
	@InjectMocks
	private Controller controller;

//	@Autowired
	private ObjectMapper objectMapper;
	
	@Before
    public void setup() {
        // We would need this line if we would not use MockitoJUnitRunner
         MockitoAnnotations.initMocks(this);
         objectMapper = new ObjectMapper();
        // Initializes the JacksonTester
        JacksonTester.initFields(this, new ObjectMapper());
//         MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new ExceptionHandlerAdvice())
//                .addFilters(new SuperHeroFilter())
                .build();
    }

	@Test
	public void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
		UserStoryMapper input = new UserStoryMapper();
		input.setStory("Testing new story");
		when(service.addStory(input)).thenReturn(input);
		String body = objectMapper.writeValueAsString(input);

		mvc.perform(post("/story").contentType("application/json").content(body))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void whenInputIsValid_thenReturnsStatus200() throws Exception{
		UserStoryMapper input = new UserStoryMapper();
		input.setStory("Testing new story");
		input.setDescription("this is descyption");
		String body = objectMapper.writeValueAsString(input);

		mvc.perform(post("/story").contentType("application/json").content(body))
				.andExpect(status().isOk());
	}
}
