package com.jcsoftware.newsmeapi.service.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcsoftware.newsmeapi.model.Provider;
import com.jcsoftware.newsmeapi.repository.ProviderDao;

@Transactional
@Service("providerService")
public class ProviderServiceBean implements ProviderService {

	@Autowired
	private ProviderDao providerDao;

	@Override
	public Provider findProviderById(long id) {
		Provider provider = providerDao.getProviderById(id);

		return provider;
	}

	@Override
	public Provider findProviderByName(String name) {
		Provider provider = providerDao.getProviderByName(name);

		return provider;
	}

	@Override
	public void saveProvider(Provider provider) {
		providerDao.addProvider(provider);
	}

	@Override
	public void updateProvider(Provider provider) {
		providerDao.updateProvider(provider);

	}

	@Override
	public void deleteProviderById(long id) {
		providerDao.deleteProviderById(id);

	}

	@Override
	public List<Provider> fillAllProviders() {
		List<Provider> providers = new ArrayList<Provider>();
		providers.addAll(providerDao.getAllProviders());
		return providers;
	}

	@Override
	public void deleteAllProviders() {
		providerDao.deleteAllProviders();

	}

}
