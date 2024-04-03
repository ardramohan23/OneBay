package pagepkg;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/div[1]/ul/li[2]/a")
	WebElement productlabel;
	@FindBy(xpath="/html/body/main/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[4]/product-form/form/div[1]/div[1]/button")
	WebElement addToCart;
	@FindBy(xpath="/html/body/main/div[2]/section/div[1]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/div[1]/a/div[2]/responsive-image/img")
	WebElement product1;
	@FindBy(xpath="/html/body/m-cart-drawer/div/div/div/div[2]/div[3]/a")
	WebElement viewCart;
	@FindBy(xpath="/html/body/main/div[1]/div[2]/m-cart-template/form/div[2]/div/div[4]/div/div/button")
	WebElement checkout;
	@FindBy(xpath="/html/body/div/div[1]/div[1]/div[3]/div/div/div[2]/div[1]/input")
	WebElement mobileNumber;
	
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void cartAdd() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		productlabel.click();
		product1.click();
		addToCart.click();
		viewCart.click();
	
}
	
	public void checkout() {
		
		checkout.click();

		
	}
	

	
	
}