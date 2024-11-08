package com.pv.project1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import fixtures.FixturesClass;

//import com.aventstack.extentreports.MediaEntityBuilder;

//import com.github.dockerjava.transport.DockerHttpClient.Response;

//import fixtures.FixturesClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
//import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.*;

import java.io.File;

public class RestAssuredAPItest01 extends FixturesClass
{
	private int i, j;
	String s1;
	Response res1, res2;

	
	@Test(priority = 8)
	public void prequal_footprint_get() 
	{
		//driver.close();

		test = report.createTest("API_Test : RestAssured : Prequal Footprint");
		
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
	s1 = res1.getBody().asPrettyString();
	test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
	
	//test.pass(resp1.log().all().extract().asPrettyString());
		
	//"PASSED : RestAssured API test : Prequal Footprint");
	test.info("RestAssured API Testing : 'Prequal Footprint' request was successful with response code"+ "  " +resp1.extract().statusCode());
}

	}
	
	@Test(priority = 9)
	public void onlineApp_login_post() {

		
		//driver.close();
		
		test = report.createTest("API_Test : RestAssured : OnlineApp Login");
		
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
			s1 = resp.getBody().asPrettyString();
			test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
			
			//test.pass(res.log().all().extract().asPrettyString());
			
			//test.log(LogStatus.PASS, res.extract().statusCode());
			test.info("RestAssured API Testing : 'OnlineApp login' POST request was successful with response code"+ "  " +res.extract().statusCode());
			//"PASSED : RestAssured API test : Okta Login");
			
			/*//Incase if I want to display json format in report
			s1 = res.log().all().extract().asPrettyString();
			test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
			*/
			
			
			
		}

	}
	
	
	
	
	
	@Test(priority = 10)
	public void customer_check() 
	{
		//driver.close();

		test = report.createTest("API_Test : RestAssured : Customer Check");
		
		File jsonfile1 = new File("src/test/resources/customer-check.json");
		
		
		baseURI = "https://secure-test.republicfinance.com/";

	
		Response resp2 =		given().
		//param("name", "Automation").
		contentType(ContentType.JSON)
		.body(jsonfile1)
		//accept(ContentType.JSON).
		.when()
		.post("/enrollment/api/customer/Check");
		
		/*then().
		statusCode(200).
		log().all();
		*/
		
	//String s1 = res1.assertThat().statusCode(200).toString();
	// i = Integer.parseInt(res1.statusCode(200).toString());
	//System.out.println("SYSO" +i);
				
		//resp1 = RestAssured.get("https://www-test.republicfinance.com/qualify/api/branch/zipcode/78748");
	j = resp2.getStatusCode();
if(j == 200)
{
	//test.pass(resp1.getBody().asPrettyString());
			//"PASSED : RestAssured API test : Prequal Footprint");
	
	
	//Incase if I want to display json format in report
	s1 = resp2.getBody().asPrettyString();
	test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
	test.info("RestAssured API Testing : 'Customer Check' POST request was successful with response code"+ "  " +resp2.getStatusCode());
	
}

}
	
	

@Test(priority = 11)
public void customerPortal_login_post() 
{	
	//driver.close();
	
	test = report.createTest("API_Test : RestAssured : Customer Portal Login");
	
	JSONObject request = new JSONObject();

	request.put("password", "P@ssword123");
	request.put("username", "preethapv01+b1011@gmail.com");
	
    baseURI = "https://secure-test.republicfinance.com/";

	/*ValidatableResponse res = given().
	contentType(ContentType.JSON).
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	post("/auth/login").
	then().
	statusCode(200)
	.log().all();
	*/
	
	//RestAssured.post("https://republicciam.oktapreview.com/api/v1/authn", request);
	
	Response resp3 = given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("/auth/login");
	
	if(resp3.getStatusCode() == 200)
	{
		
		
		//Incase if I want to display json format in report
		s1 = resp3.getBody().asPrettyString();
		test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
		
		//test.pass(res.log().all().extract().asPrettyString());
		//test.log(LogStatus.PASS, res.extract().statusCode());
		test.info("RestAssured API Testing : 'Customer Portal login' POST request was successful with response code"+ "  " +resp3.getStatusCode());
		//"PASSED : RestAssured API test : Okta Login");
				
	}

}



@Test(priority = 12)
public void forgot_password_post() 
{	
	//driver.close();
	
	test = report.createTest("API_Test : RestAssured : Forgot Password Post");
	
	JSONObject request = new JSONObject();

	request.put("username", "preethapv01+r5a7@gmail.com");
//	request.put("username", "preethapv01+b1011@gmail.com");
	
    baseURI = "https://secure-test.republicfinance.com/";

	/*ValidatableResponse res = given().
	contentType(ContentType.JSON).
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
	post("/auth/login").
	then().
	statusCode(200)
	.log().all();
	*/
	
	//RestAssured.post("https://republicciam.oktapreview.com/api/v1/authn", request);
	
	Response resp3 = given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("/auth/login/password/forgot");
	
	if(resp3.getStatusCode() == 200)
	{
		
		
		//Incase if I want to display json format in report
		s1 = resp3.getBody().asPrettyString();
		test.pass(MarkupHelper.createCodeBlock(s1, CodeLanguage.JSON));
		
		//test.pass(res.log().all().extract().asPrettyString());
		//test.log(LogStatus.PASS, res.extract().statusCode());
		test.info("RestAssured API Testing : 'Forgot Password' POST request was successful with response code"+ "  " +resp3.getStatusCode());
		//"PASSED : RestAssured API test : Okta Login");
				
	}

}






	}
	
	
	
	
	
	
	
	
	
	
	
	


