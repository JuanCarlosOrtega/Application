package com.jcsoftware.newsmeapi.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcsoftware.newsmeapi.dao.ProviderDAO;
import com.jcsoftware.newsmeapi.model.Provider;

@Transactional
@Service("providerService")
public class ProviderServiceBean implements ProviderService {

	@Override
	public Provider findProviderById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider findProviderByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProvider(Provider provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProvider(Provider provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProviderById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Provider> fillAllProviders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllProviders() {
		// TODO Auto-generated method stub

	}

}
