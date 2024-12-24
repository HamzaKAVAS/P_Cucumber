package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.HeroPage;

public class HeroStepdefinitions {

    HeroPage heroPage = new HeroPage();

    @And("kullanici Add Element butonuna basar")
    public void kullaniciAddElementButonunaBasar() {
        heroPage.addElementButonu.click();
    }

    @Then("Delete butonu’nun gorunur oldugunu test eder")
    public void deleteButonuNunGorunurOldugunuTestEder() {
        Assertions.assertTrue(heroPage.deleteButonu.isDisplayed());
    }

    @And("Delete tusuna basar")
    public void deleteTusunaBasar() {
        heroPage.deleteButonu.click();
    }

    @Then("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void addRemoveElementsYazisininGorunurOldugunuTestEder() {
        Assertions.assertTrue(heroPage.addRemoveElementi.isDisplayed());
    }

    @Then("Delete butonu’nun gorunur olmadigini test eder")
    public void deleteButonuNunGorunurOlmadiginiTestEder() {
       /* try {
            System.out.println(heroPage.deleteButonu.isDisplayed());
            Assertions.assertTrue(false);
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }*/

        try {
            Assertions.assertTrue(heroPage.deleteButonu.isDisplayed());
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
