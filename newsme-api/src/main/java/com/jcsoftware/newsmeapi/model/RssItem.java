package com.jcsoftware.newsmeapi.model;

import java.util.List;

public class RssItem {

	private long providerId;
	private String title;
	private String description;
	private String link;
	private String author;
	private String guid;
	private String date;
	private String imageUrl;
	private String commentsUrl;
	private List<String> categories;

	public RssItem() {

	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCommentsUrl() {
		return commentsUrl;
	}

	public void setCommentsUrl(String commentsUrl) {
		this.commentsUrl = commentsUrl;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void addCategory(String category) {
		this.categories.add(category);
	}
	
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
