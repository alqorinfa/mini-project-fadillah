Feature: List
  As a user
  I want to see list of items
  So that I can buy that item when shopping

  Background: Home page
    Given I am on the home page


  Scenario: As a user, I can see list of items
    When I see item data
    Then I can see all items