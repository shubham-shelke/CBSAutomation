package StepDefinitions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pagefactory.EnquiryPF;
import Pagefactory.LoginPF;
import Pagefactory.MoveManPF;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MoveManStepDefinition {

    private WebDriver driver;
    private MoveManPF moveman;
    private Properties prop;
    public Map<String, String> data;
    public String Jobnum;

    @Before
    public void setup() throws IOException {
        driver = LoginPF.driver;  // Initialize WebDriver
        moveman = new MoveManPF(driver);  // Pass the driver to MoveManPF
        prop = new Properties();
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);
    }

    @When("user clicks on moveman")
    public void user_clicks_on_moveman() throws InterruptedException {
        Thread.sleep(1500);
        EnquiryPF.clickonmenu();  
//        Thread.sleep(1000);
    }

    @And("I click on open job menu")
    public void i_click_on_open_job_menu() throws InterruptedException {
        moveman.moveMan(); 
      
    }

    @And("I search job by using enquiry number")
    public void i_search_job_by_using_enquiry_number(DataTable dataTable) throws InterruptedException {

        data = dataTable.asMaps(String.class, String.class).get(0);
        String Enquiry_Select = data.get("Enquiry_Select");
        moveman.selectFromDynamicDropdown(moveman.dropDownSelectJob, moveman.openJobTextBox, Enquiry_Select);    
        // Wait for the dropdown interaction to complete
        Thread.sleep(1000);
        moveman.textBox(moveman.Enq_search,moveman.enqnumber);
        moveman.searchbtn();
        
    }

    @And("I click on open job or view job button")
    public void i_click_on_open_job_or_view_job_button() throws InterruptedException {
    	Thread.sleep(1000);
//        moveman.clickonOpenJobBtn();
//    	 WebElement JobNo1=driver.findElement(By.xpath(prop.getProperty("JobNo")));   
//          JobNo = JobNo1.getText();
//         System.out.println("Job Number"+JobNo);
         
    
    	moveman.clickOnJobButton();
    	
    	
    	try {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the alert text (optional)
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);

            // Accept the alert (click OK)
            alert.accept();

            System.out.println("Alert accepted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("I selecting the Nationality")
    public void i_selecting_the_nationality(DataTable dataTable) throws InterruptedException {
        
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String nationality = data.get("nationality");
    	moveman.selectDropdown(moveman.nationality, nationality);
    	
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("fromLocation")).sendKeys("Pune");
    	Thread.sleep(2000);
    	Actions actions = new Actions(driver);
    	actions.keyDown(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.TAB).perform();

//    	driver.findElement(By.id("fromLocation")).sendKeys(Keys.TAB+Keys.ENTER);
//    	driver.findElement(By.id("fromLocation")).sendKeys(Keys.ENTER);
    	

    	driver.findElement(By.id("toLocation")).sendKeys("Mumbai");
    	Thread.sleep(2000);
    	Actions actions1 = new Actions(driver);
    	actions1.keyDown(Keys.TAB).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyUp(Keys.TAB).perform();
//    	driver.findElement(By.id("toLocation")).sendKeys(Keys.ARROW_DOWN);
//    	driver.findElement(By.id("toLocation")).sendKeys(Keys.ENTER);
    	
    }

    @And("I selecting origin warehouse")
    public void i_selecting_origin_warehouse(DataTable dataTable) throws InterruptedException {
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//	        // Scroll down the window using JavaScript
//	        js.executeScript("window.scrollBy(0, 500);");
//	        Thread.sleep(1000);
//		    
//	        WebElement selecterWarehouse =driver.findElement(By.xpath(prop.getProperty("OrgWarehouse")));
//		    selecterWarehouse.click();
//		    WebElement Warehouse =driver.findElement(By.xpath(prop.getProperty("orgsearchbox")));
//		    Warehouse.sendKeys("Panvel-Mumbai-Panvel");
//		    Warehouse.sendKeys(Keys.ARROW_DOWN);
//		    Thread.sleep(1000);
//		    Warehouse.sendKeys(Keys.ENTER);
	       
		    data = dataTable.asMaps(String.class, String.class).get(0);
	        String originWareHouse = data.get("originWh");
		    moveman.selectFromDynamicDropdown(moveman.orgWarehouse, moveman.origindestSearchBox, originWareHouse);
    }

    @And("I selecting destination warehouse")
    public void i_selecting_destination_warehouse(DataTable dataTable) throws InterruptedException {

//		    Thread.sleep(1000);
//		    WebElement selecterDWarehouse1 =driver.findElement(By.xpath(prop.getProperty("DestWarehouse")));
//		    selecterDWarehouse1.click();
//		    WebElement Warehouse1 =driver.findElement(By.xpath(prop.getProperty("orgsearchbox")));
//		    Warehouse1.sendKeys("Koralur-Bangalore-Koralur");
//		    Warehouse1.sendKeys(Keys.ARROW_DOWN);
//		    Thread.sleep(1000);	    
//		    Warehouse1.sendKeys(Keys.ENTER);
		  
    		data = dataTable.asMaps(String.class, String.class).get(0);
	        String destWareHouse = data.get("destWh");
		    moveman.selectFromDynamicDropdown(moveman.destWarehouse, moveman.origindestSearchBox, destWareHouse);
    }

    @And("I enter the advance payment details")
    public void i_enter_the_advance_payment_details(DataTable dataTable) {
    	
//    	driver.findElement(By.xpath(prop.getProperty("Cheque_No"))).sendKeys("Cash");
   	 
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String chequeno = data.get("Cheque_No");
    	 
    	 moveman.enterTextIntoTextBox(moveman.Cheque_No, chequeno);
        
    }

    @And("I enter advanced amount")
    public void i_enter_advanced_amount(DataTable dataTable) {
        
//    	driver.findElement(By.xpath(prop.getProperty("Cheque_Amt"))).sendKeys("2500");
     	data = dataTable.asMaps(String.class, String.class).get(0);
        String chequeamount = data.get("amount");
    	 
    	 moveman.enterTextIntoTextBox(moveman.Cheque_Amt, chequeamount);
        
	    
    }

    @And("I selecting the HOSD")
    public void i_selecting_the_hosd(DataTable dataTable) throws InterruptedException {
	    
//	    WebElement selecterHOSD = driver.findElement(By.xpath(prop.getProperty("HOSD")));
//	       selecterHOSD.click();
//	    
//	    WebElement HOSD = driver.findElement(By.xpath(prop.getProperty("HOSDtextbox")));
////	    HOSD.sendKeys("Shubham Shelke-2222");
//	    HOSD.sendKeys(Keys.ARROW_DOWN);
//	    HOSD.sendKeys(Keys.ENTER);
//	    Select dropdownHOSD = new Select(selecterHOSD);
//	    dropdownHOSD.selectByVisibleText("Shubham Shelke-2222");
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String hosd = data.get("HOSD");
    	moveman.selectFromDynamicDropdown(moveman.hOSD, moveman.hOSDtextbox, hosd);
    }

    @And("I selecting DestBrSD")
    public void i_selecting_dest_br_sd(DataTable dataTable) throws InterruptedException {
//    	WebElement selecterDBRSD = driver.findElement(By.xpath(prop.getProperty("DestBRSD")));
//	    selecterDBRSD.click();
//	    WebElement DBRSD = driver.findElement(By.xpath(prop.getProperty("BRDStextBox")));
//	    
//	    DBRSD.sendKeys(Keys.ARROW_DOWN);
//	    DBRSD.sendKeys(Keys.ENTER);
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String hosd = data.get("BRSD");
    	moveman.selectFromDynamicDropdown(moveman.destBRSD, moveman.hOSDtextbox, hosd);
    }

    @When("I click on save job button")
    public void i_click_on_save_job_button() throws InterruptedException {
    	  WebElement SaveJob1= driver.findElement(By.xpath(prop.getProperty("SaveJob")));
		      
		    JavascriptExecutor SaveJob1_click = (JavascriptExecutor)driver;
		    SaveJob1_click.executeScript("arguments[0].click()", SaveJob1);
		    
		    Thread.sleep(1500);
		    
		    // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the alert text (optional)
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);

            // Accept the alert (click OK)
            alert.accept();

            System.out.println("Alert accepted successfully!");
		    
		    
    }

