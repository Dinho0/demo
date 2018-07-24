package com.sqs.training.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class example1 {

    String valStr ;
    int val1 = 0;
    int val2 = 0;
    int res = 0;

 //   You can implement missing steps with the snippets below:

    @Given("^I have a calculator$")
    public void i_have_a_calculator() {
        // Write code here that turns the phrase above into concrete actions
            assertThat(true, equalTo(true));
    }

    @When("^I add (\\d+) with (\\d+)$")
    public void i_add_with(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        val1 = arg1;
        val2 = arg2;
        res = arg1 + arg2;

    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(int arg1) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(arg1, equalTo(res));
    }

    @When("^I subtract (\\d+) from (\\d+)$")
    public void i_subtract_from(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        val1 = arg1;
        val2 = arg2;
        res = arg2 - arg1 ;
    }
    @When("^I multiply (\\d+) andi (\\d+)$")
    public void i_multiply_and(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions


        val1 = arg1;
        val2 = arg2;
        res = arg2 * arg1 ;
    }


    @When("^I divide (\\d+) by (\\d+)$")
    public void i_divide_by(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        val1 = arg1;
        val2 = arg2;
        res = arg1 / arg2 ;
    }

    @When("^I do (.*) on (\\d+) and (\\d+)$")
    public void i_do_on_and(String arg1, int arg2, int arg3) {
        // Write code here that turns the phrase above into concrete actions

        valStr = arg1;
        val1 = arg2;
        val2 = arg3;


        if (valStr.equals("Add") ){
            res = arg2 + arg3;
        }else if (valStr.contains("Subtract") ){
            res = arg3 - arg2  ;
        }else if (valStr.contains("Multiply") ){
            res = arg2 * arg3;
        }else if (valStr.contains("Divide") ){
            res = arg2 / arg3;
        }else {
        System.out.println("Pring: [" + valStr + "]" + res);
        }
    }



}
