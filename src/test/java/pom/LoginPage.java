package pom;

import io.cucumber.java.be.I;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(),'Remind Me Later')]")
    private WebElement remindMeLaterLnk;

    @FindBy(xpath = "//*[@class='defaultProfileImg']")
    private WebElement profileImgIcon;

    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    private WebElement logoutLnk;

    @FindBy(xpath = "//*[@placeholder='Username or email']")
    private WebElement userNameTb;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordTb;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id='topMainHeader']/div/div/button")
    private WebElement signInLnk;

    public void clickSignInToDialogBox(){
        signInLnk.click();
    }

    public void enterUserCredentialsAndClickToLogin(String username, String password){
        userNameTb.sendKeys(username);
        passwordTb.sendKeys(password);
        submitBtn.click();
        remindMeLaterLnk.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void logOut(){
        logoutLnk.click();
    }

    public boolean isLogOutLinkPresent(){

        boolean res = false;
        try{
//            driver.navigate().refresh();
            Thread.sleep(5000);
            profileImgIcon.click();
            Thread.sleep(5000);
            res = logoutLnk.getText().equalsIgnoreCase("Logout");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return res;

    }


}
