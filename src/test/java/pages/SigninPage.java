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

    //orange hrm sample website
    @FindBy(xpath ="//*[@id=\"txtUsername\"]")
    private WebElement txtUserName;
    @FindBy(xpath ="//*[@id=\"txtPassword\"]")
    private WebElement txtPassword;
    @FindBy(id ="btnLogin")
    private WebElement btnLogin;





    public void login(String username, String password) throws InterruptedException {
   /*     usernamefield.click();

        usernamefield.sendKeys(username);
        Thread.sleep(8000);
        log.info("I entered username");
        passwordField.click();
        passwordField.sendKeys(password);

        log.info("I entered pass");
     wait.until (ExpectedConditions.elementToBeClickable (loginButton));
      loginButton.click();

        log.info(" i am logging in");
        System.out.println ("I clicked logged in");*/


   //hrms login function
//        Thread.sleep(10000);
        txtUserName.click();
        txtUserName.sendKeys("Admin");
        txtPassword.sendKeys("admin123");
        btnLogin.click();
        log.info("Clicked on Login button");

    }

//    public void submit(){
//        loginButton.click();
//
//    }


}