//===============================================================Paking Stage===================================================
    
    
    @Given("I am on job opening page")
    public void i_am_on_job_opening_page() {
        
    }

//    @And("I click on packing stage tab")
//    public void i_click_on_packing_stage_tab() throws InterruptedException {
//    	Thread.sleep(1000);
//     	WebElement CopyJobNo = driver.findElement(By.xpath(prop.getProperty("JobNoCopy")));
//
//        // Copy the job No to the clipboard
//         Jobnum = CopyJobNo.getText();
//        StringSelection stringSelection = new StringSelection(Jobnum);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);
//
//        System.out.println(Jobnum);
//    
//        driver.findElement(moveman.Packing_Stage).click();
//    }

    
    @And("I click on packing stage tab")
    public void i_click_on_packing_stage_tab() throws InterruptedException {
        // Wait for the element to load
//        Thread.sleep(1000);
//
//        // Locate the "CopyJobNo" element and retrieve its text
//        WebElement CopyJobNo = driver.findElement(By.xpath(prop.getProperty("JobNoCopy")));
//        Jobnum = CopyJobNo.getText(); // Store the job number in the public variable
//
//        // Copy the job number to the clipboard
//        StringSelection stringSelection = new StringSelection(Jobnum);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);
//
//        System.out.println("Copied Job Number: " + Jobnum);

 
        // Click on the Packing Stage tab
    	Thread.sleep(1000);
        driver.findElement(moveman.Packing_Stage).click();
    }

    @And("I selecting the pack date")
    public void i_selecting_the_pack_date(DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String packdate = data.get("pack_date");
        moveman.textBox(moveman.PackDate, packdate);
    }

    @And("I selecting the Load date")
    public void i_selecting_the_load_date(DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String load_date = data.get("load_date");
        moveman.textBox(moveman.PackingInfo, load_date);
       
    }

    @And("I selecting the Loose Cased from DropDown")
    public void i_selecting_the_loose_cased_from_drop_down(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String losecased = data.get("losecased");
        moveman.selectDropdown(moveman.LooseCased, losecased);
    }

    @And("I selecting the LCL FCL")
    public void i_selecting_the_lcl_fcl(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String LCL_FCL = data.get("LCL_FCL");
        moveman.selectDropdown(moveman.LCLorFCL, LCL_FCL);
    	
    }

    @And("I selecting the container size")
    public void i_selecting_the_container_size(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String load_date = data.get("container_Size");
        moveman.selectDropdown(moveman.pakingcontainer, load_date);
    	
    }

    @And("I selecting the volume unit")
    public void i_selecting_the_volume_unit(io.cucumber.datatable.DataTable dataTable) {
   
    }

    @And("I entered the net volume")
    public void i_entered_the_net_volume(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String netVolume = data.get("netVolume");
        moveman.enterTextIntoTextBox(moveman.netVol, netVolume);
    	
    }

    @And("I entered the gross volume")
    public void i_entered_the_gross_volume(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String gross_volume = data.get("gross_volume");
        moveman.enterTextIntoTextBox(moveman.grossVol, gross_volume);
    }

    @And("I selecting Wt Unit")
    public void i_selecting_wt_unit(io.cucumber.datatable.DataTable dataTable) {
    	
    }

    @And("I entered the wt_net volume")
    public void i_entered_the_wt_net_volume(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String wt_net_volume = data.get("wt_net_volume");
        moveman.enterTextIntoTextBox(moveman.packingNetWt, wt_net_volume);
    }

    @And("I entered the wt_gross volume")
    public void i_entered_the_wt_gross_volume(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String wt_gross_volume = data.get("wt_gross_volume");
        moveman.enterTextIntoTextBox(moveman.pkgGrossWt, wt_gross_volume);

    }

    @And("I click on Get Cost button")
    public void i_click_on_get_cost_button() {
        driver.findElement(moveman.getCostbtn).click();   
    }

    @And("I click on the packing cost")
    public void i_click_on_the_packing_cost() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(moveman.packing_Cost).click();
    }

    @And("I selecting rate component")
    public void i_selecting_rate_component(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String rate_component = data.get("rate_component");
    	moveman.selectDropdown(moveman.rateComp, rate_component);
  
    }

    @And("I selecting the cost head")
    public void i_selecting_the_cost_head(io.cucumber.datatable.DataTable dataTable) {
    	
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String selectingcostHead = data.get("selectingcostHead");
    	moveman.selectDropdown(moveman.pkgCostHead, selectingcostHead);
        
    }

    @And("I enter wt per unit")
    public void i_enter_wt_per_unit(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String per_unit = data.get("wt_per_unit");
    	moveman.enterTextIntoTextBox(moveman.costper, per_unit);
    }

    @And("I enter the rate cost")
    public void i_enter_the_rate_cost(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String rate = data.get("rate");
    	moveman.enterTextIntoTextBox(moveman.PKGRate, rate);
    }

    @And("I selecting the rate currency")
    public void i_selecting_the_rate_currency(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String currency = data.get("currency");
    	moveman.selectDropdown(moveman.pkgcurrency, currency);
    }

    @And("I enter the Revenue")
    public void i_enter_the_revenue(io.cucumber.datatable.DataTable dataTable) {
    	data = dataTable.asMaps(String.class, String.class).get(0);
        String Revenue = data.get("Revenue");
    	moveman.enterTextIntoTextBox(moveman.pkgRev, Revenue);
    }

    @And("I click on add button")
    public void i_click_on_add_button() {
        
//        driver.findElement(moveman.btnAddCost).click();
        // Click the Add Cost button
    driver.findElement(moveman.btnAddCost).click();
        
        // Wait for the alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));  // Extended wait time
        try {
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Optionally, capture and print the alert message
            String alertMessage = alert.getText();
            System.out.println("Alert message: " + alertMessage);

            // Accept the alert (click OK)
            alert.accept();

        } catch (TimeoutException e) {
            // No alert appeared within the wait time, so just proceed
            System.out.println("No alert appeared within the wait time. Continuing the test.");
        } catch (NoAlertPresentException e) {
            // If the alert was not found at all, proceed without failure
            System.out.println("No alert present, continuing without handling alert.");
        }
    }
    

    @And("I click on save paking button")
    public void i_click_on_save_paking_button() {
        driver.findElement(moveman.btnSavePacking).click();
        
    }
    

