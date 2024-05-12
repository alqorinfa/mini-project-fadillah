Feature: Delete Category
  As a user
  I want to delete a category
  So that category can be deleted

  Scenario: As a user, i can delete a category
    Given I set API endpoint for get category by id
    When I send request to delete a category
    Then I receive status code 200
    And I receive empty data