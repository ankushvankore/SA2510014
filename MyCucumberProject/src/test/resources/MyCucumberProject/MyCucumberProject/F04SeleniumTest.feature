@AllSeleniumTests
Feature: Selenium Test

  Background: 
    Given Open Selenium Home Page

	@DownloadTest
  Scenario: To validate Downloads link
    When Click on Downloads link
    Then Downloads page should display

	@DocumentationTest
  Scenario: To validate Documentatin Link
    When Click on Documentation Link
    Then Documentation page should display

	@ProjectTest
  Scenario: To validate Projects link
    When Click on Projects link
    Then Projects page should display

	@SupportTest
  Scenario: To validate Support link
    When Click on Support link
    Then Supports page should display
