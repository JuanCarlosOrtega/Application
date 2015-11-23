package com.jcsoftware.newsmeapi.service.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcsoftware.newsmeapi.model.Provider;
import com.jcsoftware.newsmeapi.model.RssItem;
import com.jcsoftware.newsmeapi.service.parserengine.ParserEngineService;
import com.jcsoftware.newsmeapi.service.provider.ProviderService;

@Transactional
@Service("parserService")
public class ParserServiceBean implements ParserService {

	@Autowired
	private ProviderService providerService;
	@Autowired
	private ParserEngineService parserEngineService;

	@Override
	public List<RssItem> getAllRssItems() {
		List<RssItem> rssItems = new ArrayList<RssItem>();
		List<Provider> providers = providerService.findAllProviders();
		for (Provider provider : providers) {
			rssItems.addAll(getRssItemsByProviderId(provider.getId()));
		}
		return rssItems;
	}

	@Override
	public List<RssItem> getRssItemsByProviderId(long id) {
		List<RssItem> rssItems = new ArrayList<RssItem>();
		Provider provider = providerService.findProviderById(id);
		rssItems.addAll(parserEngineService.getAllRssItems(provider.getId(), provider.getRssUrl()));
		return rssItems;
	}

}
