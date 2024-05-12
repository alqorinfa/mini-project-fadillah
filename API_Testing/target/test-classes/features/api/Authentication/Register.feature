Feature: Register
  As a user
  I want to register
  So that I can access all data

  Scenario: As a user, I can register with valid inputs
    Given I set API endpoint for register
    When I send request to register with valid inputs
    Then I receive status code 200
    And I receive valid data of account

  Scenario: As a user, I cannot register with invalid email
    Given I set API endpoint for register
    When I send request to register with invalid email
    Then I receive status code 400
    And I receive error message "ERROR: invalid email"

  Scenario: As a user, I can register with empty inputs
    Given I set API endpoint for register
    When I send request to register with empty inputs
    Then I receive status code 400
    And I receive error message empty email "email is required"
