package pagepkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	Logger LOGGER=Logger.getLogger(HomePage.class.getName());
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/div[1]/ul/li[1]/a")
	WebElement home;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void homelabelTest() {
		
		String exp_url="https://onebay.in/";
		try {
		home.click();
		String actual_url=driver.getCurrentUrl();
		Assert.assertEquals(actual_url, exp_url);
		LOGGER.info("Home when clicked redirected to intended page");
		}catch (Exception e) {
			LOGGER.severe("Home when clicked redirects to wrong page");
		}
		
	}
	
	public void linkValidationTest()  {
			
			List<WebElement> linklist=driver.findElements(By.tagName("a"));
			System.out.println("Total number of links present in home page: "+linklist.size());
			List<String> failedLinks=new ArrayList<String>();
			for(WebElement list:linklist) {
				String link=list.getAttribute("href");
				String linkName=list.getText();
				try {
					URL u=new URL(link);
					HttpURLConnection ht=(HttpURLConnection) u.openConnection();
					int responseCode=ht.getResponseCode();
					if(responseCode==200) {
				
						System.out.println(linkName+" "+link+" "+responseCode+" ---SUCCESS---");
					}
					else {
						System.out.println(linkName+" "+link+" "+responseCode+" ---FAILED---");
						
						failedLinks.add(linkName+ " "+ link);
					}
				}catch (Exception e) {
					
					System.out.println(linkName+" "+link+" has some issues");
					e.getMessage();
					
				}
			
					
				}
			System.out.println("Failed link list:"+failedLinks);

	}
}
