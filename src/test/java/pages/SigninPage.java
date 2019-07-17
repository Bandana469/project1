package pages;

import base.BasePage;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SigninPage extends BasePage {

       private  WebDriver driver;
        WebDriverWait wait;
    public Logger log;


        public SigninPage(WebDriver idriver) {
            this.driver = idriver;
            PageFactory.initElements (driver, this);
            wait = new WebDriverWait (driver,getTimeOutInSeconds ());
             log = Logger.getLogger(SigninPage.class);
        }


    @FindBy(id ="SectionContent")
    private WebElement loginForm;
    @FindBy(name ="ctl00$BodyContent$UserName")
    private WebElement usernamefield;
    @FindBy(xpath ="//input[@name='ctl00$BodyContent$Password']")
    private WebElement passwordField;
    @FindBy(xpath="//input[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath="//*[@class='main-content']")
    private WebElement alertPage;
    @FindBy(xpath="//*[@id=\"contentheader\"]")
    private WebElement agreement;





    public void login(String username, String password) throws InterruptedException {
        usernamefield.click();

        usernamefield.sendKeys(username);
        Thread.sleep(8000);
        System.out.println ("I entered username");
        passwordField.click();
        passwordField.sendKeys(password);

        System.out.println ("I entered pass");
     wait.until (ExpectedConditions.elementToBeClickable (loginButton));
      loginButton.click();

        log.info(" i am logging in");
        System.out.println ("I clicked logged in");

    }

//    public void submit(){
//        loginButton.click();
//
//    }


}


