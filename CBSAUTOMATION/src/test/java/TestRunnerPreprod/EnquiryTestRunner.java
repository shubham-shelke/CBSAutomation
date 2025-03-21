package TestRunnerPreprod;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\src\\test\\resources\\Featurepreprod",
    glue = {"StepDefinitions"},
    tags = "@Enquiry",
    plugin = {
        "pretty",
        "junit:target/JunitReports/reports.xml",
        "json:target/JsonReports/reports.json",
        "html:target/HtmlReports.html"
    }
)
public class EnquiryTestRunner {
}
