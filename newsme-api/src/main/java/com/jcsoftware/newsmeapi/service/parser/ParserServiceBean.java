package com.jcsoftware.newsmeapi.service.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;
import com.jcsoftware.newsmeapi.repository.ParserConfigurationDao;

@Transactional
@Service("parserService")
public class ParserServiceBean implements ParserService {
	
	@Autowired
	private ParserConfigurationDao parserConfigurationDao;

	@Override
	public List<ParserConfiguration> findAllParserConfigurations() {
		List<ParserConfiguration> parserConfigurations = new ArrayList<ParserConfiguration>();
		parserConfigurations.addAll(parserConfigurationDao.getAllParserConfigurations());
		return parserConfigurations;
	}

	@Override
	public ParserConfiguration findParserConfigurationByProviderId(long id) {
		ParserConfiguration parserConfiguration = parserConfigurationDao.getParserConfigurationByProviderId(id);
		
		return parserConfiguration;
	}

	@Override
	public void saveParserConfiguration(ParserConfiguration parserConfiguration) {
		parserConfigurationDao.addParserConfiguration(parserConfiguration);		
	}

	@Override
	public void updateParserConfiguration(ParserConfiguration parserConfiguration) {
		parserConfigurationDao.updateParserConfiguration(parserConfiguration);
	}

	@Override
	public void deleteParserConfigurationByProviderId(long id) {
		parserConfigurationDao.deleteParserConfigurationByProviderId(id);
	}

	@Override
	public void deleteAllParserConfigurations() {
		parserConfigurationDao.deleteAllParserConfigurations();
	}

}
