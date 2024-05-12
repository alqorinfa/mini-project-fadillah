Feature: Comment
  As a user
  I want to comment at a product
  So that my comment is saved

  Scenario: As a user I can post a comment
    Given I set API endpoint for get all products
    When I send request to post a comment
    Then I receive status code 200
    And I receive single valid data of comment

  Scenario: As a user I can get a comment
    Given I set API endpoint for get all products
    When I send request to get a comment
    Then I receive status code 200
    And I receive a valid data of comment