Feature: login validation
@login
  Scenario: Verify valid credentials
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin123"
    Then the user should successfully login to the application

  Scenario: Verify Invalid credentials
    Given User is on the login page
    When the user tries to login the application with "Admin" and "admin234"
    Then the user should successfully login to the applicat ion
@multiLogin
  Scenario: Verify multiple credentials
    Given User is on the login page
    When the user tries to login the application with following credentials
    |username|password|
    |Admin   |admin123|
    |shini   |shini   |
    Then the user should successfully login to the application
