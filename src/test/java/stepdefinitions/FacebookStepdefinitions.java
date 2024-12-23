package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.FacebookPage;
import utilities.Driver;

public class FacebookStepdefinitions {

    FacebookPage facebookPage = new FacebookPage();

    @And("facebook'da yeni hesap olustur butonuna basar")
    public void facebookDaYeniHesapOlusturButonunaBasar() {
        facebookPage.yeniHesapOlusturButonu.click();
    }

    @And("faker class'dan bilgilerle facebook kayit formunu doldurur")
    public void fakerClassDanBilgilerleFacebookKayitFormunuDoldurur() {
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(facebookPage.firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("Tem")
                .sendKeys(Keys.TAB)
                .sendKeys("1992")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();
    }

    @And("facebook kayit ol tusuna basar")
    public void facebookKayitOlTusunaBasar() {
        facebookPage.kayitOlButonu.click();
    }
}
