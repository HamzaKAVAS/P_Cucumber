Feature: US1001 Testotomasyonu phone arama testi
  @paralel1
  Scenario: TC01 kullanici testotomasyonu sitesinde phone bulabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna phone yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    #And sayfayi kapatir

  @paralel1
  Scenario: TC02 kullanici testotomasyonu sitesinde dress bulabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    #And sayfayi kapatir

  @paralel1
  Scenario: TC03 kullanici testotomasyonu sitesinde java bulamamali

    Given kullanici testotomasyonu anasayfaya gider
    And arama kutusuna java yazip aratir
    Then arama sonucunda urun bulunamadigini test eder
    #And sayfayi kapatir