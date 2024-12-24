package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucePage {

    public SaucePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "login-button")
    public WebElement anasayfaLoginButonu;

    @FindBy(xpath = "(//*[@*='inventory_item_name '])[1]")
    public WebElement ilkUrunIsimElementi;

    @FindBy(id = "add-to-cart")
    public WebElement ilkUrunAddtoCartButonu;

    @FindBy(className = "shopping_cart_link")
    public WebElement alisverisSepetiButonu;

    @FindBy(className = "inventory_item_name")
    public WebElement sepetteOlanIlkUrunIsimElementi;

}
