Feature: Test a successful Login

  Scenario: Succesfull Login
    Given A Cloud98 login page
    When I login with email "Timones@sqs.com" and password "Timon"
    Then the Login should be succesful



  Scenario: Successfull Booking
    Given A valid login with email  "Timones@sqs.com" and password "Timon"
    When  I input Origin as "Chicago"  and Destination as "Durban" and Seat as "21" and Class as "First"
    Then the booking should be successful

  Scenario: Successful Update
    Given A sucessful login with email "Timones@sqs.com" and password "Timon"
    And A sucessful booking with Origin as "Chicago"  and Destination as "Durban" and Seat as "21" and Class as "First"
    When I update booking with FlightID "10046" and set Origin as "Johannesburg"  and Destination as "Durban" and Seat as "22" and Class as "Economy"
    Then the update should be succesful

  Scenario: Successful Delete
    Given A sucessfull login with email "Timones@sqs.com" and password "Timon"
    And A sucessfull booking with Origin as "Chicago"  and Destination as "Durban" and Seat as "21" and Class as "First"
    When I Delete the booking with FlightID "10098"
    Then the delete should be succesful

