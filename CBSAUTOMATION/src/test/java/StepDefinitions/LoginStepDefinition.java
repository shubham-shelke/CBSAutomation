package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import Pagefactory.LoginPF;
import Pagefactory.PricingPF;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginStepDefinition {

    public static WebDriver driver;
    LoginPF loginpage;
    public static Properties prop = new Properties();
    public static FileReader fr;
    private WebDriverWait wait;
    private PricingPF pricingPage;
    
    
    @Before
    public void setUp() throws IOException {
        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
            prop.load(fr);
           
EdgeOptions options = new EdgeOptions();
options.addArguments("--headless");
options.addArguments("--disable-gpu");
options.addArguments("--no-sandbox");
options.addArguments("--remote-allow-origins=*");
driver = new EdgeDriver(options);

            driver.manage().window().maximize();
            
        }
    }
    

@Given("Browser is open")
public void browser_is_open() {
System.out.println("Browser is open");
//driver.get(prop.getProperty("website"));
}

@And("User is on login page")
public void user_is_on_login_page() {

driver.get(prop.getProperty("website"));
}

@When("^user enter (.*) and (.*) and clicks on login$")
public void user_enter_username_and_password(String username, String password) throws InterruptedException, IOException, TesseractException {

    loginpage = new LoginPF(driver);
    int maxAttempts = 5;  // Set the maximum number of login attempts
    int attempt = 0;
    boolean loginSuccessful = false;

    while (attempt < maxAttempts && !loginSuccessful) {
        attempt++;
        driver.navigate().refresh();
        System.out.println("Login attempt: " + attempt);

        loginpage.enterUsername(username);
        loginpage.enterPassword(password);

        Thread.sleep(500);

        try {
            WebElement imagepath = driver.findElement(By.xpath(prop.getProperty("Captcha")));
            File src = imagepath.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "\\Screenshot\\captcha.png";
            FileHandler.copy(src, new File(path));

            Thread.sleep(500);

            ITesseract image = new Tesseract();
            String Imagetext = image.doOCR(new File(path));
            System.out.println("Captcha recognized: " + Imagetext);

            // Retry if captcha recognition fails
            if (Imagetext.isBlank() || Imagetext.length() < 4) {
                System.out.println("Captcha not recognized properly, retrying...");
                continue;
            }

            driver.findElement(By.xpath(prop.getProperty("Captcha_testfield"))).sendKeys(Imagetext);
            Thread.sleep(1000);
            driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
            Thread.sleep(1000);

            // Check if the dropdown is present to confirm successful login
            try {
                WebElement selecter = driver.findElement(By.xpath(prop.getProperty("Relo_india")));
                Select dropdown = new Select(selecter);
                dropdown.selectByVisibleText("Relo-India");
                loginSuccessful = true;  // Login successful when dropdown is found and selected
                System.out.println("Login successful on attempt: " + attempt);
            } catch (NoSuchElementException e) {
                System.out.println("Dropdown 'Relo-India' not found, retrying login...");
                // Optionally refresh or logout before retrying
                driver.navigate().refresh();  // Refresh page to retry login
                continue;  // Retry login
            }

        } catch (UnhandledAlertException e) {
            System.out.println("Invalid captcha entered, retrying...");
        } catch (IOException e) {
            System.out.println("Error in captcha recognition process, retrying...");
        }

        if (!loginSuccessful && attempt >= maxAttempts) {
            System.out.println("Login failed after maximum attempts.");
            throw new RuntimeException("Failed to login after " + maxAttempts + " attempts");
        }
    }
}

@When("select the company and business_line")
public void select_the_company_and_business_line(DataTable dataTable) throws InterruptedException {
	Thread.sleep(1000);
    Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
    String company = data.get("company");
	loginpage.selectcompany(company);
//	Thread.sleep(1000);
    Map<String, String> data1 = dataTable.asMaps(String.class, String.class).get(0);
    String Business = data1.get("business_line");
	loginpage.selectBusiness(Business);
//   driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();

}

@Given("I click on submit button")
public void i_click_on_submit_button() {
    loginpage.clickOnSubmit();
}
@Then("user navigated to the home page")
public void user_navigated_to_the_home_page() throws InterruptedException {
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);
	Thread.sleep(1000);
	String expectedTitle = "[Relo Writer] Dashboard";
	assertEquals(expectedTitle,actualTitle);
    
}

}
