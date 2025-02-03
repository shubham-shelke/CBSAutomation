package TestRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginTestRunner.class,
    EnquiryTestRunner.class,
    SurveyTestRunner.class,
    PricingTestRunner.class,
    ApproverTestRunner.class,
    LoginTestRunner.class,
    MoveManTestRunner.class,
    QuoteApproverTestRunner.class
    
})
public class TestSuite {

}
