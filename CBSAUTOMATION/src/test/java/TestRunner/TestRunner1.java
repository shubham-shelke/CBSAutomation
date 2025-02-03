package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"StepDefinitions"},
    plugin = {
        "pretty",
        "junit:target/JunitReports/reports.xml",
        "json:target/JsonReports/reports.json",
        "html:target/HtmlReports.html"
    },
    monochrome = true,
//    strict = true,
    tags = "@Login or @Enquiry or @SurveyDetails or @Pricing or @MoveMan or QuoteApprover or @Billing"  
)
public class TestRunner1 {
}
