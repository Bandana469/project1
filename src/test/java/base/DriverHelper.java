package base;



import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.PropertyFile;
import util.WaitHelper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverHelper extends PropertyFile {
    private WebDriver driver;
    private Properties properties = getProperties ( );
    public Logger log = Logger.getLogger(DriverHelper.class);
    WaitHelper wait ;

    public WebDriver getDriver() {
        //System.out.println ("Tests are being run for : " + driverName);

        try {
            if (driver == null) {
                String driverName = properties.getProperty ("driver");
                System.out.println ("Tests are being run for : " + driverName);
                if (driverName.equals ("remote-chrome")) {
                    driver = getRemoteChromeDriver ( );
                } else if (driverName.equals ("chrome")) {
                    driver = getChromeDriver ( );
                } else if (driverName.equals ("firefox")) {
                    driver = getFireFoxDriver ( );
                }
            }
            initLogs();
        } catch (Exception ex) {
            ex.printStackTrace ( );
        }
        wait = new WaitHelper(driver);
        String URL = (String.format ("https://%s", properties.getProperty ("base.url")));
        log.info("Navigate to url "+URL);
        driver.get (URL);
        wait.waitForPageToLoad();
        driver.manage ( ).timeouts ( ).pageLoadTimeout (10, TimeUnit.SECONDS);
        return driver;
    }


    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.path"));
       new ChromeOptions ().addArguments("headless");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }



    private WebDriver getFireFoxDriver() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.path"));
        new ChromeOptions ().addArguments("headless");
        WebDriver driver = new FirefoxDriver ();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver getRemoteChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions ( );
        chromeOptions.addArguments ("headless");
        chromeOptions.addArguments ("window-size=1920,1080");
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver (new URL ("http://localhost:4444/wd/hub"), (Capabilities) chromeOptions);
        } catch (MalformedURLException exception) {
            System.err.println (exception.getMessage ( ));
            System.err.println ("How did you manage to break this?");
        }
        return driver;
    }



        public void quitDriver() {
                driver.quit ( );
                driver = null;
            }


    private void initLogs() {
        if (log == null) {
            // Initialize Log4j logs
            System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
            System.out.println(System.getProperty ("user.dir") + File.separator + "config" + File.separator + "log4j.xml");
            DOMConfigurator.configure (System.getProperty ("user.dir") + File.separator + "config" + File.separator + "log4j.xml");
//            DOMConfigurator.configure ( "config/log4j.xml");

            log = Logger.getLogger (Log.class.getName());
            log.info ("Logger is initialized..");

        }
    }


}



