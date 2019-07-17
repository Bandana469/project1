//package pages;
//
//import base.BasePage;
//import base.PageBase;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//public class SampleHomePage extends BasePage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//
//
//
//    @FindBy(xpath = "//*[@id=\"content\"]/h1")
//
//    private WebElement title;
//
//
//    public SampleHomePage(WebDriver driver) {
//
//
//        this.driver = driver;
//            wait = new WebDriverWait (driver, getTimeOutInSeconds());
//            PageFactory.initElements(driver, this);
//        } //super (driver);
//
//
//
//
//    public boolean seeIfTitlePresents() {
//
//        return title.isDisplayed ( );
//
//    }
//
//}