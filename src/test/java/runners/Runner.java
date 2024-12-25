package runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("src/test/java")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "stepdefinitions")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@wip") // olmazsa feature altındaki bütün dosyaları çalıştırır
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport.html")
                   // HtmlReport ismini degistirirsek birden fazla htmlreports dosyası oluşur
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor.json")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber.xml")

public class Runner {

     /*
        Cucumber'daki Runner Class'i içinde hiçbir kod yazılmaz
        Görevi TestNG'deki.xml dosyalari gibi
        toplu çalıştırmayı sağlamaktır.

        Runner Class'i görevini
        kullanacagımız notasyonlar ile gerçekleştirir
     */

     /*
        @IncludeEngines("cucumber") : Class'ın cucumber ile calışmasını sağlar.
        @SelectClasspathResource("src/test/java") : Java Class'larını bulacağı dosya yolu.

        Constants.FEATURES_PROPERTY_NAME : "src/test/resources/features"
        Calıştırılacak feature dosyalarının yerini gösterir.

        Constants.GLUE_PROPERTY_NAME : "stepdefinitions"
        belirlenen feature dosyalarını çalıştırmak için
        kullanılacak stepdefinition'ların bulunduğu package'in dosya yolu

        EĞER sadece bu notasyonları kullanırsak,
        features klasoru içindeki tüm feature'ları çalıştırır.

        istediğimiz feature'ları çalıştırmak için cucumber 2 alternatif sunar
        1- istediğiniz feature'ları bir klasör içine koyup sadece o klasoru çalıştırmasını isteyebilirsiniz
        2- istediğiniz Feature veya Scenario'lari bir tag ile belirleyip,
           Constants.FILTER_TAGS_PROPERTY_NAME : "@smoke"

        EĞER Runner dosyası ile çalıştırdığımız feature dosyalarını
        SADECE eksik stepdefinition'ları bulmak ve method'larını oluşturmak için
        çalıştırıyorsak

        Constants.EXECUTION_DRY_RUN_PROPERTY_NAME : "true" yaparız
        dryRun değeri true iken Runner SADECE eksik adım kontrolü yapar
        Feature veya Scenario'ları çalıştırmaz
        eksik adım varsa failed diyip eksik adımları verir
        eksik adım yoksa passed diyip çalışmayı bitirir

     */
}
