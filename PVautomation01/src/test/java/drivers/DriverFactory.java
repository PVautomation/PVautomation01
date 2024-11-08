package drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 

{
   //  static String browser;
public static WebDriver driver;

//	public DriverFactory(String browserName)
//	{
//		browser = browserName;
//	}
	
	public static WebDriver chooseBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		  	WebDriverManager.chromedriver().setup();  		
	        //ChromeOptions option = new ChromeOptions();
	        //option.addArguments("--headless");
		  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pvenkatarajan\\Downloads\\chromedriver-win64\\chromedriver.exe");
	         driver = new ChromeDriver();
		}
		return driver;
	}
	
	
	
	
	
}
