Feature: US1004 Kullanıcı istediği ürünü aratır ve test eder

  Scenario: TC08 Kullanıcı istediği ürünü aratıp, bulduğu ürünü test edebilmeli

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna "dress" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And ilk urune tiklar
    Then acilan sayfada urun isminde case sensitive olmadan "dress" bulundugunu test eder
    And senkronizasyon icin 2 saniye bekler
    And sayfayi kapatir
