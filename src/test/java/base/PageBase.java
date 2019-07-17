package base;

import junit.framework.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;


public abstract class PageBase {

	/**
	 * The Driver.
	 */
	protected WebDriver driver = null;
	public Logger log = TestBase.log;



	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	/**
	 * Wait
	 */
	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private final int webDriverWaitinSeconds = 10;

	public int getTimeOutInSeconds() {

		return webDriverWaitinSeconds;

	}



	/**
	 * Sample action code
	 */
	public void pressEnter() {
		try {
			Thread.sleep(5000l);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


}
