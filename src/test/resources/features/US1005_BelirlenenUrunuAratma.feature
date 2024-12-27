Feature: US1005 Kullanıcı belirlenen kelimeyi aratır

  Scenario: TC09 Kullanıcı belirlenen kelimeyi aratır ve bulunabildigini test eder

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna test data dosyasindaki belirlenen kelimeyi yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And ilk urune tiklar
    Then acilan sayfada urun isminde case sensitive olmadan test data dosyasindaki belirlenen kelimenin bulundugunu test eder
    #And sayfayi kapatir