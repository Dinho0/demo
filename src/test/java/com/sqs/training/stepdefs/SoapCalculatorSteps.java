package com.sqs.training.stepdefs;

import com.dneonline.calculator.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SoapCalculatorSteps {
    private ObjectFactory factory = null;
    private Add add = null;
    private Subtract subtract = null;
    private Divide divide = null;
    private Multiply multiply = null;
    private Calculator calculator = null;
    private  int addAnswer,subtractAnswer,divideAnswer, multiplyAnswer, lastAnswer;

    @Given("^That the online calculator service is running$")
    public void that_the_online_calculator_service_is_running()throws Exception {
        // Write code here that turns the phrase above into concrete actions
        factory = new ObjectFactory ();
        add = factory.createAdd();
        subtract = factory.createSubtract();
        divide = factory.createDivide();
        multiply = factory.createMultiply();
        calculator = new Calculator();
    }

    @When("^I add number (\\d+) with number (\\d+)$")
    public void i_add_number_with_number(int arg1, int arg2)throws Exception {
        // Write code here that turns the phrase above into concrete actions
       add.setIntA(arg1);
       add.setIntB(arg2);
       addAnswer = calculator.getCalculatorSoap().add(add.getIntA(), add.getIntB());

       lastAnswer = addAnswer;
    }

    @Then("^I get a result of (\\d+)$")
    public void i_get_a_result_of(int arg1)throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //

        assertThat(lastAnswer, is(equalTo(arg1)));

    }

    @When("^I subtract number (\\d+) from number (\\d+)$")
    public void i_subtract_number_from_number(int arg1, int arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        subtract.setIntA(arg2);
        subtract.setIntB(arg1);

        subtractAnswer = calculator.getCalculatorSoap().subtract(subtract.getIntA(), subtract.getIntB());

        lastAnswer = subtractAnswer;
    }

    @When("^I multiply number (\\d+) and number (\\d+)$")
    public void i_multiply_number_and_number(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();

        multiply.setIntA(arg1);
        multiply.setIntB(arg2);

        multiplyAnswer = calculator.getCalculatorSoap().multiply(multiply.getIntA(), multiply.getIntB());

        lastAnswer = multiplyAnswer;
    }

    @When("^I divide number (\\d+) by (\\d+)$")
    public void i_divide_number_by(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();

        divide.setIntA(arg1);
        divide.setIntB(arg2);

        divideAnswer = calculator.getCalculatorSoap().divide(divide.getIntA(), divide.getIntB());

        lastAnswer = divideAnswer;
    }
}
