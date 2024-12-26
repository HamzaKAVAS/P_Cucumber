package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.BabaPage;

public class babayigitStepdefinitions {

    BabaPage babaPage = new BabaPage();

    @Then("kullanici login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        babaPage.loginResimButonu.click();
    }

    @Then("kullanici username olarak {string} girer")
    public void kullaniciUsernameOlarakGirer(String kullaniciAdi) {
        babaPage.usernameKutusu.sendKeys(kullaniciAdi);
    }

    @Then("kullanici sifre olarak {string} girer")
    public void kullaniciSifreOlarakGirer(String kullaniciSifresi) {
        babaPage.passwordKutusu.sendKeys(kullaniciSifresi);
    }

    @Then("kullanici kayit sayfasindaki login butonuna tiklar")
    public void kullaniciKayitSayfasindakiLoginButonunaTiklar() {
        babaPage.kayitSayfasiLoginButonu.click();
    }

    @Then("kullanici giris yapılamadigini dogrular")
    public void kullaniciGirisYapilamadiginiDogrular() {
            String sonucYazisi = babaPage.sonucYazisiElementi.getText();
            System.out.println(sonucYazisi);
            Assertions.assertTrue(babaPage.sonucYazisiElementi.isDisplayed());
    }

}