@And("I click on Delivery final stage tab")
public void i_click_on_delivery_final_stage_tab() throws InterruptedException {
	
	try {
        // Wait for the element to be present
        Thread.sleep(2000);

        // Locate the job number element
        WebElement jobNoElement = driver.findElement(By.xpath(prop.getProperty("JobNoCopy")));

        // Copy the job number to the clipboard
        String JobNo = jobNoElement.getText();
        StringSelection stringSelection = new StringSelection(JobNo);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        System.out.println("Copied Job Number: " + JobNo);

        // File path and key for the job number
        String filePath = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\Configuration\\Locater.properties";
        String jobNumberKey = "Jobno=";
        String jobNumber = "";

        // Read the current job number from the properties file
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(jobNumberKey)) {
                    jobNumber = line.substring(jobNumberKey.length());
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!jobNumber.isEmpty()) {
            System.out.println("Old Job Number: " + jobNumber);
        } else {
            System.out.println("Job number not found in the locator file.");
        }

        // Replace the old job number with the new one
        String oldJobNumber = jobNumber;
        String newJobNumber = JobNo;
//        Jobnum=newJobNumber;
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Replace only the line with the job number key
                if (line.startsWith(jobNumberKey)) {
                    line = jobNumberKey + newJobNumber;
                }
                stringBuilder.append(line).append("\n");
            }

            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringBuilder.toString());
            writer.close();

            System.out.println("Job number replaced successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        // Clean up and quit the WebDriver
//        driver.quit();
    }


	Thread.sleep(1000);
  driver.findElement(moveman.finalStageTab).click();
  }

