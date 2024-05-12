Feature: Create Category
  As a user
  I can create a category
  So that new category is created

  Scenario: As a user I can create a new category
    Given I set API endpoint for get all categories
    When I send request to create a new category
    Then I receive status code 200
    And I receive valid data of new category

  Scenario: As a user I cannot create a new category with empty inputs
    Given I set API endpoint for get all categories
    When I send request to create a new category with empty inputs
    Then I receive status code 500
    And I receive error message about empty inputs