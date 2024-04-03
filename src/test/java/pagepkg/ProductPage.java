package pagepkg;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ProductPage {
	
	static WebDriver driver;
	Logger LOGGER=Logger.getLogger(ProductPage.class.getName());
	@FindBy(xpath="//*[@id=\"shopify-section-sections--21688849727761__header\"]/section/div[1]/header[2]/div[3]/div/div[1]/ul/li[2]/a")
	WebElement productlabel;
	@FindBy(xpath="//*[@id=\"CollectionProductGrid\"]")
	static
	WebElement products;
	@FindBy(name="add")
	static
	WebElement addtocartButton;

	
	public ProductPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void shopByCollectionTest() {
		
		productlabel.click();
        productValidation();
	}
	
	public static void productValidation() {
		
		List<WebElement> list=products.findElements(By.tagName("a"));
		int listSize=list.size();
		System.out.println("No of products = "+listSize);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for(WebElement product:list) {
			String productLink=product.getAttribute("href");
			String productName=product.getText();
			System.out.println(productLink+" "+productName);
			if(productName.isEmpty()) {
				continue;
			}
			else {
				product.click();
				addtocartButton.click();
				driver.navigate().refresh();
				driver.navigate().back();
			}
			

		}
		
		
	}
	
	public void noOfCartItems() throws Exception {
		
		String exp="6";
		WebElement cartDetails=driver.findElement(By.xpath("/html/body/div[2]/section/div[1]/header[2]/div[3]/div/div[3]/a/span[2]"));
		String cartItems=cartDetails.getText();
		try {	
		Assert.assertEquals(cartItems, exp);
		LOGGER.info("No of cart items validated");
		}
		catch (Exception e) {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshot/cartdefect.png"));
			LOGGER.severe("No of cart items are not validated");
			
		}
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}

}
