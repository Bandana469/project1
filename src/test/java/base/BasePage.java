package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage extends BaseTest{


    private final int webDriverWaitinSeconds = 20;

    public int getTimeOutInSeconds() {

        return webDriverWaitinSeconds;

    }

}
