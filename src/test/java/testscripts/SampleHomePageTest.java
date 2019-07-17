//package testscripts;
//
//import base.BaseTest;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.SampleHomePage;
//
//import org.openqa.selenium.WebDriver;
//import util.WaitHelper;
//
//public class SampleHomePageTest extends BaseTest {
//
//
//    //Initialize required objects
//    private WebDriver driver = getDriver ( );
//     private WaitHelper waitHelper = PageFactory.initElements (driver, WaitHelper.class);
//
//
//
//
////    @BeforeMethod
////    public void loadLogin () throws Exception{
////        driver.get(data.getProperty("base.url"));
////        SampleLogin login = new SampleLogin(driver);
////        login.loginAndSubmit(data.getProperty("mypage.user"),data.getProperty("mypage.pass"));
////        Assert.assertTrue(true);
////
////    }
//
//        @Test
//        public void testHomeTitle() throws Exception {
//            SampleHomePage sampleHomePage = new SampleHomePage (driver);
//            Assert.assertTrue (sampleHomePage.seeIfTitlePresents ( ));
//        }
//
//
//    }
