package Pagefactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveManPF {

    private WebDriver driver;
    private Properties prop = new Properties();
    public By moveman, open_Job, openJobbtn, dropDownSelectJob, openJobTextBox, Enq_search,searchbutton,nationality,jobNumber,openJobBtn;
	private By jobOpeningTab;
	public By orgWarehouse,destWarehouse,origindestSearchBox,Cheque_No,Cheque_Amt,hOSD,hOSDtextbox,destBRSD,Packing_Stage,PackDate,PackingInfo,LooseCased;
    public By LCLorFCL,pakingcontainer,netVol,grossVol,WeightUnitID,packingNetWt,pkgGrossWt,getCostbtn,packing_Cost,rateComp,pkgCostHead,costper,PKGRate,pkgcurrency,pkgRev,btnAddCost,btnSavePacking;
	public By finalStageTab,deliveryCostBtn,destRateComponent,destCostHead,destUnitPer,destRateCost,destRevenue,destAddbtn,finalSavebtn,btnSendToApprove,finalApproveList,btnSendToCSApprove,btnApproveDelivery;
    public String enqnumber;

    // Constructor where the driver is passed
    public MoveManPF(WebDriver driver) throws IOException {
        this.driver = driver; 

        // Load the properties file
        FileReader fr = new FileReader(System.getProperty("user.dir") + "\\Configuration\\Locater.properties");
        prop.load(fr);

        // Initialize locators
        moveman = By.xpath(prop.getProperty("Move_Management"));
        open_Job = By.xpath(prop.getProperty("Open_Job"));
        openJobbtn = By.partialLinkText(prop.getProperty("Open_job"));
        dropDownSelectJob = By.xpath(prop.getProperty("SelectJob"));
        openJobTextBox = By.xpath(prop.getProperty("openJtext"));
        Enq_search = By.xpath(prop.getProperty("EP_search"));
        enqnumber=prop.getProperty("EnqNumber");
        searchbutton=By.id("btnSearch");
        nationality=By.xpath(prop.getProperty("Nationality"));
       jobNumber= By.xpath(prop.getProperty("JobNo"));
       openJobBtn=By.partialLinkText(prop.getProperty("Open_job"));
       jobOpeningTab= By.xpath(prop.getProperty("jobOpeningTab"));
       orgWarehouse=By.xpath(prop.getProperty("OrgWarehouse"));
       origindestSearchBox=By.xpath(prop.getProperty("orgsearchbox"));
       destWarehouse=By.xpath(prop.getProperty("DestWarehouse"));
       Cheque_No=By.xpath(prop.getProperty("Cheque_No"));
       Cheque_Amt=By.xpath(prop.getProperty("Cheque_Amt"));
       hOSD=By.xpath(prop.getProperty("HOSD"));
       hOSDtextbox=By.xpath(prop.getProperty("HOSDtextbox"));
       destBRSD=By.xpath(prop.getProperty("DestBRSD"));
       
//       Paking Stage MOve man
       Packing_Stage=By.partialLinkText(prop.getProperty("Packing_Stage"));
       PackDate=By.xpath(prop.getProperty("PackDate"));
       PackingInfo=By.xpath(prop.getProperty("PackingInfo"));
       LooseCased=By.xpath(prop.getProperty("LooseCased"));
       LCLorFCL=By.xpath(prop.getProperty("LCLorFCL"));
       pakingcontainer=By.xpath(prop.getProperty("packing_container"));
       netVol=By.xpath(prop.getProperty("NetVol"));
       grossVol=By.xpath(prop.getProperty("GrossVol"));
       WeightUnitID=By.xpath(prop.getProperty("WeightUnitID"));
       packingNetWt=By.xpath(prop.getProperty("PackingNetWt"));
       pkgGrossWt=By.xpath(prop.getProperty("pkgGrossWt"));
       getCostbtn=By.xpath(prop.getProperty("GetCost"));
       packing_Cost=By.xpath(prop.getProperty("Packing_Cost"));
       rateComp=By.xpath(prop.getProperty("RateComp"));
       pkgCostHead=By.xpath(prop.getProperty("PkgCostHead"));
       costper=By.xpath(prop.getProperty("Costper"));
       PKGRate=By.xpath(prop.getProperty("PKGRate"));
       pkgcurrency=By.xpath(prop.getProperty("Pkgcurrency"));
       pkgRev=By.xpath(prop.getProperty("PkgRev"));
       btnAddCost=By.xpath(prop.getProperty("btnAddCost"));
       btnSavePacking=By.xpath(prop.getProperty("btnSavePacking"));
       finalStageTab=By.partialLinkText(prop.getProperty("FinalStage"));
       deliveryCostBtn=By.xpath(prop.getProperty("Delivery_Cost"));
       destRateComponent= By.xpath(prop.getProperty("FinalRateComp"));
       destCostHead=By.xpath(prop.getProperty("FinalCostHead"));
       destUnitPer=By.xpath(prop.getProperty("FinalPer"));
       destRateCost=By.xpath(prop.getProperty("FinalRateCost"));
       destRevenue=By.xpath(prop.getProperty("FinalChRev"));
       destAddbtn=By.xpath(prop.getProperty("FinalAddbtn"));
       finalSavebtn=By.xpath(prop.getProperty("FinalSavebtn"));
       btnSendToApprove=By.xpath(prop.getProperty("btnSendToApprove"));
       finalApproveList=By.xpath(prop.getProperty("FinalApproveList"));
       btnSendToCSApprove=By.xpath(prop.getProperty("btnSendToCSApprove"));
       btnApproveDelivery=By.id(prop.getProperty("btnApproveDelivery"));
       
    }

    // Method to interact with the Move Management elements
    public void moveMan() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(moveman).click();  // Click on the Move Management element
        Thread.sleep(1000);
        driver.findElement(open_Job).click();  // Click on the Open Job element
    }

    // Method to click on the "Open Job" button
    public void clickonOpenJobBtn() {
        driver.findElement(openJobbtn).click();
    }

 // Method to select a job from a dynamic dropdown
    public void selectFromDynamicDropdown(By dropdownLocator, By textBoxLocator, String valueToSelect) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Wait for the overlay to disappear if it exists
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("overlay")));

            Actions actions = new Actions(driver);
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
            actions.moveToElement(dropdown).click().perform();


            // Wait until the associated textbox is visible
            WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

            // Type into the dropdown's associated text box
            textBox.clear();
            textBox.sendKeys(valueToSelect);

            // Pause briefly to allow suggestions to appear
            Thread.sleep(1000);

            // Select the option from the dropdown
            textBox.sendKeys(Keys.ARROW_DOWN);
