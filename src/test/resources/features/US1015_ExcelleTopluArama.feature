Feature: US1015 Kullanıcı excel olarak verilen ürünlerle arama testi yapar

  Scenario Outline: TC21 Kullanıcı exceldeki ürünleri istenen miktarda bulabilmeli
    
    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And urun excelindeki "<istenenSatir>" daki urunun min. miktarini ve urun ismini kaydeder
    And urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder
    Then bulunan urun sayisinin "<istenenSatir>" da verilen min. miktardan fazla oldugunu test eder
    And bulunan sonuc sayisini excel'de "<istenenSatir>" da ki 3.sutuna yazdirir
    #And sayfayi kapatir

    Examples:
      | istenenSatir |
      | 2            |
      | 3            |
      | 4            |
      | 5            |
      | 6            |
      | 7            |
      | 8            |
      | 9            |