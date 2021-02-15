@wip
Feature: Navigating to specific accounts in Accounts Activity
Background:
Given the user is on the login page
When the user enters the user "username"

Scenario: Savings account redirect
And the user navigates to Account Summary page
When the user clicks on "Savings" link on the Account Summary page
Then Account drop down should have "Savings" selected

Scenario: Brokerage account redirect
And the user navigates to Account Summary page
When the user clicks on "Brokerage" link on the Account Summary page
And Account drop down should have "Brokerage" selected

Scenario: Checking account redirect
And the user navigates to Account Summary page
When the user clicks on "Checking" link on the Account Summary page
And Account drop down should have "Checking" selected

Scenario: Credit Card account redirect
And the user navigates to Account Summary page
When the user clicks on "Credit Card" link on the Account Summary page
And Account drop down should have "Credit Card" selected

Scenario: Loan account redirect
  And the user navigates to Account Summary page
When the user clicks on "Loan" link on the Account Summary page
And Account drop down should have "Loan" selected