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
		TaxPolicy tax =mock(TaxPolicy.class);
		InvoiceFactory invoiceFactory = mock(InvoiceFactory.class);
		BookKeeper book = new BookKeeper(invoiceFactory);
		InvoiceRequest invoiceRequest = new InvoiceRequest(new ClientData(new Id("1"),"fakturka"));
		ProductData productData = new ProductData(new Id("1"),new Money(10), "book",ProductType.DRUG, new Date(0));
		RequestItem requestitem = new RequestItem(productData,15,new Money(20));
		
		
		//when
		when(book.issuance(invoiceRequest, tax).thenReturn(serviceMock));
		
		
		
		
		//then
		
		
		
	}

}
