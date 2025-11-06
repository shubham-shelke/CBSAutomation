package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pagefactory.CommonFunction;
import Pagefactory.EnquiryPF;
import Pagefactory.LoginPF;
import Pagefactory.PricingPF;

import static org.testng.Assert.assertEquals;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class EnquiryCreateStepdefinition {

    private WebDriver driver=CommonFunction.driver;  // Ensure driver is initialized properly in your setup
    private EnquiryPF enquiryPage;
    private Properties prop;
    public Map<String, String> data;
    private EnquiryPF getEnquiryPage() throws IOException {
        if (enquiryPage == null) {
        	enquiryPage = new EnquiryPF(driver);  // Initialize PricingPF only when needed
        }
        return enquiryPage;
    }
    @Given("user is on the home page")
    public void user_is_on_the_home_page() throws IOException, InterruptedException {
        // Load the properties file
        prop = new Properties();
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        driver = LoginPF.driver;  // Assuming you already have a Login class managing WebDriver
//        driver.manage().window().maximize();

        // Initialize the Pricing page object
        enquiryPage = new EnquiryPF(driver);
        Thread.sleep(1000);
    }

    @When("user click on the Enquiry button")
    public void user_click_on_the_enquiry_button() throws InterruptedException, IOException {
          // Initialize EnquiryPF in the method
    	Thread.sleep(1000);
        enquiryPage.clickonmenu();
        Thread.sleep(1000);
        enquiryPage.clickOnEnquiry();
    }
    @And("user clicks on the create button")
  public void user_clicks_on_the_create_button() throws InterruptedException {
    	enquiryPage.clickOnCreateButton(); 
  }
  @Then("Enquiry page should be open")
  public void enquiry_page_should_be_open() {
  	String actualTitle = driver.getTitle();
  	System.out.println(actualTitle);
  	
  	String expectedTitle = "[Relo Writer] Enquiry";
  	assertEquals(expectedTitle,actualTitle);
  }

@And("user selecting the revenue_branch")
public void user_selecting_the_revenue_branch(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	Thread.sleep(1000);
    data = dataTable.asMaps(String.class, String.class).get(0);
    String rev_branch = data.get("revenue_branch");
    enquiryPage.selectRevenueBranch(rev_branch);
    
}

@And("user selecting the move_class")
public void user_selecting_the_move_class(io.cucumber.datatable.DataTable dataTable) {
    
	 	data = dataTable.asMaps(String.class, String.class).get(0);
	    String move_class = data.get("move_class");
	    enquiryPage.selectMoveClass(move_class);
}

@And("user selecting the info_source")
public void user_selecting_the_info_source(io.cucumber.datatable.DataTable dataTable) {
    
	data = dataTable.asMaps(String.class, String.class).get(0);
    String info_source = data.get("info_source");
    enquiryPage.selectInfoSource(info_source);
    
}

@And("user enter the enquiry form name")
public void user_enter_the_enquiry_form_name(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String formName = data.get("name");
    enquiryPage.enqformname(formName);
}

@And("user select the tentive movedate")
public void user_select_the_tentive_movedate() { 
	enquiryPage.selectTentivedate();
}

@And("user select the enquiry receiveddate")
public void user_select_the_enquiry_receiveddate() throws InterruptedException {
    enquiryPage.selectRecieveDate();
}

@And("user selecting the client")
public void user_selecting_the_client(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    data = dataTable.asMaps(String.class, String.class).get(0);
    String client = data.get("client");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.getClientDropdown(), enquiryPage.getClientTextBox(), client);
}

@And("user selecting the corporate")
public void user_selecting_the_corporate(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    data = dataTable.asMaps(String.class, String.class).get(0);
    String corporate = data.get("corporate");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.getCorporateDropdown(), enquiryPage.getCorporateTextBox(), corporate);
}



@And("user selecting the account_manager")
public void user_selecting_the_account_manager(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String account_manager = data.get("account_manager");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.accountmangerdropdown, enquiryPage.txt_Account_manager, account_manager);
}

@And("user select the shipper title")
public void user_select_the_shipper_title(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String title = data.get("title");
   enquiryPage.selectDropdown(enquiryPage.shipperTitle,title );
}

