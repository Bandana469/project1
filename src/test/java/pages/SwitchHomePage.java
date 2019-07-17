package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.WebDriverWait;


public class SwitchHomePage extends PageBase {

    @FindBy(xpath = "//*[@id=\"contentheader\"]/h1")

    private WebElement agreement;

    @FindBy(xpath = "//*[@id=\"ctl00_BodyContent_Disagree\"]")

    private WebElement cancelagreement;

    @FindBy(xpath = "//*[@id=\"ctl00_BodyContent_Agree\"]")

    private WebElement agreeButton;
    @FindBy(id="ctl00_ctl00_TopMenu")

    private WebElement landingPage;

    public SwitchHomePage(WebDriver driver) {
        super (driver);


       WebDriverWait wait = new WebDriverWait (driver, 120);
 }


    public boolean seeIfTitlePresents() {

        return agreement.isDisplayed ( );

    }

    public void clickAgreement() {

        if (agreement.isEnabled ()) {
            agreeButton.click ( );
        }
        else {
            System.out.println ("agreement was not visible");
            System.out.println("yay, I am inside  a landing page");
        }

    }


    public void setCancelAgreement() {
        //wait.until(ExpectedConditions.visibilityOf (agreement));
        if (agreement.isEnabled ()) {
            cancelagreement.click ();
        }
        else {
            System.out.println ("agreement was not visible");
            System.out.println("yay, I am inside  a landing page");
        }

    }



    public boolean goToLandingPage() {
        return  landingPage.isDisplayed ();

    }

}
