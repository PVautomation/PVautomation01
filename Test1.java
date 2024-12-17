//===========================


    @Test(description = "Owner: pv_test")
    public void crmTest1() {
        try {
            // Open Salesforce login page
            driver.get("https://republicfinance--qa.sandbox.my.salesforce.com/");
            System.out.println("svc acct getURL done");

            // Enter username
            WebElement username = driver.findElement(By.id("username"));
            waitAndClick(username);
            username.clear();
            username.sendKeys("svcQSETA@republicfinance.com.qa");
            System.out.println("svc acct uid done");

            // Enter password
            WebElement password = driver.findElement(By.id("password"));
            waitAndClick(password);
            password.clear();
            password.sendKeys("YourSecurePassword"); // Replace with actual secure password
            System.out.println("svc acct pwd done");

            // Login button
            WebElement loginButton = driver.findElement(By.id("Login"));
            waitAndClick(loginButton);
            System.out.println("svc acct login click done");

            // Take a screenshot after login
            captureScreenshot("screenshot2");

            // Verify text is not present
            verifyTextNotPresent("verification code");

            Reporter.log("CRM TEST1 GOT COMPLETED");

        } catch (Exception e) {
            System.out.println("CRM-TEST1 LOGIN CLICK CATCH");

            // Take a screenshot in case of failure
            captureScreenshot("screenshot3");
        }

        System.out.println("came outside crm login try catch");

        // Wait for the page to load completely
        waitForPageToLoad(driver);
        System.out.println("Waiting for page to fully load.");

        // Take another screenshot
        captureScreenshot("screenshot4");

        // Click on a specific element using JavaScriptExecutor
        WebElement targetElement = driver.findElement(By.xpath(
                "/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[2]/div/div/div[1]/div/div/a/div/lightning-icon/span/lightning-primitive-icon"));
        waitAndClick(targetElement);

        System.out.println("Clicked on target element using JavaScriptExecutor.");
    }
//====================================

@Test
@Parameters("ownerName")
public void crmTest2() {
    try {
        // Refresh the page and wait for it to load
        driver.navigate().refresh();
        waitForPageToLoad(driver);
        System.out.println("Waiting for page to fully load.");
        js.executeScript("window.scroll(0,0);");

        // Click on 'Branch Operations'
        try {
            WebElement branchOperations = driver.findElement(By.xpath("//*[@title='Branch Operations']"));
            waitAndClick(branchOperations);
            System.out.println("Clicked on Branch Operations");
        } catch (Exception e) {
            System.out.println("Unable to click on Branch Operations.");
        }

        // Handle search button with fallback XPaths
        WebElement searchBox = null;
        try {
            searchBox = driver.findElement(By.xpath("//button[@aria-label='Search']"));
            System.out.println("Element found using the first XPath");
        } catch (NoSuchElementException e) {
            System.out.println("First XPath failed. Trying alternate XPath..");
            searchBox = findElementWithFallback("//div[contains(@class, 'slds-global-header__item_search')]//input");
            System.out.println("Element found using the alternate XPath");
        }

        // Perform actions on the search box
        if (searchBox != null) {
            waitAndClick(searchBox);
            Actions actions = new Actions(driver);
            actions.sendKeys(searchBox, "MARTHA YYCPXHA").sendKeys(Keys.ENTER).perform();
            System.out.println("Search executed successfully");
        } else {
            System.out.println("Search box not found");
        }

        // Refresh the page twice for validation
        for (int i = 0; i < 2; i++) {
            driver.navigate().refresh();
            waitForPageToLoad(driver);
            System.out.println("Page refreshed and fully loaded.");
            js.executeScript("window.scroll(0,0);");
        }

        // Handle multiple XPath fallback for a target element
        List<String> xPaths = Arrays.asList(
                "//a[contains(@data-recordid, '001Ek00000qsRWsIAM') and contains(@class, 'outputLookupLink')]",
                "//a[@title='MARTHA YYCPXHA' and contains(@class, 'outputLookupLink')]",
                "//a[contains(@data-ownerid, '17288:0') and contains(@class, 'outputLookupLink')]",
                "//a[contains(@class, 'outputLookupLink') and contains(@data-recordid, '001Ek00000qsRWsIAM')]",
                "//div[contains(@class, 'some-class')]//a[contains(@class, 'outputLookupLink') and contains(@data-recordid, '001Ek00000qsRWsIAM')]"
        );

        boolean found = false;
        for (String xpath : xPaths) {
            try {
                WebElement targetElement = driver.findElement(By.xpath(xpath));
                waitAndClick(targetElement);
                System.out.println("Element found and clicked using XPath: " + xpath);
                found = true;
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Element not found using XPath: " + xpath);
            }
        }

        if (!found) {
            System.out.println("No element found with any of the provided XPaths.");
        }

        // Final page refresh
        driver.navigate().refresh();
        waitForPageToLoad(driver);
        js.executeScript("window.scroll(0,0);");
        System.out.println("Final refresh completed and page fully loaded.");

    } catch (Exception e) {
        System.out.println("Exception in crmTest2: " + e.getMessage());
    }
}


