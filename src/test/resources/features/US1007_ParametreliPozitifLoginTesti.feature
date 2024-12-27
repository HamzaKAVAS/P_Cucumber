Feature: US1007 Kullanıcı geçerli bilgilerle sisteme giriş yapar

  Scenario: TC11 geçerli bilgilerle sisteme giriş yapılabilmeli

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecerliPassword" girer
    And signIn butonuna basar
    Then basarili giris yapilabildigini test eder
    And senkronizasyon icin 3 saniye bekler
    And logout butonuna basar
    #And sayfayi kapatir