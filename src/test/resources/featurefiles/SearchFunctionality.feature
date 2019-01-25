Feature: Test Rabobank.nl search functionality

  Scenario: The search results page is populated when I use the search function
    Given I am on the Rabobank homepage
    And I navigate to particulieren
    When I search for "Rekening openen"
    Then I find the information page containing information about "Rekening openen"

  Scenario: I can filter the search results for "Particulieren" or "Bedrijven"
    Given I am on the Rabobank homepage
    And I navigate to particulieren
    And I search for "Sparen"
    When I select "Business" to filter the search results
    Then I find the information page containing information about "Business savings"