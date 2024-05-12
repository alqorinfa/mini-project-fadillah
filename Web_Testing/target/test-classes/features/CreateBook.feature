Feature: Create book
  As a user
  I want to create a book
  So that new book is created

  Background:
    Given I am on the main page
    When I click plus button

  Scenario: As a user, I can create a book with valid inputs
    And I input valid title
    And I input valid author
    And I input valid year
    And I click save book button
    Then system shows success create message "Book created successfully"
    And I am on the main page

  Scenario: As a user, I cannot create a book with all empty inputs
    And I click save book button
    Then systems show error create message "Book failed to create"
    And I am on the main page

  Scenario: As a user, I cannot create a book with empty title
    And I input valid author
    And I input valid year
    And I click save book button
    Then systems show error create message "Book failed to create"

  Scenario: As a user, I cannot create a book with empty author
    And I input valid title
    And I input valid year
    And I click save book button
    Then systems show error create message "Book failed to create"

  Scenario: As a user, I cannot create a book with empty year
    And I input valid title
    And I input valid author
    And I click save book button
    Then systems show error create message "Book failed to create"

  Scenario: As a user, I cannot create a book with invalid year
    And I input valid title
    And I input valid author
    And I input invalid year
    And I click save book button
    Then systems show error create message "Book failed to create"


