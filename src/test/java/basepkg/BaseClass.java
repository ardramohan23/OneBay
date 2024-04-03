package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	String url="https://onebay.in/";
	
	@BeforeTest
	public void setUp() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	

}
