Feature: Kullanici login bilgileri ile giriş yapmayı dener

  Scenario Outline: Kullanıcı yanlış bilgilerle giriş yapamadıgını dogrular

    Given kullanici test data dosyasinda verilen "babayigitTest" anasayfaya gider
    Then kullanici login butonuna tiklar
    Then kullanici username olarak "<username>" girer
    Then kullanici sifre olarak "<password>" girer
    Then kullanici kayit sayfasindaki login butonuna tiklar
    Then kullanici giris yapılamadigini dogrular
    Then sayfayi kapatir

    Examples:
      | username | password |
      | mubam    | 12345    |
      | alim     | hnfg     |
      | kafi     | Kfimtrak |