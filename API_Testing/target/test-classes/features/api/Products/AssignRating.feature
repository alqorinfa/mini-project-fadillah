Feature: Assign Rating
  As a user
  I want to assign rating for a product
  So that product have a rating

  Scenario: As a user, i can assign rating for a product
    Given I set API endpoint for get all products
    When I send request to assign rating for a product
    Then I receive status code 200
    And I get data of product with rating

  Scenario: As a user, i cannot assign rating for unexisted product
    Given I set API endpoint for get all products
    When I send request to assign rating for unexisted product
    Then I receive status code 500
    And I receive error message unexisted product "record not found"

  Scenario: As a user, i can get a product rating
    Given I set API endpoint for get all products
    When I send request to get a product rating
    Then I receive status code 200
    And I get data of product rating