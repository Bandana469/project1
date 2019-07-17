package testscripts;


import base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.HomePage;
import pages.SigninPage;




public class HomePageTests extends BaseTest {

        private WebDriver driver;
        private SigninPage login;
        private HomePage homePage;
        private WebDriverWait wait;


    @BeforeClass
        public void setUp() throws Exception {
            driver = getDriver ( );
            login = new SigninPage (driver);
            homePage = new HomePage (driver);
            wait = new WebDriverWait (driver, 10);
            log.info ("logging in");
            logInToApplication ();


        }


        @Test(priority =1)
        public void login() throws Exception{
            Assert.assertTrue(homePage.goToLandingPage ());
        }



@Test(priority =2)
public void testHomeTitle() throws Exception{
        log.info("user navigates from login to Homepage");
        Assert.assertTrue (homePage.seeIfTitlePresents ());

        }



    @Test(priority =3)
    public void clickCancel() throws Exception{
        log.info("User should see Agreement Page after logged in");
        homePage.clickAgreement ();
        log.info("user to cancel the agreement page");
        homePage.setCancelAgreement ( );
        Assert.assertTrue ( homePage.goToLandingPage());

    }


    @Test(priority =4)
    public void validateLandingPageIsDispalyedAfterUserAgreement() throws Exception{
        log.info("Agreement page might not be visible to the user if logging in 2nd time");
        homePage.clickAgreement ();
        wait (5000);
        log.info ("user navigates to Main Page");
        Assert.assertTrue ( homePage.goToLandingPage());
        System.out.println("yay, I am inside  a landing page");

    }






}
