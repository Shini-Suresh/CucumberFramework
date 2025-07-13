Feature:Admin page scenarios

  Background:
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin123"
    And user navigates to Admin page

  @Admin
  Scenario: Verify user details
    And user searches for a user with username "Admin"
    Then user should see the user details

  @Admin
  Scenario: Verify user details
    And user searches for a user with username "shini"
    Then user should see the user details