package Pagefactory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {

    public static WebDriver driver=LoginPF.driver;
    public static Properties prop = new Properties();
      
    // Common method to select from dropdown
    public void selectDropdown(By dropdownLocator, String dropdownValue) {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(dropdownValue);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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


}
