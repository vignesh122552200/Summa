@BookHotel
Feature: Verifying Adactin Book Hotel details
	
  Scenario Outline: Verifying Adactin Book Hotel by select all fields
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"
    And User should perform select hotel and continue
    Then User should verify sucess message after continue "Book A Hotel"
    And User should perform book hotel "<firstName>" , "<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cVVNumber |
      | 8789876545678765 | VISA             | January     |       2022 |      9875 |
      | 7689875435678906 | American Express | February    |       2022 |      9376 |
      | 6689815535678906 | Master Card      | January     |       2022 |      1878 |
      | 8689815535678906 | Others           | May         |       2022 |      4555 |
    Then User should verify sucess message after book hotel "Booking Confirmation" and save the order id

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom | firstName | lastName | billingAddress    |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      | 1 - One          | Vignesh   | Elumalai | 7072, 17th street |
	@sanity
  Scenario Outline: Verifying Adactin Book a Hotel without select any fields
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"
    And User should perform select hotel and continue
    Then User should verify sucess message after continue "Book A Hotel"
    And User should perform book hotel without select any fields
    Then User should verify error message after book hotel "Please Enter your First Name" , "Please Enter you Last Name" , " Please Enter your Address" , "Please Enter your 16 Digit Credit Card Number" , "Please Select your Credit Card Type" , "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      | 1 - One          |
