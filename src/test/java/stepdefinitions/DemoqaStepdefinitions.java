package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoqaPage;
import utilities.Driver;

import java.time.Duration;

public class DemoqaStepdefinitions {

    DemoqaPage demoqaPage = new DemoqaPage();
    WebDriverWait wait;

    @Then("soldaki sekmelerden Alerts'e tiklar")
    public void soldaki_sekmelerden_alerts_e_tiklar() {
        demoqaPage.alertsButton.click();
    }

    @When("On button click, alert will appear after bes seconds karsisindaki click me butonuna basar")
    public void on_button_click_alert_will_appear_after_seconds_karsisindaki_click_me_butonuna_basar() {
        demoqaPage.onButtonClickMe.click();
    }

    @When("Allert’in gorunur olmasini bekler")
    public void allert_in_gorunur_olmasini_bekler() {
        wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("Allert uzerindeki yazinin {string} oldugunu test edin")
    public void allert_uzerindeki_yazinin_oldugunu_test_edin(String expectedAlertYazi) {
        String actualAlertYazi = Driver.getDriver().switchTo().alert().getText();
        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);
    }

    @Then("Ok diyerek alerti kapatir")
    public void ok_diyerek_alerti_kapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }
}
