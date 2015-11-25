package com.jcsoftware.newsmeapi.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;

@Component("parserConfigurationDao")
public class InMemoryParserConfigurationDao implements ParserConfigurationDao {
	
	private List<ParserConfiguration> parserConfigurations;

	public InMemoryParserConfigurationDao() {
		parserConfigurations = new ArrayList<ParserConfiguration>();
		
		ParserConfiguration elMundoParserConfiguration = new ParserConfiguration();
		elMundoParserConfiguration.setProviderId(1);
		elMundoParserConfiguration.setItemTag("item");
		elMundoParserConfiguration.setItemTypeSelector("elements");
		elMundoParserConfiguration.setTitleTag("title");
		elMundoParserConfiguration.setTitleTypeSelector("text");
		elMundoParserConfiguration.setCreatorTag("dc|creator");
		elMundoParserConfiguration.setCreatorTypeSelector("text");
		elMundoParserConfiguration.setLinkTag("link");
		elMundoParserConfiguration.setLinkTypeSelector("text");
		elMundoParserConfiguration.setDescriptionTag("media|description");
		elMundoParserConfiguration.setDescriptionTypeSelector("text");
		elMundoParserConfiguration.setDateTag("pubdate");
		elMundoParserConfiguration.setDateTypeSelector("text");
		elMundoParserConfiguration.setImageTag("media|content");
		elMundoParserConfiguration.setImageTagTypeSelector("attr");
				
		ParserConfiguration abcParserConfiguration = new ParserConfiguration();
		abcParserConfiguration.setProviderId(2);
		abcParserConfiguration.setItemTag("item");
		abcParserConfiguration.setItemTypeSelector("elements");
		abcParserConfiguration.setTitleTag("title");
		abcParserConfiguration.setTitleTypeSelector("text");
		abcParserConfiguration.setCreatorTag("dc|creator");
		abcParserConfiguration.setCreatorTypeSelector("text");
		abcParserConfiguration.setLinkTag("link");
		abcParserConfiguration.setLinkTypeSelector("text");
		abcParserConfiguration.setDescriptionTag("description");
		abcParserConfiguration.setDescriptionTypeSelector("text");
		abcParserConfiguration.setDateTag("pubdate");
		abcParserConfiguration.setDateTypeSelector("text");
		abcParserConfiguration.setCategoryTag("category");
		abcParserConfiguration.setCategoryTypeSelector("elements");
		
		ParserConfiguration elPaisParserConfiguration = new ParserConfiguration();
		elPaisParserConfiguration.setProviderId(3);
		elPaisParserConfiguration.setItemTag("item");
		elPaisParserConfiguration.setItemTypeSelector("elements");
		elPaisParserConfiguration.setTitleTag("title");
		elPaisParserConfiguration.setTitleTypeSelector("text");
		elPaisParserConfiguration.setCreatorTag("dc|creator");
		elPaisParserConfiguration.setCreatorTypeSelector("text");
		elPaisParserConfiguration.setLinkTag("link");
		elPaisParserConfiguration.setLinkTypeSelector("text");
		elPaisParserConfiguration.setDescriptionTag("description");
		elPaisParserConfiguration.setDescriptionTypeSelector("text");
		elPaisParserConfiguration.setDateTag("pubdate");
		elPaisParserConfiguration.setDateTypeSelector("text");
		elPaisParserConfiguration.setImageTag("enclosure");
		elPaisParserConfiguration.setImageTagTypeSelector("attr");
		elPaisParserConfiguration.setCategoryTag("category");
		elPaisParserConfiguration.setCategoryTypeSelector("elements");
		
		ParserConfiguration elPeriodicoParserConfiguration = new ParserConfiguration();
		elPeriodicoParserConfiguration.setProviderId(4);
		elPeriodicoParserConfiguration.setItemTag("item");
		elPeriodicoParserConfiguration.setItemTypeSelector("elements");
		elPeriodicoParserConfiguration.setTitleTag("title");
		elPeriodicoParserConfiguration.setTitleTypeSelector("text");
		elPeriodicoParserConfiguration.setLinkTag("link");
		elPeriodicoParserConfiguration.setLinkTypeSelector("text");
		elPeriodicoParserConfiguration.setDateTag("pubdate");
		elPeriodicoParserConfiguration.setDateTypeSelector("text");
		elPeriodicoParserConfiguration.setDescriptionTag("description");
		elPeriodicoParserConfiguration.setDescriptionTypeSelector("text");
		
		ParserConfiguration expansionParserConfiguration = new ParserConfiguration();
		expansionParserConfiguration.setProviderId(5);
		expansionParserConfiguration.setItemTag("item");
		expansionParserConfiguration.setItemTypeSelector("elements");
		expansionParserConfiguration.setTitleTag("title");
		expansionParserConfiguration.setTitleTypeSelector("text");
		expansionParserConfiguration.setCreatorTag("dc|creator");
		expansionParserConfiguration.setCreatorTypeSelector("text");
		expansionParserConfiguration.setLinkTag("link");
		expansionParserConfiguration.setLinkTypeSelector("text");
		expansionParserConfiguration.setDateTag("pubdate");
		expansionParserConfiguration.setDateTypeSelector("text");
		expansionParserConfiguration.setImageTag("media|thumbnail");
		expansionParserConfiguration.setImageTagTypeSelector("attr");
		expansionParserConfiguration.setDescriptionTag("description");
		expansionParserConfiguration.setDescriptionTypeSelector("text");
		
		parserConfigurations.add(elMundoParserConfiguration);
		parserConfigurations.add(abcParserConfiguration);
		parserConfigurations.add(elPaisParserConfiguration);
		parserConfigurations.add(elPeriodicoParserConfiguration);
		parserConfigurations.add(expansionParserConfiguration);
	}
	
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
