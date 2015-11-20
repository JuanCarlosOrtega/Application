package com.jcsoftware.newsmeapi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcsoftware.newsmeapi.model.Provider;

@Component("providerDao")
public class ProviderDAO {

	private List<Provider> providers;

	public ProviderDAO() {
		providers = new ArrayList<Provider>();

		Provider elMundoProvider = new Provider();
		elMundoProvider.setId(1);
		elMundoProvider.setName("El Mundo");
		elMundoProvider.setDescription("Periodico El Mundo");
		elMundoProvider.setProviderUrl("http://www.elmundo.es/");
		elMundoProvider.setRssUrl("http://estaticos.elmundo.es/elmundo/rss/portada.xml");	
		
		providers.add(elMundoProvider);

	}

	public Provider getProviderById(long id) {
		for (Provider p : providers) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}	
	
}
