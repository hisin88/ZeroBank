Feature: Account Summary Activity

  Background:
    Given the user is on the login page
    When the user enters the user "username"


  Scenario: Checking the account summary page features
    Given the user navigates to Account Summary page
    Then The page should have the title "Zero - Account Summary"
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |
  @wip
  Scenario: Checking the account activity page features
    Given the user navigates to Account Activity page
    Then The page should have the title "Zero - Account Activity"
    And In the Account drop down option should be "Savings"
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
