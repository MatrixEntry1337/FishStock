#feature View Stocks
Feature: View Stocks
  As a user I can 
  View the stock list

  Background: Stock List
    Given I have these stocks
      | Stock Name | Stock Symbol |
      | Nvidia     | NVDA         |
      | Apple      | AAPL         |
      | Sirius Xm  | SIRI         |
      | Amazon     | AMZN         |
      | Starbucks  | SBUX         |

  Scenario: View Stocks
    Given I am logged in
    And I view <stocks> stocks
    Then I should see all <stockList> stocks
