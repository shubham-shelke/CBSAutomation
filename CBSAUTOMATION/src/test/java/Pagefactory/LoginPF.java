package Pagefactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import Pagefactory.PricingPF;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPF {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;
    private WebDriverWait wait;
    // Define locators
    private By txt_username,txt_password,captcha,txt_captcha,btn_login,selectcompany,bussiness_Line,submitbtn;

    // Constructor to load properties and initialize locators
   
    private PricingPF pricingPage;

    // Constructor for LoginPF where you instantiate PricingPF
  
    public LoginPF(WebDriver driver) throws IOException {
        this.driver = driver;
        pricingPage = new PricingPF(driver); 
        // Load the properties file
        fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        // Initialize locators using properties
        txt_username = By.xpath(prop.getProperty("username"));
        txt_password = By.xpath(prop.getProperty("Password"));
        captcha = By.xpath(prop.getProperty("Captcha"));
        txt_captcha = By.xpath(prop.getProperty("Captcha_testfield"));
        btn_login = By.xpath(prop.getProperty("Login_button"));
        selectcompany= By.xpath(prop.getProperty("Relo_india"));
        bussiness_Line=By.xpath(prop.getProperty("NON_RMC-BUSINESS"));
        submitbtn= By.xpath(prop.getProperty("submit_button"));
    }

    public void enterUsername(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void enterCaptcha() throws InterruptedException, IOException, TesseractException {
        Thread.sleep(500);
        try {
            WebElement imagepath = driver.findElement(captcha);
            File src = imagepath.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "\\Screenshot\\captcha.png";
            FileHandler.copy(src, new File(path));

            Thread.sleep(500);

            ITesseract image = new Tesseract();
            String imageText = image.doOCR(new File(path));
            System.out.print(imageText);

            driver.findElement(txt_captcha).sendKeys(imageText);
            Thread.sleep(1000); 

        } catch (UnhandledAlertException e) {
            System.out.println("Invalid captcha Entered");
        }
    }

    public void clickLogin() throws InterruptedException {
        driver.findElement(btn_login).click();
        Thread.sleep(1000);
    }
    
    public void selectcompany(String company)
    {
    	pricingPage.selectDropdown(selectcompany, company);
    }
    public void selectBusiness(String business)
    {
    	pricingPage.selectDropdown(bussiness_Line, business);
    }
    
    public void clickOnSubmit()
    {
    	driver.findElement(submitbtn).click();
    }
    
    
    
}
