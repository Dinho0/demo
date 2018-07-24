Feature: Calculator Soap Service

  Background:
    Given  That the online calculator service is running

    Scenario: Add two numbers
      When I add number 1 with number 2
      Then I get a result of 3

    Scenario: Subtract two numbers
      When I subtract number 3 from number 6
      Then I get a result of 3

    Scenario: Multiply two numbers
      When I multiply number 7 and number 7
      Then I get a result of 49

    Scenario:  Divide two numbers
      When I divide number 60 by 6
      Then I get a result of 10
