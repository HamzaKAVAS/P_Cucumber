Feature: US1018 Kullanıcı demoqa sayfasındaki butonları kullanır

  Scenario: TC24 Kullanıcı butonların çalıştığını test edebilmeli

    Given kullanici test data dosyasinda verilen "demoqaUrl" anasayfaya gider
    And soldaki sekmelerden Alerts'e tiklar
    And On button click, alert will appear after bes seconds karsisindaki click me butonuna basar
    And Allert’in gorunur olmasini bekler
    Then Allert uzerindeki yazinin "This alert appeared after 5 seconds" oldugunu test edin
    And Ok diyerek alerti kapatir