package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.util.Date;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class ProductBuilder {
	private Id productId = Id.generate();

	private Money price = new Money(0);

	private String name = "";

	private Date snapshotDate = new Date();

	private ProductType type = ProductType.STANDARD;

	public ProductBuilder withProductId(Id id) {
		this.productId = id;
		return this;
	}

	public ProductBuilder withPrice(double price) {
		this.price = new Money(price);
		return this;
	}

	public ProductBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ProductBuilder withSnapshotDate(Date date) {
		this.snapshotDate = date;
		return this;
	}

	public ProductBuilder withProductType(ProductType type) {
		this.type = type;
		return this;
	}

	public ProductData build() {
		return new ProductData(productId, price, name, type, snapshotDate);
	}

}



