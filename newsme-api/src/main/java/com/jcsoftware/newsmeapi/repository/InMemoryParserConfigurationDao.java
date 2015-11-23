package com.jcsoftware.newsmeapi.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

@Component("parserConfigurationDao")
public class InMemoryParserConfigurationDao implements ParserConfigurationDao {
	
	private List<ParserConfiguration> parserConfigurations;

	@Override
	public ParserConfiguration getParserConfigurationByProviderId(long id) {
		for (ParserConfiguration p : parserConfigurations) {
			if (p.getProviderId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void addParserConfiguration(ParserConfiguration parserConfiguration) {
		parserConfigurations.add(parserConfiguration);		
	}

	@Override
	public void updateParserConfiguration(ParserConfiguration parserConfiguration) {
		int index = parserConfigurations.indexOf(parserConfiguration);
		parserConfigurations.set(index, parserConfiguration);
	}

	@Override
	public void deleteParserConfigurationByProviderId(long id) {
		for (Iterator<ParserConfiguration> iterator = parserConfigurations.iterator(); iterator.hasNext();) {
			ParserConfiguration parserConfiguration = iterator.next();
			if (parserConfiguration.getProviderId() == id) {
				iterator.remove();
			}
		}		
	}

	@Override
	public void deleteAllParserConfigurations() {
		parserConfigurations.clear();
	}

	@Override
	public List<ParserConfiguration> getAllParserConfigurations() {
		return parserConfigurations;
	}

}
