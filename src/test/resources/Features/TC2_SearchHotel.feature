@SearchHotel
Feature: Verifying Adactin Hotel Search Hotel details

  Scenario Outline: Verifying Adactin search Hotel by select all fields
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      | 1 - One          |

  Scenario Outline: Verifying Adactin search Hotel by select only mandatory fields
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform only mandatory fields "<location>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" and "<adultPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"

    Examples: 
      | userName  | password  | location | numberOfRoom | checkInDate | checkOutDate | adultPerRoom |
      | Krishhh95 | 123456789 | Sydney   | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      |

 @reg
  Scenario Outline: Verifying Adactin search hotel by invalid date checking
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify error message after search hotel by using invalid date "Check-In Date shall be before than Check-Out Date" , "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2024  | 04/01/2023   | 1 - One      | 1 - One          |

  Scenario Outline: Verifying Adactin search hotel without enter any fields
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel without Enter any fields
    Then User should verify error message after search hotel in location field "Please Select a Location"

    Examples: 
      | userName  | password  |
      | Krishhh95 | 123456789 |
