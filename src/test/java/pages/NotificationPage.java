package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {



    public class SwitchLoginpage extends PageBase {
        private WebDriver driver;



        @FindBy(id ="//*[@id=\"tms-notifications-container\"]/div/div/div/div/div[1]/div/h1[1]")
        private WebElement message1;
        @FindBy(xpath="//*[@id=\"tms-notifications-container\"]/div/div/div/div/div[1]/div/p[2]")
        private WebElement message2;
        @FindBy(xpath ="//*[@id=\"tms-notifications-container\"]/div/div/div/div/div[1]/div/p")
        private WebElement message3;
        @FindBy(id = "//*[@id=\"tms-notifications-container\"]/div/div/div/div/div[2]/div[1]/button")
        private WebElement acknowledgeButton;


        public SwitchLoginpage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }







    }


}
