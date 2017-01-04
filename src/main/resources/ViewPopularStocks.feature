Feature: View Popular Stocks
  As a user
  I can view stocks that are the most popular

  Scenario:
    Given I am logged in
    And I am viewing stocks
    When I click to see the most popular stocks
    Then the most popular stocks appear