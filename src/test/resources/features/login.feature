Feature: Only Authorized Users should be able to login

  Scenario: Authorized users should be able to login to the application
    Given the user is on the login page
    When the user enters the user "username"
    Then the "username" should be able to login


  Scenario Outline: UnAuthorized users should not be able to login to the application
    Given the user is on the login page
    When the user enters the invalid user "<users>"
    And the user enters the invalid passwords "<pass>"
    Then the UnAuthorized user should not be able to login

    Examples:
      | users    | pass     |
      |          | password |
      | username |          |
      | UserName | password |
      | username | PASSword |