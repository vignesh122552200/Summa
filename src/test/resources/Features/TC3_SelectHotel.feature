@SelectHotel
Feature: Verifying Adactin select Hotel details
	@smoke
  Scenario Outline: Verifying Adactin select Hotel and continue
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"
    And User should perform select hotel and continue
    Then User should verify sucess message after continue "Book A Hotel"

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      | 1 - One          |

  Scenario Outline: Verifying Adactin without select hotel and continue
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"
    And User should perform search hotel "<location>" , "<hotels>" , "<rommType>" , "<numberOfRoom>" , "<checkInDate>" , "<checkOutDate>" , "<adultPerRoom>" and "<childerenPerRoom>"
    Then User should verify after search hotel sucess message "Select Hotel"
    And User should perform continue
    Then User should verify error message after continue "Please Select a Hotel"

    Examples: 
      | userName  | password  | location | hotels      | rommType | numberOfRoom | checkInDate | checkOutDate | adultPerRoom | childerenPerRoom |
      | Krishhh95 | 123456789 | Sydney   | Hotel Creek | Standard | 1 - One      | 03/01/2023  | 04/01/2023   | 1 - One      | 1 - One          |
