package com.sqs.training.stepdefs;

//import cucumber.api.java.ObjectFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.unitConversion.conversion.*;

import java.text.DecimalFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SoapUnitConversionSteps {

    private ObjectFactory factory = null;
    private C2F c2f = null;
    private F2C f2c = null;
    private Cm2In cm2In = null;
    private In2Cm in2Cm = null;

    private UnitConversionImplService convert = null;


    private double c2fAnswer, f2cAnswer, cm2inAnswer, in2cmAnswer, lastAnswer;

@Given("^The online unit conversion service is running$")
    public void the_online_unit_conversion_service_is_running() {
        // Write code here that turns the phrase above into concrete actions
        factory = new ObjectFactory();

        c2f = factory.createC2F();
        f2c = factory.createF2C();
        cm2In = factory.createCm2In();
        in2Cm = factory.createIn2Cm();

        convert = new UnitConversionImplService();
    }


    @When("^I input (.+) degree celsius$")
    public void i_input_degree_celsius(double arg1) {
        // Write code here that turns the phrase above into concrete actions
        c2f.setArg0(arg1);
        c2fAnswer = convert.getUnitConversionImplPort().c2F(c2f.getArg0());

        lastAnswer = c2fAnswer;
    }

    @When("^I input (.+) degree fahrenheit$")
    public void i_input_degree_fahrenheit(double arg1) {
        // Write code here that turns the phrase above into concrete actions

        f2c.setArg0(arg1);
        f2cAnswer = convert.getUnitConversionImplPort().f2C(f2c.getArg0());

        lastAnswer = f2cAnswer;
    }

    @When("^I input (.+) cm$")
    public void i_input_cm(double arg1) {
        cm2In.setArg0(arg1);
        cm2inAnswer = convert.getUnitConversionImplPort().cm2In(cm2In.getArg0());

        lastAnswer = cm2inAnswer;
    }

    @When("^I input (.+) in$")
    public void i_input_in(double arg1) {
        // Write code here that turns the phrase above into concrete actions
        in2Cm.setArg0(arg1);
        in2cmAnswer = convert.getUnitConversionImplPort().in2Cm(in2Cm.getArg0());

        lastAnswer = in2cmAnswer;

    }
    @Then("^The result should be (.+)$")
    public void the_result_should_be(double arg1) {
        // Write code here that turns the phrase above into concrete actions
       // double c = Double.parseDouble(arg1 + "." + arg2);

        assertThat(lastAnswer, is(arg1));
    }


}
