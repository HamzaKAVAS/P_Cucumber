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

    @And("ilk urune tiklar")
    public void ilkUruneTiklar() {
        testotomasyonuPage.ilkUrunElementi.click();
    }

    @Then("acilan sayfada urun isminde case sensitive olmadan {string} bulundugunu test eder")
    public void acilanSayfadaUrunIsmindeCaseSensitiveOlmadanBulundugunuTestEder(String aranacakUrun) {
        String actualUrunIsim = testotomasyonuPage.IlkUrunSayfasindakiIsimElementi.getText().toLowerCase();
        Assertions.assertTrue(actualUrunIsim.contains(aranacakUrun));
    }

    @And("arama kutusuna test data dosyasindaki belirlenen kelimeyi yazip aratir")
    public void aramaKutusunaTestDataDosyasindakiBelirlenenKelimeyiYazipAratir() {
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
    }

    @Then("acilan sayfada urun isminde case sensitive olmadan test data dosyasindaki belirlenen kelimenin bulundugunu test eder")
    public void acilanSayfadaUrunIsmindeCaseSensitiveOlmadanTestDataDosyasindakiBelirlenenKelimeninBulundugunuTestEder() {
        String actualUrunIsmi = testotomasyonuPage.IlkUrunSayfasindakiIsimElementi.getText().toLowerCase();
        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));
    }

    @Given("kullanici test data dosyasinda verilen {string} anasayfaya gider")
    public void kullaniciTestDataDosyasindaVerilenAnasayfayaGider(String configIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configIstenenUrl));
    }

    @Then("url'in test data dosyasinda verilen {string} ile ayni oldugunu test eder")
    public void urlInTestDataDosyasindaVerilenIleAyniOldugunuTestEder(String configIstenenUrl) {
        String expectedUrl = ConfigReader.getProperty(configIstenenUrl);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @And("account butonuna basar")
    public void accountButonunaBasar() {
        testotomasyonuPage.accountLink.click();
    }

    @And("email olarak {string} girer")
    public void emailOlarakGirer(String kullanilacakEmail) {
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty(kullanilacakEmail));
    }

    @And("password olarak {string} girer")
    public void passwordOlarakGirer(String kullanilacakPassword) {
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty(kullanilacakPassword));
    }

    @And("signIn butonuna basar")
    public void signInButonunaBasar() {
        testotomasyonuPage.loginButonu.click();
    }

    @Then("basarili giris yapilabildigini test eder")
    public void basariliGirisYapilabildiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
    }

    @And("logout butonuna basar")
    public void logoutButonunaBasar() {
        testotomasyonuPage.logoutButonu.click();
    }

    @Then("sisteme giris yapamadigini test eder")
    public void sistemeGirisYapamadiginiTestEder() {
        Assertions.assertTrue(testotomasyonuPage.loginButonu.isDisplayed());
    }
}