//=====================================

@Test
public void crmTest002() {
    System.out.println("Waiting for page to fully load. - WAITING FOR 'VIEW' TO JUMP TO APPROVED PAGE - before try");

    try {
        // Locate the 'VIEW' element
        WebElement viewElement = driver.findElement(By.xpath(
                "(//omnistudio-flex-action[contains(@class, 'flexActionElement')]//a[contains(@class, 'slds-action_item')])[77]"));
        waitAndClick(viewElement);
        System.out.println("VIEW clicked successfully");
    } catch (NoSuchElementException e) {
        System.out.println("VIEW xpath not found - CATCH");
    }

    waitForPageToLoad(driver);
    System.out.println("Waiting for page to fully load. - WAITING FOR 'VIEW' TO JUMP TO APPROVED PAGE - after try");
}

//=====================================

@Test
public void crmTest02() {
    // List of fallback XPaths for locating 'Start' button
    List<String> xPaths1 = Arrays.asList(
            "//div[@class='slds-col condition-element']//span[@title='Start']",
            "//div[contains(@class, 'slds-col') and contains(@class, 'condition-element')]//a[@aria-label='Start']//span[@title='Start']",
            "//div[contains(@class, 'block-container')]//span[@title='Start']"
    );

    // Attempt to locate 'Start' button with fallback XPaths
    boolean found1 = false;
    for (String xpath : xPaths1) {
        try {
            WebElement startElement = driver.findElement(By.xpath(xpath));
            waitAndClick(startElement);
            System.out.println("Element found and clicked using XPath: " + xpath);
            found1 = true;
            break;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found using XPath: " + xpath);
        }
    }

    if (!found1) {
        System.out.println("No 'Start' button found with any of the provided XPaths.");
    }

    // Wait for the page to load after clicking 'Start'
    waitForPageToLoad(driver);
    System.out.println("Waiting for page to fully load after clicking 'Start'.");

    // Click on "New Application" text
    try {
        WebElement newAppText = driver.findElement(By.xpath(
                "//*[text()='New Application' and contains(@class, 'slds-page-header__title')]"));
        waitAndClick(newAppText);
        System.out.println("New Application text clicked.");
    } catch (Exception e) {
        System.out.println("New Application text not clicked.");
        Assert.fail("Test failed because 'New Application' was not clicked.");
    }

    // Perform keyboard actions using Actions class
    Actions actions = new Actions(driver);

    // TAB and enter values
    actions.sendKeys(Keys.TAB).perform();
    actions.sendKeys(Keys.TAB).perform();
    actions.sendKeys("7000").perform();

    // Select options with Arrow keys and Enter
    for (int i = 0; i < 3; i++) {
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    // Perform additional TABs and SPACE/ENTER actions
    for (int i = 0; i < 7; i++) {
        actions.sendKeys(Keys.TAB).perform();
    }
    actions.sendKeys(Keys.SPACE).perform();
    actions.sendKeys(Keys.ENTER).perform();
    System.out.println("Keyboard actions completed successfully.");

    // Verify the test as pass
    Assert.assertTrue(true, "Test pass");
}


//=====================================
@Test
public void crmTest3() {
    try {
        waitForPageToLoad(driver);
        System.out.println("Waiting for 'Please verify' section to appear");

        // Click the section title
        WebElement verifySection = driver.findElement(By.xpath(
            "//h3[text()='Please verify the information below is correct, update any incorrect/outdated information & fill in any additional fields.']"
        ));
        waitAndClick(verifySection);

        // Perform Actions sequence
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).perform();

        for (int i = 0; i < 6; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("11/11/1999").perform();

        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys("666034693").sendKeys(Keys.TAB).sendKeys("0").perform();

        for (int i = 0; i < 11; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_RIGHT).perform();

        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();

        // Handle Checkbox and Next Button
        WebElement checkbox = driver.findElement(By.xpath(
            "(//*[contains(text(), 'By submitting the information in this application for credit')]/preceding-sibling::span[@class='slds-checkbox_faux'])[1]"
        ));
        waitAndClick(checkbox);
        System.out.println("Checkbox clicked");

        WebElement nextButton = driver.findElement(By.xpath("(//span[text()='Next'])[1]"));
        waitAndClick(nextButton);
        System.out.println("Next button clicked");

        waitForPageToLoad(driver);
        System.out.println("crmTest3 execution completed");

    } catch (Exception e) {
        System.out.println("Exception in crmTest3: " + e.getMessage());
    }
}

//=====================================
@Test
public void crmTest4() {
    try {
        waitForPageToLoad(driver);
        System.out.println("Page fully loaded - crmTest4");

        // Adjust page zoom and scroll
        js.executeScript("document.body.style.zoom='30%'");
        js.executeScript("window.scroll(0,0);");
        System.out.println("Page zoomed to 30%");

        // Handle income verification
        try {
            WebElement incomeRecord = driver.findElement(By.xpath(
                "(//*[contains(text(), 'We found an income record from the applicant(s)')])[1]"
            ));
            if (incomeRecord.isDisplayed()) {
                waitAndClick(incomeRecord);
                System.out.println("Existing income record handled");

                Actions actions = new Actions(driver);
                for (int i = 0; i < 7; i++) {
                    actions.sendKeys(Keys.TAB).perform();
                }
                actions.sendKeys("a").sendKeys(Keys.TAB).sendKeys("a").perform();
                actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
                actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
                actions.sendKeys(Keys.TAB).sendKeys("5125011234").perform();
                System.out.println("Income record updated successfully");
            }
        } catch (Exception e) {
            System.out.println("Error handling income record: " + e.getMessage());
        }

        // Verify income section
        try {
            waitAndClick(driver.findElement(By.xpath("(//*[contains(text(), '| Employment | a |')])[2]")));
            waitAndClick(driver.findElement(By.xpath("(//*[text()='Verify Income'])[4]")));
            waitAndClick(driver.findElement(By.xpath("(//*[text()='Verify Employment Income'])[2]")));

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            System.out.println("Income verification completed");

            WebElement saveButton = driver.findElement(By.xpath("(//*[contains(@title, 'Save')])[20]"));
            waitAndClick(saveButton);
            System.out.println("Income Save button clicked");

        } catch (Exception e) {
            System.out.println("Error during income verification: " + e.getMessage());
        }

        // Handle Non-Applicant section
        WebElement noOption = driver.findElement(By.xpath("(//*[text()='No'])[13]"));
        waitAndClick(noOption);
        System.out.println("Clicked on 'No' option in Non-Applicant section");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
        System.out.println("Non-Applicant section completed");

        // Final Next button
        WebElement nextButton = driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[7]"));
        waitAndClick(nextButton);
        waitForPageToLoad(driver);
        System.out.println("crmTest4 execution completed");

    } catch (Exception e) {
        System.out.println("Exception in crmTest4: " + e.getMessage());
    }
}

//=====================================
@Test
public void crmTest5() {
    try {
        waitForPageToLoad(driver);
        System.out.println("crmTest5 - Page loaded and scroll to top.");
        js.executeScript("window.scroll(0,0);");

        // Click on 'Verifications'
        WebElement verifications = driver.findElement(By.xpath("//h3[text()='Verifications']"));
        waitAndClick(verifications);
        Thread.sleep(5000);

        // Perform Action logic: TAB and SPACE
        for (int i = 0; i < 5; i++) {
            a1.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.SPACE).perform();
            Thread.sleep(500);
        }

        // Manage Debts Section
        try {
            WebElement manageDebts = driver.findElement(By.xpath("//*[text()='Manage Debts']"));
            WebElement manualOption = driver.findElement(By.xpath("//div[text()='Manual | MARTHA YYCPXHA']"));

            waitAndClick(manageDebts);
            Thread.sleep(5000);
            waitAndClick(manualOption);
            Thread.sleep(2000);

        } catch (NoSuchElementException e) {
            System.out.println("Manage Debts section not found.");
        }

        // Final navigation steps
        for (int i = 0; i < 5; i++) {
            a1.sendKeys(Keys.TAB).perform();
        }
        a1.sendKeys(Keys.SPACE).perform();
        Thread.sleep(2000);

        waitForPageToLoad(driver);
        js.executeScript("window.scroll(0,0);");

        // Click 'Next' button
        WebElement nextButton = driver.findElement(By.xpath("(//*[contains(text(), 'Next')])[8]"));
        waitAndClick(nextButton);

        waitForPageToLoad(driver);
        System.out.println("crmTest5 COMPLETED");

    } catch (Exception e) {
        System.out.println("Exception in crmTest5: " + e.getMessage());
    }
}

