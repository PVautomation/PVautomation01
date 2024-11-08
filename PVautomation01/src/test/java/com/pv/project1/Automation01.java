
package com.pv.project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.DriverFactory;
import fixtures.FixturesClass;
//import com.aventstack.extentreports.MediaEntityBuilder;
import io.restassured.response.Response;





public class Automation01 extends FixturesClass

{

int i;
Response res1, res2;
	
	String cancatenate = ".";
	// public WebDriver driver;
	private boolean offerpresent, got_funding;
//        HSSFWorkbook workbook;
//        HSSFSheet sheet;
//        HSSFCell cell;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String[] data = { "78748", "$10,000", "Appliances", "pvTest04252024", "pvTest04252024", "AUKIA MSUPB	277", "666-15-1122",
			"02/25/1999", "pvTest04252024@mailinator.com", "(512) 501-1234", "myself", "0", "$500", "$20,000", "$19,100" };
	// String[] data0 = {"data1", "data2", "data3", "data4", "data5", "data6",
	// "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14",
	// "data15"};
//       // String data;

	// public ExtentHtmlReporter htmlReporter;
	// public ExtentReports extentTest= extent.assignProject("TEST");
	// public ExtentHtmlReporter;
	// public ITestResult result;

	// ExtentSparkReporter spark;

//	public Automation01(ExtentTest test){
//        
//        this.test=test;
//    }

//    bs()
//    {
//
//    }

	// private StringBuilder verificationErrors;
	public String baseURLCP = "https://secure-test.republicfinance.com/apps/account/login";
	// private boolean acceptNextAlert = true;
	private boolean pay_success;
	
	// string[] data = { "78749", "$2,000", "Appliances", "ELAINE", "AACRWAFWSP",
	// "AUKIA MSUPB 277", "666-14-0503", "02/25/1963", "preethapv01+la15@gmail.com",
	// "(111) 111-1111", "myself", "0", "$500", "$20,000", "$19,100" };
//baseURLCP = "https://secure-test.republicfinance.com/apps/account/login";

//        public void Automain01(ITestResult result)
//        {
//        	this.result = result;	
//        }

	/*
	 * @AfterMethod public void endReport(){ extent.flush(); //extent.close(); }
	 */

//        public void setExtentReport()
//        {
//        	ExtentHtmlReporter htmlrepo1;
//        }

//        public void mapArray()
//        {
//        	Map<String, String> map = new HashMap<String, String>();
//        	
//        	for(int i=0;i<15;i++)
//        	{
//        		data0[i]=data[i];
//        		//map.put(data0[0], data[0]);
//        		//map.get(data0[0]);
//        	}
//        }

//        public static IEnumerable<object[]> GetExcelData() {
//            ExcelPackage ep = new ExcelPackage(new FileInfo("Data1.xlsx"));
//            ExcelWorksheet worksheet = ep.Workbook.Worksheets["C"];
//            int rowcount = worksheet.Dimension.End.Row;
//            for (int i = 2; (i <= rowcount); i++) {
//                yield;
//                return new object[] {
//                        worksheet.Cells[i, 1].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 2].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 3].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 4].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 5].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 6].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 7].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 8].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 9].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 10].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 11].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 12].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 13].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 14].Value?.ToString().Trim(),
//                        worksheet.Cells[i, 15].Value?.ToString().Trim()};
//            }

