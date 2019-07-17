package util;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;
    private Logger Log = Logger.getLogger(BrowserHelper.class);

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void goBack() {
        driver.navigate().back();
        Log.info("");
    }

    public void goForward() {
        driver.navigate().forward();
        Log.info("");
    }

    public void refresh() {
        driver.navigate().refresh();
        Log.info("");
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
        Log.info("");
    }

    public Set<String> getWindowHandlens() {
        Log.info("");
        return driver.getWindowHandles();
    }

    public void SwitchToWindow(int index) {

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());

        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid Index : " + index);

        driver.switchTo().window(windowsId.get(index));
        Log.info(index);
    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));
        Log.info("");
    }

    public void switchToParentWithChildClose() {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<String>(
                getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++) {
            Log.info(windowsId.get(i));
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }

    public Iterator<String> getAllWindows() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        return itr;
    }

    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
        Log.info(nameOrId);
    }
    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
        Log.info("Switched to Default window");
    }
}
