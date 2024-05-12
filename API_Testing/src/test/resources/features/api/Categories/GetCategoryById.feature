Feature: Get Category By Id
  As a user
  I want to get a category by ID
  So that the category is displayed

  Scenario: As a user, I can get a category by id
    Given I set API endpoint for get category by id
    When I send request to get a category
    Then I receive status code 200
    And I receive valid data of the category

  Scenario: As a user, I cannot get a category by unexisted id
    Given I set API endpoint for get category by id
    When I send request to get a category by unexisted id
    Then I receive status code 404
    And I receive error message unexisted category "record not found"
