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
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@paralel1") // olmazsa feature altındaki bütün dosyaları çalıştırır
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")

//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/HtmlReport1.html")
                     // HtmlReport ismini degistirirsek birden fazla htmlreports dosyası oluşur
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, json:target/json-reports/cucumberRapor1.json")
//@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, junit:target/xml-report/cucumber1.xml")

public class ParalelRun1 {
     /*
         Cucumber'da toplu çalıştırmayı Runner Class'ından yapıyoruz

         Paralel olarak birden fazla browser'ın çalışması için
         birden fazla Runner Class hazırlamalıyız

         Birden fazla Runner Class'ı olduğunda hepsini birlikte manuel olarak
         olarak çalıştırmamız MÜMKÜN olmadığından
         Terminal'den bu Runner Class'larını çalıştırabileceğimiz bir yapı oluşturmalıyız

         Terminalden Runner Class çalıştırmak için
         1- Maven'ı sistem değişkenlerine eklemeliyiz
         2- pom.xml'e terminalden çalıştırmayı sağlayacak
            ve bize güzel Html raporlar oluşturacak bazi plug-in'leri eklemeliyiz
         3- Eklediğimiz plug-in'lerde çalışacak Runner adedi ve çalışacak Runner'ların
            bulunduğu yer ve isimlerindeki ortak bölümü güncellememiz gerekir
         4- Terminalden mvn clean verify yazarak
            plug-in'ler üzerinden istenen Runner Class'lar çalıştırılabilir
     */

}
