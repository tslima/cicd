package br.com.alura.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.auth.exceptions.DivideByZeroException;
import br.com.alura.auth.services.TestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestController {
	
	private final TestService testService;
	
	@GetMapping("/v01/test/{div}")
	public int testEndpoint(@PathVariable final int div) {
		
		if (div == 0) throw new DivideByZeroException();
		
		return testService.divide(div);
	}

}
