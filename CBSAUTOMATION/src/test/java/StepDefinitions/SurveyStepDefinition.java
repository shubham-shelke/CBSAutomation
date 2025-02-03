package StepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pagefactory.EnquiryPF;
import Pagefactory.LoginPF;
import Pagefactory.PricingPF;
import pages.SurveyPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SurveyStepDefinition {
    public static WebDriver driver = LoginPF.driver; // Reuse the driver 
    public static Properties prop = new Properties();
    private WebDriverWait wait;
    private SurveyPOM surveyPOM;



    public SurveyStepDefinition() {
        try {
            // Load properties file
            if (prop.isEmpty()) {
                FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
                prop.load(fr);
            }
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            surveyPOM = new SurveyPOM(driver, prop, wait);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties or initialize SurveyPOM", e);
        }
    }

    @When("user clicks on the survey button")
    public void user_clicks_on_the_survey_button() throws InterruptedException {
    	Thread.sleep(1000);
        surveyPOM.clickOnMenu();
        surveyPOM.clickOnSurveyButton();
    }

    @And("user is navigated to the survey page")
    public void user_is_navigated_to_the_survey_page() {
        surveyPOM.navigateToSurveyPage();
    }

    @And("user searches for an enquiry number")
    public void user_searches_for_an_enquiry_number() throws InterruptedException {
        surveyPOM.searchForEnquiryNumber(prop.getProperty("EnqNumber"));
    }

    @And("user clicks on the edit survey button")
    public void user_clicks_on_the_edit_survey_button() throws InterruptedException {
    	Thread.sleep(4000);
        surveyPOM.clickOnEditSurveyButton();
    }

    @And("user clicks on the detail tab")
    public void user_clicks_on_the_detail_tab() {
        surveyPOM.clickOnDetailTab();
    }

    @When("user selects the Sch. Pack Date as {string}")
    public void user_selects_the_sch_pack_date(String date) {
        surveyPOM.selectSchPackDate(date);
    }

    @When("user enters the number of days as {string}")
    public void user_enters_the_number_of_days(String days) {
        surveyPOM.enterNoOfDays(days);
    }
    
    @When("user selects the Sch. Load Date as {string}")
    public void user_selects_the_sch_load_date(String date) {
        surveyPOM.selectSchLoadDate(date);
    }

    @When("user selects the Sch. Sub. Quote Date as {string}")
    public void user_selects_the_sch_sub_quote_date(String date) {
        surveyPOM.selectSchSubQuoteDate(date);
    }

    @When("user selects the Req. Delivery Date as {string}")
    public void user_selects_the_req_delivery_date(String date) {
        surveyPOM.selectReqDeliveryDate(date);
    }

    @When("user selects the insurance provider as {string}")
    public void user_selects_the_insurance_provider(String provider) {
        surveyPOM.selectInsuranceProvider(provider);
    }

    @When("user enters the Ins. Approx. Value as {string}")
    public void user_enters_the_ins_approx_value(String value) {
        surveyPOM.enterInsApproxValue(value);
    }

    @When("user selects the Ins. Currency as {string}")
    public void user_selects_the_ins_currency(String currency) {
        surveyPOM.selectInsCurrency(currency);
    }

    @When("I fill the origin shipment details")
    public void i_fill_the_origin_shipment_details() throws InterruptedException {
        surveyPOM.fillOriginShipmentDetails();
    }

    @When("I fill the destination shipment details")
    public void i_fill_the_destination_shipment_details() throws InterruptedException {
        surveyPOM.fillDestinationShipmentDetails();
    }
   
    @Then("I save the shipment details")
    public void saveShipmentDetails() throws InterruptedException {
        surveyPOM.saveShipmentDetails();
    }
    }


