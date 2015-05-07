package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class ClientDataBuild {
	
	private Id id;
	private String name;

	public ClientDataBuild withId(Id id) {
		this.id = id;
		return this;
	}

	public ClientDataBuild withName(String name) {
		this.name = name;
		return this;
	}

	public ClientData build() {
		return new ClientData(id, name);
	}

}
