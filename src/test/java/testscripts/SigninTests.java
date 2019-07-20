package testscripts;

import base.BaseTest;
//import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import pages.SigninPage;

import java.util.concurrent.TimeUnit;


public class SigninTests extends BaseTest {
    private WebDriver driver;
    private SigninPage login;
   // private HomePage homePage;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        driver = getDriver ( );
        login = new SigninPage (driver);
       //homePage = new HomePage (driver);
        wait = new WebDriverWait (driver, 10);
        logInToApplication ( );

    }

//    @Test(priority = 1)
//    public void logInToApplication() throws InterruptedException {
//        driver.manage ( ).deleteAllCookies ( );
//
//
//        login.login ("bkarki","Contractor.123");
//        //login.submit ();
//    }

    @Test (priority = 2)
    public void login() throws Exception {
       // Assert.assertTrue (homePage.goToLandingPage ( ));
    }





}









