package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LandingPage;

import java.time.Duration;
import java.util.List;

public class LandingPageSearchFeatureSteps {

    WebDriver driver = new ChromeDriver();
    LandingPage landingPage = new LandingPage(driver);

    @Given("User opens the landing page")
    public void User_launches_the_landing_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
        landingPage = new LandingPage(driver);
    }

//    @When("^User clicks the search icon and enters the \"([^\"]*)\" hit enter button$")
//@When("^User clicks the search icon and enters the {string} hit enter button$")
@When("User clicks the search icon and enters the {string} hit enter button")
    public void user_clicks_the_search_icon_and_enters_the_hit_enter_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        landingPage.clickSearchIconAndEnterText(string);
    }

//    @Then("^Search list appears and entered \"([^\"]*)\" appears in the list$")
//@Then("^Search list appears and entered {appearedText} appears in the list$")
@Then("Search list appears and entered {string} appears in the list")
    public void search_list_appears_and_entered_appears_in_the_list(String string) {
        List<String> textList = landingPage.getResultLinkText();
            String actual = "";
            for(String item : textList){
                if(item.equalsIgnoreCase(string)){
                    actual = item;
                    break;
                }
            }
        Assert.assertEquals(actual,string);
            driver.quit();
    }

}
