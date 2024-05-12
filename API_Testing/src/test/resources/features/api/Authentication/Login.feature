Feature: Login
  As a user
  I want to login
  So that i can have all access to all endpoint

  Scenario: As a user, I can login with valid credentials
    Given I set API endpoint for login
    When I login with valid credentials
    Then I receive status code 200
    And I receive token

  Scenario: As a user, I cannot login with invalid email
    Given I set API endpoint for login
    When I login with invalid email
    Then I receive status code 400
    And I receive error message invalid email "record not found"

  Scenario: As a user, I cannot login with invalid password
    Given I set API endpoint for login
    When I login with invalid password
    Then I receive status code 400
    And I receive error message invalid password "email or password is invalid"

  Scenario: As a user, I cannot login with empty inputs
    Given I set API endpoint for login
    When I login with empty inputs
    Then I receive status code 400
    And I receive error message empty email "email is required"

  Scenario: As a user, I cannot login with unregistered email
    Given I set API endpoint for login
    When I login with unregistered email
    Then I receive status code 400
    And I receive error message invalid email "record not found"