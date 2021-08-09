package br.com.alura.auth.controllers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.auth.services.TestService;

@WebMvcTest(TestController.class)
public class TestControllerTest {

	@Autowired MockMvc mockMvc;
	@MockBean TestService testService;
	
	@Test
	public void testDivideEndPoint() throws Exception {
		when(testService.divide(anyInt())).thenAnswer(i -> i.getArgument(0));
		
		mockMvc.perform(get("/api/v01/test/1"))
			.andExpect(status().isOk())
			.andExpect(content().string("1"))
			.andDo(print());		
	}
	
	@Test
	public void testDivideByZeroEndPoint() throws Exception {
		
		mockMvc.perform(get("/api/v01/test/0"))
			.andExpect(status().isBadRequest())
			.andDo(print());		
	}
}
