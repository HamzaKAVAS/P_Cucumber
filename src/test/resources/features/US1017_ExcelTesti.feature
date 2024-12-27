Feature: US1017 Kullanıcı excelden data kullanır ve test eder
  @wip
  Scenario: TC23 Kullanıcı exceldeki dataları test edebilmeli

    Given kullanici baskentler exceline ulasir
    And 1.satir 2.hucredeki datayi yazdirir
    And 1.satir 2.hucredeki datayi bir string degiskene kaydeder
    Then kaydedilen datanin "Başkent (İngilizce)" oldugunu test eder
    Then baskenti "Jakarta" olan ulkenin Turkce isminin "Endonezya" oldugunu test eder
    Then excelde kayitli ulke sayisinin 190 oldugunu test eder
    Then excelde kullanilan fiziki satir sayisinin 191 oldugunu test eder
    And Tum bilgileri map olarak kaydedip
    And Ingilizce baskent "Jakarta" olan ulkenin tum bilgilerini yazdirir
    Then mapi kullanarak Turkce ismi "Hollanda" olan bir ulke bulundugunu test eder