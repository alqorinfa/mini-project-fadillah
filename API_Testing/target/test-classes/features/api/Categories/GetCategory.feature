Feature: Get Category
  As a user
  I want to get all categories
  So that all categories can be viewed

  Scenario: As a user I can create a new category
    Given I set API endpoint for get all categories
    When I send request to get all categories
    Then I receive status code 200
    And I receive all data of categories