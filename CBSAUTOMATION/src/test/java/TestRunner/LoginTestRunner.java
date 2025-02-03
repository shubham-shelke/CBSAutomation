package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\CBS Automation\\CBSCucumber\\CBSAUTOMATION\\src\\test\\resources\\Features",
    glue = {"StepDefinitions"},
    tags = "@Login",
    plugin = {
        "pretty",
        "junit:target/JunitReports/reports.xml",
        "json:target/JsonReports/reports.json",
        "html:target/HtmlReports.html"
    }
)
public class LoginTestRunner {
}

//package TestRunner;
//
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//    features = "D:/CBS Automation/CBSCucumber/CBSAUTOMATION/src/test/resources/Features/Login.feature",
//    glue = {"StepDefinitions"},
//    monochrome = true
//)
//public class LoginTestRunner {
//}
