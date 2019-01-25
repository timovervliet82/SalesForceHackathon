Feature: Test SalesForce cases page

  Background:
    Given I am logged into SalesForce

  Scenario: Test priority sorting
    Given user wants to get an overview of all open cases
    When the user wants to sort the open cases by high priority
    Then the user gets an sorted overview sorted by high priority