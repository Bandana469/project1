package base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.SampleLogin;
import pages.SigninPage;

import util.BrowserHelper;
import util.PropertyFile;
import util.ResourceHelper;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;


public class BaseTest extends PropertyFile {


    public String resultsDir;
    public String screenshotPath = "Screenshot";
    public Logger log = Logger.getLogger(BaseTest.class);
    public Properties properties = getProperties ( );
    private WebDriver webDriver;
    private DriverHelper driverHelper = new DriverHelper ( );



    public WebDriver getDriver() {
        webDriver = driverHelper.getDriver ( );
        initLogs ( );
        return webDriver;
    }

    public void logInToApplication() throws Exception {
        webDriver.manage ( ).deleteAllCookies ( );
        SigninPage loginPage = new SigninPage (webDriver);
        loginPage.login(properties.getProperty("base.user"),properties.getProperty("base.pass"));


//        webDriver.manage ( ).deleteAllCookies ( );
  //  SampleLogin loginPage = new SampleLogin (webDriver);
//        loginPage.loginAndSubmit (properties.getProperty("user"),properties.getProperty("pass"));


    }


    @BeforeSuite
    public void initSuite() {

    }

    @BeforeClass
    public void beforeClass() {
        try {
            this.getClass ( ).getSimpleName ( );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    @BeforeMethod()
    public void beforeMethod(Method method) {

    }

    @AfterMethod()
    public void afterMethod(ITestResult result) {
        try {
            getresult (result);
            //extent.flush();
        } catch (Exception e) {
            // Reporter("Exception in @AfterMethod: " + e, "Fail", log);
        }
    }



    @AfterSuite
    public void cleanUp() {
        // If additional activities are required after Suite is complete
    }

    public void tearDownDriver() {
        if (((RemoteWebDriver) webDriver).getSessionId ( ) != null) {
            System.out.println ("Tearing down driver...." + ((RemoteWebDriver) webDriver).getSessionId ( ).toString ( ));
            driverHelper.quitDriver ( );
        }
    }

    public String getSystemTime() {
        return "Current time :" + new SimpleDateFormat ("HH:mm:ss:SSS").format ((Calendar.getInstance ( )).getTime ( ));
    }


    public void getresult(ITestResult result) {
        try {
            File screenShotName;
            String sdft = new SimpleDateFormat ("YYYY-MM-dd_HHmmss").format (new Date ( ));
            if (result.getStatus ( ) == ITestResult.SUCCESS) {
                //  xtReportLog.log(Status.PASS, result.getName() + " test is pass");
            } else if (result.getStatus ( ) == ITestResult.SKIP) {
                log.debug (result.getName ( ) + " test is skipped and skip reason is:-" + result.getThrowable ( ));
            } else if (result.getStatus ( ) == ITestResult.FAILURE) {
                String scrPath = takeScreenShot (result.getName ( ) + "_Fail");
                //xtReportLog.fail(result.getName() + " test is failed",
                //    MediaEntityBuilder.createScreenCaptureFromPath(scrPath).build());
                log.error (result.getName ( ) + " test is failed" + result.getThrowable ( ));
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }



    public String takeScreenShot(String name) {
        try {
            File screenShotName;
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs (OutputType.FILE);
            String scrPath = ResourceHelper.getBaseResourcePath ( ) + File.separator + screenshotPath + File.separator + name + ".png";
            screenShotName = new File (scrPath);
            FileUtils.copyFile (scrFile, screenShotName);
            String filePath = screenShotName.toString ( );
            return filePath;
        } catch (Exception e) {
            e.printStackTrace ( );
            return null;
        }
    }

    private void initLogs() {
        if (log == null) {
            // Initialize Log4j logs
            DOMConfigurator.configure (System.getProperty ("user.dir") + File.separator + "config" + File.separator + "log4j.xml");
            log = Logger.getLogger ("MyLogger");
            log.info ("Logger is initialized..");

        }
    }


}

