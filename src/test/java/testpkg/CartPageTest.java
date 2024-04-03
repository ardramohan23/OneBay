package testpkg;


import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.CartPage;


public class CartPageTest  extends BaseClass {
	
	@Test
	public void productPageTest() {
		
		CartPage cp=new CartPage(driver);
		cp.cartAdd();
		refresh();
		cp.checkout();
		
		
		

}

}
