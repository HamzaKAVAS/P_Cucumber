Feature: US1006 Kullanıcı Url'i dinamik olarak girer

  Scenario: TC10 Kullanıcı Url'i config dosyasından dinamik olarak kullanabilmeli

    Given kullanici test data dosyasinda verilen "zeroUrl" anasayfaya gider
    Then url'in test data dosyasinda verilen "zeroUrl" ile ayni oldugunu test eder
    And senkronizasyon icin 5 saniye bekler
    And sayfayi kapatir