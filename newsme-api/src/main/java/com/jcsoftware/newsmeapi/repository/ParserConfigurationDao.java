package com.jcsoftware.newsmeapi.repository;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

public interface ParserConfigurationDao {
	
	ParserConfiguration getParserConfigurationByProviderId(long id);
	
	void addParserConfiguration(ParserConfiguration parserConfiguration);
	
	void updateParserConfiguration(ParserConfiguration parserConfiguration);
	
	void deleteParserConfigurationByProviderId(long id);
	
	void deleteAllParserConfigurations();

}
