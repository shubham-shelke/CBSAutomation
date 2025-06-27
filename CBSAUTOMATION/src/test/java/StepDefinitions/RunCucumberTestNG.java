package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
    		"src\\test\\resources\\Features"
           //  "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\CBSAutomation\\CBSAUTOMATION\\src\\test\\resources\\Features"
             //"https://github.com/shubham-shelke/CBSAutomation/tree/main/CBSAUTOMATION/src/test/resources/Features",
//    		"D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\src\\test\\resources\\Featurepreprod",
    },
    glue = {"StepDefinitions"},
    plugin = {
       "pretty",
        "junit:target/JunitReports/reports.xml",
        "json:target/JsonReports/reports.json",
       "html:target/HtmlReports.html"
   },
    monochrome = true ,
//    tags = "@Login or @SurveyDetails or @Pricing or @Approver "
     tags = "@Login or @Enquiry or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
//    tags = "@Login or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
//    tags = "@Login or @Pricing or @Approver or @Login or @MoveMan or @QuoteApprover or @Billing"
//    tags ="@Approver or @Login or @MoveMan or @QuoteApprover"
//    tags = "@Login or @MoveMan or @QuoteApprover or @Billing "
//    tags = "@QuoteApprover or @Billing"
//    tags = "@Billing"
)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests{
}


// package StepDefinitions;

// import io.cucumber.testng.AbstractTestNGCucumberTests;
// import io.cucumber.testng.CucumberOptions;

// @CucumberOptions(
//     features = "src/test/resources/features",
//     glue = "StepDefinitions",
//     plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"}
// )
// public class RunCucumberTestNG extends AbstractTestNGCucumberTests {
// }

