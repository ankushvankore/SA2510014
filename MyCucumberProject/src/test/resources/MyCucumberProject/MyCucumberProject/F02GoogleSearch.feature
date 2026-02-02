Feature: Search functionality on Google

  Scenario: To verify search functionality on Google
    Given Open Google in browser
    When Enter text to search
    And Hit enter
    Then A valid search result should display
