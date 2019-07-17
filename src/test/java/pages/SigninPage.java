package pages;

import base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPage extends BasePage {

       private  WebDriver driver;
        WebDriverWait wait;


        public SigninPage(WebDriver idriver) {
            this.driver = idriver;
            PageFactory.initElements (driver, this);
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
        usernamefield.sendKeys(username);
        Thread.sleep(8000);
        System.out.println ("I entered username");
        passwordField.sendKeys(password);
        Thread.sleep(8000);
        System.out.println ("I entered pass");
        loginButton.click();
        Thread.sleep(10000);
        log.info(" i am logging in");
        System.out.println ("I clicked logged in");

    }

//    public void submit(){
//        loginButton.click();
//
//    }


}


