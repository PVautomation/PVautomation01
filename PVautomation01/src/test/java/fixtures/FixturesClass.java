package fixtures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import com.relevantcodes.extentreports.*;
import com.pv.project1.PageObjectModelClass;
import drivers.DriverFactory;

public class FixturesClass extends DriverFactory
{
	
	public WebDriver driver;
	  public String baseURL;
	  
	  	//= new ExtentReports("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\test-output\\"+"ExtentReport.html", true);
		
				//report.createTest("START");
		public static ExtentReports report;
	//public ExtentHtmlReporter htmlreport;
	 
	    public static ExtentTest test;
	    ExtentSparkReporter spark;
	    
		static int i = 0;
	  	
	  	File source;
    	String destination1;
     
	        
	  
	   @BeforeSuite
       public void setup() throws IOException {
       	  
       	
          
       	//--------------------
       	//extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
       	        //  report = new ExtentReports("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\report\\report.html", false);
       	        //  test = report.startTest("Test Started1");
       	         //   report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
       	          
           report = new ExtentReports();
       	          // htmlreport = new ExtentHtmlReporter("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\report\\report.html");
       	           //report.attachReporter(htmlreport);
       	                  	           
       	         // spark = new ExtentSparkReporter("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVautomation01\\report\\report.html");
       	          spark = new ExtentSparkReporter(System.getProperty("user.dir")+"./ExtentReport/ExtentReport.html");
           
           
       	           String css = ".r-img {width: 100%;}";
       	           spark.config().setCss(css);
       	           
       	           //spark.loadXMLConfig("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVautomation01\\src\\test\\resources\\extent-config.xml");
       	           spark.loadXMLConfig(System.getProperty("user.dir")+"./ExtentReport/extent-config.xml");
       	           
       	           report.attachReporter(spark);
       	           //("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVautomation01\\src\\test\\resources\\extent-config.xml");
       	           
       	       //     spark = new ExtentSparkReporter("target/Spark/Spark.html");
       	          //  report.attachReporter(spark);
       	            
       	         
       	         report.setSystemInfo("Environment", "AUTOMATION");
       	         report.setSystemInfo("User Name", "Preetha V");
       	         report.setSystemInfo("Host Name", "Machine for Automation Testing");
       	         report.setSystemInfo("Teschnologies Frameworks", "JAVA, Selenium, TestNG");
          

       }


	   
	   //55555555555555555555555555555555555555555555555555555555555555555555555555555
	   
	   @AfterSuite
		public void afterTestMethod()
		{
		//report.endTest(test);
			report.flush();
			//report.close();
		}
	        
	    /*    @AfterSuite
	        public void tearDown() 
	        {
	        
	            driver.quit();
	            
	        }
	        */
	  //5555555555555555555555555555555555555555555555555555555555555555555555555555555555
	        
	        
	       
	   
	   
            protected final boolean isElementPresent(By b) {
                try {
                    driver.findElement(b);
                    return true;
                }
                catch (Exception e) {
                    return false;
                }
                
            }
	   
	   
	   //55555555555555555555555555555555555555555555555555555555555555555555555555
            
            

            
            
            
            //8888888888888888888888888888888888888888888888888888888
            
            
        	public String getScreenshot()
        	{
        		//WebDriver driver, String screenshotname
        		/*
        		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        		//String screenshot;
        		TakesScreenshot ts = (TakesScreenshot) driver;
        		File source = ts.getScreenshotAs(OutputType.FILE);
        		// after execution, you could see a folder "FailedTestsScreenshots"
        		// under src folder
        		String destination = System.getProperty("user.dir")+screenshotname+dateName+".png";
        		
        		//String destination = "src/../screenshots" + System.currentTimeMillis() + ".png";
        		//String destination = "C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\" + screenshotname +  ".png";
        		//System.currentTimeMillis() +
        		
        		File finalDestination = new File(destination);
        		
        		//String absolutepath = finalDestination.getAbsolutePath();
        		
        		FileUtils.copyFile(source, finalDestination);
        		
        		return destination;
        		
        		*/
        		/*
        		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        		//String screenshot;
        		TakesScreenshot ts = (TakesScreenshot) driver;
        		File source = ts.getScreenshotAs(OutputType.FILE);
        		// after execution, you could see a folder "FailedTestsScreenshots"
        	   // String destination = System.getProperty("user.dir")+"screenshotname"+dateName+".png";
        		//String destination = "src/../screenshots" + System.currentTimeMillis() + ".png";
        		//String destination = "C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\" + screenshotname +  ".png";
        		//System.currentTimeMillis() +
        		File finalDestination = new File("screen1.png");
        		//String absolutepath = finalDestination.getAbsolutePath();
        		//FileUtils.copyFile(source, finalDestination);
        		FileHandler.copy(source, finalDestination);
        	//	test.addScreenCapture("screen2.png");
        		
        		*/
        		
        		try
        		{
        			
        			i++;
        			int j = i;
         		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        		//String screenshot;
        		TakesScreenshot ts = (TakesScreenshot) driver;
        		source = ts.getScreenshotAs(OutputType.FILE);
        		// after execution, you could see a folder "FailedTestsScreenshots"
        	   // String destination = System.getProperty("user.dir")+"screenshotname"+dateName+".png";
        		
        		
        		//destination1 = System.getProperty("user.dir") + File.separator + "/screenshots/"+"NewScr" + j +".png";
        		//destination1 = "C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVautomation01\\screenshots\\" + "screenshot" + j +".png";
        		destination1 = "./ExtentReport/screenshots/"+"NewScr" + j +".png";
        		
        		//String destination = "src/../screenshots" + System.currentTimeMillis() + ".png";
        		//String destination = "C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\" + screenshotname +  ".png";
        		//System.currentTimeMillis() +
        		File finalDestination = new File(destination1);
        		//String absolutepath = finalDestination.getAbsolutePath();
        		//FileUtils.copyFile(source, finalDestination);
        		FileUtils.copyFile(source, finalDestination);
        		//test.addScreenCaptureFromPath("screen1.png");
        		
        		}
        		catch(Exception e)
        		{
        			System.out.println("Exception by FILE class");
        		}
        		return destination1;
        	
        	}
	   
	   
	   
	
	
	

}
