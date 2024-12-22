package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestotomasyonuStepdefinitions {

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullaniciTestotomasyonuAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @And("arama kutusuna phone yazip aratir")
    public void aramaKutusunaPhoneYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void aramaSonucundaUrunTestEder() {
        String unExpectedUrun = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualUrunYazi = testotomasyonuPage.aramaSonucuElementi.getText();
        Assertions.assertNotEquals(unExpectedUrun, actualUrunYazi);
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }

    @And("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
    }

    @And("arama kutusuna java yazip aratir")
    public void aramaKutusunaJavaYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys("java" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {
        String expectedUrun = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualUrunYazisi = testotomasyonuPage.aramaSonucuElementi.getText();
        Assertions.assertEquals(expectedUrun, actualUrunYazisi);
    }

    @And("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String aranacakUrun) {
        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
    }

    @And("senkronizasyon icin {int} saniye bekler")
    public void senkronizasyonIcinSaniyeBekler(int beklemeSuresi) {
        ReusableMethods.bekle(beklemeSuresi);
    }
}
