@regression @manual-TC-003
Feature: Product search validation mapped from manual test cases

  Background:
    Given user launches Automation Exercise home page

  @manual-TC-003
  Scenario Outline: Search a product from all products page
    When user navigates to products page
    And user searches for product "<productName>"
    Then searched products section should be visible

    Examples:
      | productName |
      | Tshirt      |
      | Blue Top    |
