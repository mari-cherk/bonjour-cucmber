@smoke
Feature: Contests

  Scenario: Contest elements have “Enter now” button and a “Live” indicator
    Given I am on the "Contests" screen
    When I scroll to the contest
    Then The "Enter now" and "Live" elements are visible

  Scenario: “Sorting” button changes the elements order
    Given I am on the "Contests" screen
    When I apply "Most Popular" sorting
    Then Most popular post is displayed at the top