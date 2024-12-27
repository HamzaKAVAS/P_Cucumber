
Feature: US1008 Kullanıcı yanlış bilgilerle giriş yapamaz

  Scenario: TC12 Kullanıcı yanlış password ile giriş yapamamalı

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecersizPassword" girer
    And signIn butonuna basar
    Then sisteme giris yapamadigini test eder
    And senkronizasyon icin 3 saniye bekler
    #And sayfayi kapatir

  Scenario: TC13 Kullanıcı yanlış email ile giriş yapamamalı

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And account butonuna basar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecerliPassword" girer
    And signIn butonuna basar
    Then sisteme giris yapamadigini test eder
    And senkronizasyon icin 3 saniye bekler
    #And sayfayi kapatir

  Scenario: TC14 Kullanıcı yanlış password ve yanlıs email ile giriş yapamamalı

    Given kullanici test data dosyasinda verilen "toUrl" anasayfaya gider
    And account butonuna basar
    And email olarak "toGecersizEmail" girer
    And password olarak "toGecersizPassword" girer
    And signIn butonuna basar
    Then sisteme giris yapamadigini test eder
    And senkronizasyon icin 3 saniye bekler
    #And sayfayi kapatir