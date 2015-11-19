package com.jcsoftware.newsmeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.newsmeapi.model.Demo;
import com.jcsoftware.newsmeapi.service.DemoService;

@RestController
public class DemoRestController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "/demo/", method = RequestMethod.GET)
	public ResponseEntity<Demo> testDemoRestService() {
		
		Demo demo = demoService.checkDemoService();
		
		return new ResponseEntity<Demo>(demo, HttpStatus.OK);
	}
	
}
