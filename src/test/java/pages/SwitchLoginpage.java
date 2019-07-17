package pages;


import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SwitchLoginpage extends PageBase {
    private  WebDriver driver;



    @FindBy(id ="SectionContent")
    private WebElement loginForm;
    @FindBy(xpath="//input[@name='ctl00$BodyContent$UserName']")
    private WebElement usernamefield;
    @FindBy(xpath ="//input[@name='ctl00$BodyContent$Password']")
    private WebElement passwordField;
    @FindBy(id = "ctl00_BodyContent_LoginButton")
    private WebElement loginButton;
    @FindBy(xpath="//*[@class='main-content']")
    private WebElement alertPage;
    @FindBy(xpath="//*[@id=\"contentheader\"]")
    private WebElement agreement;

    public SwitchLoginpage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    public void login(String username, String password) {
        usernamefield.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }



}

