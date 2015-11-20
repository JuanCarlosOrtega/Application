package com.jcsoftware.newsmeapi.model;

public class Provider {
	
	private long id;
	private String name;
	private String description;
	private String providerUrl;
	private String rssUrl;
	private boolean isActive;
	
	public Provider() {
		this.id = 0;
		this.name = "";
		this.description = "";
		this.providerUrl = "";
		this.rssUrl = "";
		this.isActive = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getRssUrl() {
		return rssUrl;
	}

	public void setRssUrl(String rssUrl) {
		this.rssUrl = rssUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}	

}
