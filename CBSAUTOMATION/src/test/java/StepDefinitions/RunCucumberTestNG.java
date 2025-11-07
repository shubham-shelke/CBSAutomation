// package StepDefinitions;

// import org.junit.runner.RunWith;
// import io.cucumber.junit.Cucumber;

// import io.cucumber.testng.AbstractTestNGCucumberTests;
// import io.cucumber.testng.CucumberOptions;

// @RunWith(Cucumber.class)
// @CucumberOptions(
//     features = {
//     		"src\\test\\resources\\Features"
//            //  "C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\CBSAutomation\\CBSAUTOMATION\\src\\test\\resources\\Features"
//              //"https://github.com/shubham-shelke/CBSAutomation/tree/main/CBSAUTOMATION/src/test/resources/Features",
// //    		"D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\src\\test\\resources\\Featurepreprod",
//     },
//     glue = {"StepDefinitions"},
//     plugin = {
//        "pretty",
//         "junit:target/JunitReports/reports.xml",
//        //  "json:target/JsonReports/reports.json",
//        // "html:target/HtmlReports.html"
//          "html:target/cucumber-reports/report.html",
//         // "json:target/cucumber-reports/reports.json",
       // "json:target/cucumber-reports/report.json"
//    },
//     monochrome = true ,
// //    tags = "@Login or @SurveyDetails or @Pricing or @Approver "
//      tags = "@Login or @Enquiry or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
// //    tags = "@Login or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
// //    tags = "@Login or @Pricing or @Approver or @Login or @MoveMan or @QuoteApprover or @Billing"
// //    tags ="@Approver or @Login or @MoveMan or @QuoteApprover"
// //    tags = "@Login or @MoveMan or @QuoteApprover or @Billing "
// //    tags = "@QuoteApprover or @Billing"
// //    tags = "@Billing"
// )
// public class RunCucumberTestNG extends AbstractTestNGCucumberTests{
// }

/*
package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.File;                       // NEW
import org.testng.annotations.BeforeClass; // NEW

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
        "src\\test\\resources\\Features"
    },
    glue = {"StepDefinitions"},
   plugin = {
    "pretty",
    "junit:target/junit-reports/cucumber.xml",
    // "html:target/html-reports/cucumber.html",
    // "json:target/json-reports/cucumber.json"

    "json:target/cucumber-reports/Cucumber.json",   // must match POM
        "html:target/cucumber-reports/html-report"
   },
    monochrome = true,
    tags = "@Login"
    // tags = "@Login or @Enquiry or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests {

   
    @BeforeClass(alwaysRun = true)
    public static void ensureReportDirectoryExists() {
        File reportDir = new File("target/cucumber-reports");
        if (!reportDir.exists() && !reportDir.mkdirs()) {
            throw new RuntimeException(
                "Failed to create report directory: " + reportDir.getAbsolutePath()
            );
        }
    }
}
*/

package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import java.io.File;



@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    plugin = {
        "pretty",
        "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports/HtmlReports.html",
        "junit:target/cucumber-reports/report.xml"
    },
    monochrome = true,
       tags = "@Login or @Enquiry or @SurveyDetails or @Pricing or @Approver or @MoveMan or @QuoteApprover or @Billing"
)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests {

    @BeforeSuite(alwaysRun = true)
    public void ensureReportDirectoryExists() {
        File reportDir = new File("target/cucumber-reports");
        if (!reportDir.exists() && !reportDir.mkdirs()) {
            throw new RuntimeException("Failed to create report directory: " + reportDir.getAbsolutePath());
        }
    }
}