//            Thread.sleep(1000);
            textBox.sendKeys(Keys.ENTER);
            
        } catch (Exception e) {
            System.out.println("Error selecting from dropdown: " + e.getMessage());
        }
    }
    
    public void searchbtn() throws InterruptedException
    {
    	Thread.sleep(1000);
    	driver.findElement(searchbutton).click();
    }

    // Method to enter text into a text box
    public void textBox(By textBoxLocator, String valueToEnter) {
        WebElement textBox = driver.findElement(textBoxLocator);
        textBox.sendKeys(valueToEnter);
//        if (textBox != null && valueToEnter != null && !valueToEnter.isEmpty()) {
//            textBox.clear();  // Clear the text box before entering a new value
//            textBox.sendKeys(valueToEnter);
//        } else {
//            throw new IllegalArgumentException("TextBox element or value to enter is null/empty.");
//        }
    }
    public void selectDropdown(By dropdownLocator, String dropdownValue) {
        WebElement dropdownElement = driver.findElement(dropdownLocator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(dropdownValue);
    }

    
    public void clickOnJobButton() {
        try {
            // Try to locate and click the "Open Job" button
        	 WebElement JobNo1=driver.findElement(jobNumber);   
             String JobNo = JobNo1.getText();
             System.out.println("Job Number"+JobNo);
             
                if(JobNo.isEmpty())
                {
                	WebElement jobButton = driver.findElement(By.partialLinkText(prop.getProperty("Open_job")));
                    jobButton.click();
                    System.out.println("Clicked on 'Open Job' button.");
         }
                else {
                	WebElement jobButton = driver.findElement(By.partialLinkText(prop.getProperty("View_Job")));
                    jobButton.click();
                }
            
        } catch (NoSuchElementException e1) {
            try {
                // If "Open Job" is not found, try "View Job"
                WebElement jobButton = driver.findElement(By.partialLinkText(prop.getProperty("View_Job")));
                jobButton.click();
                System.out.println("Clicked on 'View Job' button.");
            } catch (NoSuchElementException e2) {
                System.out.println("Job button not found.");
            }
        }
    }
    
    
    public void enterTextIntoTextBox(By textBoxLocator, String textBoxValue)
    {
    WebElement textBoxElement = driver.findElement(textBoxLocator);
    textBoxElement.clear();
    textBoxElement.sendKeys(textBoxValue);
    }
   //jobOpeningTab 
    public void jobOpeningTab() {
       
    	
		    
    }
}


