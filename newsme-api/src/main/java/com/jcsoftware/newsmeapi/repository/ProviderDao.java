package com.jcsoftware.newsmeapi.repository;

import java.util.List;

import com.jcsoftware.newsmeapi.model.Provider;

public interface ProviderDao {

	Provider getProviderById(long id);

	Provider getProviderByName(String name);

	List<Provider> getAllProviders();

	void addProvider(Provider provider);

	void updateProvider(Provider provider);

	void deleteProviderById(long id);

	void deleteProviderByName(String name);

	void deleteAllProviders();

}
