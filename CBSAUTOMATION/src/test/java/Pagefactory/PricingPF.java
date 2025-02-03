package Pagefactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPF {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    private By menu, survey, pricingButton, searchbox, searchbtn, Apply_Estimation, Rate_Component, agent, costHead, costHeadAmount, addButton, saveRatesButton, costHeadSearchBox;
    private By applyQuotationButton, gpTextBox, applyToAllButton, savebutton, sendForApprovalButton, approverDropdown, proceedForApprovalButton,pendingApproval,bookButton,BillingAndCollection;
    private By selectbillTo,Paymentdropdown,Detailtab,savebtn; 

    // Constructor to load properties and initialize locators
    public PricingPF(WebDriver driver) throws IOException {
        this.driver = driver;

        // Load the properties file
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        // Initialize locators using properties
        menu = By.xpath(prop.getProperty("Menu"));
        pricingButton = By.xpath(prop.getProperty("Pricing_Menu"));
        survey = By.xpath(prop.getProperty("survey_menu"));
        searchbox = By.xpath(prop.getProperty("EP_search"));
        searchbtn = By.xpath(prop.getProperty("Search_btn"));
        Apply_Estimation = By.partialLinkText(prop.getProperty("Apply_Estimation"));
        Rate_Component = By.xpath(prop.getProperty("Rate_Component"));
        agent = By.xpath(prop.getProperty("AgentDropDown"));
        costHead = By.xpath(prop.getProperty("CostHeadDropdown"));
        costHeadSearchBox = By.xpath(prop.getProperty("CostHead"));  // New locator for the search box inside the dropdown
        costHeadAmount = By.xpath(prop.getProperty("CostHeadAmount"));
        addButton = By.xpath(prop.getProperty("add_btn"));
        saveRatesButton = By.xpath(prop.getProperty("save_rate"));
        // For Apply Quotation
        applyQuotationButton = By.xpath(prop.getProperty("Apply_Quotation"));
        gpTextBox = By.xpath(prop.getProperty("GP_MarginPercent"));
        applyToAllButton = By.xpath(prop.getProperty("Apply_all"));
        savebutton = By.xpath(prop.getProperty("Qsave_btn"));
        sendForApprovalButton = By.xpath(prop.getProperty("SendForApprove"));
        approverDropdown = By.xpath(prop.getProperty("ApproverList"));
        proceedForApprovalButton = By.xpath(prop.getProperty("proceed_btn"));
        pendingApproval=By.xpath(prop.getProperty("Approvebtn"));
        bookButton=By.xpath(prop.getProperty("Book"));
        BillingAndCollection=By.xpath(prop.getProperty("Billing"));
        selectbillTo=By.xpath(prop.getProperty("BillingTo"));
        Detailtab=By.xpath(prop.getProperty("Details"));
        Paymentdropdown=By.xpath(prop.getProperty("PrePayment"));
        savebtn=By.xpath(prop.getProperty("Save_btn"));
    }
    

    // Method to click on the Menu
    public void clickMenu() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(menu).click();
    }

    public void clickSurvey() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(survey).click();
    }

    public void clickPricingButton() {
        driver.findElement(pricingButton).click();
    }

    public void searchEnquiryNumber(String enquiryNumber) throws InterruptedException {
        driver.findElement(searchbox).sendKeys(enquiryNumber);
        Thread.sleep(2000);
        driver.findElement(searchbtn).click();
    }

    public void applyEstimation() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.findElement(Apply_Estimation).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until the Apply Estimation button is visible
        WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Apply_Estimation));
        
        // Click the Apply Estimation button
        applyButton.click();
    }

    // Method to enter the cost head amount
    public void enterCostHeadAmount(String amount) {
        driver.findElement(costHeadAmount).sendKeys(amount);
    }

    // Method to click the Add button
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    // Method to click Save Rates button
    public void clickSaveRatesButton() {
        driver.findElement(saveRatesButton).click();
    }

    // Method to select a cost head from the dropdown with search functionality
    public void selectCostHead(String costHeadValue) throws InterruptedException {
        // Step 1: Click on the dropdown to reveal the search box
        Thread.sleep(500);
        driver.findElement(costHead).click();

        // Step 2: Wait for the search box to appear and enter the cost head to search
        WebElement searchInput = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(costHeadSearchBox));
        searchInput.sendKeys(costHeadValue);

        // Step 3: Select the desired option from the dropdown
        WebElement desiredOption = new WebDriverWait(driver, Duration.ofSeconds(10)) // Updated to use Duration
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), '" + costHeadValue + "')]")));
        desiredOption.click();
    }

    public void clickApplyQuotationButton() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementToBeClickable(applyQuotationButton).click();
    }

    public void enterGPPercentage(String percentage) {
        WebElement gpTextBoxElement = waitForElementToBeVisible(gpTextBox);
        gpTextBoxElement.clear();
        gpTextBoxElement.sendKeys(percentage);
    }

    public void clickApplyToAllButton() {
        waitForElementToBeClickable(applyToAllButton).click();
    }

    public void clickSaveButton() {
        waitForElementToBeClickable(savebutton).click();
    }
    public void clickSendForApprovalButton() {
        waitForElementToBeClickable(sendForApprovalButton).click();
    }
    
    public void selectApprover(String approver) {
        selectDropdown(approverDropdown, approver);
    }

    public void clickProceedForApprovalButton() {
        waitForElementToBeClickable(proceedForApprovalButton).click();
    }
    
    public void clickOnPendingApproval()
    {
    	waitForElementToBeClickable(pendingApproval).click();
    }
    // Utility method to wait for an element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void clickOnBookButton()
    {
    	scrollIntoViewAndClick(bookButton);
    }
    
    public void clickOnBACbutton()
    {
    	scrollIntoViewAndClick(BillingAndCollection);
    }
    
    public void selectBillTo(String billTo){
    	selectDropdown(selectbillTo, billTo);
    }
    
    public void selectPaymentType(String Payment) throws InterruptedException
    {
    	Thread.sleep(1000);
    	scrollIntoViewAndClick(Detailtab);
    	Thread.sleep(1000);
    	selectDropdown(Paymentdropdown, Payment);
    	
    }
    
    public void saveBAC()
    {
    	scrollIntoViewAndClick(savebtn);
    	
    }
    
    
    // Common method to select from dropdown
    public void selectDropdown(By dropdownLocator, String dropdownValue) {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(dropdownValue);
    }
    // Utility method to wait for an element to be visible
    public WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    // Scroll into view and click using JavaScript
    public void scrollIntoViewAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Method to handle potential overlays
    private void handleOverlayAndClick(By locator) {
        try {
            WebElement element = waitForElementToBeClickable(locator);
            element.click();
        } catch (Exception e) {
            // In case of an overlay, wait for a while and retry
            WebElement overlay = driver.findElement(By.id("overlay")); // Assuming the overlay has this ID
            if (overlay.isDisplayed()) {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(overlay));
            }
            scrollIntoViewAndClick(locator);
        }
    }

    
    // Getters for locators
    public By getRateComponentLocator() {
        return Rate_Component;
    }

    public By getAgentLocator() {
        return agent;
    }

    public By getCostHeadLocator() {
        return costHead;
    }
    
    public By selectBillToLocator()
    {
		return selectbillTo;
    	
    }
}
