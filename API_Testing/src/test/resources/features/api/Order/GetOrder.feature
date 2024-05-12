Feature: Get All Order
  As a user
  I want to get all order
  So that the list of all order can be viewed

  Scenario: As a user, I can get all order
    Given I set API endpoint for all order
    When I send request to get all order
    Then I receive status code 200
    And I receive data of all order
