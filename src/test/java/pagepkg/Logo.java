package pagepkg;

import java.util.logging.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Logo {
	

	WebDriver driver;
	Logger LOGGER = Logger.getLogger(Logo.class.getName());
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/h1/a")
	WebElement logo;
	@FindBy(xpath = "//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/h1/a/div/img")
	WebElement logoSize;
	
	
	
	
	public Logo(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void logoTest() {
		
		String exp_url="https://onebay.in/";
		try {
		logo.click();
		Assert.assertEquals(driver.getCurrentUrl(), exp_url);
		LOGGER.info("Logo when clicked redirected to homepage");
		}catch(AssertionError e){
			  LOGGER.severe("Logo redirected to wrong page");
		}
		Dimension dimention=logoSize.getSize();
		int expwidth=145;
		int actualWidth=dimention.getWidth();
		int expheight=36;
		int actualheight=dimention.getHeight();
		try {
			Assert.assertEquals(actualWidth, expwidth);
			LOGGER.info("Width satisfies expectation");
			Assert.assertEquals(actualheight, expheight);
			LOGGER.info("Height satisfies expectation");
		}catch (Exception e) {
			LOGGER.severe("Width doesn't satisfy expectation");
		}
	}


}