//        public void ReadData() throws IOException
//        {
//            // Import excel sheet.
//            File src=new File("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\src\\test\\java\\com\\pv\\test\\Data1.xls");
//             
//            // Load the file.
//            FileInputStream finput = new FileInputStream(src);
//             
//            // Load he workbook.
//           workbook = new HSSFWorkbook(finput);
//             
//            // Load the sheet in which data is stored.
//            sheet= workbook.getSheet(C);
//             
//            int totalrows = sheet.getLastRowNum() - sheet.getFirstRowNum()+1;
//            int totalcols = sheet.getRow(0).getLastCellNum();
//            
//            System.out.println("total rows" +totalrows + "total columns" +totalcols);
//            
//            for(int i=1; i&amp;lt;=sheet.getLastRowNum(); i++)
//            {
//                // Import data for Email.
//                cell = sheet.getRow(i).getCell(1);
//                cell.setCellType(Cell.CELL_TYPE_STRING);
//                driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
//                 
//                // Import data for password.
//                cell = sheet.getRow(i).getCell(2);
//                cell.setCellType(Cell.CELL_TYPE_STRING);
//                driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
//                        
//               }
//         } 

	/*
	 * 
	 * @DataProvider(name ="excel-data") public Object[][] excelDP() throws
	 * IOException{ //We are creating an object from the excel sheet data by calling
	 * a method that reads data from the excel stored locally in our system
	 * //Object[][] arrObj = getExcelData("data1", "data2", "data3", "data4",
	 * "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12",
	 * "data13", "data14", "data15"); Object[][] arrObj = getExcelData(); return
	 * arrObj; } //This method handles the excel - opens it and reads the data from
	 * the respective cells using a for-loop & returns it in the form of a string
	 * array //public String[][] getExcelData(String data1, String data2, String
	 * data3, String data4, String data5, String data6, String data7, String data8,
	 * String data9, String data10, String data11, String data12, String data13,
	 * String data14, String data15) throws IOException{ public String[][]
	 * getExcelData() throws IOException { String[][] data = null; //= null; // try
	 * // {
	 * 
	 * // Import excel sheet. File src=new File(
	 * "C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\src\\test\\java\\com\\pv\\test\\Data1.xlsx"
	 * ); // // Load the file. fis = new FileInputStream(src); wb = new
	 * XSSFWorkbook(fis); sh = wb.getSheet("C"); XSSFRow row = null; //=
	 * sh.getRow(0); int noOfRows = sh.getPhysicalNumberOfRows(); int noOfCols =
	 * row.getLastCellNum(); Cell cell; data = new String[noOfRows-1][noOfCols];
	 * 
	 * for(int i =2; i<=noOfRows;i++){ for(int j=1;j<=noOfCols;j++){ row =
	 * sh.getRow(i); cell= row.getCell(j); data[i][j] = cell.getStringCellValue(); }
	 * } return data;
	 * 
	 * // catch (Exception e) { // System.out.println("The exception is: "
	 * +e.getMessage()); // } //// finally //// { //// fis.close(); //// }
	 * 
	 * }
	 */

	/*
	 * 
	 * @DataProvider(name = "excel-data") public Object[][]
	 * getLoginDataForAllRoles() throws Exception {
	 * 
	 * 
	 * ParsingExcel userData = new ParsingExcel("testdata/SampleExcel.xlsx",
	 * "Users");
	 * 
	 * 
	 * ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 * 
	 * int i = 1;// excluding header row int totalRows = 4;// the row number of data
	 * in the sheet while (i < totalRows) { System.out.println("Users : line : " +
	 * i);
	 * 
	 * Object[] dataLine = new Object[6]; dataLine[0] = userData.getCell(i, 0);//
	 * Test No dataLine[1] = userData.getCell(i, 1);// LastName dataLine[2] =
	 * userData.getCell(i, 2);// FirstName dataLine[3] = userData.getCell(i, 3);//
	 * GmailAddress dataLine[4] = userData.getCell(i, 4);// Passwd dataLine[5] =
	 * userData.getCell(i, 5);// PasswdAgain
	 * 
	 * 
	 * dataList.add(dataLine);
	 * 
	 * i++; }
	 * 
	 */

