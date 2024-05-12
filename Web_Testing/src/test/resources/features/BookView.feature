Feature: : Book View
  As a user
  I want to see a list of books
  So that books list is viewed

  Scenario: As a user, I can see books list by table
    Given I am on the main page
    When I click table button
    Then I see books list by table

  Scenario: As a user, I can see books list by card
    Given I am on the main page
    When I click card button
    Then I see books list by card

  Scenario: As a user, I can see detail of book
    Given I am on the main page
    When I click detail icon
    Then I see a detail of book