@And("I click on Delivey Cost button")
public void i_click_on_delivey_cost_button() {
   driver.findElement(moveman.deliveryCostBtn).click();
}


@And("I selecting destination rate component")
public void i_selecting_destination_rate_component(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String rate_component = data.get("rate_component");
	moveman.selectDropdown(moveman.destRateComponent, rate_component);
}

@And("I selecting the destination cost head")
public void i_selecting_destination_the_cost_head(io.cucumber.datatable.DataTable dataTable) {
 	data = dataTable.asMaps(String.class, String.class).get(0);
    String selectingcostHead = data.get("selectingcostHead");
	moveman.selectDropdown(moveman.destCostHead, selectingcostHead);
}

@And("I enter destination wt per unit")
public void i_enter_destination_wt_per_unit(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String per_unit = data.get("wt_per_unit");
	moveman.enterTextIntoTextBox(moveman.destUnitPer, per_unit);
}

@And("I enter the destination rate cost")
public void i_enter_the_destination_rate_cost(io.cucumber.datatable.DataTable dataTable) {
  	data = dataTable.asMaps(String.class, String.class).get(0);
    String rate = data.get("rate");
	moveman.enterTextIntoTextBox(moveman.destRateCost, rate);
}

@And("I selecting the destination rate currency")
public void i_selecting_the_destination_rate_currency(io.cucumber.datatable.DataTable dataTable) {
//	data = dataTable.asMaps(String.class, String.class).get(0);
//    String currency = data.get("currency");
//	moveman.selectDropdown(moveman.des, currency); 
}

