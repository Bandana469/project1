//package testscripts;
//
//import base.TestBase;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.SwitchLoginpage;
//import pages.TopMenuPage;
//
//
//public class SwitchTalkTests extends TestBase
//
//    {
//
//        WebDriverWait wait;
//
//        public SwitchTalkTests() {
//            super (driver);
//        }
//
//
//        @BeforeClass
//        public void setup () throws Exception {
//        SwitchLoginpage login = new SwitchLoginpage (driver);
//        log.info (" user logs in using users' valid credentials");
//        login.login (data.getProperty ("base.user"), data.getProperty ("base.pass"));
//        wait = new WebDriverWait (driver, 10);
//    }
//
//
//        @Test(priority = 1)
//        public void testHomeTitle () throws Exception {
//        TopMenuPage topmenu = new TopMenuPage (driver);
//        topmenu.clickSwitchTalkPage ();
//          //  Assert.assertTrue (switchTa);
//
//    }
//    }