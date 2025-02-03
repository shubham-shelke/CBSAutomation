package Pagefactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnquiryPF {

	  	public static WebDriver driver;
	    public static Properties prop = new Properties();

	    private static By menu;
		private By enquiryBtn;
		private By enqCreatebtn;
		private By revenueBranch;
		private By move_class;
		private By infoSource;
		private By EnqFromName;
		private By Tentive_date;
		private By Enquiry_ReceiveDate;
		private By clientDropdown;
		private By clientTextBox;
		private By corporateDropdown;
		private By corporateTextBox;
		public By accountmangerdropdown,txt_Account_manager,shipperTitle,first_name,lastname,shipperDesignation,Shipper_type,Shpt_category;
		public By address1,address2,cityDropdown,cityNameTextBox,pinCode,nationality,mobile_number,emailId;
		public By handling_branch,service_line,transit_mode,shipment_type,commodity,details_tab,origin_dropdown,textbox,destinationDropdown,Survey_PersonDropdown,Survey_type1;
	    CommonFunction commonFunction=new CommonFunction();

	 // Constructor to load properties and initialize locators
	    public EnquiryPF(WebDriver driver) throws IOException {
	        this.driver = LoginPF.driver;

	        // Load the properties file
	        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
	        prop.load(fr);

	        // Initialize locators using properties
	        menu = By.xpath(prop.getProperty("Menu"));
	        enquiryBtn=By.xpath(prop.getProperty("Enquiry_btn"));
	        enqCreatebtn=By.xpath(prop.getProperty("Create_btn"));
	        revenueBranch=By.xpath(prop.getProperty("reveniu_branch"));
	        move_class=By.xpath(prop.getProperty("move_class"));
	        infoSource=By.xpath(prop.getProperty("info_surce"));
	        EnqFromName=By.xpath(prop.getProperty("Enq_name"));
	        Tentive_date=By.xpath(prop.getProperty("Tent_date"));
	        Enquiry_ReceiveDate=By.xpath(prop.getProperty("Contact_date"));
	        setClientDropdown(By.xpath(prop.getProperty("Client_text")));
	        setClientTextBox(By.xpath(prop.getProperty("Client_name")));
	        setCorporateDropdown(By.xpath(prop.getProperty("Corporate_text")));
	        setCorporateTextBox(By.xpath(prop.getProperty("Corporate_name")));
	        accountmangerdropdown=By.xpath(prop.getProperty("Acc_mng_test"));
	        txt_Account_manager=By.xpath(prop.getProperty("Account_manager"));
	        shipperTitle=By.xpath(prop.getProperty("Mr_Msr"));   
	        first_name=By.xpath(prop.getProperty("Fname"));
	        lastname=By.xpath(prop.getProperty("Lname"));
	        shipperDesignation=By.xpath(prop.getProperty("Designation"));
	        Shipper_type=By.xpath(prop.getProperty("Shipper_type"));
	        Shpt_category=By.xpath(prop.getProperty("Shpt_category"));
	        address1=By.xpath(prop.getProperty("Address1"));
	        address2=By.xpath(prop.getProperty("Address2"));
	       
	        cityDropdown=By.xpath(prop.getProperty("City_text"));
	        cityNameTextBox=By.xpath(prop.getProperty("City_name"));
	        pinCode=By.xpath(prop.getProperty("Pin_code"));
	        nationality=By.xpath(prop.getProperty("Nationality"));
	        mobile_number=By.xpath(prop.getProperty("Phone1"));
	        emailId=By.xpath(prop.getProperty("Email_id"));
//	        Detailed tab
	        handling_branch=By.xpath(prop.getProperty("Handling_branch"));
	        service_line=By.xpath(prop.getProperty("Service_line"));
	        transit_mode=By.xpath(prop.getProperty("Transit_mode"));
	        shipment_type =By.xpath(prop.getProperty("Shpment_type"));
	        commodity=By.xpath(prop.getProperty("Commodity"));
	        details_tab=By.xpath(prop.getProperty("Details_tab"));
	        origin_dropdown=By.xpath(prop.getProperty("Origin_drop"));
	        textbox=By.xpath(prop.getProperty("Original"));
	        destinationDropdown=By.xpath(prop.getProperty("Distination_drop"));
	        Survey_PersonDropdown=By.xpath(prop.getProperty("Survey_person"));
	        Survey_type1=By.xpath(prop.getProperty("Survey_type1"));
	    }
	    
//	    public static void clickonmenu()
//	    {	
//	    driver.findElement(menu).click();
//	    }
	   
//	    public static void clickonmenu() {
//	        // Create an explicit wait to wait for the menu to be clickable
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	        // Wait until the element is clickable before clicking
//	        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
//	    }
	    
	    public static void clickonmenu()
	    {	
	    	
	     WebElement Menu1 = driver.findElement(menu);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", Menu1);
	    }
	     


	

	    public void clickOnEnquiry()
	    {
	    	driver.findElement(enquiryBtn).click();
	    }
	    
	    public void clickOnCreateButton()
	    {
	    	scrollIntoViewAndClick(enqCreatebtn);
	    }
	    
	    public void selectRevenueBranch(String revenuebranch)
	    {
	    	selectDropdown(revenueBranch, revenuebranch);
	    }
	    
	    public void selectMoveClass(String moveClass)
	    {
	    	selectDropdown(move_class, moveClass);
	    }
	    
	    public void selectInfoSource(String info_source)
	    {
	    	selectDropdown(infoSource, info_source);
	    }
	    
	    public void enqformname(String name)
	    {
	    	driver.findElement(EnqFromName).sendKeys(name);
	    }
	    
	    public void selectTentivedate()
	    {
	    	waitForElementToBeClickable(Tentive_date);
	    	driver.findElement(Tentive_date).click();
	    	driver.findElement(Tentive_date).sendKeys(Keys.ARROW_DOWN);
	    	
	    }
	    
	    public void selectRecieveDate() throws InterruptedException
	    {
	    	Thread.sleep(100);
	    	driver.findElement(Enquiry_ReceiveDate).click();
	    	
	    }
	  
	    //common method for dropdown 
	    public void selectFromDynamicDropdown(By dropdownLocator, By textBoxLocator, String valueToSelect) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        
	        // Attempt to click and open the dropdown
	        try {
	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	            dropdown.click();
	        } catch (Exception e) {
	            System.out.println("Failed to click on the dropdown: " + e.getMessage());
	            return;  // Exit the method if the dropdown can't be clicked
	        }

	        // Find the text box and enter the value
	        WebElement textBox = driver.findElement(textBoxLocator);
	        textBox.sendKeys(valueToSelect);

	        // Wait for the suggestions to appear and interact with them
	        try {
	            Thread.sleep(1500);  // Short delay to allow suggestions to load

	            textBox.sendKeys(Keys.ARROW_DOWN);  // Navigate through the dropdown options
	            textBox.sendKeys(Keys.ARROW_DOWN);  // You can adjust the number of arrow downs as needed
	            textBox.sendKeys(Keys.ENTER);       // Select the option

	            // Ensure the value is selected
	            boolean selectedOption = wait.until(ExpectedConditions.textToBePresentInElementValue(textBoxLocator, valueToSelect));
	            if (selectedOption) {
	                System.out.println("Successfully selected the option: " + valueToSelect);
	            } else {
	                System.out.println("Failed to select the option: " + valueToSelect);
	            }

	        } catch (Exception e) {
	            System.out.println("Error while interacting with the dropdown: " + e.getMessage());
	        }
	    }

	    // Common method to select from dropdown
	    public void selectDropdown(By dropdownLocator, String dropdownValue) {
	        WebElement dropdownElement = driver.findElement(dropdownLocator);
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(dropdownValue);
	    }
	    
	    //Common method for enter text into textbox
	    public void enterTextIntoTextBox(By textBoxLocator, String textBoxValue)
	    {
	    WebElement textBoxElement = driver.findElement(textBoxLocator);
	    textBoxElement.sendKeys(textBoxValue);
	    }
		  // Utility method to wait for an element to be visible
	    private WebElement waitForElementToBeVisible(By locator) {
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

	    // Utility method to wait for an element to be clickable
	    public WebElement waitForElementToBeClickable(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	        return element;
	    }
	    // Method to handle potential overlays
	    public void handleOverlayAndClick(By locator) {
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

		public By getClientDropdown() {
			return clientDropdown;
		}

		public void setClientDropdown(By clientDropdown) {
			this.clientDropdown = clientDropdown;
		}

		public By getClientTextBox() {
			return clientTextBox;
		}

		public void setClientTextBox(By clientTextBox) {
			this.clientTextBox = clientTextBox;
		}

		public By getCorporateDropdown() {
			return corporateDropdown;
		}

		public void setCorporateDropdown(By corporateDropdown) {
			this.corporateDropdown = corporateDropdown;
		}

		public By getCorporateTextBox() {
			return corporateTextBox;
		}

		public void setCorporateTextBox(By corporateTextBox) {
			this.corporateTextBox = corporateTextBox;
		}
}
