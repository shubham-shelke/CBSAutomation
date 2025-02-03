package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pagefactory.LoginPF;

public class SurveyPOM {
    private WebDriver driver;
    private WebDriverWait wait;
    private Properties prop;

    // Constructor to load properties and initialize WebDriverWait
    public SurveyPOM(WebDriver driver, Properties prop, WebDriverWait wait) throws IOException {
    	 this.driver = LoginPF.driver;
        this.prop = prop;
        this.wait = wait;
       

        // Load the properties file
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);
    }

    public void clickOnMenu() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Menu"))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", menu);
    }

    public void clickOnSurveyButton() {
        WebElement survey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("crt_survey"))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", survey);
    }

    public void navigateToSurveyPage() {
        WebElement surveyPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Survey2"))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", surveyPage);
    }

    public void searchForEnquiryNumber(String enquiryNumber) throws InterruptedException {
        WebElement searchEnq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SearchEnq"))));
        searchEnq.sendKeys(enquiryNumber);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(3000);
    }

    public void clickOnEditSurveyButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement editSurveyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Edit_sry"))));
        editSurveyBtn.click();
        Thread.sleep(4000);
    }

    public void clickOnDetailTab() {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Detail"))).click();
    }

    public void selectSchPackDate(String date) {
        WebElement SchPackDate=driver.findElement(By.xpath(prop.getProperty("Survey_PackDate")));
        SchPackDate.click();
        SchPackDate.sendKeys(Keys.CONTROL+"A");
        SchPackDate.sendKeys(Keys.DELETE);
        SchPackDate.sendKeys(date);
    }

    public void enterNoOfDays(String days) {
        WebElement no_of_days = driver.findElement(By.xpath(prop.getProperty("No_Days")));
        no_of_days.click();
        no_of_days.clear();
        no_of_days.sendKeys(days);
    }

    public void selectSchLoadDate(String date) {
        WebElement loadDate = driver.findElement(By.xpath(prop.getProperty("Load_date")));
        loadDate.click();
        loadDate.sendKeys(Keys.CONTROL+"A");
        loadDate.sendKeys(Keys.DELETE);
        loadDate.sendKeys(date);
    }

    public void selectSchSubQuoteDate(String date) {
    	WebElement SchSubQuoteDate= driver.findElement(By.xpath(prop.getProperty("Sub_Quot")));
    	SchSubQuoteDate.click();
    	SchSubQuoteDate.sendKeys(Keys.CONTROL+"A");
    	SchSubQuoteDate.sendKeys(Keys.DELETE);
    	SchSubQuoteDate.sendKeys(date);
    }

    public void selectReqDeliveryDate(String date) {
      WebElement ReqDeliveryDate=  driver.findElement(By.xpath(prop.getProperty("DeliveryDate")));
        ReqDeliveryDate.click();
        ReqDeliveryDate.sendKeys(Keys.CONTROL+"A");
        ReqDeliveryDate.sendKeys(Keys.DELETE);
        ReqDeliveryDate.sendKeys(date);
    	
    }

    public void selectInsuranceProvider(String provider) {
        driver.findElement(By.xpath(prop.getProperty("InsuredByDropDown"))).sendKeys(provider);
    }

    public void enterInsApproxValue(String value) {
    	driver.findElement(By.xpath(prop.getProperty("InsuredAmount"))).clear();
        driver.findElement(By.xpath(prop.getProperty("InsuredAmount"))).sendKeys(value);
    }

    public void selectInsCurrency(String currency) {
        driver.findElement(By.xpath(prop.getProperty("InsuredCurrDropDown"))).sendKeys(currency);
    }

    public void fillOriginShipmentDetails() throws InterruptedException {
    	  WebElement shipmentDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Shipment_Detail"))));
          shipmentDetail.click();
          Thread.sleep(500);
        WebElement LooseCasedDropDown = driver.findElement(By.xpath(prop.getProperty("LooseCasedDropDown")));
        LooseCasedDropDown.sendKeys("Loose");
        Thread.sleep(1000);
        LooseCasedDropDown.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        LooseCasedDropDown.sendKeys(Keys.ENTER);

        WebElement LCLorFCLDropDown = driver.findElement(By.xpath(prop.getProperty("LCLorFCLDropDown")));
        LCLorFCLDropDown.sendKeys("LCL");

        WebElement DensityFact = driver.findElement(By.xpath(prop.getProperty("DensityFact")));
        DensityFact.clear();
        DensityFact.sendKeys("10.4");

        WebElement VolumeToPack1 = driver.findElement(By.xpath(prop.getProperty("VolumeToPack")));
        VolumeToPack1.clear();
        VolumeToPack1.click();
        WebElement VolumeToPack2 = driver.findElement(By.xpath(prop.getProperty("VolumeToPack")));
        VolumeToPack2.sendKeys("235");
        Thread.sleep(1000);

        WebElement VolumeNetclick = driver.findElement(By.xpath(prop.getProperty("VolumeNet")));
        VolumeNetclick.click();

        WebElement ContainerTypeDropDown = driver.findElement(By.xpath(prop.getProperty("ContainerTypeDropDown")));
        ContainerTypeDropDown.sendKeys("20ft");
        ContainerTypeDropDown.sendKeys(Keys.ENTER);
//        WebElement CopyOriginclick=driver.findElement(By.xpath(prop.getProperty("CopyOrigin")));
//	    CopyOriginclick.click();
        
    }

    public void fillDestinationShipmentDetails() throws InterruptedException {
        WebElement SurveyLooseCasedDropDown = driver.findElement(By.xpath(prop.getProperty("SurveyLooseCasedDropDown")));
        SurveyLooseCasedDropDown.sendKeys("Loose");
        Thread.sleep(1000);
        SurveyLooseCasedDropDown.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        SurveyLooseCasedDropDown.sendKeys(Keys.ENTER);

        WebElement SurveyLCLorFCLDropDown = driver.findElement(By.xpath(prop.getProperty("SurveyLCLorFCLDropDown")));
        SurveyLCLorFCLDropDown.sendKeys("LCL");

        WebElement SurveyDensityFact = driver.findElement(By.xpath(prop.getProperty("SurveyDensityFact")));
        SurveyDensityFact.clear();
        SurveyDensityFact.sendKeys("10.4");

        WebElement SurveyVolumeTobePack = driver.findElement(By.xpath(prop.getProperty("SurveyVolumeTobePack")));
        SurveyVolumeTobePack.sendKeys(Keys.CONTROL + "a");
        SurveyVolumeTobePack.sendKeys(Keys.DELETE);
        SurveyVolumeTobePack.click();
        SurveyVolumeTobePack.sendKeys("235");
        Thread.sleep(1000);

        WebElement SurveyNetVolume1 = driver.findElement(By.xpath(prop.getProperty("SurveyNetVolume")));
        SurveyNetVolume1.click();

        WebElement SurveyContainerDropDown = driver.findElement(By.xpath(prop.getProperty("SurveyContainerDropDown")));
        SurveyContainerDropDown.sendKeys("20ft");
        SurveyContainerDropDown.sendKeys(Keys.ENTER);
        
//        WebElement CopyDest=driver.findElement(By.xpath(prop.getProperty("CopyDest")));
//	    CopyDest.click();
        
	    WebElement DestAddress = driver.findElement(By.xpath(prop.getProperty("DestAddress")));
        DestAddress.clear();
        Thread.sleep(1000);
        DestAddress.clear();
        DestAddress.sendKeys("Bangalore");
        Thread.sleep(1000);
        WebElement DestCityDrop = driver.findElement(By.xpath(prop.getProperty("DestCityDrop")));
        DestCityDrop.click();
        Thread.sleep(1000);
        WebElement CityText = driver.findElement(By.xpath(prop.getProperty("DestCityText")));
        CityText.click();
        Thread.sleep(1000);
        CityText.sendKeys("CITY BANGALORE -Karnataka-INDIA");
        Thread.sleep(1500);
        driver.findElement(By.xpath(prop.getProperty("DestCityText"))).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement DestPhone = driver.findElement(By.xpath(prop.getProperty("DestPhone")));
        DestPhone.clear();
        DestPhone.sendKeys("9168534744");
        WebElement DestPin = driver.findElement(By.xpath(prop.getProperty("DestPin")));
        DestPin.clear();
        DestPin.sendKeys("400007");
    }
    
    
    
    public void saveShipmentDetails() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.xpath(prop.getProperty("S_Save")));
        saveButton.click();
        Thread.sleep(1000);
        WebElement completeButton = driver.findElement(By.xpath(prop.getProperty("Complete_btn")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", completeButton);
  //       Handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
