#feature View Stocks
Feature: View Stocks
  As a user I can 
  View the stock list

  Scenario Outline: View Stocks
    Given I am logged in
    And I view <stocks> stocks
    Then I should see all <stockList> stocks

    Examples: 
      | stocks | stockList |
      |     10 |        10 |
      |      8 |         8 |
      |      5 |         5 |
      |      4 |         4 |
