package com.kcc.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlTestController {

	@GetMapping(value = "/test1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RestResource<String>> getTest1() {
		RestResource<String> body = RestResourceFactory.<String>newInstance();
		String str = "Hello Test1111111111111";
		body.setItems(Arrays.asList(str));
		body.setStatus(HttpStatus.OK.value());
		body.setTotalItems(1);

		return new ResponseEntity<>(body, HttpStatus.OK);
	}

	@GetMapping(value = "/test2", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RestResource<String>> getTest2() {
		RestResource<String> body = RestResourceFactory.<String>newInstance();
		String str = "Hello Test2222222222222";
		body.setItems(Arrays.asList(str));
		body.setStatus(HttpStatus.OK.value());
		body.setTotalItems(1);

		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
