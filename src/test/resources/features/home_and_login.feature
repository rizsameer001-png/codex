@smoke @manual-TC-001
Feature: Home and Login validations mapped from manual test cases

  Background:
    Given user launches Automation Exercise home page

  @manual-TC-001
  Scenario: Validate home page is loaded
    Then home page banner should be visible

  @manual-TC-002
  Scenario: Validate login with invalid credentials
    When user navigates to signup login page
    And user logs in with invalid credentials from "testdata/users.json"
    Then invalid login error should be displayed as "Your email or password is incorrect!"
