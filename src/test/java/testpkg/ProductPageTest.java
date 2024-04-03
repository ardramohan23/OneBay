package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.ProductPage;


public class ProductPageTest extends BaseClass {
	
	@Test
	public void productPageTest() throws Exception  {
		
		ProductPage sh=new ProductPage(driver);
		sh.shopByCollectionTest();
		sh.refresh();
		sh.noOfCartItems();
	}
	
		
	}