//        @BeforeMethod
//        public void bforeEachMethod()
//       {
//        	   result.setTestName("ZipCode-Page-Test1");       	
//        	//extentTest = extent.createTest("a");
//        }

	
	
	
	
     
     

	
	
	
	
	
	
	@Test
	public void test1Method() throws IOException {

		test = report.createTest("ZipCode Page TEST");

		// test = new ExtentTest();
		// report.createTest("Test Started01");
		// Object obj = test.getExtent();

		// test.log(Status.INFO, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Zipcode test started");
		test.pass("Zipcode test started",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		// test.addScreenCapture(Automation01.getScreenshot(driver, "a1"))+
		// extentTest = extent.startTest("test1Method");

//        	JavascriptExecutor js10 = (JavascriptExecutor)driver;
//              js10.executeScript("window.scrollTo(0, document.body.scrollHeight - 150)");

		PageObjectModelClass.welcome_Zipcode.sendKeys(data[0]);
		System.out.println("Complted zipcode");

		// Assert.isTrue(true, "a", "a");
		// testCase.log(Status.PASS, "test1Method Test Passed");
		// test.log(Status.PASS,
		// MediaEntityBuilder.createScreenCaptureFromPath("screens1.png").build() +
		// "Completed Zipcode Test");
		// test.log(Status.PASS,
		// MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString()
		// + "/screen1.png").build() + "Completed Zipcode Test");
		// test.log(Status.PASS,
		// MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screen1.png").build()
		// + "Completed Zipcode Test");

		// addScreenCaptureFromPath in com.aventstack works
		// test.log(Status.PASS,
		// test.addScreenCaptureFromPath("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screen1.png")
		// + "Completed Zipcode Test");

		// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Completed Zipcode Test");
		test.pass("Completed Zipcode Test",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		// test.addScreenCaptureFromPath(getScreenshot())+
		// test.addScreenCapture("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\screen1.png")

		//driver.close();
		
	}

	@Test
	public void test2Method() throws InterruptedException, IOException {

		
		test = report.createTest("Purpose Page TEST");

		// test.log(Status.INFO, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Purpose javascriptexecutor started");
		// test.log(LogStatus.INFO, "Purpose page test started");
		// test.log(LogStatus.WARNING, test.addScreenCapture(getScreenshot(driver,
		// "a3"))+"Purpose javascriptexecutor started");

		Thread.sleep(3000);
		
		
      //  ((JavaScriptExecutor)driver).ExecuteScript("window.scrollTo(0, document.body.scrollHeight - 150)");
      //  ((JavaScriptExecutor)driver).ExecuteScript("arguments[0].click();", welcome_NextButton);
      
		
		((JavascriptExecutor) (driver)).executeScript("arguments[0].scrollIntoView(true)", PageObjectModelClass.welcome_NextButton);
		//Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.welcome_NextButton);
		//PageObjectModelClass.welcome_NextButton.click();
		try {
			// @SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(PageObjectModelClass.purpose_HowMuch));
			// wait.Until(ExpectedConditions.ElementToBeClickable(PageObjectModelClass.purpose_HowMuch));
			//PageObjectModelClass.purpose_HowMuch.click();
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.purpose_HowMuch);			
			
			Select d15 = new Select(PageObjectModelClass.purpose_HowMuch);
			d15.selectByVisibleText(data[1]);
			// (new SelectElement(PageObjectModelClass.purpose_HowMuch) +
			// SelectByText(data2));
		} catch (Exception e) {
//             	File src3 = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
//                 FileUtils.copyFile(src3, new File("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\src4.png") );
//                 System.out.println("Took screenshot after zipcode action");
//                 Screenshot newscr021 = ((ITakesScreenshot)(this.driver)).GetScreenshot();
//                 newscr021.SaveAsFile("C://Users//pvenkatarajan//source//repos//SeleniumAutomation01//SeleniumAutomation01//after-zipcode.pn" +
//                     "g", ScreenshotImageFormat.Png);

		}

		// IWebElement purpose_FundUse =
		// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[2]/div[2]/div/select"));
		PageObjectModelClass.purpose_FundUse.click();
		Select d11 = new Select(PageObjectModelClass.purpose_FundUse);
		d11.selectByVisibleText(data[2]);
		WebElement purpose_HowHear = driver
				.findElement(By.xpath("//*[@id=\'wizardProfile\']/div[2]/div/div[2]/div/div[4]/div/select"));

		try {
			purpose_HowHear.click();
		} catch (Exception e) {
//                 Screenshot newscr028 = ((ITakesScreenshot)(this.driver)).GetScreenshot();
//                 // newscr.SaveAsFile(("C://Users//pvenkatarajan//source//repos//SeleniumTests2//SeleniumTests2//Image_ct1.png"), System.Drawing.Imaging.ImageFormat.Jpeg);
//                 newscr028.SaveAsFile("C://Users//pvenkatarajan//source//repos//SeleniumAutomation01//SeleniumAutomation01//elt-intercept.pn" +
//                     "g", ScreenshotImageFormat.Png);
//                 Console.WriteLine("Took screenshot after zipcode action");
//                 
//                	File src5 = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
//                 FileUtils.copyFile(src5, new File("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\src6.png") );
			System.out.println("Took screenshot after zipcode action");
		}

		// IJavaScriptExecutor jse8 = (IJavaScriptExecutor)driver;
		// jse8.ExecuteScript("arguments[0].click()", purpose_HowHear);
		// purpose_HowHear.Click();

		Select d12 = new Select(purpose_HowHear);
		d12.selectByVisibleText("Email");
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", d12.selectByVisibleText("Email"));
		
		// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Completed Purpose Page Test");
		test.pass("Completed Purpose Page Test",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		Thread.sleep(3000);
		//driver.findElement(By.id("next-button")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("next-button")));

		// test.log(LogStatus.PASS, test.addScreenCapture(getScreenshot(driver,
		// "a4"))+"Purpose page test passed");

	}

	@Test
	public void test3Method() throws IOException, InterruptedException {
		test = report.createTest("About Page TEST");

		Thread.sleep(2000);
		try {
			// IWebElement about_FirstName = driver.FindElement(By.Id("firstName"));
			PageObjectModelClass.about_FirstName.click();
			PageObjectModelClass.about_FirstName.clear();
			PageObjectModelClass.about_FirstName.sendKeys(data[3]);
		} catch (Exception e) {
//               	File src7 = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
//                 FileUtils.copyFile(src7, new File("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\src8.png") );

			System.out.println("Took screenshot after firstname action");

		}

		// IWebElement about_LastName =
		// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div[3]/div/input"));
		// For dev env :
		// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div[3]/div/input"));
		PageObjectModelClass.about_LastName.click();
		PageObjectModelClass.about_LastName.clear();
		PageObjectModelClass.about_LastName.sendKeys(data[4]);
		Thread.sleep(5000);
		
		PageObjectModelClass.about_Email.click();
		PageObjectModelClass.about_Email.clear();
		PageObjectModelClass.about_Email.sendKeys(data[8]);
		// IWebElement about_Phone =
		// driver.FindElement(By.XPath("//*[@id='identity-row']/div[2]/div[3]/div/input"));
		PageObjectModelClass.about_Phone.click();
		PageObjectModelClass.about_Phone.clear();
		PageObjectModelClass.about_Phone.sendKeys(data[9]);
		
		Thread.sleep(2000);;
		// IWebElement about_Dob =
		// driver.FindElement(By.XPath("//*[@id='identity-row']/div[1]/div[3]/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.about_Dob);
		//PageObjectModelClass.about_Dob.click();
		PageObjectModelClass.about_Dob.clear();
		PageObjectModelClass.about_Dob.sendKeys(data[7]);
		// IWebElement about_Email =
		// driver.FindElement(By.XPath("//*[@id='identity-row']/div[2]/div[2]/div/input"));

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.about_Ssn);
		//PageObjectModelClass.about_Ssn.click();
		PageObjectModelClass.about_Ssn.clear();
		PageObjectModelClass.about_Ssn.sendKeys(data[6]);

		// IWebElement about_Street =
		// driver.FindElement(By.XPath("//*[@id='address-row']/div[1]/div[2]/div/input"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.about_Street);
		//PageObjectModelClass.about_Street.click();
		PageObjectModelClass.about_Street.clear();
		PageObjectModelClass.about_Street.sendKeys(data[5]);
		// IWebElement about_Ssn = driver.FindElement(By.Id("ssn"));
		
		if (data[10].equals("myself")) {
			// IWebElement about_WhoApplies =
			// driver.FindElement(By.XPath("//div[@id='singleOrCo-row']/div/div/div[2]/div/div/p"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.about_WhoApplies);
			//PageObjectModelClass.about_WhoApplies.click();
		} else {
			// LATER CO-BORROWER CODE
		}

		// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Completed About Test");
		test.pass("Completed About Page Test",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		// IWebElement about_NextButton = driver.FindElement(By.Id("next-button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.about_NextButton);
		//PageObjectModelClass.about_NextButton.click();

	}

	@Test
	public void test4Method() throws InterruptedException, IOException {

		test = report.createTest("Child Frame TEST");

		Thread.sleep(2000);
		System.out.println("INTO CHILD FRAME");
		// IWebElement childFrame_checkBox1 =
		// driver.FindElement(By.XPath("//*[@id='myModal']/div/div/div[2]/div/div[1]/div[2]/div/div/label/div/input"));
		PageObjectModelClass.childFrame_checkBox1.click();
		// TCPA consent
		// IWebElement childFrame_checkBox2 =
		// driver.FindElement(By.XPath("//*[@id='myModal']/div/div/div[2]/div/div[2]/div[2]/div/div/label/div/input"));

		// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Completed Child Frame Test");
		test.pass("Completed Purpose Page Test", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.childFrame_checkBox2);
		//PageObjectModelClass.childFrame_checkBox2.click();
		// IWebElement childFrame_NextButton =
		// driver.FindElement(By.XPath("//*[@id='modal-next-button']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.childFrame_NextButton);
		//PageObjectModelClass.childFrame_NextButton.click();
		System.out.println("CHILD FRAME COMPLETE");
		// Thread.Sleep(5000);
		System.out.println("CAME INTO MAIN FRAME");
		Thread.sleep(4000);
		if (data[11].equals("0")) {
			// IWebElement finance_Own1 =
			// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div[2]/div/div/label[1]/input"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.finance_Own1);
			System.out.println("SELECTED OWN");
		} else {
			// IWebElement finance_Own2 =
			// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[1]/div[2]/div/div/label[2]/input"));
			PageObjectModelClass.finance_Own2.click();
			System.out.println("SELECTED RENT");
		}

	}

	@Test
	public void test5Method() throws IOException, InterruptedException {

		test = report.createTest("Finance Page TEST");

		// Thread.Sleep(3000);
		// IWebElement finance_MortgageRent =
		// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[2]/div[2]/div/input"));
		PageObjectModelClass.finance_MortgageRent.clear();
		PageObjectModelClass.finance_MortgageRent.sendKeys(data[12]);
		// IWebElement finance_Dependants =
		// driver.FindElement(By.XPath("//*[@id='wizardProfile']/div[2]/div/div/div[3]/div[2]/div/select"));
		//Thread.sleep(2000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.finance_Dependants);
		//PageObjectModelClass.finance_Dependants.click();
		Select d1 = new Select(PageObjectModelClass.finance_Dependants);
		d1.selectByVisibleText("0");

		// IWebElement finance_Income =
		// driver.FindElement(By.XPath("//*[@id='incomeAmount']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.finance_Income);
		//PageObjectModelClass.finance_Income.click();
		PageObjectModelClass.finance_Income.clear();
		PageObjectModelClass.finance_Income.sendKeys(data[13]);
		// IWebElement finance_VerifiableIncome =
		// driver.FindElement(By.XPath("//*[@id='employment-row']/div[2]/div[2]/div/input"));
	
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectModelClass.finance_VerifiableIncome));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.finance_VerifiableIncome);
		//PageObjectModelClass.finance_VerifiableIncome.clear();
		//PageObjectModelClass.finance_VerifiableIncome.sendKeys(data[14]);
		// IWebElement finance_NextButton = driver.FindElement(By.Id("next-button"));

		// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
		// "Completed Finance Page Test");
		test.pass("Finance Page Test",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.finance_NextButton);
		//PageObjectModelClass.finance_NextButton.click();
	}

