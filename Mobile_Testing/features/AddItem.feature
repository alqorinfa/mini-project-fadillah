Feature: List
  As a user
  I want to see add item
  So that I can buy that item when shopping

  Background: Home page
    Given I am on the home page

  Scenario: As a user, I can add vegetables item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose vegetables
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add fruit item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose fruit
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add meat item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose meat
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add dairy item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose dairy
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add carbs item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose carbs
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add sweets item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose sweets
    Then I tap add item button
    Then I redirected to the home page

  Scenario: As a user, I can add spices item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose spices
    Then I tap add item button
    Then I redirected to the home page

    Scenario: As a user, I can add convenience item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose convenience
    Then I tap add item button
    Then I redirected to the home page

    Scenario: As a user, I can add hygiene item 
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I choose hygiene
    Then I tap add item button
    Then I redirected to the home page

Scenario: As a user, I can reset item
    When I tap plus button
    Then I insert valid name product
    Then I insert valid quantity
    Then I tap reset button
    Then the inputs are reset

Scenario: As a user, I cannot add an item without name
    When I tap plus button
    Then I insert valid quantity
    Then I tap add item button
    Then error message is shown about empty name

Scenario: As a user, I cannot add an item with 0 quantity
    When I tap plus button
    Then I insert valid name product
    Then I insert invalid quantity
    Then I tap add item button
    Then error message is shown about zero quantity

    