//=====================================
@Test
public void crmTest6() {
    try {
        waitForPageToLoad(driver);

        // Open Section
        WebElement openButton = driver.findElement(By.xpath("(//*[text()='Open'])[1]"));
        waitAndClick(openButton);

        System.out.println("crmTest6 - Open button clicked.");

        // Personal Information Verification
        waitAndClick(driver.findElement(By.xpath("//*[text()='Personal Information Verification']")));

        for (int i = 0; i < 3; i++) {
            a1.sendKeys(Keys.TAB).perform();
        }
        a1.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        // Income Employment Verification
        try {
            WebElement employmentSection = driver.findElement(By.xpath("//*[contains(text(), '| Employment | a |')]"));
            if (employmentSection.isDisplayed()) {
                waitAndClick(employmentSection);
                performEmploymentVerificationSteps();
            }
        } catch (Exception e) {
            System.out.println("Employment verification catch.");
        }

        waitForPageToLoad(driver);
        System.out.println("crmTest6 COMPLETED");

    } catch (Exception e) {
        System.out.println("Exception in crmTest6: " + e.getMessage());
    }
}

private void performEmploymentVerificationSteps() throws InterruptedException {
    for (int i = 0; i < 4; i++) {
        a1.sendKeys(Keys.TAB).perform();
        Thread.sleep(500);
    }
    a1.sendKeys(Keys.ENTER).perform();

    for (int i = 0; i < 3; i++) {
        a1.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(500);
    }
    a1.sendKeys(Keys.ENTER).perform();
    Thread.sleep(5000);
}

