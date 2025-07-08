// package StepDefinitions;

// import static org.testng.Assert.assertEquals;

// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Map;
// import java.util.NoSuchElementException;
// import java.util.Properties;

// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.UnhandledAlertException;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.io.FileHandler;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import Pagefactory.LoginPF;
// import Pagefactory.PricingPF;
// import io.cucumber.datatable.DataTable;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import net.sourceforge.tess4j.ITesseract;
// import net.sourceforge.tess4j.Tesseract;
// import net.sourceforge.tess4j.TesseractException;

// public class LoginStepDefinition {

//     public static WebDriver driver;
//     LoginPF loginpage;
//     public static Properties prop = new Properties();
//     public static FileReader fr;
//     private WebDriverWait wait;
//     private PricingPF pricingPage;


//     @Before
//     public void setUp() throws IOException {
//         if (driver == null) {
//             fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
//             prop.load(fr);
//             driver = new EdgeDriver();
//             driver.manage().window().maximize();

//         }
//     }


// @Given("Browser is open")
// public void browser_is_open() {
// System.out.println("Browser is open");
// //driver.get(prop.getProperty("website"));
// }

// @And("User is on login page")
// public void user_is_on_login_page() {

// driver.get(prop.getProperty("website"));
// }

// @When("^user enter (.*) and (.*) and clicks on login$")
// public void user_enter_username_and_password(String username, String password) throws InterruptedException, IOException, TesseractException {

//     loginpage = new LoginPF(driver);
//     int maxAttempts = 5;  // Set the maximum number of login attempts
//     int attempt = 0;
//     boolean loginSuccessful = false;

//     while (attempt < maxAttempts && !loginSuccessful) {
//         attempt++;
//         driver.navigate().refresh();
//         System.out.println("Login attempt: " + attempt);

//         loginpage.enterUsername(username);
//         loginpage.enterPassword(password);

//         Thread.sleep(500);

//         try {
//             WebElement imagepath = driver.findElement(By.xpath(prop.getProperty("Captcha")));
//             File src = imagepath.getScreenshotAs(OutputType.FILE);

//             String path = System.getProperty("user.dir") + "\\Screenshot\\captcha.png";
//             FileHandler.copy(src, new File(path));

//             Thread.sleep(500);

//             ITesseract image = new Tesseract();
//             String Imagetext = image.doOCR(new File(path));
//             System.out.println("Captcha recognized: " + Imagetext);

//             // Retry if captcha recognition fails
//             if (Imagetext.isBlank() || Imagetext.length() < 4) {
//                 System.out.println("Captcha not recognized properly, retrying...");
//                 continue;
//             }

//             driver.findElement(By.xpath(prop.getProperty("Captcha_testfield"))).sendKeys(Imagetext);
//             Thread.sleep(1000);
//             driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
//             Thread.sleep(1000);

//             // Check if the dropdown is present to confirm successful login
//             try {
//                 WebElement selecter = driver.findElement(By.xpath(prop.getProperty("Relo_india")));
//                 Select dropdown = new Select(selecter);
//                 dropdown.selectByVisibleText("Relo-India");
//                 loginSuccessful = true;  // Login successful when dropdown is found and selected
//                 System.out.println("Login successful on attempt: " + attempt);
//             } catch (NoSuchElementException e) {
//                 System.out.println("Dropdown 'Relo-India' not found, retrying login...");
//                 // Optionally refresh or logout before retrying
//                 driver.navigate().refresh();  // Refresh page to retry login
//                 continue;  // Retry login
//             }

//         } catch (UnhandledAlertException e) {
//             System.out.println("Invalid captcha entered, retrying...");
//         } catch (IOException e) {
//             System.out.println("Error in captcha recognition process, retrying...");
//         }

//         if (!loginSuccessful && attempt >= maxAttempts) {
//             System.out.println("Login failed after maximum attempts.");
//             throw new RuntimeException("Failed to login after " + maxAttempts + " attempts");
//         }
//     }
// }

// @When("select the company and business_line")
// public void select_the_company_and_business_line(DataTable dataTable) throws InterruptedException {
// 	Thread.sleep(1000);
//     Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//     String company = data.get("company");
// 	loginpage.selectcompany(company);
// //	Thread.sleep(1000);
//     Map<String, String> data1 = dataTable.asMaps(String.class, String.class).get(0);
//     String Business = data1.get("business_line");
// 	loginpage.selectBusiness(Business);
// //   driver.findElement(By.xpath(prop.getProperty("submit_button"))).click();

