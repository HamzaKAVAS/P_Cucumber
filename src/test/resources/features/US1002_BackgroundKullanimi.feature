Feature: US1002 ortak baslangic adimlari background olarak yazilabilir

  Background:
    Given kullanici testotomasyonu anasayfaya gider

  Scenario: TC04 kullanici testotomasyonu sitesinde phone bulabilmeli

    And arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

  Scenario: TC05 kullanici testotomasyonu sitesinde dress bulabilmeli

    And arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

  Scenario: TC06 kullanici testotomasyonu sitesinde java bulamamali

    And arama kutusuna java yazip aratir
    Then arama sonucunda urun bulunamadigini test eder
    And sayfayi kapatir