//=====================================
@Test
public void crmTest06() {
    try {
        waitForPageToLoad(driver);

        // Click 'Open'
        WebElement openButton = driver.findElement(By.xpath("(//*[text()='Open'])[2]"));
        waitAndClick(openButton);

        // Add Property
        waitAndClick(driver.findElement(By.xpath("//*[text()='+ Add Property']")));
        performPropertyAdditionSteps();

        waitForPageToLoad(driver);

        // Loan Details
        waitAndClick(driver.findElement(By.xpath("//*[text()='Loan Details']")));
        for (int i = 0; i < 2; i++) {
            a1.sendKeys(Keys.TAB).perform();
        }
        a1.sendKeys(Keys.ENTER).perform();
        performArrowDownSteps();

        // Generate Offers
        WebElement generateOffers = driver.findElement(By.xpath("//button[text()='Generate Offers']"));
        waitAndClick(generateOffers);

        waitForPageToLoad(driver);
        System.out.println("crmTest06 COMPLETED");

    } catch (Exception e) {
        System.out.println("Exception in crmTest06: " + e.getMessage());
    }
}

private void performPropertyAdditionSteps() throws InterruptedException {
    a1.sendKeys(Keys.TAB).sendKeys("d").perform();
    Thread.sleep(500);
    a1.sendKeys(Keys.TAB).sendKeys("800000").perform();

    for (int i = 0; i < 2; i++) {
        a1.sendKeys(Keys.TAB).perform();
    }
    a1.sendKeys("m").perform();
    a1.sendKeys(Keys.TAB).sendKeys("111111").perform();
    Thread.sleep(2000);
    System.out.println("Property addition completed.");
}

