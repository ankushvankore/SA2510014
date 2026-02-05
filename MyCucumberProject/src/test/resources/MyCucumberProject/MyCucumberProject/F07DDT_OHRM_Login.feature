Feature: Data driven testing on OHRM

  Scenario Outline: To validate login functionality
    Given Open Orange HRM application
    When Enter user name as "<UserName>"
    When Enter password as "<Password>"
    When Click on the login button
    Then Dashboard page should display

    #Examples: will work as @DataProvider, means this will pass the data to step
    Examples: 
      | UserName | Password   |
      | ashwini  | ashwini123 |
      | admin    | admin123   |
      | naveen   | naveen123  |
      | admin    | admin123   |
      | sourab   | sourabh123 |
