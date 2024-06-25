Feature: Login tests

  Scenario: A valid customer should be able to login
    Given I am on the Polteq Great testshop
    When I log in as a valid user
    Then I should be logged in