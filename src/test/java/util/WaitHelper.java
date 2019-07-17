package util;


import base.BaseTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WaitHelper extends BaseTest {
    private WebDriver driver;
    private Logger Log = Logger.getLogger(WaitHelper.class);

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setImplicitWait(long timeout, TimeUnit unit) {
        Log.info(timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
        Log.info(locator);
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElement(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        Log.info("element found..." + element.getText());
    }

    public void waitForElementDisapear(WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
        Log.info("element disapear .." + element.getText());
    }

    public WebElement waitForElement(long time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method initializes the wait with specified time
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchFrameException.class);
            return wait;
        } catch (Exception e) {
            //Reporter("Exception while applying wait to the element" + e.getMessage(), "Debug", Log);
            throw new RuntimeException("Exception while applying wait to the element");
        }
    }

    /**
     * This method allows page to Load for 10 seconds
     *
     * @author shikhar
     */
    public void waitForPageToLoad() {
        try {
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
        } catch (Exception e) {
           // Reporter("Exception while applying wait to load page:" + e.getMessage(), "Fail", Log);
        }
    }

    /**
     * This method wait for an element to be clickable using Explicit wait
     *
     * @param element
     * @author shikhar
     */
    public void waitElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = getWait(40, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            //Reporter("Exception while applying wait to the element to become clickable:" + e.getMessage(), "Debug", Log);
        }
    }

    /**
     * This method wait and clicks on the element
     *
     * @param element
     * @param text
     * @return
     */
    public boolean waitAndClickElement(WebElement element, String text) {
        try {
            WebDriverWait wait = getWait(30, 5);
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true && element.isDisplayed()) {
                element.click();
                //Reporter("Clicked on the element: " + text, "Pass", Log);
                return true;
            }

        } catch (StaleElementReferenceException elementUpdated) {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            Boolean elementPresent = wait.until(ExpectedConditions.stalenessOf(element));
            if (elementPresent == true) {
                WebElement staleElement = element;
                staleElement.click();
                //Reporter("Clicked on the 'Stale' element: " + text, "Pass", Log);
                return true;
            }
        } catch (NoSuchElementException e) {
            //Reporter("Exception! - Could not click on the element: " + text + ", Exception: " + e.toString(), "Fail", Log);
            throw (e);
        } catch (TimeoutException e) {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            Boolean elementPresent = wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
            if (elementPresent == true && element.isDisplayed()) {
                element.click();
               // Reporter("Clicked on the element: " + text, "Pass", Log);
                return true;
            }
        } catch (Exception e) {
            //Reporter("Exception while waiting for element: " + text + " to be clickable:" + e.fillInStackTrace(), "Fail", Log);
            throw new RuntimeException(e);
        } finally {
            waitForPageToLoad();
        }
        return false;
    }

    /**
     * This method wait for an element to be visible using Explicit wait
     * @author shikhar
     * @param element
     */
    public void waitElementToBeVisible(WebElement element) {
        try {
            WebDriverWait wait = getWait(40, 5);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
           // Reporter("Element is not visible on page", "Info", Log);
        } catch (Exception e) {
            log.debug("Not able to apply wait to the element to be visible");
        }
    }

    /**
     * This method wait for a text to be available in an element using Explicit wait
     * @param element
     * @param text
     * @author shikhar
     */
    public void waitForTextToBeAvailable(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            //Reporter("Exception while applying wait to the element to become clickable:" + e.getMessage(), "Fail", Log);
        }
    }

    /**
     * This method wait for a element to become invisible using Explicit wait
     * @param element
     * @author shikhar
     */
    public void waitForInvisibiltyOfElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (NoSuchElementException e) {

        } catch (TimeoutException e) {

        } catch (Exception e) {
            e.printStackTrace();
            //Reporter("Exception while applying wait for element to be invisible:" + e.getMessage(), "Fail", Log);
        }
    }
}

