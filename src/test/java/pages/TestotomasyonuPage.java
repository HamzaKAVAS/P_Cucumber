package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonuPage {

     /*
         Page Class'larında locate yapabilmesi için
         WebDriver objemizi bu Class'a tanıtmamız gerekiyor

         Bu tanıtma işlemini yapmak için Constructor içi tercih edilmiş
         bu işlemin sebebi Test Class'larından Page Class'ına ulaşmak için
         obje oluşturma yöntemini kullanmamızdır
         Test Class'ından Page Class'ından obje oluşturmak için
         Constructor çalıştığında Constructor içine koyduğumuz
         initElements() çalışır ve Page Class'ına WebDriver objemizi tanıtır

         Bir Page Class'ı oluşturduğumuzda ILK YAPILMASI GEREKEN IŞLEM
         Constructor'ı görünür hale getirip içerisinde initElements() method'u ile
         WebDriver'ı tanıtmak olacaktır.
     */

    public TestotomasyonuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement aramaSonucuElementi;

    @FindBy(xpath = "(//*[@class='prod-img'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement IlkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLink;

    @FindBy(id = "email")
    public WebElement emailKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;

}
