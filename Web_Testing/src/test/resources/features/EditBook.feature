Feature: Edit Book
  As a user
  I can edit a book
  So that the book can be updated

  Background:
    Given I am on the main page

  Scenario: As a user, I can edit a book with valid inputs
    When I click edit icon
    And I input valid title
    And I input valid author
    And I input valid year
    And I click edit book button
    Then the new detail is showed

  Scenario: As a user, I cannot edit a book with invalid year
    When I click edit icon
    And I input valid title
    And I input valid author
    And I input invalid year
    And I click edit book button
    Then systems show error message "Book edit failed"

  Scenario: As a user, I can delete a book
    When I click delete icon
    And I click yes button
    Then system shows success message "book deleted successfully"
