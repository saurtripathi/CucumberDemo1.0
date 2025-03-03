package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPage;

import java.time.Duration;

public class LoginSteps {



    WebDriver driver = new ChromeDriver();
    LoginPage loginPage ;

    @Given("Open the browser and launch the application")
    public void open_the_browser_and_launch_the_application() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
        driver.findElement(By.xpath("//*[@id='topMainHeader']/div/div/button")).click();
        loginPage = new LoginPage(driver);
    }


    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" in the app$")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUserCredentialsAndClickToLogin(username, password);
    }

    @Then("^user log in to the application$")
    public void user_log_in_to_the_application() {
        try{
            Thread.sleep(5000);

            Assert.assertTrue(loginPage.isLogOutLinkPresent());
            loginPage.logOut();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