@And("I enter the destination Revenue")
public void i_enter_the_destination_revenue(io.cucumber.datatable.DataTable dataTable) {
	data = dataTable.asMaps(String.class, String.class).get(0);
    String Revenue = data.get("Revenue");
	moveman.enterTextIntoTextBox(moveman.destRevenue, Revenue);
}

@And("I click on add button on final stage")
public void i_click_on_add_button_on_final_stage() {
    driver.findElement(moveman.destAddbtn).click();
    
    // Wait for the alert to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));  // Extended wait time
    try {
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Optionally, capture and print the alert message
        String alertMessage = alert.getText();
        System.out.println("Alert message: " + alertMessage);

        // Accept the alert (click OK)
        alert.accept();

    } catch (TimeoutException e) {
        // No alert appeared within the wait time, so just proceed
        System.out.println("No alert appeared within the wait time. Continuing the test.");
    } catch (NoAlertPresentException e) {
        // If the alert was not found at all, proceed without failure
        System.out.println("No alert present, continuing without handling alert.");
    }
}

@And("I click on save delivery button")
public void i_click_on_save_delivery_button() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Adjust timeout as needed

    // Wait until spinner disappears
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));

    // Now wait for the dropdown to be clickable
    wait.until(ExpectedConditions.elementToBeClickable(moveman.finalSavebtn));
driver.findElement(moveman.finalSavebtn).click();
}



@And("I click on send for approval button")
public void i_click_on_send_for_approval_button() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));  

    // Wait until spinner disappears
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));

    // Now wait for the dropdown to be clickable
    wait.until(ExpectedConditions.elementToBeClickable(moveman.btnSendToApprove));
	driver.findElement(moveman.btnSendToApprove).click();
}

@And("I select the approver name and click on proceed button")
public void i_select_the_approver_name_and_click_on_proceed_button(DataTable dataTable) {
	 
	data = dataTable.asMaps(String.class, String.class).get(0);
    String Approver = data.get("Approver");
	moveman.selectDropdown(moveman.finalApproveList, Approver);
	
	driver.findElement(moveman.btnSendToCSApprove).click();
}

@When("user clicks on menu")
public void user_clicks_on_menu() throws InterruptedException {
    Thread.sleep(1500);
    EnquiryPF.clickonmenu();  
    
}
@When("I click on pending button")
public void i_click_on_pending_button() throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(moveman.btnApproveDelivery).click();
}


@When("I selecting the cost heads")
public void i_selecting_the_cost_heads() throws InterruptedException {
	Thread.sleep(1000);
	try {
   	    // Check the first checkbox
	    	try {
   	    WebElement checkbox1 = driver.findElement(By.xpath(prop.getProperty("chkToBill11")));
   	    checkbox1.click();
   	    }catch(IllegalArgumentException e) {
   	    	System.out.println("select the bill 2");
   	    }
	    	try {
   	    WebElement checkbox3 = driver.findElement(By.xpath(prop.getProperty("chkToBill2")));
   	    checkbox3.click();}
	    	catch(IllegalArgumentException e)
	    	{
	    		System.out.println("Clicked not");
	    	}
   	    WebElement checkbox4 = driver.findElement(By.xpath(prop.getProperty("chkToBill3")));
   	    checkbox4.click();
   	    WebElement checkbox5 = driver.findElement(By.xpath(prop.getProperty("chkToBill4")));
   	    checkbox5.click();
   	} catch (org.openqa.selenium.NoSuchElementException e) {
   		Thread.sleep(2500);
   		System.out.println("select the bill 3");
   	}
    
}

