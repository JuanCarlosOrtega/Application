package com.jcsoftware.newsmeapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.newsmeapi.model.RssItem;
import com.jcsoftware.newsmeapi.service.parser.ParserService;

@RestController
@RequestMapping(value = "/v1")
public class SearchRestController {

	@Autowired
	private ParserService parserService;

	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	public ResponseEntity<List<RssItem>> searchAllRssItems() {
		List<RssItem> rssItems = new ArrayList<RssItem>();

		rssItems.addAll(parserService.getAllRssItems());

		return new ResponseEntity<List<RssItem>>(rssItems, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<RssItem>> searchRssItemsByProviderId(@PathVariable("id") long id) {
		List<RssItem> rssItems = new ArrayList<RssItem>();

		rssItems.addAll(parserService.getRssItemsByProviderId(id));

		return new ResponseEntity<List<RssItem>>(rssItems, HttpStatus.OK);
	}

}
