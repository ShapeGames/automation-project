Feature: Scenarios related to login

  Scenario: Login
    Given user opens app "Betsafe Ontario"
    And user taps "Log In" flow
    And user taps login button
    And user "betSafeOnTest1" logs in
    And user taps "Other Actions" flow
    When user taps "Show Account Details" from Other actions menu
    Then "betSafeOnTest1" user details are displayed

  Scenario: Validate login credentials
    Given user opens app "Betsafe Ontario"
    And user taps "Log In" flow
    And user taps login button
    And user fills email field with "artis@shapegames.com"
    And user fills password field with "Qwerty12345"
    When user taps Here we go button
    Then invalid credentials error is displayed

  Scenario: Create new account
    Given user opens app "Betsafe Ontario"
    And user taps "Log In" flow
    And user taps create account button