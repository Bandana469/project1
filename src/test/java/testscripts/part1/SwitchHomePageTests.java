package testscripts.part1;



import base.TestBase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SwitchHomePage;
import pages.SwitchLoginpage;




public class SwitchHomePageTests extends TestBase {


    public SwitchHomePageTests() {
        super (driver);
    }

    @BeforeClass
    public void setup () throws Exception{
        SwitchLoginpage login = new  SwitchLoginpage(driver);
        log.info(" user logs in using users' valid credentials");
       login.login(data.getProperty("base.user"),data.getProperty("base.pass"));
        //Assert.assertTrue(true);
    }



    @Test(priority =1)
    public void testHomeTitle() throws Exception{
        SwitchHomePage homePage = new SwitchHomePage (driver);
        log.info("user navigates from login to Homepage");
        Assert.assertTrue (homePage.seeIfTitlePresents ());

    }



    @Test(priority =2)
    public void clickCancel() throws Exception{
        SwitchHomePage homePage = new SwitchHomePage (driver);
        log.info("User should see Agreement Page after logged in");
        homePage.clickAgreement ();
        log.info("user to cancel the agreement page");
        homePage.setCancelAgreement ( );
        Assert.assertTrue ( homePage.goToLandingPage());

    }


    @Test(priority =3)
    public void validateLandingPageIsDispalyedAfterUserAgreement() throws Exception{
        SwitchHomePage homePage = new SwitchHomePage (driver);
        log.info("Agreement page might not be visible to the user if logging in 2nd time");
        homePage.clickAgreement ();
        wait (5000);
        log.info ("user navigates to Main Page");
        Assert.assertTrue ( homePage.goToLandingPage());
        System.out.println("yay, I am inside  a landing page");

    }


}