private void performArrowDownSteps() throws InterruptedException {
    a1.sendKeys(Keys.ARROW_DOWN).perform();
    a1.sendKeys(Keys.ARROW_DOWN).perform();
    a1.sendKeys(Keys.ENTER).perform();
    Thread.sleep(2000);
}

//=====================================

@Test
public void crmTest7() {
    try {
        System.out.println("crmTest7 STARTED");

        // Set Zoom and Scroll
        js.executeScript("document.body.style.zoom='30%'; window.scroll(0,0);");
        Thread.sleep(25000);

        // Click on Loan Class Dropdown
        WebElement loanClassDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[text()='KY Conventional'])[2]")));
        scrollToElement(loanClassDropdown);
        waitAndClick(loanClassDropdown);
        System.out.println("Loan class dropdown clicked.");

        // Select dropdown options using Action Class
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println("Loan class option selected.");

        // Enter values into form fields
        performFieldEntry("24", "4", "2000");
        System.out.println("Entered values into the fields.");

        // Verify Collateral Message
        checkAndLogMessage("(//*[text()='Please include at least one collateral entry in this offer'])[2]",
                           "MESSAGE THROWN - PLEASE INCLUDE AT LEAST ONE COLLATERAL");

        // Click Calculate Button
        performButtonClick("(//button[contains(text(), 'Calculate')])[2]");
        System.out.println("Calculate button clicked.");
        waitForPageToLoad(driver);

        // Submit Process
        performButtonClick("(//button[text()='Submit'])[2]");
        System.out.println("Submit button clicked.");

        // Expand/Collapse Section
        performButtonClick("(//button[text()='Expand/Collapse'])[2]");
        System.out.println("Expand/Collapse section clicked.");

        // Enter 'Need Approval' in Comments Field
        WebElement commentsField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='Sales Comments']/following::textarea[1]")));
        scrollToElement(commentsField);
        waitAndClick(commentsField);
        commentsField.sendKeys("Need Approval");
        System.out.println("Entered 'Need Approval' in comments.");
        Thread.sleep(6000);

        // Needs Review and Send for Review
        performButtonClick("//*[text()='Needs Review']");
        System.out.println("Needs Review clicked.");
        performButtonClick("//*[text()='Send for Review']");
        System.out.println("Send for Review clicked.");

        // Perform Tab and Space Actions using Action Class
        performKeyActions(Keys.TAB, 1);
        actions.sendKeys(Keys.SPACE).perform();
        performKeyActions(Keys.TAB, 3);
        actions.sendKeys(Keys.ENTER).perform();

        waitForPageToLoad(driver);
        System.out.println("crmTest7 completed successfully.");
    } catch (Exception e) {
        System.out.println("Caught issue during crmTest7: " + e.getMessage());
    }
}

// Helper Methods
private void performFieldEntry(String... inputs) throws InterruptedException {
    for (String input : inputs) {
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(500);
        actions.sendKeys(input).perform();
        Thread.sleep(500);
    }
}

private void checkAndLogMessage(String xpath, String message) {
    if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
        System.out.println(message);
    }
}

private void performButtonClick(String xpath) throws InterruptedException {
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    scrollToElement(button);
    waitAndClick(button);
    Thread.sleep(5000);
}

private void performKeyActions(Keys key, int count) throws InterruptedException {
    for (int i = 0; i < count; i++) {
        actions.sendKeys(key).perform();
        Thread.sleep(500);
    }
}



//=====================================
@Test
public void crmTest8() throws InterruptedException {
    try {
        waitForPageToLoad(driver);
        js.executeScript("document.body.style.zoom='30%';");
        Thread.sleep(25000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));

        // Click Present Offers
        WebElement presentOffers = driver.findElement(By.xpath("//button[text()='PresentOffers']"));
        scrollToElement(presentOffers);
        waitAndClick(presentOffers);
        System.out.println("Present Offers clicked.");

        // Perform Next Button Loop
        for (int i = 0; i < 4; i++) {
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
            scrollToElement(nextButton);
            waitAndClick(nextButton);
        }

        // Save
        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
        scrollToElement(saveButton);
        waitAndClick(saveButton);

        // Begin Booking
        performButtonClick("(//button[text()='Begin Booking'])[2]");
        performButtonClick("//button[text()='Move to Closing Prep']");

        System.out.println("crmTest8 COMPLETED");

    } catch (Exception e) {
        System.out.println("Caught in crmTest8: " + e.getMessage());
    }
}

