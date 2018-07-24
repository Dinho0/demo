Feature: Test a successful Registration

Scenario: Succesfull registration
    Given A Cloud9 login page
    When I register with name "Timones" "Towel"
    And email "Timones@sqs.com" and password "Timon"
    Then the registration should be succesful