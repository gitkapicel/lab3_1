package pl.com.bottega.ecommerce.sales.domain.invoicing;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
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
	public void test() {
		//given
		Money money = new Money(10);
		Id id = new Id("1");
		TaxPolicy tax =mock(TaxPolicy.class);
		InvoiceFactory invoiceFactory = mock(InvoiceFactory.class);
		BookKeeper book = new BookKeeper(invoiceFactory);
		ClientData clientData = new ClientData(id,"dzemba");
		InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
		//ProductData productData = new ProductData(id,money, "book",ProductType.DRUG, new Date(0));
		//RequestItem requestitem = new RequestItem(productData,15,money);
		
	
		when(invoiceFactory.create(clientData)).thenReturn(new Invoice(id,clientData));
		
		when(tax.calculateTax(ProductType.DRUG, money)).thenReturn(new Tax(money,"opis"));
		
		
		//when
		when(book.issuance(invoiceRequest, tax).thenReturn());
		
		
		
		
		//then
		
		
		
	}

}