@When("I click on the prepare bill button")
public void i_click_on_the_prepare_bill_button() throws InterruptedException {
	 Thread.sleep(700);
	  WebElement BillPrepareclick = driver.findElement(By.xpath(prop.getProperty("BillPrepare")));
		BillPrepareclick.click();
	    Thread.sleep(1000);
	    WebElement SelectBillTo = driver.findElement(By.xpath(prop.getProperty("BillTo")));
	       
	    Select dropdownFBT = new Select(SelectBillTo);
	       
	    dropdownFBT.selectByVisibleText("Client");
	   Thread.sleep(1000);

}




@When("click on the prepareBill button")
public void click_on_the_prepare_bill_button() throws InterruptedException {
//	 Thread.sleep(1000);
//	    WebElement SelectBillTo = driver.findElement(By.xpath(prop.getProperty("BillTo")));
//	       
//	    Select dropdownFBT = new Select(SelectBillTo);
//	       
//	    dropdownFBT.selectByVisibleText("Client");
//	   Thread.sleep(1000);
}



@When("select the Bill TO")
public void select_the_bill_to(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	 Thread.sleep(1000);
    WebElement SelectBillTo = driver.findElement(By.xpath(prop.getProperty("BillTo")));
       
    Select dropdownFBT = new Select(SelectBillTo);
       
    dropdownFBT.selectByVisibleText("Client");
   Thread.sleep(1500);
}

@When("click on the get tax button")
public void click_on_the_get_tax_button() throws InterruptedException {
	driver.findElement(By.xpath(prop.getProperty("BtnGetTax"))).click();
	   Thread.sleep(500);
	   
	   WebElement NoofPkgs= driver.findElement(By.xpath(prop.getProperty("NoofPkgs")));
 		NoofPkgs.clear();
 		NoofPkgs.sendKeys("2");
 		
 		WebElement VehicleNo= driver.findElement(By.xpath(prop.getProperty("VehicleNo")));
 		VehicleNo.clear();
 		VehicleNo.sendKeys("MH14JN0011");
 		
 		  WebElement SaveInvoice= driver.findElement(By.xpath(prop.getProperty("SaveInvoice")));
 		 JavascriptExecutor SaveInvoiceClick = (JavascriptExecutor)driver;
 		SaveInvoiceClick.executeScript("arguments[0].click()", SaveInvoice);

}

@When("click on the sent to finance button")
public void click_on_the_sent_to_finance_button() throws InterruptedException {
	Thread.sleep(1000);
		WebElement BtnSendtoFinance= driver.findElement(By.xpath(prop.getProperty("BtnSendtoFinance")));
		 JavascriptExecutor sendfinanace = (JavascriptExecutor)driver;
		sendfinanace.executeScript("arguments[0].click()", BtnSendtoFinance);
		
		Thread.sleep(500);
 		WebElement submitbtn1= driver.findElement(By.xpath(prop.getProperty("submit")));
 		JavascriptExecutor submitbtn1click = (JavascriptExecutor)driver;
 		submitbtn1click.executeScript("arguments[0].click()", submitbtn1);
 		
 		
		Thread.sleep(1000);
//		 driver.navigate().back();
		
}
@When("click on approve button")
public void click_on_approve_button() throws InterruptedException {
    

	Thread.sleep(1000);
		WebElement BtnApproved = driver.findElement(By.xpath(prop.getProperty("BtnApproved")));
		JavascriptExecutor BtnApprovedClick = (JavascriptExecutor)driver;
		BtnApprovedClick.executeScript("arguments[0].click()", BtnApproved);
		
}

@When("cheking and accepting SAP Cost alert")
public void cheking_and_accepting_sap_cost_alert() throws InterruptedException {
    
    // Wait for the alert to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));  // Extended wait time
    try {
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Optionally, capture and print the alert message
        String alertMessage = alert.getText();
        System.out.println("Alert message: " + alertMessage);

        // Accept the alert (click OK)
        alert.accept();

    } catch (TimeoutException e) {
        // No alert appeared within the wait time, so just proceed
        System.out.println("No alert appeared within the wait time. Continuing the test.");
    } catch (NoAlertPresentException e) {
        // If the alert was not found at all, proceed without failure
        System.out.println("No alert present, continuing without handling alert.");
    }
}

