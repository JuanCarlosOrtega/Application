package com.jcsoftware.newsmeapi.repository;

import java.util.List;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

public interface ParserConfigurationDao {
	
	List<ParserConfiguration> getAllParserConfigurations();
	
	ParserConfiguration getParserConfigurationByProviderId(long id);
	
	void addParserConfiguration(ParserConfiguration parserConfiguration);
	
	void updateParserConfiguration(ParserConfiguration parserConfiguration);
	
	void deleteParserConfigurationByProviderId(long id);
	
	void deleteAllParserConfigurations();

}
