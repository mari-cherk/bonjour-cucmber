@smoke
Feature: Welcome screen

  Scenario: Onboarding screen should be shown when starting the app for the first time
    Given I am launching the application for the first time
    Then I am on the "Welcome" screen

  Scenario: User should be able to access Terms of Use screen
    Given I am on the "Welcome" screen
    When I tap the "Terms of service" link
    Then the "Terms of use" screen should be opened

  Scenario: User should be able to access Privacy Policy screen
    Given I am on the "Welcome" screen
    When I tap the "Privacy Policy" link
    Then the "Privacy Policy" screen should be opened
