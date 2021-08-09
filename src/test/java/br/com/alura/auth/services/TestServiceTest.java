package br.com.alura.auth.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestServiceTest {
	
	@InjectMocks TestService testService;
	
	@Test
	public void testDivideBy2() {
		final int ret = testService.divide(2);
		assertThat(ret).isEqualTo(5);
	}

}
