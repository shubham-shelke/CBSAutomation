//package StepDefinitions;
//
//import static org.testng.Assert.assertEquals;
//import pages.SurveyPOM;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.NoSuchElementException;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.UnhandledAlertException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//import Pagefactory.LoginPF;
//import Pagefactory.PricingPF;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import pages.SurveyPOM;
//
//public class CreateEnquiry {
//
//	    public static WebDriver driver;
//	    LoginPF loginpage;
//	    public static Properties prop = new Properties();
//	    public static FileReader fr;
//	    private WebDriverWait wait;
//	    private PricingPF pricingPage;
//	    private SurveyPOM surveyPOM;
//	    
//	    @Before
//	    public void setUp() throws IOException {
//	        if (driver == null) {
//	            try {
//	                // Load properties from locater file
//	                fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
//	                prop.load(fr);
//	                
//	                // Initialize WebDriver (EdgeDriver)
//	                driver = LoginPF.driver;
////	                driver.manage().window().maximize();
//	                
//	            } catch (FileNotFoundException e) {
//	                System.out.println("Locater.properties file not found: " + e.getMessage());
//	                throw e;
//	            } catch (IOException e) {
//	                System.out.println("Error loading properties file: " + e.getMessage());
//	                throw e;
//	            }
//	        }
//	    }
//@Given("user is on the home page")
//public void user_is_on_the_home_page() {
//    
//	String actualTitle = driver.getTitle();
//	System.out.println(actualTitle);
////	String expectedTitle = "[Relo Writer] Dashboard";
////	assertEquals(expectedTitle,actualTitle);
//}
//
//@When("user click on the Enquiry button")
//public void user_click_on_the_enquiry_button() throws InterruptedException, IOException {
//
//    
//	Thread.sleep(1500);
//	WebElement Enquiry = driver.findElement(By.xpath(prop.getProperty("Enquiry_btn")));
//	  
//	  JavascriptExecutor jse = (JavascriptExecutor)driver;
//			jse.executeScript("arguments[0].click()", Enquiry);
//			Thread.sleep(500); 
//}
//
//@Then("Enquiry page should be open")
//public void enquiry_page_should_be_open() {
//	String actualTitle = driver.getTitle();
//	System.out.println(actualTitle);
//	
//	String expectedTitle = "[Relo Writer] Enquiry";
//	assertEquals(expectedTitle,actualTitle);
//}
//
//@And("user clicks on the create button")
//public void user_clicks_on_the_create_button() throws InterruptedException {
//    
//	WebElement  Create= driver.findElement(By.xpath(prop.getProperty("Create_btn")));
//	
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click()", Create);
//	
//	Thread.sleep(1000);
//}
//
//@And("^user selecting the (.*)$")
//public void user_selecting_the_option(String option) throws InterruptedException {
//    switch (option) {
//        case "MUMBAI":
//        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("reveniu_branch")))); 
//            Select select = new Select(dropDown);
//            select.selectByVisibleText(option);
//            break;
//        case "WhatsApp":
//      	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//  	    WebElement dropDown1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("info_surce"))));
//  	    Select select1 = new Select(dropDown1);
//  	    select1.selectByVisibleText(option);
//            break;
//        case "Quote":
//        	  WebDriverWait Qwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        	  
//        	    WebElement MovedropDown = Qwait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("move_class"))));
//        	    Select selectmoveclass = new Select(MovedropDown);
//        	    selectmoveclass.selectByVisibleText(option);
//              break;       
//        case "CARTUS":
//     	 Thread.sleep(2000);
//  	    driver.findElement(By.xpath(prop.getProperty("Client_text"))).click();
//  	    WebElement client = driver.findElement(By.xpath(prop.getProperty("Client_name")));
//  	    client.sendKeys(option);
//  	    Thread.sleep(1000);
//  	    client.sendKeys(Keys.ARROW_DOWN);
//  	    Thread.sleep(1000);
//  	    client.sendKeys(Keys.ENTER);
//            break;
//            
//        case "Aargus":	
////    	  WebDriverWait clientwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//   	 Thread.sleep(2000);
//	    driver.findElement(By.xpath(prop.getProperty("Corporate_text"))).click();
//	    WebElement client1 = driver.findElement(By.xpath(prop.getProperty("Corporate_name")));
//
//	    client1.sendKeys(option);
//	    Thread.sleep(1000);
//	    client1.sendKeys(Keys.ARROW_DOWN);
//	    Thread.sleep(1000);
//	    client1.sendKeys(Keys.ENTER);
//          break;
//        case "Shubham Shelke-2222":
//        driver.findElement(By.xpath(prop.getProperty("Acc_mng_test"))).click();
//      	  WebDriverWait accountmanagerwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      	    WebElement AccountManagerdropdown = accountmanagerwait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Account_manager"))));
//      	  AccountManagerdropdown.sendKeys(option);
//      	  
//        AccountManagerdropdown.sendKeys(Keys.ARROW_DOWN);
//        AccountManagerdropdown.sendKeys(Keys.ARROW_DOWN);
////        Thread.sleep(1000);
//        AccountManagerdropdown.sendKeys(Keys.ENTER);
//            break;
//        
//        case "CEO":
//      	  	WebDriverWait Dwait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      	    WebElement Designationdropdown = Dwait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Designation"))));
//      	    Select selectDesignation = new Select(Designationdropdown);
//      	  selectDesignation.selectByVisibleText(option);
//            break;   
//            
//        case "Government":
//      	  	WebDriverWait Typewait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      	    WebElement ShipperTypedropdown = Typewait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Shipper_type"))));
//      	    Select selectShipperType = new Select(ShipperTypedropdown);
//      	  selectShipperType.selectByVisibleText(option);
//            break; 
//            
//        case "VIP":
//      	  	WebDriverWait catagorywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      	    WebElement ShipperCategaory = catagorywait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Designation"))));
//      	    Select ShipperCategaoryselect = new Select(ShipperCategaory);
//      	  ShipperCategaoryselect.selectByVisibleText(option);
//            break; 
//            
//        default:
//            throw new IllegalArgumentException("Unknown option: " + option);
//    }
//    
//}
//
//
//@And("^user enter the enquiry form (.*)$")
//public void user_enter_the_enquiry_form_shubham(String name) {
//	WebElement nameInputBox = driver.findElement(By.xpath(prop.getProperty("Enq_name")));
//	nameInputBox.sendKeys(name);
//}
//
//
//
//@Then("user select the tentive movedate")
//public void user_select_the_tentive_movedate() throws InterruptedException {
//	Thread.sleep(500);
//	WebElement tentDateInput = driver.findElement(By.xpath(prop.getProperty("Tent_date")));
//	
//	    
//	    tentDateInput.click();
//	    tentDateInput.sendKeys(Keys.ARROW_DOWN);
//	    tentDateInput.sendKeys(Keys.ARROW_DOWN);
//	    Thread.sleep(500);
//	    
////	    WebElement specificDate = driver.findElement(By.xpath(prop.getProperty("date_select"))); 
////	    specificDate.click();    
//	
//}
//
//@Then("user select the enquiry receiveddate")
//public void user_select_the_enquiry_receiveddate() throws InterruptedException {
//	WebElement enquiryReceivedate = driver.findElement(By.xpath(prop.getProperty("Contact_date")));
//	Thread.sleep(500);
//	enquiryReceivedate.click();	
////	Thread.sleep(1000);
//}
//
//
//@And("^user select the shipper (.*)$")
//public void user_selecting_the_shipper_mr(String title) {
//     
//	WebElement value1 = driver.findElement(By.xpath(prop.getProperty("Mr_Msr")));
//  
//  Select dropdown9 = new Select(value1);
//     
//  dropdown9.selectByVisibleText("Mr.");
//}
//
///*
//@And("^user enters the shipper (.*)$")
//public void user_enters_the_shipper_shubham(String name) {
//	WebElement firstNameTextBox = driver.findElement(By.xpath(prop.getProperty("Fname")));
//  firstNameTextBox.clear();
//  firstNameTextBox.sendKeys(name);
//}
//*/
//@And("^user enter the shipper (.+) as \"([^\"]*)\"$")
//public void user_enter_the_shipper(String field, String value) {
//    String locator = "";
//    switch (field.toLowerCase()) {
//    case "first_name":
//        locator = prop.getProperty("Fname");
//        break;
//    	case "last_name":
//            locator = prop.getProperty("Lname");
//            break;
//        case "address1":
//            locator = prop.getProperty("Address1");
//            break;
//        case "address2":
//            locator = prop.getProperty("Address2");
//            break;
//        case "pincode":
//            locator = prop.getProperty("Pin_code");
//            break;
//        case "mobile_number":
//            locator = prop.getProperty("Phone1");
//            break;
//        case "email":
//            locator = prop.getProperty("Email_id");
//            break;
//        default:
//            throw new IllegalArgumentException("Invalid field: " + field);
//    }
//    driver.findElement(By.xpath(locator)).sendKeys(value);
//}
//
//
//
//@And("^user selects the shipper (CEO|CFO|Director)$")
//public void user_selects_the_shipper_ceo(String designation) {
//    WebElement designationdropdown = driver.findElement(By.xpath(prop.getProperty("Designation")));
//    Select designationdropdownvalue = new Select(designationdropdown);
//    designationdropdownvalue.selectByVisibleText(designation);
//}
//
//@And("^user selects the shipper type (Government|VIP|Regular)$")
//public void user_selects_the_shipper_type(String shipperType) {
//    WebElement designationDropdown = driver.findElement(By.xpath(prop.getProperty("Shipper_type")));
//    Select designationDropdownValue = new Select(designationDropdown);
//    designationDropdownValue.selectByVisibleText(shipperType);
//}
//
//@And("^user selects the shipment category (VIP|Regular)$")
//public void user_selects_the_ship_category(String shipCategory) {
//    WebElement shipmentTypeDropdown = driver.findElement(By.xpath(prop.getProperty("Shpt_category")));
//    Select shipmentTypeDropdownValue = new Select(shipmentTypeDropdown);
//    shipmentTypeDropdownValue.selectByVisibleText(shipCategory);
//}
//
//@And("^user selects the shipper city (MUMBAI-Maharashtra-INDIA)$")
//public void user_selects_the_shipper_city_mumbai_maharashtra_india(String city) throws InterruptedException {
//	 
//	    driver.findElement(By.xpath(prop.getProperty("City_text"))).click();
//	    WebElement city1 = driver.findElement(By.xpath(prop.getProperty("City_name")));
//
//	    city1.sendKeys(city);
//	    Thread.sleep(1200);
//	    city1.sendKeys(Keys.ARROW_DOWN);
//	    Thread.sleep(1000);
//	    city1.sendKeys(Keys.ENTER);
//}
//
//@And("^user selects the shipper nationality (INDIAN)$")
//public void user_selects_the_shipper_nationality_indian(String nationality) {
//	 WebElement nationalityDropdown = driver.findElement(By.xpath(prop.getProperty("Nationality")));
//	    Select nationalityDropdownValue = new Select(nationalityDropdown);
//	    nationalityDropdownValue.selectByVisibleText(nationality);
//}
//
////Details_tab
//
//@And("user clicks on the detailed tab")
//public void user_clicks_on_the_detailed_tab() throws InterruptedException {
//	 driver.findElement(By.xpath(prop.getProperty("Details_tab"))).click();
//	 Thread.sleep(1000);
//}
//@And("the clicks on the SchSurvey Details tab")
//public void the_clicks_on_the_sch_survey_details_tab() throws InterruptedException {
//	 Thread.sleep(1000);
// driver.findElement(By.xpath(prop.getProperty("Survey_link"))).click();
//
//}
//@And("^user select the shipment (.+) as \"([^\"]*)\"$")
//public void user_select_the_shipment(String field, String value) throws InterruptedException {
//    String locator = "";
//    
//    // Define locators for each field
//    switch (field.toLowerCase()) {
//        case "handling_branch":
//            locator = prop.getProperty("Handling_branch"); 
//            break;
//        case "service_line":
//            locator = prop.getProperty("Service_line"); 
//            break;
//        case "transit_mode":
//            locator = prop.getProperty("Transit_mode"); 
//            break;
//        case "shipment type":
//            locator = prop.getProperty("Shpment_type"); 
//            break;
//        case "commodity":
//            locator = prop.getProperty("Commodity"); 
//            break;
//        default:
//            throw new IllegalArgumentException("Invalid field: " + field);
//    }
//
//    
//    WebElement dropdown = driver.findElement(By.xpath(locator));
//    Select select = new Select(dropdown);
//    select.selectByVisibleText(value);
//}
//
//
//@And("user selects the tentive move date")
//public void user_selects_the_tentive_move_date() {
//	 driver.findElement(By.xpath(prop.getProperty("Test_mv_date"))).click();
//}
//
//@And("the user selecting the origin city")
//public void the_user_selecting_the_origin_city() throws InterruptedException {
//	 driver.findElement(By.xpath(prop.getProperty("Origin_drop"))).click();
//	    WebElement Origin =driver.findElement(By.xpath(prop.getProperty("Original")));
//	    Origin.sendKeys("Mumbai");
//	    Thread.sleep(1000);
//	    Origin.sendKeys(Keys.ARROW_DOWN);
//	    Thread.sleep(1000);
//	    Origin.sendKeys(Keys.ENTER);
//}
//
//@And("the user selecting destination city")
//public void the_user_selecting_destination_city() throws InterruptedException {
//	Thread.sleep(4000);
//    driver.findElement(By.xpath(prop.getProperty("Distination_drop"))).click();
//    WebElement Distination =driver.findElement(By.xpath(prop.getProperty("Distination_name")));
//    Distination.sendKeys("Pune");
//    Thread.sleep(1000);
//    Distination.sendKeys(Keys.ARROW_DOWN);
//    Thread.sleep(1000);
//    Distination.sendKeys(Keys.ENTER);
//}
//@And("user selecting Sch.Surveyor Name")
//public void user_selecting_sch_surveyor_name() throws InterruptedException {
//	Thread.sleep(500);
//    WebElement surveyExport = driver.findElement(By.xpath(prop.getProperty("Survey_person")));
//   
//    Select surveyExport1 = new Select(surveyExport);
//    surveyExport1.selectByVisibleText("Shubham Shelke-2222");
//}
//
//@And("user selecting Sch Survey Date")
//public void user_selecting_sch_survey_date() throws InterruptedException {
//	Thread.sleep(500);
//    driver.findElement(By.xpath(prop.getProperty("Survey_date"))).click();
//    
//}
//@And("user selecting Sch.Survey Type")
//public void user_selecting_sch_survey_type() throws InterruptedException {
//	  Thread.sleep(1000);
//	    WebElement surveytypeExport = driver.findElement(By.xpath(prop.getProperty("Survey_type1")));
//     
//	    Select surveyExport2 = new Select(surveytypeExport); 
//	    surveyExport2.selectByVisibleText("Virtual");
//}
//@And("click on add shipment button")
//public void click_on_add_shipment_button() throws InterruptedException {
//	 Thread.sleep(1000);
//	    driver.findElement(By.id(prop.getProperty("Add_shipment"))).click();
//}
//
//@And("click on save button")
//public void click_on_save_button() throws InterruptedException {
//	 WebElement Save = driver.findElement(By.xpath(prop.getProperty("Save_btn")));
//	    Save.click();
//	    
//
//	 
//		Thread.sleep(5000);
//		WebElement enquiryNoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[2]/form[2]/div[2]/div[1]/div[1]/span[2]/h4[1]"));
//
//        // Copy the Enquiry No to the clipboard
//        String enquiryNo = enquiryNoElement.getText();
//        StringSelection stringSelection = new StringSelection(enquiryNo);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);
//
//        System.out.println(enquiryNo);
//        String enquiryInfo = enquiryNo;
//        
//        String[] parts = enquiryInfo.split(":\\s+");
//        String enquiryNo1 = parts[1];
//        System.out.println(enquiryNo1);
//        String filePath = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\Configuration\\Locater.properties";
//        String enquiryNumberKey = "EnqNumber=";
//        String enquiryNumber = "";
//
//        try {
//            File file = new File(filePath);
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith(enquiryNumberKey)) {
//                    enquiryNumber = line.substring(enquiryNumberKey.length());
//                    break;
//                }
//            }
//
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (!enquiryNumber.isEmpty()) {
//            System.out.println("Old enquiry number: " + enquiryNumber);
//        } else {
//            System.out.println("Enquiry number not found in prop.locator file.");
//        }
//
//                String oldEnquiryNumber = enquiryNumber;
//                String newEnquiryNumber = enquiryNo1;
//
//                try {
//                    File file = new File(filePath);
//                    BufferedReader reader = new BufferedReader(new FileReader(file));
//                    StringBuilder stringBuilder = new StringBuilder();
//                    String line;
//
//                    while ((line = reader.readLine()) != null) {
//                        stringBuilder.append(line.replaceAll(oldEnquiryNumber, newEnquiryNumber)).append("\n");
//                    }
//
//                    reader.close();
//
//                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//                    writer.write(stringBuilder.toString());
//                    writer.close();
//
//                    System.out.println("Enquiry number replaced successfully.");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//	    
//
//}
//}
