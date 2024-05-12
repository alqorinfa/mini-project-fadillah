Feature: Get all products
  As a user
  I want to get all products
  So that i can view a list of products

  Scenario: As a user, I want to get all products
    Given I set API endpoint for get all products
    When I send request to get all products
    Then I receive status code 200
    And I receive valid data of all products