@And("user enters the shipper first name")
public void user_enters_the_shipper_first_name(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_first_name = data.get("first_name");
	enquiryPage.enterTextIntoTextBox(enquiryPage.first_name, txt_first_name);
}

@And("User enters the shipper last name")
public void user_enters_the_shipper_last_name(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_last_name = data.get("last_name");
	enquiryPage.enterTextIntoTextBox(enquiryPage.lastname, txt_last_name);    
}

@And("user selects the shipper designation")
public void user_selects_the_shipper_designation(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String shipperDesignation = data.get("designation");
    enquiryPage.selectDropdown(enquiryPage.shipperDesignation,shipperDesignation );
}

@And("user selects the shipper type shipper_type")
public void user_selects_the_shipper_type_shipper_type(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String Shippertypevalue = data.get("shipper_type");
    enquiryPage.selectDropdown(enquiryPage.Shipper_type,Shippertypevalue );
	
}

@And("user selects the shipment category ship_category")
public void user_selects_the_shipment_category_ship_category(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String ship_categoryValue = data.get("ship_category");
    enquiryPage.selectDropdown(enquiryPage.Shpt_category,ship_categoryValue );
}

@And("user fills the address1")
public void user_fills_the_address1(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_address1 = data.get("address1");
	enquiryPage.enterTextIntoTextBox(enquiryPage.address1, txt_address1);  
}

@And("user fills the address2")
public void user_fills_the_address2(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_address2 = data.get("address2");
	enquiryPage.enterTextIntoTextBox(enquiryPage.address2, txt_address2);   
}

@And("user selects the shipper city city")
public void user_selects_the_shipper_city_city(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    
	data = dataTable.asMaps(String.class, String.class).get(0);
    String selectcity = data.get("city");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.cityDropdown, enquiryPage.cityNameTextBox, selectcity);
}

@Then("User Enters the Pincode")
public void user_enters_the_pincode(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String pincode = data.get("pincode");
	enquiryPage.enterTextIntoTextBox(enquiryPage.pinCode, pincode);    
}

@Then("user selects the shipper nationality nationality")
public void user_selects_the_shipper_nationality_nationality(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String nationality = data.get("nationality");
	enquiryPage.selectDropdown(enquiryPage.nationality, nationality);
}

@And("user enters the mobile number")
public void user_enters_the_mobile_number(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_mobile_number = data.get("mobile_number");
	enquiryPage.enterTextIntoTextBox(enquiryPage.mobile_number, txt_mobile_number); 

}

@And("user enters the email address")
public void user_enters_the_email_address(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String txt_email = data.get("email");
	enquiryPage.enterTextIntoTextBox(enquiryPage.emailId, txt_email);	
}

@And("user clicks on the detailed tab")
public void user_clicks_on_the_detailed_tab() throws InterruptedException {
//	 driver.findElement(By.xpath(prop.getProperty("Details_tab"))).click();
//	 Thread.sleep(1000);
	enquiryPage.scrollIntoViewAndClick(enquiryPage.details_tab);
}

@And("user select the handling branch")
public void user_select_the_handling_branch(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String handling_branch = data.get("handling_branch");
	enquiryPage.selectDropdown(enquiryPage.handling_branch, handling_branch);
}


@And("user select the service_line")
public void user_select_the_service_line(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String service_line = data.get("service_line");
	enquiryPage.selectDropdown(enquiryPage.service_line, service_line);
}

@And("user select the transit mode")
public void user_select_the_transit_mode(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String transit_mode = data.get("transit_mode");
	enquiryPage.selectDropdown(enquiryPage.transit_mode, transit_mode);
}

@And("user select the handling shipment type")
public void user_select_the_handling_shipment_type(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String shipment_Type = data.get("shipment_Type");
	enquiryPage.selectDropdown(enquiryPage.shipment_type, shipment_Type);
}

@And("user select the commodity")
public void user_select_the_commodity(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String commodity = data.get("commodity");
	enquiryPage.selectDropdown(enquiryPage.commodity, commodity);
}

@And("user selects the tentive move date")
public void user_selects_the_tentive_move_date() {
	driver.findElement(By.xpath(prop.getProperty("Test_mv_date"))).click();  
}

