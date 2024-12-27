Feature: US1013 Kullanıcı belirlenen miktarda ürün bulabilmeli

  Scenario Outline: TC19 kullanıcı arattıgı urunlerin belirlenen miktar veya daha fazla bulunabildigini test edebilmeli

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And arama kutusuna "<aranacakKelime>" yazip aratir
    Then arama sonucunda "<belirlenenMiktar>" veya daha fazla urun bulunabildigini test eder
    And senkronizasyon icin 2 saniye bekler
    #And sayfayi kapatir

    Examples:
    |aranacakKelime|belirlenenMiktar|
    |phone         |3               |
    |dress         |8               |
    |java          |0               |
    |samsung       |2               |
    |baby          |1               |