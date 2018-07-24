Feature: Testing basics

Scenario Outline: Testing Calculator
    Given I have a calculator
    When I do <Operation> on <val1> and <val2>
    Then the result is <ExpectedResult>
Examples:
  |Operation |val1|val2|ExpectedResult|
  |Add       |10  |20    |30  |
  |Subtract  |10  |10    |0   |
  |Multiply  |10  |9     |90  |
  |Divide    |20  |10    |2   |



Scenario: Addition of 2 numbers
    Given I have a calculator
    When I add 10 with 20
    Then the result is 30

Scenario:   Subtract 2 numbers
    Given I have a calculator
    When I subtract 10 from 20
    Then the result is 10

Scenario: Multiply 2 numbers
    Given I have a calculator
    When I multiply 2 andi 2
    Then the result is 4

Scenario: Divide 2 numbers
    Given I have a calculator
    When I divide 6 by 3
    Then the result is 2

Scenario Outline: Subtract 2 numbers from table
    Given I have a calculator
    When I subtract <val1> from <val2>
    Then the result is <ExpectedResult>
Examples:
    |val1|val2|ExpectedResult|
    |10  |20    |10  |
    |10  |10    |0|
    |1   |10    |9|



