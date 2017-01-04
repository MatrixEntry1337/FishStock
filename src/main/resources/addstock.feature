#feature file - user has the ability to add stock
Feature: Add Stock
  As a user
  I can add a stock
  So that I can watch the growth

  Background: Stock List
    Given I have these stocks
      | Stock Name | Stock Symbol |
      | Nvidia     | NVDA         |
      | Apple      | AAPL         |
      | Sirius Xm  | SIRI         |
      | Amazon     | AMZN         |
      | Starbucks  | SBUX         |

  Scenario Outline: Add a stock to my stock list
    Given I am logged in
    And Access a list of <stockList> Stocks
    And I am watching <myStocks> stocks
    When I add <stock> stocks to my stocks
    Then I now watch these <myNewStocks> stocks

    Examples: 
      | stockList | myStocks | stock | myNewStocks |
      |        10 |        2 |     7 |           9 |
      |        10 |        4 |     1 |           5 |
      |        10 |        5 |     2 |           7 |
