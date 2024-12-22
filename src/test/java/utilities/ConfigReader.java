package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     /*
             Bu Class'ın iki temel görevi var

          1- configuration.properties dosyasındaki bilgileri okumak
             ConfigReader çalıştırıldığında ONCELİKLE bu okuma işleminin yapılması için
             okuma işlemini bir static blok içerisinde yapıyoruz

             static blok çalıştığında
             configuration.properties dosyasındaki tüm key - value ikililerini okuyup
             Class levelda bulunan "properties" objesine yüklüyor

          2- ilk görevde configuration.properties dosyasındaki
             tüm key - value ikilileri okunup properties objesine yuklendi

             getProperty(istenenKey) method'u ise
             properties objesine yüklenen key - value'lerden
             bizim vereceğimiz key'in karşılığındaki value'yu alıp
             test methodu'una döndürür
     */

    static Properties properties; // configuration.properties'deki tüm key - value'ler yüklendi

    static {// static blok herseyden once calisir
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    // static block calisip, Java FileInputStream sayesinde
    // configuration.properties dosyasindaki tum Key- Value'leri alip
    // properties objesine yukledi
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
