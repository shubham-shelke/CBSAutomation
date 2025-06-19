package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
    @Before
public void setUp() throws IOException {
    if (driver == null) {
        fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        // Configure EdgeOptions for headless mode
        EdgeOptions options = new EdgeOptions();
        options.setCapability("ms:edgeOptions", options);
        options.addArguments("--headless=new"); // fallback to "--headless" if still crashing
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        // Set binary path explicitly if needed
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

        driver = new EdgeDriver(options);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));
    }
}


    @Given("Browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");
    }

    @And("User is on login page")
    public void user_is_on_login_page() {
        driver.get(prop.getProperty("website"));
    }

    @When("^user enter (.*) and (.*) and clicks on login$")
    public void user_enter_username_and_password(String username, String password) throws InterruptedException, IOException, TesseractException {

        loginpage = new LoginPF(driver);
        int maxAttempts = 5;
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
                String Imagetext = image.doOCR(new File(path)).trim();
                System.out.println("Captcha recognized: " + Imagetext);

                if (Imagetext.isBlank() || Imagetext.length() < 4) {
                    System.out.println("Captcha not recognized properly, retrying...");
                    continue;
                }

                driver.findElement(By.xpath(prop.getProperty("Captcha_testfield"))).sendKeys(Imagetext);
                Thread.sleep(1000);
                driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
                Thread.sleep(1000);

                try {
                    WebElement selecter = driver.findElement(By.xpath(prop.getProperty("Relo_india")));
                    Select dropdown = new Select(selecter);
                    dropdown.selectByVisibleText("Relo-India");
                    loginSuccessful = true;
                    System.out.println("Login successful on attempt: " + attempt);
                } catch (NoSuchElementException e) {
                    System.out.println("Dropdown 'Relo-India' not found, retrying login...");
                    driver.navigate().refresh();
                }

            } catch (UnhandledAlertException e) {
                System.out.println("Invalid captcha entered, retrying...");
            } catch (IOException e) {
                System.out.println("Error in captcha recognition process, retrying...");
            }

            if (!loginSuccessful && attempt >= maxAttempts) {
                throw new RuntimeException("Failed to login after " + maxAttempts + " attempts");
            }
        }
    }

    @When("select the company and business_line")
    public void select_the_company_and_business_line(DataTable dataTable) throws InterruptedException {
        Thread.sleep(1000);
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        loginpage.selectcompany(data.get("company"));
        loginpage.selectBusiness(data.get("business_line"));
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
        assertEquals(expectedTitle, actualTitle);
    }
}
