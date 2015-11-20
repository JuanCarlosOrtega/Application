package com.jcsoftware.newsmeapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

@Component("parserConfigurationDao")
public class ParserConfigurationDAO {
	
	List<ParserConfiguration> parserConfigurations;
	
	public ParserConfigurationDAO() {
		parserConfigurations = new ArrayList<ParserConfiguration>();
		
		ParserConfiguration parserConfiguration = new ParserConfiguration();
		
		parserConfigurations.add(parserConfiguration);
	}

}