@And("the user selecting the origin city")
public void the_user_selecting_the_origin_city(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String originCity = data.get("originCity");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.origin_dropdown, enquiryPage.textbox, originCity);
    
}

@And("the user selecting destination city")
public void the_user_selecting_destination_city(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {    
	data = dataTable.asMaps(String.class, String.class).get(0);
    String destinationCity = data.get("destinationCity");
    enquiryPage.selectFromDynamicDropdown(enquiryPage.destinationDropdown, enquiryPage.textbox, destinationCity);
    
}

@And("the clicks on the SchSurvey Details tab")
public void the_clicks_on_the_sch_survey_details_tab() throws InterruptedException {
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(prop.getProperty("Survey_link"))).click();
	 Thread.sleep(1000);
}

@And("user selecting Sch.Surveyor Name")
public void user_selecting_sch_surveyor_name(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	Thread.sleep(1000);
	data = dataTable.asMaps(String.class, String.class).get(0);
    String surveyor_name = data.get("surveyor_name");
	enquiryPage.selectDropdown(enquiryPage.Survey_PersonDropdown, surveyor_name);
}

@And("user selecting Sch.Survey Type")
public void user_selecting_sch_survey_type(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String survey_Type = data.get("survey_Type");
	enquiryPage.selectDropdown(enquiryPage.Survey_type1, survey_Type);
}

@And("user selecting Sch Survey Date")
public void user_selecting_sch_survey_date() throws InterruptedException {
	Thread.sleep(500);
  driver.findElement(By.xpath(prop.getProperty("Survey_date"))).click();
    
}

@And("click on add shipment button")
public void click_on_add_shipment_button() throws InterruptedException {
    
	 Thread.sleep(1000);
    driver.findElement(By.id(prop.getProperty("Add_shipment"))).click();
}

@And("click on save button")
public void click_on_save_button() throws InterruptedException {
	 driver.findElement(By.xpath(prop.getProperty("Save_btn"))).click();;
	    
   
	 
	 
	 Thread.sleep(5000);
		WebElement enquiryNoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[2]/form[2]/div[2]/div[1]/div[1]/span[2]/h4[1]"));

     // Copy the Enquiry No to the clipboard
     String enquiryNo = enquiryNoElement.getText();
     StringSelection stringSelection = new StringSelection(enquiryNo);
     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
     clipboard.setContents(stringSelection, null);

     System.out.println(enquiryNo);
     String enquiryInfo = enquiryNo;
     
     String[] parts = enquiryInfo.split(":\\s+");
     String enquiryNo1 = parts[1];
     System.out.println(enquiryNo1);
     // String filePath = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\Configuration\\Locater.properties";
	String filePath ="C:\Users\shubham.shelke\git\repository\CBSAUTOMATION\Configuration\Locater.properties";
     String enquiryNumberKey = "EnqNumber=";
     String enquiryNumber = "";

     try {
         File file = new File(filePath);
         BufferedReader reader = new BufferedReader(new FileReader(file));
         String line;

         while ((line = reader.readLine()) != null) {
             if (line.startsWith(enquiryNumberKey)) {
                 enquiryNumber = line.substring(enquiryNumberKey.length());
                 break;
             }
         }

         reader.close();
     } catch (IOException e) {
         e.printStackTrace();
     }

     if (!enquiryNumber.isEmpty()) {
         System.out.println("Old enquiry number: " + enquiryNumber);
     } else {
         System.out.println("Enquiry number not found in prop.locator file.");
     }

             String oldEnquiryNumber = enquiryNumber;
             String newEnquiryNumber = enquiryNo1;

             try {
                 File file = new File(filePath);
                 BufferedReader reader = new BufferedReader(new FileReader(file));
                 StringBuilder stringBuilder = new StringBuilder();
                 String line;

                 while ((line = reader.readLine()) != null) {
                     stringBuilder.append(line.replaceAll(oldEnquiryNumber, newEnquiryNumber)).append("\n");
                 }

                 reader.close();

                 BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                 writer.write(stringBuilder.toString());
                 writer.close();

                 System.out.println("Enquiry number replaced successfully.");
             } catch (IOException e) {
                 e.printStackTrace();
             }
	    


}





}
