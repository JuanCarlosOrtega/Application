package com.jcsoftware.newsmeapi.service.parser;

import java.util.List;

import com.jcsoftware.newsmeapi.model.RssItem;

public interface ParserService {
	
	List<RssItem> getAllRssItems();
	
	List<RssItem> getRssItemsByProviderId(long id);

}
