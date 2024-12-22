package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebDriverUniversityPage {

    public WebDriverUniversityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='LOGIN PORTAL']")
    public WebElement loginPortal;

    @FindBy(xpath = "//*[@*='Username']")
    public WebElement usernameElement;

    @FindBy(xpath = "//*[@*='Password']")
    public WebElement passwordElement;

    @FindBy(id = "login-button")
    public WebElement nextLogin;

}
