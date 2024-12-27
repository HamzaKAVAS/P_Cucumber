package stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelStepdefinitions {

    Workbook workbook;
    Sheet sayfa1;
    String actualHucreData;

    @Given("kullanici baskentler exceline ulasir")
    public void kullanici_baskentler_exceline_ulasir() throws IOException {
        String excelDosyaYolu = "src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");
    }

    @Given("{int}.satir {int}.hucredeki datayi yazdirir")
    public void satir_hucredeki_datayi_yazdirir(Integer satirNo, Integer hucreNo) {
        System.out.println(satirNo + ".satır " + hucreNo + ".hücredeki bilgi: " + sayfa1.getRow(satirNo-1).getCell(hucreNo-1));
    }

    @Given("{int}.satir {int}.hucredeki datayi bir string degiskene kaydeder")
    public void satir_hucredeki_datayi_bir_string_degiskene_kaydeder(Integer satirNo, Integer hucreNo) {
        actualHucreData = sayfa1.getRow(satirNo-1).getCell(hucreNo-1).getStringCellValue();
    }

    @Then("kaydedilen datanin {string} oldugunu test eder")
    public void kaydedilen_datanin_oldugunu_test_eder(String expectedHucreData) {
        Assertions.assertEquals(expectedHucreData,actualHucreData);
    }

    @Then("baskenti {string} olan ulkenin Turkce isminin {string} oldugunu test eder")
    public void baskenti_olan_ulkenin_turkce_isminin_oldugunu_test_eder(String verilenIngilizceBaskent, String expectedTurkceUlkeIsmi) {
        for (int i = 0; i < sayfa1.getLastRowNum(); i++) {
            String satirdakiIngilizceBaskent = sayfa1.getRow(i).getCell(1).getStringCellValue();
            if (satirdakiIngilizceBaskent.equals(verilenIngilizceBaskent)){
                String satirdakiTurkceUlkeIsmi = sayfa1.getRow(i).getCell(2).getStringCellValue();
                Assertions.assertEquals(expectedTurkceUlkeIsmi,satirdakiTurkceUlkeIsmi);
                break;
            }
        }
    }

    @Then("excelde kayitli ulke sayisinin {int} oldugunu test eder")
    public void excelde_kayitli_ulke_sayisinin_oldugunu_test_eder(Integer int1) {

    }

    @Then("excelde kullanilan fiziki satir sayisinin {int} oldugunu test eder")
    public void excelde_kullanilan_fiziki_satir_sayisinin_oldugunu_test_eder(Integer int1) {

    }

    @Then("Tum bilgileri map olarak kaydedip")
    public void tum_bilgileri_map_olarak_kaydedip() {

    }

    @Then("Ingilizce baskent {string} olan ulkenin tum bilgilerini yazdirir")
    public void ingilizce_baskent_olan_ulkenin_tum_bilgilerini_yazdirir(String string) {

    }

    @Then("mapi kullanarak Turkce ismi {string} olan bir ulke bulundugunu test eder")
    public void mapi_kullanarak_turkce_ismi_olan_bir_ulke_bulundugunu_test_eder(String string) {

    }

}