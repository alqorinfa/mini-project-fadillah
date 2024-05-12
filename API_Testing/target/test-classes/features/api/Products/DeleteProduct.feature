Feature: Delete Product
  As a user
  I want to delete a product
  So that the product is deleted

  Scenario: As a user, I can delete a product
    Given I set API endpoint for get all products
    When I send delete request to a product
    Then I receive status code 200
    And I receive empty data