//  @Test(dataProvider="excel-data")
//	public void TheCase1Test(String data1, String data2, String data3, String data4, String data5, String data6, String data7, String data8, String data9, String data10, String data11, String data12, String data13, String data14, String data15) throws InterruptedException, IOException {
	
	// @SuppressWarnings("deprecation")
	@Test
	public void TheCase1Test() throws InterruptedException, IOException {

		// mapArray();
		// 8888888888888888888888888888888888888888888888888

		test = report.createTest("PREQUAL Offer TEST");

		Thread.sleep(3000);
		System.out.println("Final Screen");
		// System.Diagnostics.Debug.WriteLine("Final screen");
		//IWebElement consent_ChkBox =
		//driver.FindElement(By.XPath("//*[@id='loading']/div/div[1]/div[2]/div/div/label/div/input"));
		//Thread.sleep(3000);
		//Thread.sleep(5000);	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(PageObjectModelClass.consent_ChkBox));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.consent_ChkBox);
		
		//PageObjectModelClass.consent_ChkBox.click();
		// driver.FindElement(By.Id("back-button")).Click();
		// IWebElement consent_ChkOfferButton =
		// driver.FindElement(By.XPath("//*[@id='next-button']"));
		
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", PageObjectModelClass.consent_ChkOfferButton);
		PageObjectModelClass.consent_ChkOfferButton.click();
		
		System.out.println("CALCULATING OFFER");
		Thread.sleep(10000);
		System.out.println("CHECKING TITLE");
		String title = driver.getTitle().toLowerCase();
		System.out.println(title);
		try {
			// IWebElement congratulations =
			// driver.FindElement(By.XPath("//*[contains(text(),'Congratulations!')]"));
			offerpresent = PageObjectModelClass.congratulations.isDisplayed();
		} catch (Exception e) {
			System.out.println("Did not get offer");
		}

		if ((offerpresent == true)) {

			test.pass("Completed Offer Test",
					MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight - 150)");

			// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
			// "Completed Offer Page Test");
			test.pass("Completed Purpose Page Test",
					MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

			Assert.assertEquals(offerpresent, true);

			// string url2 = driver.Url;
			System.out.println("\n Congratulations! YOU GOT OFFER \n  CLICK ON THE BELOW LINK TO APPLY!!! \n");
			System.out.println("\n Congratulations! YOU GOT OFFER");
			System.out.println("CLICK ON THE BELOW LINK TO APPLY!!! \n" + driver.getCurrentUrl());
			System.out.println(driver.getCurrentUrl());
			System.out.println("\n");
		}

		if ((offerpresent == false)) {

			test.fail("Completed Offer Test",
					MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight - 150)");

			// test.log(Status.PASS, test.addScreenCaptureFromPath(getScreenshot()) +
			// "Completed Offer Page Test");
			test.fail("Completed Purpose Page Test",
					MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());

			Assert.assertEquals(offerpresent, true);

			if (title.contains("declined")) {
				System.out.println("APPLICATION DECLINED");
				System.out.println("APPLICATION DECLINED");
			} else if (title.contains("no match")) {
				System.out.println("APPLICATION DECLINED - NO MATCH");
				System.out.println("APPLICATION DECLINED - NO MATCH");
			} else if (title.contains("downtime-error")) {
				System.out.println("APPLICATION DECLINED - Downtime-Error");
				System.out.println("APPLICATION DECLINED - Downtime-Error");
			} else if (title.contains("404")) {
				System.out.println("GOT 404");
				System.out.println("GOT 404");
			}

		}

		System.out.println("SELENIUM TEST COMPLETED SUCCESSFULLY!!! \n");
		System.out.println("Complted full test(debug)");
		System.out.println("Complted full test(trace)");
		System.out.println("Complted full test(console)");
		//Thread.sleep(2000);
//                File src1 = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(src1, new File("C:\\Users\\pvenkatarajan\\eclipse-workspace\\PVproject1\\screenshots\\src2.png") );
//                // newscr.SaveAsFile(("C://Users//pvenkatarajan//source//repos//SeleniumTests2//SeleniumTests2//Image_ct1.png"), System.Drawing.Imaging.ImageFormat.Jpeg);
//               // newscr025.SaveAsFile("C://Users//pvenkatarajan//source//repos//SeleniumAutomation01//SeleniumAutomation01//OfferPg1.png", ScreenshotImageFormat.Png);
//                System.out.println("Took screenshot in offer screen");

		//driver.close();
	}


	/*
	 * @AfterMethod public void afterEachMethod(ITestResult result) throws
	 * IOException{
	 * 
	 * 
	 * 
	 * //extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	 * // result.getStatus(); result.setStatus(ITestResult.SUCCESS);
	 * result.setTestName("ZipCode-Page-Test1");
	 * 
	 * String screenshotPath3 = Automation01.getScreenshot(driver,
	 * "ZipCode-Page-Test"); //extentTest.log(LogStatus.PASS,
	 * extentTest.addScreenCapture(screenshotPath3)); //to add screenshot in extent
	 * report //extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreencast(screenshotPath));
	 * 
	 * // extent.endTest(extentTest); //ending test and ends the current test and
	 * prepare to create html report ////driver.quit(); extent.flush();
	 * extent.close();
	 * 
	 * /*
	 * 
	 * if(result.getStatus()==ITestResult.FAILURE){ extentTest.log(LogStatus.FAIL,
	 * "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
	 * extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable());
	 * //to add error/exception in extent report
	 * 
	 * String screenshotPath = Automation01.getScreenshot(driver, result.getName());
	 * extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
	 * //to add screenshot in extent report //extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreencast(screenshotPath)); } else
	 * if(result.getStatus()==ITestResult.SKIP){ extentTest.log(LogStatus.SKIP,
	 * "Test Case SKIPPED IS " + result.getName());
	 * 
	 * String screenshotPath2 = Automation01.getScreenshot(driver,
	 * result.getName()); extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreenCapture(screenshotPath2)); //to add screenshot in extent
	 * report //extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreencast(screenshotPath));
	 * 
	 * } else if(result.getStatus()==ITestResult.SUCCESS){
	 * extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	 * 
	 * String screenshotPath3 = Automation01.getScreenshot(driver,
	 * result.getName()); extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreenCapture(screenshotPath3)); //to add screenshot in extent
	 * report //extentTest.log(LogStatus.FAIL,
	 * extentTest.addScreencast(screenshotPath)); }
	 * 
	 */
	// extent.endTest(extentTest); //ending test and ends the current test and
	// prepare to create html report
	// driver.quit();
//extent.flush();
	// extent.close();

	// }

//888888888888888888888888888888  CP START  88888888888888888888888888888888

	/*
	
	@Test(priority = 6)
	public void testCustomerPortal() throws InterruptedException {

		test = report.createTest("CUSTOMER PORTAL TEST");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// if starting from offer page
		// driver.Navigate().GoToUrl("https://secure-test.republicfinance.com/apply/prequalification?applicationId=6037dd7d8e70b80028247634");
		// apply online button
		// driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/form/div[2]/div[2]/div[1]/div[3]/button")).Click();

		// if starting from login page
		driver.navigate().to(baseURLCP);
		driver.findElement(By.xpath("//*[@id='username']")).click();
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("preethapv01+10081@gmail.com");

		// login pwd (if coming frm offer page, pwd fields have this xpath)
		// driver.FindElement(By.XPath("//*[@id='password']")).Click();
		// driver.FindElement(By.XPath("//*[@id='password']")).Clear();
		// driver.FindElement(By.XPath("//*[@id='password']")).SendKeys("P@ssword123");

		// login pwd (if coming frm login page, pwd fields have this xpath)
		driver.findElement(By.xpath("//*[@id='password']")).click();
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("P@ssword123");

		// login submit (if coming from offer pg)
		// driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/div[1]/button")).Click();
		// driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/div[1]/button")).Click();

		// login submit (if coming frm login pg)
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/form/button")).click();
		// logi pg completed

		Thread.sleep(8000);
		
		test.pass("Customer Portal test passed",
				MediaEntityBuilder.createScreenCaptureFromPath(cancatenate + getScreenshot()).build());
		Assert.assertEquals(true, true);

		//driver.close();
		  
		
////		  try {
//	
//            driver.findElement(By.xpath("//*[@id='root]/div[2]/div/div/div/div[1]/div/div[2]/div[1]/div[3]/button")).click();
//
//            driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/button[1]")).click();
//
////            //new SelectElement(driver.FindElement(By.XPath("//*[@id='selectFundingAccount']"))).SelectByIndex(7);
////
////
////            // MMMMMMMMMMMMMMMMMMMMMM   GIVE EXPLICIT WAIT CONDITION start MMMMMMMMMMMMMMMMMMMMMMM
////
////           
////                WebDriverWait wait = new WebDriverWait(driver, 10);
////                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='selectFundingAccount']"))));
////
////                //IJavaScriptExecutor jse2 = (IJavaScriptExecutor)driver;
////                //jse2.ExecuteScript("arguments[0].click()", pom.purpose_HowMuch);
////                driver.findElement(By.xpath("//*[@id='selectFundingAccount']")).click();
////                //Thread.Sleep(5000);
////                new Select(driver.findElement(By.xpath("//*[@id='selectFundingAccount']"))).selectByIndex(6);
////                
////                
////                              
////            }
////            catch (Exception e)
////            {
////            	// Assert.assertEquals(true, true);
////            	test.fail("In Catch Block - Unable to make payment", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
////            	
//////                Screenshot newscr021 = ((ITakesScreenshot)driver).GetScreenshot();
//////                //newscr.SaveAsFile(("C://Users//pvenkatarajan//source//repos//SeleniumTests2//SeleniumTests2//Image_ct1.png"), System.Drawing.Imaging.ImageFormat.Jpeg);
//////                newscr021.SaveAsFile(("C://Users//pvenkatarajan//source//repos//PrequalSelenium1//PrequalSelenium1//debitDropDown.png"), ScreenshotImageFormat.Png);
//////                Console.WriteLine("Took screenshot after debit dropdown click action");
////            }
////
////            // MMMMMMMMMMMMMMMMMMMMMM   GIVE EXPLICIT WAIT CONDITION end MMMMMMMMMMMMMMMMMMMMMMM
////
////
////
// //           driver.findElement(By.xpath("//*[@id='amountDueCustom']")).click();
//            
//            driver.findElement(By.xpath("//*[@id='field-65']")).click();
//            driver.findElement(By.xpath("//*[@id='field-65']")).sendKeys("27");
//
//
//            //  MMMMMMMMMM SUBMIT IS DISABLED IN AUTOMATION (NOT IN MANUAL TEST) start MMMMMMMMMMMMM
//
//            driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div/div/div/div[2]/div/div[3]/div/button[1]")).click();
//
////            //  MMMMMMMMMM SUBMIT IS DISABLED IN AUTOMATION (NOT IN MANUAL TEST) end MMMMMMMMMMMMM
////
////            
//          driver.findElement(By.xpath("//*[@id=\'root\']/div[2]/div/div/div/div/div/div/div[2]/div[2]/button[1]")).click();
////
////
//            try
//            {
//                WebElement congratulations = driver.findElement(By.xpath("//*[contains(text(),'Your payment has been submitted!')]"));
//                pay_success = congratulations.isDisplayed();
//            }
//            catch(Exception e)
//            {
//            	test.fail("Your payment was not successful (Catch)", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
//            	
//               // Console.WriteLine("Your payment was not successful");
//            }
//
//            if (pay_success == true)
//            {
//            	test.pass("Your payment was successful. Thank you for your payment!", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
//            	
////                Console.WriteLine("\n Your payment was successful. Thank you for your payment! \n");
////                System.Diagnostics.Debug.WriteLine("\n Your payment was successful. Thank you for your payment!");
//            }
//            else
//            {
//            	test.fail("Your payment was NOT successful", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
//            	
////                Console.WriteLine("\n Your payment was NOT successful \n");
////                System.Diagnostics.Debug.WriteLine("\n Your payment was NOT successful");
//            }
//
//
//            // 9999999999999999999  CP  DONE 999999999999999999999999999999999999

		
	}
	
	
	
	
	
	@Test(priority = 7)
	public void testOnlineApp() throws InterruptedException {

		test = report.createTest("ONLINE APPLICATION TEST");

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	
	
		//if starting from offer page
        //driver.Navigate().GoToUrl("https://secure-test.republicfinance.com/apply/prequalification?applicationId=6037dd7d8e70b80028247634");
        //apply online button
        //driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/form/div[2]/div[2]/div[1]/div[3]/button")).Click();

        //if starting from login page
        driver.navigate().to("https://secure-test.republicfinance.com/apply/login");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Thread.Sleep(4000);

        driver.findElement(By.id("okta-signin-username")).click();
        driver.findElement(By.id("okta-signin-username")).clear();
        driver.findElement(By.id("okta-signin-username")).sendKeys("pv62006@mailinator.com");


        //login pwd (if coming frm offer page, pwd fields have this xpath)
        //driver.FindElement(By.XPath("//*[@id='password']")).Click();
        //driver.FindElement(By.XPath("//*[@id='password']")).Clear();
        //driver.FindElement(By.XPath("//*[@id='password']")).SendKeys("P@ssword123");

        //login pwd (if coming frm login page, pwd fields have this xpath)
        driver.findElement(By.id("okta-signin-password")).click();
        driver.findElement(By.id("okta-signin-password")).clear();
        driver.findElement(By.id("okta-signin-password")).sendKeys("P@ssword123");


        //login submit (if coming from offer pg)
        //driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/div[1]/button")).Click();
        //driver.FindElement(By.XPath("//*[@id='root']/div[2]/div[1]/div[1]/button")).Click();

        
        /*
         
        //login submit (if coming frm login pg)
        driver.findElement(By.id("okta-signin-submit")).click();
        //logi pg completed

        
        
      try
      {
          WebElement congratulations2 = driver.findElement(By.xpath("//*[contains(text(),'Thank you for trusting Republic Finance with your personal loan!')]"));
          got_funding = congratulations2.isDisplayed();
      }
      catch(Exception e)
      {
      	test.fail("Online Application Test FAILED (Catch)", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
      	
         // Console.WriteLine("Your payment was not successful");
      }

      if (got_funding == true)
      {
      	test.pass("Online Application Test PASSED !", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
      	
//          Console.WriteLine("\n Your payment was successful. Thank you for your payment! \n");
//          System.Diagnostics.Debug.WriteLine("\n Your payment was successful. Thank you for your payment!");
      }
      else
      {
      	test.fail("Online Application Test FAILED", MediaEntityBuilder.createScreenCaptureFromPath(cancatenate+getScreenshot()).build());
      	
//          Console.WriteLine("\n Your payment was NOT successful \n");
//          System.Diagnostics.Debug.WriteLine("\n Your payment was NOT successful");
      }
        
        
        
        driver.close();
	}

*/


/*

@Test(priority = 8)
	public void prequal_footprint_get() 
	{
		//driver.close();

		test = report.createTest("RestAssured API test : Prequal Footprint");
		
		baseURI = "https://www-test.republicfinance.com/";

	
		ValidatableResponse resp1 =		given().
		//param("name", "Automation").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().
		get("/qualify/api/branch/zipcode/78748").
		then().
		statusCode(200).
		log().all();
		
	//String s1 = res1.assertThat().statusCode(200).toString();
	// i = Integer.parseInt(res1.statusCode(200).toString());
	//System.out.println("SYSO" +i);
				
		res1 = RestAssured.get("https://www-test.republicfinance.com/qualify/api/branch/zipcode/78748");
		i= res1.getStatusCode();
if(i == 200)
{
	test.pass(resp1.log().all().extract().asPrettyString());
			//"PASSED : RestAssured API test : Prequal Footprint");
}

	}
	
	@Test(priority = 9)
	public void okta_login_post() {

		
		//driver.close();
		
		test = report.createTest("RestAssured API test : Okta Login");
		
		JSONObject request = new JSONObject();

		request.put("password", "P@ssword123");
		request.put("username", "preethapv01+b1011@gmail.com");
		request.put("options.warnBeforePasswordExpired", "true");
        request.put("options.multiOptionalFactorEnroll", "false");
		baseURI = "https://republicciam.oktapreview.com/";

		ValidatableResponse res = given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/api/v1/authn").
		then().
		statusCode(200)
		.log().all();
		
		
		//RestAssured.post("https://republicciam.oktapreview.com/api/v1/authn", request);
		
		Response resp = given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
				when().
				post("/api/v1/authn");
		
		if(resp.getStatusCode() == 200)
		{
			test.pass(res.log().all().extract().asPrettyString());
			//"PASSED : RestAssured API test : Okta Login");
			
		}
		
		*/
		
		
		
    @AfterTest
    public void tearDown() 
    {
    
        driver.quit();
        
    }
	
	
        @SuppressWarnings("deprecation")
		@BeforeTest
     public void beforeClassMethod() throws InterruptedException
     {
     	
            driver = DriverFactory.chooseBrowser("chrome");
            //this.driver = new ChromeDriver(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location), option);
            baseURL = "https://www-test.republicfinance.com/apps/prequal/";
            PageFactory.initElements(driver, PageObjectModelClass.class);
            
            
            
         // Using Implicit Wait
         //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         // Thread.Sleep(2000);
         driver.navigate().to(baseURL);
         driver.manage().window().maximize();
         
       
         //PageObjectModelClass pom = new PageObjectModelClass(this.driver);
         /// /// CK SECTION START
         /// /noMoreUse  IWebElement ck_button = driver.FindElement(By.XPath("//*[@id='master-page-zone']/section[1]/div/div/div[3]/div/div/a"));
         /// /lt
         /// /  IWebElement lt_button = driver.FindElement(By.XPath("//*[@id='master-page-zone']/section[1]/div/div/div[3]/div/div/a"));
         // PageObjectModelClass.ck_button.Click();
         /// /lt
         /// / lt_button.Click();
         // Thread.Sleep(1000);
         /// /// CK SECTION END
         
         
        //result.setTestName("ZipCode-Page-Test1");       	
     	//extentTest = extent.startTest("ZipCode-Page-Test");
         
         
        driver.manage().deleteAllCookies();
         Thread.sleep(2000);
         // HANDLE COOKIE BANNER
         if (isElementPresent(By.xpath("//*[@id=\'onetrust-close-btn-container\']/button"))) {
             driver.findElement(By.xpath("//*[@id=\'onetrust-close-btn-container\']/button")).click();
             //   Thread.Sleep(4000);
         }
         
         System.out.println("Deleted cache cookies");
     }

	}













