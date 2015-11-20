package com.jcsoftware.newsmeapi.service.provider;

import java.util.List;

import com.jcsoftware.newsmeapi.model.Provider;

public interface ProviderService {
	
	Provider findProviderById(long id);
	
	Provider findProviderByName(String name);
	
	void saveProvider(Provider provider);
	
	void updateProvider(Provider provider);
	
	void deleteProviderById(long id);
	
	List<Provider> fillAllProviders();
	
	void deleteAllProviders();

}
