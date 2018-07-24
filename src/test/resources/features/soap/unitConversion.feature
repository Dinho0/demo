Feature: Unit Conversion Soap service

    Background:
      Given The online unit conversion service is running

    Scenario: Convert Celsius to Fahrenheit
      When I input 45 degree celsius
      Then The result should be 113

    Scenario: Convert Fahrenheit to Celsius
      When I input 104 degree fahrenheit
      Then The result should be 40

    Scenario: Convert Cm to In
      When I input 30 cm
      Then The result should be 11.811023622047244
      
    Scenario: Convert In to cm
      When I input 20 in 
      Then The result should be 50.8




