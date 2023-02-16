@Login
Feature: Verifying Adactin Hotel Login details

  Scenario Outline: Verifying Adactin Hotel Login valid
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login success message "Hello krishhh95!"

    Examples: 
      | userName  | password  |
      | Krishhh95 | 123456789 |
	
  Scenario Outline: Verifying Adactin Hotel Login using Enter
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>" with Enter key
    Then User should verify after login success message "Hello krishhh95!"

    Examples: 
      | userName  | password  |
      | Krishhh95 | 123456789 |

  Scenario Outline: Verifying Adactin Hotel Login Invalid credential
    Given User is on the Adactin page
    When User should perform login "<userName>" , "<password>"
    Then User should verify after login with invalid credential error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName | password     |
      | Gopi123  | goodluck@123 |
