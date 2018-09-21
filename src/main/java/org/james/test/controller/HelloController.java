package org.james.test.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(HttpEntity<String> httpEntity) {		
		return httpEntity.getBody();
	}
	
	@RequestMapping("/oo/xx/ox")
	public String xx(HttpEntity<String> httpEntity) {		
		return httpEntity.getBody();
	}
}
