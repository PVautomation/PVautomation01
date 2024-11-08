package com.pv.project1;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageObjectModelClass {

   
//        public IWebDriver driver;
//        
//        public PageObjectModelClass(IWebDriver driver) {
//            this.driver = this.driver;
//            PageFactory.InitElements(this.driver, this);
//        }
	
	
	@FindBy(xpath="//*[@id=\'master-page-zone\']/section[1]/div/div/div[3]/div/div/a")    
    public static WebElement ck_button;
    
    @FindBy(xpath="//*[@id=\'zipCode\']")
    public static WebElement welcome_Zipcode;
    
    @FindBy(xpath="//*[@id=\'next-button\']")
    public static WebElement welcome_NextButton;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div[2]/div/div[1]/div/select")
    public static WebElement purpose_HowMuch;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div[2]/div/div[3]/div/select")
    public static WebElement purpose_FundUse;
    
    @FindBy(id="firstName")
    public static WebElement about_FirstName;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[2]/div[1]/div[2]/div/input")
    public static WebElement about_LastName;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[2]/div[6]/div[1]/div/input")
    public static WebElement about_Street;
    
    @FindBy(id="ssn")
    public static WebElement about_Ssn;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[2]/div[4]/div/input")
    public static WebElement about_Dob;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[2]/div[2]/div/input")
    public static WebElement about_Email;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[2]/div[3]/div/input")
    public static WebElement about_Phone;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[4]/div/div[1]/div/div/div/i[1]")
    public static WebElement about_WhoApplies;
    
    //  888888 REPLACE 88888888888
    @FindBy(id="next-button")
    public static WebElement about_NextButton;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div/div/div[2]/div/div/div[1]/label/span")
    public static WebElement childFrame_checkBox1;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div/div/div[3]/div/div/div[1]/label/span")
    public static WebElement childFrame_checkBox2;
    
    @FindBy(xpath="//*[@id=\'next-button\']")
    public static WebElement childFrame_NextButton;
    
    @FindBy(xpath="/html/body/form/div[4]/main/div/div/div/div/div/div/div/div/div[2]/div/div/div[1]/div/div[4]/div/div/label[1]/input")
    public static WebElement finance_Own1;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div[2]/div/div/label[2]/input")
    public static WebElement finance_Own2;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[6]/div/input")
    public static WebElement finance_MortgageRent;
    
    @FindBy(xpath="//*[@id=\'wizardProfile\']/div[2]/div/div/div[1]/div/div[8]/div/select")
    public static WebElement finance_Dependants;
    
    @FindBy(xpath="//*[@id=\'incomeAmount\']")
    public static WebElement finance_Income;
    
    @FindBy(xpath="//*[@id=\'all\']")
    public static WebElement finance_VerifiableIncome;
    
    @FindBy(id="next-button")
    public static WebElement finance_NextButton;
    
    @FindBy(xpath="/html/body/form/div[4]/main/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[3]/div/div/div[1]/label/span")
    //@FindBy(css=" #loading > div > div > div > div > div.chakra-container.css-1ahk6yk > div > div > div.css-zd4of5 > label")
    public static WebElement consent_ChkBox;
    
    @FindBy(xpath="/html/body/form/div[4]/main/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[5]/div/div[3]/button")
    public static WebElement consent_ChkOfferButton;
    
    @FindBy(xpath="//*[contains(text(),\'Congratulations!\')]")
    public static WebElement congratulations;


}


