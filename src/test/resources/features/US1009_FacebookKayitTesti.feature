Feature: US1009 Kullanıcı fake bilgilerle kayıt olusturmayı dener

  Scenario: TC15 kullanıcı fake bilgilerle kayıt olusturabilmeli

    Given kullanici test data dosyasinda verilen "faceUrl" anasayfaya gider
    And facebook'da yeni hesap olustur butonuna basar
    And senkronizasyon icin 1 saniye bekler
    And faker class'dan bilgilerle facebook kayit formunu doldurur
    And senkronizasyon icin 2 saniye bekler
    And facebook kayit ol tusuna basar
    And senkronizasyon icin 2 saniye bekler
    And sayfayi kapatir