package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LandingPage;

import java.time.Duration;

public class LandingPageTutorialMenuVerificationSteps {

        WebDriver driver = new ChromeDriver();
        LandingPage landingPage ;
        String text ;
    @Given("User launches the landing page")
    public void user_launches_the_landing_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
        landingPage = new LandingPage(driver);
    }
    @When("User navigates to Tutorial -> ML & Data Science submenu")
    public void user_navigates_to_tutorial_ml_data_science_submenu() {
         text = landingPage.navigateToMenuAndGetLinkText();
    }
    @Then("link for Python Tutorial exists")
    public void link_for_python_tutorial_exists() {
        Assert.assertEquals(text,"Python Tutorial");
        driver.quit();
    }


}
