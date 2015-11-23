package com.jcsoftware.newsmeapi.service.parserengine;

import java.util.List;

import com.jcsoftware.newsmeapi.model.RssItem;

public interface ParserEngineService {
	
	List<RssItem> getAllRssItems(long providerId, String rssUrl);

}