@When("entering a SAP Cost")
public void entering_a_sap_cost() throws InterruptedException {
	Thread.sleep(500);
	driver.findElement(By.id("SunCost")).clear();
	Thread.sleep(500);
	driver.findElement(By.id("SunCost")).sendKeys("10");
	
}

@When("click on Final Approve button")
public void click_on_final_approve_button() throws InterruptedException {
	Thread.sleep(1000);
	WebElement BtnFinalApprove = driver.findElement(By.id("BtnFinalApprove"));
	JavascriptExecutor BtnFinalApproveClick = (JavascriptExecutor)driver;
	BtnFinalApproveClick.executeScript("arguments[0].click()", BtnFinalApprove);
	
}



@When("user click on billing menu")
public void user_click_on_billing_menu() throws InterruptedException {
    Thread.sleep(500);
    WebElement Menu= driver.findElement(By.xpath(prop.getProperty("Menu")));
	      
	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click()", Menu);
		 Thread.sleep(1000);
		 WebElement Bill1= driver.findElement(By.xpath(prop.getProperty("BillingMenu")));

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", Bill1);
			Thread.sleep(1000);
    
}

@When("user click on billing")
public void user_click_on_billing() {
	WebElement Billing2= driver.findElement(By.xpath(prop.getProperty("BillingPage")));
    
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].click()", Billing2);
    
}

@When("user selecting the job no")
public void user_selecting_the_job_no() throws InterruptedException {

	Thread.sleep(3000);
	WebElement selectJobno=driver.findElement(By.xpath(prop.getProperty("selectJobno")));

	selectJobno.click();
	
	WebElement Jobserach=driver.findElement(By.xpath(prop.getProperty("Jobserach")));
	Jobserach.sendKeys("j");
	Jobserach.sendKeys(Keys.ENTER);
	
    
}

//@When("enter the job number")
//public void enter_the_job_number() {
//	
//    
//	driver.findElement(By.xpath(prop.getProperty("SearchJobNo"))).sendKeys(Jobnum);
//}


@When("enter the job number")
public void enter_the_job_number() {
    // Use the Jobnum variable to enter the job number into the search field
	
//    driver.findElement(By.xpath(prop.getProperty("SearchJobNo"))).sendKeys(Jobnum);
//
//    System.out.println("Entered Job Number: " + Jobnum);
    

	String locatorFilePath = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\Configuration\\Locater.properties";
    String jobNumberKey = "Jobno=";

    // Retrieve the job number from the locator file
    String jobNumber = getJobNumber(locatorFilePath, jobNumberKey);

    if (!jobNumber.isEmpty()) {
        // Use the Jobnum variable to enter the job number into the search field
        driver.findElement(By.xpath(prop.getProperty("SearchJobNo"))).sendKeys(jobNumber);
        System.out.println("Entered Job Number: " + jobNumber);
    } else {
        System.out.println("Job number not found in the locator file.");
    }
    
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
	
	WebElement JobSearchbtnclk= driver.findElement(By.xpath(prop.getProperty("JobSearchbtn")));
    
	JavascriptExecutor jobclk = (JavascriptExecutor)driver;
	jobclk.executeScript("arguments[0].click()", JobSearchbtnclk);
}

@When("click on modify button")
public void click_on_modify_button() throws InterruptedException {
	Thread.sleep(1000);
	WebElement BillActionBtn= driver.findElement(By.xpath(prop.getProperty("BillActionBtn")));
    
	JavascriptExecutor Billaction = (JavascriptExecutor)driver;
	Billaction.executeScript("arguments[0].click()", BillActionBtn);
}




//Utility method to read the job number from the locator file
private String getJobNumber(String filePath, String jobNumberKey) {
 String jobNumber = "";

 try {
     File file = new File(filePath);
     BufferedReader reader = new BufferedReader(new FileReader(file));
     String line;

     while ((line = reader.readLine()) != null) {
         if (line.startsWith(jobNumberKey)) {
             jobNumber = line.substring(jobNumberKey.length());
             break;
         }
     }

     reader.close();
 } catch (IOException e) {
     e.printStackTrace();
 }

 return jobNumber;
}
}
