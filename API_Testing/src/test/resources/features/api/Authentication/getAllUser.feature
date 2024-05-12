Feature: Get All User
  As a user
  I want to get all user
  So that i can see list of all users

  Scenario: As a user, i can get all user
    Given I set API endpoint for get all users
    When I send request to get all users
    Then I receive status code 200
    And I receive data all users