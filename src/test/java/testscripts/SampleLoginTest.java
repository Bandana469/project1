package testscripts;

import base.BaseTest;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SampleLogin;
import util.WaitHelper;

public class SampleLoginTest extends BaseTest {
 private WebDriver driver;
  private WaitHelper wait;
   private SampleLogin login;


    @BeforeClass
    public void setUp() throws Exception {
       driver = getDriver ( );
   login = new SampleLogin (driver);
   logInToApplication ();


    }

//    @Test
//    public void login() throws Exception{
//        driver.get(data.getProperty("base.url"));
//        driver.manage().window ().maximize ();
//        SampleLogin login = new SampleLogin (driver);
//        login.loginAndSubmit(data.getProperty("user"),data.getProperty("pass"));
//        //Assert.assertTrue(true);
//    }



    @Test
    public void login() throws Exception {
       // login.loginAndSubmit (System.getProperty ("user"), System.getProperty ("pass"));
        //Assert.assertTrue(true);


    }



}
