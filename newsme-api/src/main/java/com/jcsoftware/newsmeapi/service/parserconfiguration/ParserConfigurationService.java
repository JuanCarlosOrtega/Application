package com.jcsoftware.newsmeapi.service.parserconfiguration;

import java.util.List;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

public interface ParserConfigurationService {

	List<ParserConfiguration> findAllParserConfigurations();

	ParserConfiguration findParserConfigurationByProviderId(long id);

	void saveParserConfiguration(ParserConfiguration parserConfiguration);

	void updateParserConfiguration(ParserConfiguration parserConfiguriation);

	void deleteParserConfigurationByProviderId(long id);

	void deleteAllParserConfigurations();

}
