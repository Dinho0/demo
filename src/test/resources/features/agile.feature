Feature: Registration
  Scenario: Given  a cloud9 login page
    When I register with name "Simones" "Cowelles"
    And email "simones@sqs.com" and password "simon"
    Then the registration should be succesful

