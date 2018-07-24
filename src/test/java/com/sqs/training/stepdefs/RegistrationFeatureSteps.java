package com.sqs.training.stepdefs;

import com.sqs.training.pageobjects.LoginPageObject;
import com.sqs.training.pageobjects.RegisterPageObject;
import com.sqs.training.pageobjects.RegisterSuccessPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RegistrationFeatureSteps {
 /*
  *Creating object of classes
  */
    private WebDriver driver;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private RegisterSuccessPageObject registerSuccessPage;
    private Map<String, String> data;

    public RegistrationFeatureSteps(){

    }

    /*
     *@
     */
    @Given("^A Cloud9 login page$")
    public void a_Cloud_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        loginPage = new LoginPageObject(driver);
        data = new HashMap<String, String>();

        registerSuccessPage = new RegisterSuccessPageObject(driver);
        registerPage = new RegisterPageObject(driver, data);


    }

    /**
     * @param arg1 is the firstname(value) passed from the register.feature file
     *             and mapped with the firstname field of the registerPage object
     * @param arg2 is the lastname (value) passed from the register.feature file
     *             and mapped with the lastname field of the registerPage object
     */
    @When("^I register with name \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_register_with_name(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        data.put("first_name", arg1);
        data.put("last_name", arg2);
    }


    /**
    *@param arg1 is the email-address passed from the register.feature file
     *            and mapped with the email field of the registerPage object
     * @param arg2 is the password passed from the register.feature file
     *             and mapped with the password field of the registerPage object
     */
    @When("^email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void email_and_password(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        Calendar rightNow = Calendar.getInstance();
        int houri = rightNow.get(Calendar.HOUR_OF_DAY);
        String time = houri + "" + rightNow.get(Calendar.MINUTE);

        data.put("email", (arg1+time));
        data.put("password", arg2);
    }

    /**
     *The method completes the registration process by:
     * (I)   using the $driver object to get the login page.
     * (II)  Verifying that the Login page is loaded correctly
     * (III) Coallates all the login page elements
     * (IV)  Set a sleep timer of 3 seconds.
     * (V)   Click the register link in order to proceed to the registeration page
     * (VI)  Verifying that the Register page is loaded correctly {@link #registerPage}
     * (VII) Ensure that all Register page element are loaded correctly
     * (VII) Fill in the email field that has been mapped with values from register.feature
     * (IX)  Click the Register Button to register the user.
     * (X)   Set a sleep timer of 3 seconds.
     */
    @Then("^the registration should be succesful$")
    public void the_registration_should_be_succesful() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://10.9.10.6/mysql/Main/Login.html");

        //Verifying that the Login page is loaded correctly
        loginPage.verifyPageLoaded();

        //Coallates all the login page elements
        PageFactory.initElements(driver, loginPage);

        //Set a sleep timer of 3 seconds.
        Thread.sleep(3000);

        //Click the register link in order to proceed to the registration page
        loginPage.clickRegisterLink();

        // Verifying that the Register page is loaded correctly {@link #registerP
        registerPage.verifyPageLoaded();

        //Ensure that all Register page element are loaded correctly
        PageFactory.initElements(driver, registerPage);

        //Fill in the email field that has been mapped with values from register.feature
        registerPage.fill();

        //Click the Register Button to register the user.
        registerPage.clickRegisterButton();

        //Set a sleep timer of 3 seconds.
        Thread.sleep(3000);

       // registerSuccessPage.clickHomepageLink();

        driver.findElement(By.xpath("/html/body/center/a")).click();
    }

}
