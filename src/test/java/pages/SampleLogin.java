package pages;

import base.BasePage;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.*;

public class SampleLogin extends BasePage {
 WebDriver driver;
 WebDriverWait wait;


    public SampleLogin(WebDriver idriver) {
        this.driver = idriver;
        PageFactory.initElements (driver, this);
    }
    @FindBy(id = "usr")
    WebElement userName;

    @FindBy(id = "pwd")
    WebElement passKey;

    @FindBy(xpath = "//*[@id=\"case_login\"]/form/input[3]")
    WebElement submit;




    public void loginAndSubmit(String user, String pass) throws Exception {
        userName.sendKeys(user);
        Thread.sleep(8000);
        passKey.sendKeys(pass);
        Thread.sleep(8000);
        submit.click();
    }

}
