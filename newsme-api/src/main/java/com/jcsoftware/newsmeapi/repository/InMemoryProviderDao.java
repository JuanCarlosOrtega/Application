package com.jcsoftware.newsmeapi.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jcsoftware.newsmeapi.model.Provider;

@Component("providerDao")
public class InMemoryProviderDao implements ProviderDao {

	private List<Provider> providers;

	public InMemoryProviderDao() {
		providers = new ArrayList<Provider>();

		Provider elMundoProvider = new Provider();
		elMundoProvider.setId(1);
		elMundoProvider.setName("EL MUNDO");
		elMundoProvider.setDescription("Proveedor El Mundo");
		elMundoProvider.setProviderUrl("http://www.elmundo.es/");
		elMundoProvider.setRssUrl("http://estaticos.elmundo.es/elmundo/rss/portada.xml");

		Provider abcProvider = new Provider();
		abcProvider.setId(2);
		abcProvider.setName("ABC");
		abcProvider.setDescription("Proveedor ABC");
		abcProvider.setProviderUrl("http://www.abc.es/");
		abcProvider.setRssUrl("http://www.abc.es/rss/feeds/abcPortada.xml");

		Provider elPaisProvider = new Provider();
		elPaisProvider.setId(3);
		elPaisProvider.setName("EL PAIS");
		elPaisProvider.setDescription("Proveedor El Pais");
		elPaisProvider.setProviderUrl("http://elpais.com/");
		elPaisProvider.setRssUrl("http://ep00.epimg.net/rss/tags/ultimas_noticias.xml");

		Provider elPeriodicoProvider = new Provider();
		elPeriodicoProvider.setId(4);
		elPeriodicoProvider.setName("EL PERIODICO");
		elPeriodicoProvider.setDescription("Proveedor El Periodico");
		elPeriodicoProvider.setProviderUrl("http://www.elperiodico.com/es/");
		elPeriodicoProvider.setRssUrl("http://www.elperiodico.com/es/rss/rss_portada.xml");

		Provider expansionProvider = new Provider();
		expansionProvider.setId(5);
		expansionProvider.setName("EXPANSION NEWS");
		expansionProvider.setDescription("Proveedor EXPANSION");
		expansionProvider.setProviderUrl("http://www.expansion.com/");
		expansionProvider.setRssUrl("http://expansion.feedsportal.com/rss/portada.xml");
		
		providers.add(elMundoProvider);
		providers.add(abcProvider);
		providers.add(elPaisProvider);
		providers.add(elPeriodicoProvider);
		providers.add(expansionProvider);

	}

	@Override
	public Provider getProviderById(long id) {
		for (Provider p : providers) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public Provider getProviderByName(String name) {
		for (Provider p : providers) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Provider> getAllProviders() {
		return providers;
	}

	@Override
	public void addProvider(Provider provider) {
		providers.add(provider);
	}

	@Override
	public void updateProvider(Provider provider) {
		int index = providers.indexOf(provider);
		providers.set(index, provider);
	}

	@Override
	public void deleteProviderById(long id) {
		for (Iterator<Provider> iterator = providers.iterator(); iterator.hasNext();) {
			Provider provider = iterator.next();
			if (provider.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteProviderByName(String name) {
		for (Iterator<Provider> iterator = providers.iterator(); iterator.hasNext();) {
			Provider provider = iterator.next();
			if (provider.getName().equals(name)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAllProviders() {
		providers.clear();
	}

}
