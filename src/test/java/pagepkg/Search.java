package pagepkg;


import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Search {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/div[2]/m-search-popup/button")
	WebElement search;
	@FindBy(xpath="//*[@id=\"m-form-search\"]/input[4]")
	WebElement searchField;
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/div[2]/ul/li[1]/a")
	WebElement clickToHomePage;
	
	
	
	
	public Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchProducts(String product) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		search.click();
		searchField.sendKeys(product,Keys.ENTER);
		clickToHomePage.click();
		
	}
	
	
	
	


	

}
