package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestotomasyonuStepdefinitions {

    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
    String satirdakiUrunIsmi;
    double satirdaBulunacakMinUrunMiktari;
    double actualSonucSayisi;
    Sheet calisanSayfa;
    Workbook workbook;

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

    @Then("arama sonucunda {string} veya daha fazla urun bulunabildigini test eder")
    public void aramaSonucundaVeyaDahaFazlaUrunBulunabildiginiTestEder(String belirlenenMiktarStr) {
        String actualSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();
        String actualSonucYazisiStr = actualSonucYazisi.replaceAll("\\D", "");
        int actualSonucSayisi = Integer.parseInt(actualSonucYazisiStr);
        int expectedMinSonucSayisi = Integer.parseInt(belirlenenMiktarStr);
        Assertions.assertTrue(actualSonucSayisi >= expectedMinSonucSayisi);
    }

    @When("email olarak listede verilen {string} girer")
    public void emailOlarakListedeVerilenGirer(String verilenEmail) {
        testotomasyonuPage.emailKutusu.sendKeys(verilenEmail);
    }

    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String verilenPassword) {
        testotomasyonuPage.passwordKutusu.sendKeys(verilenPassword);
    }

    @And("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urunExcelindekiDakiUrununMinMiktariniVeUrunIsminiKaydeder(String excelSatirNoStr) throws IOException {
        String dosyaYolu = "src/test/resources/urunListesi.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        calisanSayfa = workbook.getSheet("Sheet1");

        int satirNo = Integer.parseInt(excelSatirNoStr); // 2
        satirdakiUrunIsmi = calisanSayfa.getRow(satirNo-1).getCell(0).getStringCellValue();
        satirdaBulunacakMinUrunMiktari = calisanSayfa.getRow(satirNo-1).getCell(1).getNumericCellValue();
    }

    @And("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urunIsminiTestotomasyonuSayfasindaArarVeSonucSayisiniKaydeder() {
        testotomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
        String actualUrunSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();
        String actualUrunSonucSayisiStr = actualUrunSonucYazisi.replaceAll("\\D","");
        actualSonucSayisi = Double.parseDouble(actualUrunSonucSayisiStr);
    }

    @Then("bulunan urun sayisinin {string} da verilen min. miktardan fazla oldugunu test eder")
    public void bulunanUrunSayisininDaVerilenMinMiktardanFazlaOldugunuTestEder(String satirNoStr) {
        Assertions.assertTrue( actualSonucSayisi >= satirdaBulunacakMinUrunMiktari);
    }

    @And("bulunan sonuc sayisini excel'de {string} da ki {int}.sutuna yazdirir")
    public void bulunanSonucSayisiniExcelDeDaKiSutunaYazdirir(String satirNoStr, int sutunNo) throws IOException {
        int satirNo = Integer.parseInt(satirNoStr);
        calisanSayfa.getRow(satirNo-1).createCell(sutunNo-1).setCellValue(actualSonucSayisi);
        String excelDosyaYolu = "src/test/resources/urunListesi.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }
}
