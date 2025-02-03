package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import Pagefactory.LoginPF;
import Pagefactory.PricingPF;

public class PricingStepDefinition {

    private WebDriver driver;
    private PricingPF pricingPage;
    private Properties prop;
   

    private PricingPF getPricingPage() throws IOException {
        if (pricingPage == null) {
            pricingPage = new PricingPF(driver);  // Initialize PricingPF only when needed
        }
        return pricingPage;
    }

    @Given("I am on the Pricing page")
    public void i_am_on_the_pricing_page() throws IOException {
        // Load the properties file
        prop = new Properties();
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        driver = LoginPF.driver;  // Assuming you already have a Login class managing WebDriver
        driver.manage().window().maximize();

        // Initialize the Pricing page object
        pricingPage = new PricingPF(driver);
    }

    @When("I click on the Menu")
    public void i_click_on_the_menu() throws InterruptedException {
        pricingPage.clickMenu();
        pricingPage.clickSurvey();
    }

    @And("I click on the Pricing Button")
    public void i_click_on_the_pricing_button() throws InterruptedException {
    	Thread.sleep(1000);
        pricingPage.clickPricingButton();
    }

    @And("I search the enquiry number")
    public void i_search_the_enquiry_number() throws InterruptedException {
        pricingPage.searchEnquiryNumber(prop.getProperty("EnqNumber"));
    }

    @And("I click on Apply Estimate button")
    public void i_click_on_apply_estimate_button() throws InterruptedException {
        pricingPage.applyEstimation();
    }

    @And("I select rate component")
    public void i_select_rate_component() {
        pricingPage.selectDropdown(pricingPage.getRateComponentLocator(), "Origin");
    }

    @And("I select agent")
    public void i_select_agent() {
//        pricingPage.selectDropdown(pricingPage.getAgentLocator(), "AgentOption");
    }
  /*  @And("I select the cost head")
    public void i_select_the_cost_head(String costHead) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        wait.until(ExpectedConditions.elementToBeClickable(pricingPage.getCostHeadLocator()));
        pricingPage.selectCostHead(costHead);
    }

    @And("I enter the cost head amount")
    public void i_enter_the_cost_head_amount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        pricingPage.enterCostHeadAmount(amount);
    }


    @And("I select the cost head")
    public void i_select_the_cost_head() throws InterruptedException {
        // Use Duration to define timeout for WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Adjust timeout as needed

        // Wait until spinner disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));

        // Now wait for the dropdown to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(pricingPage.getCostHeadLocator()));

        // Select the cost head
        pricingPage.selectCostHead("ADDITIONAL PROTECTIVE PACKING");
    }
    @And("I enter the cost head amount")
    public void i_enter_the_cost_head_amount() throws InterruptedException {
    	Thread.sleep(1000);
        pricingPage.enterCostHeadAmount("5000");  // Example value
    }
*/
    
    @And("I select the cost head")
    public void i_select_the_cost_head(DataTable dataTable) throws InterruptedException {
        // Convert DataTable to a Map
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        // Extract value
        String costHead = data.get("costHead");

        // Use WebDriverWait to handle the spinner and clickable elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        wait.until(ExpectedConditions.elementToBeClickable(pricingPage.getCostHeadLocator()));

        // Select the cost head
        pricingPage.selectCostHead(costHead);
    }

    @And("I enter the cost head amount")
    public void i_enter_the_cost_head_amount(DataTable dataTable) throws InterruptedException {
        // Convert DataTable to a Map
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        // Extract value
        String amount = data.get("amount");

        // Enter the cost head amount
        Thread.sleep(1000);
        pricingPage.enterCostHeadAmount(amount);
    }
    @And("I click on the Add button")
    public void i_click_on_the_add_button() {
        pricingPage.clickAddButton();
    }


@And("I select freight rate component")
public void i_select_freight_rate_component() {
	 pricingPage.selectDropdown(pricingPage.getRateComponentLocator(), "Freight");
}
    

@When("I select Destination rate component")
public void i_select_destination_rate_component() {
	pricingPage.selectDropdown(pricingPage.getRateComponentLocator(), "Destination");
}  
    
    
    
    @And("I click on save rates button")
    public void i_click_on_save_rates_button() {
        pricingPage.clickSaveRatesButton();
    }
    
   
    @And("I clicks on apply quotation button")
    public void i_clicks_on_apply_quotation_button() throws InterruptedException {
    	Thread.sleep(1000);
        pricingPage.clickApplyQuotationButton();
    }

    @And("I enter the GP percentage in GP text box")
    public void i_enter_the_gp_percentage_in_gp_text_box(DataTable dataTable) {
        // Convert DataTable to a Map
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String percentage = data.get("percentage");
        pricingPage.enterGPPercentage(percentage);
    }

    @And("I click on the Apply to All button")
    public void i_click_on_the_apply_to_all_button() throws InterruptedException {
    	Thread.sleep(2000);
        pricingPage.clickApplyToAllButton();
    }

    @And("I click on save button")
    public void i_click_on_save_button() {
        pricingPage.clickSaveButton();
    }

    @And("I click on the send for Approval button")
    public void i_click_on_send_for_approval_button() throws InterruptedException {
    	Thread.sleep(1500);
        pricingPage.clickSendForApprovalButton();
    }

    @And("I select the approver")
    public void i_select_the_approver(DataTable dataTable) throws InterruptedException {
        // Convert DataTable to a Map
    	Thread.sleep(1000);
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String approver = data.get("Approver_List");
        pricingPage.selectApprover(approver);
    }

    @And("I click on proceed for approval button")
    public void i_click_on_proceed_for_approval_button() {
        pricingPage.clickProceedForApprovalButton();
    }
    
    @And("I click on the approval pending button")
    public void i_click_on_the_approval_pending_button() throws InterruptedException {
    	Thread.sleep(1500);
        pricingPage.clickOnPendingApproval();
    }
    @And("I click on Book button")
    public void i_click_on_book_button() { 	
    	pricingPage.clickOnBookButton();
    }

    @And("I click on the billing and collection button")
    public void i_click_on_the_billing_and_collection_button() throws InterruptedException, IOException {
    	Thread.sleep(1000);
//    	pricingPage.clickOnBACbutton();
    	getPricingPage().clickOnBACbutton();
    }
    
    @And("I select the Bill To on billing and collection page")
    public void i_select_the_bill_to_on_billing_and_collection_page(DataTable dataTable) throws InterruptedException {
    	Thread.sleep(1000);
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String BillTo = data.get("BillTo");
        pricingPage.selectBillTo(BillTo);
    }

    @And("I select the Payment type in details tab")
    public void i_select_the_payment_type_in_details_tab(DataTable dataTable) throws InterruptedException {
    	Thread.sleep(1000);
    	
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        String Payment = data.get("Payment");
        pricingPage.selectPaymentType(Payment);
    }
    

    @And("I click and verify the save button")
    public void i_click_and_verify_the_save_button() {
    	pricingPage.saveBAC();
    }
}
