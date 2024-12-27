Feature: US1003 kullanici parametre olarak istedigi kelimeyi girip aratir

  Scenario: TC07 parametre ile urun aratilabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna "baby" yazip aratir
    And senkronizasyon icin 3 saniye bekler
    Then arama sonucunda urun bulunabildigini test eder
    #And sayfayi kapatir

  Scenario: TC08 urun testi

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna "java" yazip aratir
    And senkronizasyon icin 4 saniye bekler
    Then arama sonucunda urun bulunamadigini test eder
    #And sayfayi kapatir

