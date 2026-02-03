Feature: Insurance project

  Scenario: To validate Automobile Insurance
    Given Open Insurance project
    When Click on Automobile Link
    When Select make as "Honda"
    When Enter engine performance as "1000"
    When Enter DOM as "02/02/2023"
    When Select no of seats as "5"
    When Select Fuel Type as "Petrol"
    When Enter list price as "10000"
    When Enter Licence plate no as "MH09GF1246"
    When Enter annual milage as "10000"
    Then Data enterd successful
