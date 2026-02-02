Feature: Login on Expand Testing

  Background: 
    Given Open Expand Testing

  Scenario: To verify login with valid data
    When Enter valid user name
    When Enter valid password
    And Click on Sumbit button
    Then Home page should display

  Scenario: To verify login with invalid data
    When Enter invalid user name
    When Enter invalid password
    And Click on Submit
    Then Error message should display
