
Feature: Users should be able to login


  @login
  Scenario: Authorized users should be able to login to the application
    Given the user is on the login page
    When the user enters the user "username"
    Then the "username" should be able to login