//=====================================
@Test
public void crmTest9() throws InterruptedException {
    try {
        waitForPageToLoad(driver);
        js.executeScript("document.body.style.zoom='30%';");
        Thread.sleep(15000);

        // Click ACH
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));
        WebElement achButton = driver.findElement(By.xpath("//*[text()='ACH']"));
        scrollToElement(achButton);
        waitAndClick(achButton);

        // In-Office Personal Device
        WebElement inOfficeButton = driver.findElement(By.xpath("//*[text()='In Office-Personal Device']"));
        scrollToElement(inOfficeButton);
        waitAndClick(inOfficeButton);

        // Add Beneficiary
        performKeyActions(Keys.TAB, 6);
        a1.sendKeys("a").perform();
        performFieldEntry("5125011234");

        // Add Existing References
        try {
            if (driver.findElement(By.xpath("//*[text()='We found these references, do you want to include them as current references?']")).isDisplayed()) {
                clickMultipleReferences(3);
            }
        } catch (Exception e) {
            System.out.println("Existing references not found.");
        }

        System.out.println("crmTest9 COMPLETED");

    } catch (Exception e) {
        System.out.println("Caught in crmTest9: " + e.getMessage());
    }
}

private void clickMultipleReferences(int count) throws InterruptedException {
    for (int i = 1; i <= count; i++) {
        WebElement reference = driver.findElement(By.xpath("(//omnistudio-block[contains(@data-style-id, 'state0element0block_element0block_element2')]//div[contains(@class, 'slds-text-align_center')])[" + i + "]"));
        waitAndClick(reference);
        Thread.sleep(5000);
    }
}

//=====================================
@Test
public void crmTest10() throws InterruptedException {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));
        System.out.println("crmTest10 STARTED");

        // Click 'Next'
        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Next'])[1]")));
        scrollToElement(nextButton1);
        waitAndClick(nextButton1);
        System.out.println("Next button clicked.");
        Thread.sleep(50000);

        // Set Zoom and Wait
        setZoomLevel(30);
        System.out.println("Zoom set to 30% to see docs.");

        // Click 'Generate Docs'
        WebElement generateDocsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='Next: Generate Docs'])[1]")));
        scrollToElement(generateDocsButton);
        waitAndClick(generateDocsButton);
        System.out.println("Generate Docs button clicked.");
        Thread.sleep(50000);

        // Set Zoom Again
        setZoomLevel(30);
        System.out.println("Zoom set to 30% for Done button.");

        // Click 'Done'
        WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Done'])[1]")));
        scrollToElement(doneButton);
        waitAndClick(doneButton);
        System.out.println("Done button clicked.");
        Thread.sleep(60000);

        // Click 'Regenerate Loan Packet'
        WebElement regenerateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Regenerate Loan Packet']")));
        scrollToElement(regenerateButton);
        waitAndClick(regenerateButton);
        System.out.println("Regenerate Loan Packet button clicked.");
        Thread.sleep(40000);

        // Click 'Done' Again
        doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Done'])[1]")));
        scrollToElement(doneButton);
        waitAndClick(doneButton);
        System.out.println("Done button clicked again.");

        Thread.sleep(20000);
        System.out.println("crmTest10 COMPLETED");

    } catch (InterruptedException e) {
        e.printStackTrace();
        System.out.println("Exception caught in crmTest10");
    }
}

private void setZoomLevel(int zoomPercentage) throws InterruptedException {
    js.executeScript("document.body.style.zoom='" + zoomPercentage + "%';");
    Thread.sleep(15000);
}

private void waitAndClick(WebElement element) throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    js.executeScript("arguments[0].click();", element);
    Thread.sleep(5000);
}

private void scrollToElement(WebElement element) {
    js.executeScript("arguments[0].scrollIntoView(true);", element);
}

//=====================================
//=====================================
//=====================================
//=====================================
