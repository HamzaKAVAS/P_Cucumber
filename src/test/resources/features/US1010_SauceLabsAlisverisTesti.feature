Feature: US1010 Kullanıcı alısveris yapar

  Scenario: TC16 Kullanıcı istedigi urunu sepete ekledigini test eder

    Given kullanici test data dosyasinda verilen "sauceUrl" anasayfaya gider
    And senkronizasyon icin 2 saniye bekler
    And saucedemo username kutusuna "standard_user" yazar
    And saucedemo password kutusuna "secret_sauce" yazar
    And senkronizasyon icin 2 saniye bekler
    And saucedemo login tusuna basar
    And ilk urunun ismini kaydeder ve bu urunun sayfasina gider
    And saucedemo add to Cart butonuna basar
    And saucedemo alisveris sepetine tiklar
    And senkronizasyon icin 2 saniye bekler
    Then sectigi urunun basarili olarak sepete eklendigini test eder
    And senkronizasyon icin 2 saniye bekler
    And sayfayi kapatir