package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
        // Singleton pattern ile bu class'dan obje oluşturulabilmesini engellemek için
        // Constructor'ı görünür yapıp kimsenin erişememesi için private işaretliyoruz
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
         /*
             Bu method'u her kullandığımızda new ChromeDriver(); çalışınca
             yeni bir browser açılıyor

             Biz sadece ilk defa bu method'u kullandığımızda
             new ChromeDriver(); çalışsın,
             sonraki kullanımlarda çalışmasın istiyoruz
         */

         /*
             Driver'ın her seferinde chrome olması yerine
             configuration.properties'de browser key'in değeri ne ise
             browser'ın dinamik olarak o değer olmasını istiyoruz

             browser'ın dinamik olması için
             once configuration.properties'deki browser değerini alalım
             ve bir switch ile hangi browser istenmiş ise ona ait bir WebDriver oluşturalım
         */

        String calisacakBrowser = ConfigReader.getProperty("browser");

        if (driver == null) {

            switch (calisacakBrowser) {
                case "safari":
                    driver = new SafariDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver() {
        driver.quit(); // açık olan browserları kapatır
        driver = null; // bu Class'daki driver objesine null değeri atayarak
        // yeni browser açılmasına imkan tanır
    }
}