// }

// @Given("I click on submit button")
// public void i_click_on_submit_button() {
//     loginpage.clickOnSubmit();
// }
// @Then("user navigated to the home page")
// public void user_navigated_to_the_home_page() throws InterruptedException {
// 	String actualTitle = driver.getTitle();
// 	System.out.println(actualTitle);
// 	Thread.sleep(1000);
// 	String expectedTitle = "[Relo Writer] Dashboard";
// 	assertEquals(expectedTitle,actualTitle);

// }

// }











// package StepDefinitions;

// import static org.testng.Assert.assertEquals;

// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Map;
// import java.util.NoSuchElementException;
// import java.util.Properties;

// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.UnhandledAlertException;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.edge.EdgeOptions;
// import org.openqa.selenium.io.FileHandler;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import Pagefactory.LoginPF;
// import Pagefactory.PricingPF;

// import io.cucumber.datatable.DataTable;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;

// import io.github.bonigarcia.wdm.WebDriverManager;  // Auto‑manages EdgeDriver binary

// import net.sourceforge.tess4j.ITesseract;
// import net.sourceforge.tess4j.Tesseract;
// import net.sourceforge.tess4j.TesseractException;

// public class LoginStepDefinition {

//     public static WebDriver driver;
//     LoginPF loginpage;
//     public static Properties prop = new Properties();
//     public static FileReader fr;
//     private WebDriverWait wait;
//     private PricingPF pricingPage;

//     // ------------------------------------------------------------------
//     //  Initialise WebDriver once per test‑run – headless Edge for CI
//     // ------------------------------------------------------------------
//     @Before
//     public void setUp() throws IOException {
//         if (driver == null) {
//             // Load locator properties
//             fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
//             prop.load(fr);

//             // Ensure correct msedgedriver.exe is present
//             WebDriverManager.edgedriver().setup();

//             // Build EdgeOptions for Jenkins/non‑GUI
//             EdgeOptions options = new EdgeOptions();
//             options.addArguments("--headless");            // headless mode (Edge 109+)
//             options.addArguments("--disable-gpu");
//             options.addArguments("--window-size=1920,1080");

// // ChromeOptions options = new ChromeOptions();
// // options.addArguments("--headless=new");
// // options.addArguments("--disable-gpu");
// // options.addArguments("--window-size=1920,1080");
// // WebDriver driver = new ChromeDriver(options);



            
//             // Dynamically choose the Edge binary that exists
//             Path edge64 = Paths.get("C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe");
//             Path edge32 = Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//             if (Files.exists(edge64)) {
//                 options.setBinary(edge64.toString());
//             } else if (Files.exists(edge32)) {
//                 options.setBinary(edge32.toString());
//             } else {
//                 throw new IllegalStateException("Microsoft Edge is not installed on this machine – please install it or update the path in LoginStepDefinition");
//             }

//             driver = new EdgeDriver(options);
//             driver.manage().window().maximize();
//         }
//     }

//     // ------------------------------------------------------------------
//     //  Step definitions
//     // ------------------------------------------------------------------
//     @Given("Browser is open")
//     public void browser_is_open() {
//         System.out.println("Browser is open");
//     }

//     @And("User is on login page")
//     public void user_is_on_login_page() {
//         driver.get(prop.getProperty("website"));
//     }

//     @When("^user enter (.*) and (.*) and clicks on login$")
//     public void user_enter_username_and_password(String username, String password) throws InterruptedException, IOException, TesseractException {

//         loginpage = new LoginPF(driver);
//         int maxAttempts = 5;  // retry on captcha failure
//         int attempt = 0;
//         boolean loginSuccessful = false;

//         while (attempt < maxAttempts && !loginSuccessful) {
//             attempt++;
//             driver.navigate().refresh();
//             System.out.println("Login attempt: " + attempt);

//             loginpage.enterUsername(username);
//             loginpage.enterPassword(password);
//             Thread.sleep(500);

