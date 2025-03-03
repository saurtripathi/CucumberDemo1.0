package TestRunner;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/Features/LoginVerification.feature",
                "src/test/java/Features/LandingPageTutorialMenuVerification.feature",
                "src/test/java/Features/LandingPageSearchFeature.feature"
//                "src/test/java/Features/CucumberFeatures.feature"

        },
        glue = "steps",
//        plugin = {"pretty", "html:target/cucumber-reports.html"}
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json","html:target/cucumber-reports.html" }
)
public class RunCucumberTest {
        public static WebDriver driver;







}
