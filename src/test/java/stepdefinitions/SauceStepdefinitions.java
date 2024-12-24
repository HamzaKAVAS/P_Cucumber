package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.SaucePage;

public class SauceStepdefinitions {

    SaucePage saucePage = new SaucePage();
    String ilkUrunIsimElementiYazisi;

    @Given("saucedemo username kutusuna {string} yazar")
    public void saucedemo_username_kutusuna_yazar(String username) {
        saucePage.usernameKutusu.sendKeys(username);
    }

    @Given("saucedemo password kutusuna {string} yazar")
    public void saucedemo_password_kutusuna_yazar(String password) {
        saucePage.passwordKutusu.sendKeys(password);
    }

    @Given("saucedemo login tusuna basar")
    public void saucedemo_login_tusuna_basar() {
        saucePage.anasayfaLoginButonu.click();
    }

    @Given("ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {
        ilkUrunIsimElementiYazisi = saucePage.ilkUrunIsimElementi.getText();
        saucePage.ilkUrunIsimElementi.click();
    }

    @Given("saucedemo add to Cart butonuna basar")
    public void saucedemo_add_to_cart_butonuna_basar() {
        saucePage.ilkUrunAddtoCartButonu.click();
    }

    @Given("saucedemo alisveris sepetine tiklar")
    public void saucedemo_alisveris_sepetine_tiklar() {
        saucePage.alisverisSepetiButonu.click();
    }

    @Then("sectigi urunun basarili olarak sepete eklendigini test eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_test_eder() {
        String sepetteOlanIlkUrunElementiYazisi = saucePage.sepetteOlanIlkUrunIsimElementi.getText();
        Assertions.assertEquals(ilkUrunIsimElementiYazisi, sepetteOlanIlkUrunElementiYazisi);
    }
}
