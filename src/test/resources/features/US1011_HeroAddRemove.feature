Feature: US1011 Kullanıcı butonları çalıştırır

  Scenario: TC17 Kullanıcı butonları kullanabilmeli

    Given kullanici test data dosyasinda verilen "heroUrl" anasayfaya gider
    And kullanici Add Element butonuna basar
    And senkronizasyon icin 2 saniye bekler
    Then Delete butonu’nun gorunur oldugunu test eder
    And Delete tusuna basar
    Then Add Remove Elements yazisinin gorunur oldugunu test eder
    And senkronizasyon icin 2 saniye bekler
    Then Delete butonu’nun gorunur olmadigini test eder
    #And sayfayi kapatir