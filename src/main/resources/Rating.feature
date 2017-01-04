Feature: Rating
  As a user
  I can rate stocks

  Scenario:
    Given I am logged in
    And I am viewing a stock
    When I select a rating for the stock
    And I click the submit button
    Then the rating I have selected will be submitted