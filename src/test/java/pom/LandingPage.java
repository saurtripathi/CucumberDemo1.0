package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LandingPage {


    WebDriver driver;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='topMainHeader']/div/ul/li[2]/span/div")
    private WebElement tutorialsMenu;

    @FindBy(xpath = "//*[@id='topMainHeader']/div/ul/li[2]/ul/li[2]/span")
    private WebElement mLAndDataScienceSubMenu;

    @FindBy(xpath = "//*[@id='topMainHeader']/div/ul/li[2]/ul/li[2]/span/ul/li[1]/a")
    private WebElement pythonTutorialLnk;

    @FindBy(xpath = "//*[@id='topMainHeader']/div/div/div[4]/div[1]/span/i")
    private WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"topMainHeader\"]/div/div/div[4]/div[1]/form/input")
    private WebElement searchTb;

    @FindBy(xpath = "//*[@class='gs-single-result-title']")
    private List<WebElement> resultTitleLnk;

    @FindBy(xpath = "//*[@class='gs-modal-content']")
    private WebElement modalDivElement;


    public void clickSearchIconAndEnterText(String text){
        searchIcon.click();
        searchTb.sendKeys(text);
        searchTb.sendKeys(Keys.ENTER);
    }

    public List<String> getResultLinkText(){
        List<String> list = new ArrayList<>();
        Iterator<WebElement> it = resultTitleLnk.iterator();
        while (it.hasNext()){
            list.add(it.next().getText().trim());
        }
        return list;
    }



    public String navigateToMenuAndGetLinkText(){
        Actions actions = new Actions(driver);
        actions = new Actions(driver);
        actions.moveToElement(tutorialsMenu).perform();
        actions.moveToElement(mLAndDataScienceSubMenu).perform();
        return pythonTutorialLnk.getText();
    }

    public void refresh(){
        driver.navigate().refresh();
    }
}