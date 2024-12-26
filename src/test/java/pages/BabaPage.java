package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BabaPage {

    public BabaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@*='img/login.png']")
    public WebElement loginResimButonu;

    @FindBy(name = "username")
    public WebElement usernameKutusu;

    @FindBy(name = "password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@*='button']")
    public WebElement kayitSayfasiLoginButonu;

    @FindBy(xpath = "//*[@*='result']")
    public WebElement sonucYazisiElementi;



}
