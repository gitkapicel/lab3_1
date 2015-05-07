package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;
import org.hamcrest.Matchers.*;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
public class BookKeeperTest {

	@Test
	public void request_one_invoice_should_return_one_invoice() {
		//given
		Money money = new Money(10);
		Id id = new Id("1");
		InvoiceFactory invoiceFactory = mock(InvoiceFactory.class);
		BookKeeper book = new BookKeeper(invoiceFactory);
		ClientData clientData = new ClientDataBuild().withId(id).withName("dzemba").build();
				
		
		TaxPolicy taxPolicy = mock(TaxPolicy.class);
		
		
		when(invoiceFactory.create(clientData)).thenReturn(new Invoice(id, clientData));
	    
		
		InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
		
		
		when(taxPolicy.calculateTax(ProductType.FOOD, money)).thenReturn(
				new Tax(money, "opis"));

		ProductData productData = new ProductBuilder().withPrice(1).withProductType(ProductType.FOOD).build();

		RequestItem requestItem = new RequestItemBuild().withProductData(productData).witTotalCost(10).build();

		invoiceRequest.add(requestItem);
		
		Invoice invoice = book.issuance(invoiceRequest,taxPolicy);
		assertThat(invoice.getItems().size(),is(1));
		
		
		
		
		
		
		
	}

	
	
	
	@Test
	public void should_two_invoice_callCalculateTaxTwice() {

		// given
		Id id = new Id("1");
		Money money = new Money(10);
		ProductType productTypeEveryItem = ProductType.FOOD;
		ClientData clientData = new ClientDataBuild().withId(id).withName("dzemba").build();
		//ProductData productData = new ProductData(id,money, "book",ProductType.DRUG, new Date());
		ProductData productData = new ProductBuilder().withProductId(id).withPrice(10).withName("book").withProductType(ProductType.FOOD).build();
		RequestItem requestitem = new RequestItemBuild().withProductData(productData).withQuantity(4).witTotalCost(10).build();

		

		InvoiceFactory invoiceFactory = mock(InvoiceFactory.class);
		BookKeeper book = new BookKeeper(invoiceFactory);
		when(invoiceFactory.create(clientData)).thenReturn(
				new Invoice(id, clientData));
		TaxPolicy tax = mock(TaxPolicy.class);
		when(tax.calculateTax(ProductType.FOOD, money))
				.thenReturn(new Tax(money, "opis"));

		InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
		invoiceRequest.add(requestitem);
		invoiceRequest.add(requestitem);

		// when
		Invoice invoiceResult = book.issuance(invoiceRequest, tax);

		// then
		Mockito.verify(tax, Mockito.times(2)).calculateTax(
				ProductType.FOOD, money);
	}
}
