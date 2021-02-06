Feature: Add new payee under pay bills

  Background:
    Given the user is on the login page
    When the user enters the user "username"

  @wip
  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      | Payee_Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee_Address | 100 Same st, Anytown, USA, 10001         |
      | Payee_Account | Checking                                 |
      | Payee_Details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created" should be displayed