//             try {
//                 // ------------------ Captcha processing ------------------
//                 WebElement image = driver.findElement(By.xpath(prop.getProperty("Captcha")));
//                 File src = image.getScreenshotAs(OutputType.FILE);
//                 String path = System.getProperty("user.dir") + "\\Screenshot\\captcha.png";
//                 // String path = "D:\CaptchaPath";
//                 FileHandler.copy(src, new File(path));

//                 ITesseract tesseract = new Tesseract();
//                 String text = tesseract.doOCR(new File(path));
//                 System.out.println("Captcha recognized: " + text);

//                 if (text.isBlank() || text.trim().length() < 4) {
//                     System.out.println("Captcha not recognized, retrying...");
//                     continue;
//                 }

//                 driver.findElement(By.xpath(prop.getProperty("Captcha_testfield"))).sendKeys(text.trim());
//                 Thread.sleep(1000);
//                 driver.findElement(By.xpath(prop.getProperty("Login_button"))).click();
//                 Thread.sleep(1000);

//                 // ------------------ Validate login ------------------
//                 try {
//                     WebElement selecter = driver.findElement(By.xpath(prop.getProperty("Relo_india")));
//                     new Select(selecter).selectByVisibleText("Relo-India");
//                     loginSuccessful = true;
//                     System.out.println("Login successful on attempt " + attempt);
//                 } catch (NoSuchElementException e) {
//                     System.out.println("Dropdown not found – retrying...");
//                     continue;
//                 }

//             } catch (UnhandledAlertException e) {
//                 System.out.println("Alert appeared (likely bad captcha) – retrying...");
//             }
//         }

//         if (!loginSuccessful) {
//             throw new RuntimeException("Login failed after " + maxAttempts + " attempts");
//         }
//     }

//     @When("select the company and business_line")
//     public void select_the_company_and_business_line(DataTable dataTable) throws InterruptedException {
//         Thread.sleep(1000);
//         Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//         loginpage.selectcompany(data.get("company"));
//         loginpage.selectBusiness(data.get("business_line"));
//     }

//     @Given("I click on submit button")
//     public void i_click_on_submit_button() {
//         loginpage.clickOnSubmit();
//     }

//     @Then("user navigated to the home page")
//     public void user_navigated_to_the_home_page() throws InterruptedException {
//         String actualTitle = driver.getTitle();
//         System.out.println(actualTitle);
//         Thread.sleep(1000);
//         assertEquals("[Relo Writer] Dashboard", actualTitle);
//     }
// }




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
            driver = new EdgeDriver();
            driver.manage().window().maximize();
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
    public void user_enter_username_and_password(String username, String password)
            throws InterruptedException, IOException, TesseractException {

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

                // Use Jenkins-safe path (target folder)
                String path = System.getProperty("user.dir") + "\\target\\captcha.png";
                FileHandler.copy(src, new File(path));
                System.out.println("Captcha image saved to: " + path);

                Thread.sleep(500);

                String Imagetext = "";

                // Optional: Skip OCR via Maven property in Jenkins
                boolean skipOCR = Boolean.parseBoolean(System.getProperty("skip.ocr", "false"));
                if (skipOCR) {
                    System.out.println("⚠️ Skipping OCR in Jenkins run");
                    Imagetext = "dummyCaptcha";
                } else {
                    File imageFile = new File(path);
                    if (!imageFile.exists()) {
                        System.out.println("❌ Captcha image not found at: " + path);
                        continue;
                    }

                    ITesseract image = new Tesseract();
                    image.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Update if needed
                    image.setLanguage("eng");

                    try {
                        Imagetext = image.doOCR(imageFile).trim();
                        System.out.println("Captcha recognized: " + Imagetext);
                    } catch (TesseractException | Error e) {
                        System.out.println("❌ OCR failed: " + e.getMessage());
                        continue;
                    }
                }

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
                    System.out.println("✅ Login successful on attempt: " + attempt);
                } catch (NoSuchElementException e) {
                    System.out.println("❌ Dropdown 'Relo-India' not found, retrying login...");
                    driver.navigate().refresh();
                }

            } catch (UnhandledAlertException e) {
                System.out.println("⚠️ Unhandled alert - possibly invalid captcha, retrying...");
            } catch (IOException e) {
                System.out.println("⚠️ Error during captcha screenshot saving.");
            }

            if (!loginSuccessful && attempt >= maxAttempts) {
                System.out.println("❌ Login failed after maximum attempts.");
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
