Feature: US1012 Kullanıcı liste olarak verilen ürünleri aratır

  Scenario Outline: TC18 Kullanıcı liste olarak verilen ürünleri aratabilmeli

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And arama kutusuna "<aratilacakKelime>" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And senkronizasyon icin 1 saniye bekler
    And sayfayi kapatir

    Examples:
    |aratilacakKelime|
    |phone           |
    |samsung         |
    |apple           |
    |bag             |