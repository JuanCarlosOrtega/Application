package com.jcsoftware.newsmeapi.service.parserengine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcsoftware.newsmeapi.model.ParserConfiguration;
import com.jcsoftware.newsmeapi.model.RssItem;
import com.jcsoftware.newsmeapi.service.parserconfiguration.ParserConfigurationService;

@Service("parserEngineService")
public class ParserEngineServiceBean implements ParserEngineService {

	@Autowired
	private ParserConfigurationService parserConfigurationService;
	
	@Override
	public List<RssItem> getAllRssItems(long providerId, String rssUrl) {
		List<RssItem> rssItems = new ArrayList<RssItem>();		
		ParserConfiguration parserConfiguration = parserConfigurationService.findParserConfigurationByProviderId(providerId);
		
		Document document = null;
		Connection connection = Jsoup.connect(rssUrl);
		Document xmlString = null;
		try {
			xmlString = connection.get();
			
			document = Parser.xmlParser().parseInput(xmlString.toString(), "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (xmlString == null) {
			String finalStr = "";
			try {
				URL url = new URL(rssUrl);
				URLConnection conn = url.openConnection();
				
				BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
				
				String inputLine;
				while ((inputLine = br.readLine()) != null) {
					finalStr = finalStr + inputLine;
				}
				
				document = Parser.xmlParser().parseInput(finalStr.toString(), ""); 
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				 
		String itemTag = parserConfiguration.getItemTag();
		for (Element element : document.select(itemTag)) {
			System.out.println(element);
			System.out.println();
			RssItem item = parseNode(parserConfiguration, element);
			if (isValid(item)) {
				rssItems.add(item);
			}			
		}		

		return rssItems;
	}
	
	private RssItem parseNode(ParserConfiguration parserConfiguration, Element element) {
		RssItem rssItem = new RssItem();
		
		rssItem.setProviderId(parserConfiguration.getProviderId());
		rssItem.setTitle(applyRule(element, parserConfiguration.getTitleTag(), parserConfiguration.getTitleTypeSelector()));
		rssItem.setAuthor(applyRule(element, parserConfiguration.getCreatorTag(), parserConfiguration.getCreatorTypeSelector()));
		
		String description = applyRule(element, parserConfiguration.getDescriptionTag(), parserConfiguration.getDescriptionTypeSelector());
		
		
		rssItem.setDescription(description.length() < 80 ? description : description.substring(0, 250) + "...");
		rssItem.setLink(applyRule(element, parserConfiguration.getLinkTag(), parserConfiguration.getLinkTypeSelector()));
		rssItem.setDate(applyRule(element, parserConfiguration.getDateTag(), parserConfiguration.getDateTypeSelector()));
		rssItem.setImageUrl(applyRule(element, parserConfiguration.getImageTag(), parserConfiguration.getImageTagTypeSelector()));
		
		String categoryTag = parserConfiguration.getCategoryTag();
		if (categoryTag != null && categoryTag.length() > 0) {
			for (Element categoryElement : element.select(categoryTag)) {
				rssItem.addCategory(categoryElement.text());
			}
		}		
		return rssItem;
	}
	
	private boolean isValid(RssItem item) {
		if (item.getTitle() != null && item.getTitle().length() > 0) {
			return true;
		}
		return false;
	}
	
	private String applyRule(Element node, String tagName, String typeSelector) {
		String result = null;
		if (tagName != null && tagName.length() > 0) {
			if (typeSelector.equals("text")) {
				result = node.select(tagName).text();
			} else if (typeSelector.equals("attr")) {
				result = node.select(tagName).attr("url");
			} else {
				result = null;
			}
		}
		return result;
	}

}
