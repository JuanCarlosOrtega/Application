package com.jcsoftware.newsmeapi.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.jcsoftware.newsmeapi.model.Demo;

@Service("demoService")
public class DemoServiceBean implements DemoService {

	public Demo checkDemoService() {
		Demo demo = new Demo();
		
		demo.setStatus("OK");
		demo.setCreationDate((new Date()).toString());
		
		return demo;
	}

}
