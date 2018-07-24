package com.sqs.training.stepdefs;

import com.sqs.training.pageobjects.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

public class LoginFeatureSteps {

    /*
     *Creating object of classes
     */
    private WebDriver driver;
    private LoginPageObject loginPage;
    private ItineraryPageObject itineraryPage;
    private BookFlightPageObject bookFlightPage;
    private BookFlightSuccessPageObject bookFlightSuccessPage;
    private ItineraryUDPageObject itenaryUD;
    private EditPageObject editPage;
    private Map<String, String> data;

    /**
     *            constructor for initializing driver
     *            ensuring that its null
     *            and setting a time wait of 30 secs
     */
    String flightDeleteID ;
    public LoginFeatureSteps (){
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }



    //updating the login page object with driver config
    @Given("^A Cloud98 login page$")
    public void a_Cloud_login_page() {
        // Write code here that turns the phrase above into concrete actions


       loginPage = new LoginPageObject(driver);



    }

    /**
     * @param arg1 is the email-address(value) passed from the login.feature file
     *             and mapped with the email field of the loginPage object
     * @param arg2 is the password (value) passed from the login.feature file
     *             and mapped with the password field of the loginPage object
     *
     *             updating the login page object by passing the required data and driver config to page object
     *
     *             updating the itinerary page object with driver config
     */
    @When("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_login_with_email_and_password(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        data = new HashMap<String, String>();

        data.put("EMAIL_ADDRESS", arg1);
        data.put("PASSWORD", arg2);

        loginPage = new LoginPageObject(driver, data);
        itineraryPage = new ItineraryPageObject(driver);
    }

    /**
     *
     * (I)   using the $driver object to get the login page.
     * (II)  Verifying that the Login page is loaded correctly
     * (III) Coallates all the login page elements
     * (IV)  Set a sleep timer of 3 seconds.
     * (V)   Click the  login page button in order to Login.
     * (VI   Set a sleep timer of 3 seconds.
     * (VII) Quit Driver.
     */
    @Then("^the Login should be succesful$")
    public void the_Login_should_be_succesful() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        loginPage.fill();
        Thread.sleep(3000);

        loginPage.clickSignInButton();
       boolean ret = driver.getCurrentUrl().contains("mysql/Main/Itinerary.php");

       assertThat(ret, is(true));

        Thread.sleep(1000);
        driver.quit();
    }







    /**
     *
     * (I)   using the $driver object to get the login page.
     * (II)  updating the login page object by passing the new driver config to page object
     * (III) Setting up the Map object as a HashMap
     * (IV)
     * @param arg1 is the email-address(value) passed from the login.feature file
     *        and mapped with the email field of the loginPage object
     *             and mapped with the email field of the loginPage object
     * @param arg2 is the password (value) passed from the login.feature file
     *             and mapped with the password field of the loginPage object
     * (V)  Coallates all the login page elements
     * (VI)  Verifying that the Register page is loaded correctly {@link #loginPage}
     * (VII) Ensure that all Login page element are loaded correctly
     * (VII) Fill in the email field and password field that has been mapped with values from login.feature
     * (IX)  Set a sleep timer of 3 seconds.
     * (X)   Click the SignIn Button to sing in.
     * (XI)  Set a sleep timer of 1 second.
     */

    @Given("^A valid login with email  \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void a_valid_login_with_email_and_password(String arg1, String arg2) throws Exception{
        // Write code here that turns the phrase above into concrete actions

       // loginPage = new LoginPageObject(driver);

        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginPage = new LoginPageObject(driver);
        data = new HashMap<String, String>();

        data.put("EMAIL_ADDRESS", arg1);
        data.put("PASSWORD", arg2);

        loginPage = new LoginPageObject(driver, data);

       // itineraryPage = new ItineraryPageObject(driver);
        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        loginPage.fill();
        Thread.sleep(3000);

        loginPage.clickSignInButton();
        Thread.sleep(1000);

        itineraryPage = new ItineraryPageObject(driver);

        itineraryPage.verifyPageLoaded();
        PageFactory.initElements(driver, itineraryPage);
        itineraryPage.clickBookFlightLink();
        Thread.sleep(1000);


    }

    /**
     *   Setting up the Map object as a HashMap
     *
     * @param arg1 is the origin(value) passed from the login.feature file
     *      *        and mapped with the origin field of the bookflightPage object
     * @param arg2 is the destination(value) passed from the login.feature file
     *              and mapped with the destination field of the bookflightPage object
     * @param arg3 is the Seat(value) passed from the login.feature file
     *             and mapped with the Seat field of the bookflightPage object
     * @param arg4 is the class(value) passed from the login.feature file
     *             and mapped with the class field of the bookflightPage object
     *
     * updating the bookFlightPage object by passing the new driver config and new data to page object
     *

     */
    @When("^I input Origin as \"([^\"]*)\"  and Destination as \"([^\"]*)\" and Seat as \"([^\"]*)\" and Class as \"([^\"]*)\"$")
    public void i_book_with_Origin_as_and_Destination_as_and_Seat_as_and_Class_as(String arg1, String arg2, String arg3, String arg4) {
        // Write code here that turns the phrase above into concrete actions



        data = new HashMap<String, String>();

        data.put("ORIGIN", arg1);
        data.put("DESTINATION", arg2);
        data.put("SEAT", arg3);
        data.put("sCLASS", arg4);

        bookFlightPage = new BookFlightPageObject(driver, data);



    }


    /**
     *
     * (I)   using the $driver object to get the Booking page.
     * (II) Verifying that the Booking page is loaded correctly {@link #bookFlightPage}
     * (III) Setting up the Map object as a HashMap
     * (IV) Coallates all the booking page elements and driver config
     * (V)  Fill in the all field  has been mapped with values from login.feature
     * (VI)  Set a sleep timer of 3 seconds.
     * (VII) Click the Book Button to book a flight.
     * (VII)  Verifying that the Booking was successful by directly using the driver.
     * (IX)  Assert that its truly successful
     * (X)  Set a sleep timer of 3 seconds.
     * (XI)  Quit.
     */

    @Then("^the booking should be successful$")
    public void the_booking_should_be_successful() throws Exception {
        // Write code here that turns the phrase above into concrete actions

        driver.get("http://10.9.10.6/mysql/Main/BookFlight.html");
        bookFlightPage.verifyPageLoaded();
        PageFactory.initElements(driver, bookFlightPage);

        bookFlightPage.fill();
        Thread.sleep(3000);

        bookFlightPage.clickBookButton();

        boolean ret = driver.findElement(By.className("form-signin-heading")).getText().contains("Flight successfully booked");
        assertThat(ret, is(true));
        Thread.sleep(3000);

        driver.quit();

    }






    @Given("^A sucessful login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void a_sucessful_login_with_email_and_password(String arg1, String arg2) throws Exception{
        // Write code here that turns the phrase above into concrete actions

        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginPage = new LoginPageObject(driver);
        data = new HashMap<String, String>();

        data.put("EMAIL_ADDRESS", arg1);
        data.put("PASSWORD", arg2);

        loginPage = new LoginPageObject(driver, data);

        // itineraryPage = new ItineraryPageObject(driver);
        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        loginPage.fill();
        Thread.sleep(3000);

        loginPage.clickSignInButton();
        Thread.sleep(1000);

        itineraryPage = new ItineraryPageObject(driver);

        itineraryPage.verifyPageLoaded();
        PageFactory.initElements(driver, itineraryPage);
        itineraryPage.clickBookFlightLink();

        Thread.sleep(1000);
    }

    @And("^A sucessful booking with Origin as \"([^\"]*)\"  and Destination as \"([^\"]*)\" and Seat as \"([^\"]*)\" and Class as \"([^\"]*)\"$")
    public void a_sucessful_booking_with_Origin_as_and_Destination_as_and_Seat_as_and_Class_as(String arg1, String arg2, String arg3, String arg4) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        data = new HashMap<String, String>();

        data.put("ORIGIN", arg1);
        data.put("DESTINATION", arg2);
        data.put("SEAT", arg3);
        data.put("sCLASS", arg4);

        bookFlightPage = new BookFlightPageObject(driver, data);


       // driver.get("http://10.9.10.6/mysql/Main/BookFlight.html");
        bookFlightPage.verifyPageLoaded();
        PageFactory.initElements(driver, bookFlightPage);

        bookFlightPage.fill();
        Thread.sleep(2000);

        bookFlightPage.clickBookButton();
         Thread.sleep(1000);
        bookFlightPage.clickItineraryLink();


    }



    @When("^I update booking with FlightID \"([^\"]*)\" and set Origin as \"([^\"]*)\"  and Destination as \"([^\"]*)\" and Seat as \"([^\"]*)\" and Class as \"([^\"]*)\"$")
    public void i_update_booking_with_FlightID_and_set_Origin_as_and_Destination_as_and_Seat_as_and_Class_as(String arg1, String arg2, String arg3, String arg4, String arg5) {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();

        String fieldName = "Flight ID";

        List <WebElement> col = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td"));;
        List <WebElement> row = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr")); ;

        int col_size= col.size();;
        int row_size = row.size();



        System.out.println("col size := " + col_size );
        System.out.println("Table size := " + row_size );


        String flightID = arg1;
        System.out.println("flight id= " + flightID );

       for (int i = 1; i <= col_size; i++){
            String fieldValue;         //              "/html/body/div/div/div[2]/div/table/tbody/tr[3]/td[4]"
            fieldValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td["+i+"]/b")).getText();
            if (fieldName.equalsIgnoreCase(fieldValue)) {
               System.out.println("yes value := "+ fieldValue );

                for(int rowcount = 1; rowcount <= row_size; rowcount++){
                    String cellValue;
                    cellValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td["+i+"]")).getText();

                    if (cellValue.equalsIgnoreCase(flightID)){
                        System.out.println("flight id= "+ cellValue);

                        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td[1]")).findElement(By.linkText("Update")).click();

                        editPage = new EditPageObject(driver);
                        editPage.verifyPageLoaded();
                        PageFactory.initElements(driver, editPage);

                        data = new HashMap<String, String>();
                        data.put("SEAT_1", arg2);
                        data.put("DESTINATION", arg3);
                        data.put("SEAT_2", arg4);
                        data.put("sCLASS", arg5);

                    boolean ret=    driver.findElement(By.className("page-header")).getText().contains("Edit Flight");
                    assertThat(ret, is(true));
                        editPage = new EditPageObject(driver, data);


                        break;
                    }
                }
                break;
           }

      }


    }

    @Then("^the update should be succesful$")
    public void the_update_should_be_succesful() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        editPage.verifyPageLoaded();
        PageFactory.initElements(driver, editPage);

        editPage.fill();
        Thread.sleep(1000);
        editPage.clickUpdateButton();


        Thread.sleep(1000);
        System.out.println(driver.findElement(By.className("form-signin-heading")).getText());
        boolean ret = driver.findElement(By.className("form-signin-heading")).getText().contains("Flight successfully updated");
        assertThat(ret, is(true));

        driver.quit();
    }

    @Given("^A sucessfull login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void a_sucessfull_login_with_email_and_password(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginPage = new LoginPageObject(driver);
        data = new HashMap<String, String>();

        data.put("EMAIL_ADDRESS", arg1);
        data.put("PASSWORD", arg2);

        loginPage = new LoginPageObject(driver, data);

        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        loginPage.fill();
        Thread.sleep(3000);

        loginPage.clickSignInButton();
        Thread.sleep(1000);

        itineraryPage = new ItineraryPageObject(driver);

        itineraryPage.verifyPageLoaded();
        PageFactory.initElements(driver, itineraryPage);
        itineraryPage.clickBookFlightLink();

        Thread.sleep(1000);
    }

    @And("^A sucessfull booking with Origin as \"([^\"]*)\"  and Destination as \"([^\"]*)\" and Seat as \"([^\"]*)\" and Class as \"([^\"]*)\"$")
    public void a_sucessfull_booking_with_Origin_as_and_Destination_as_and_Seat_as_and_Class_as(String arg1, String arg2, String arg3, String arg4) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        data = new HashMap<String, String>();

        data.put("ORIGIN", arg1);
        data.put("DESTINATION", arg2);
        data.put("SEAT", arg3);
        data.put("sCLASS", arg4);

        bookFlightPage = new BookFlightPageObject(driver, data);


        bookFlightPage.verifyPageLoaded();
        PageFactory.initElements(driver, bookFlightPage);

        bookFlightPage.fill();
        Thread.sleep(2000);

        bookFlightPage.clickBookButton();
        Thread.sleep(1000);
        bookFlightPage.clickItineraryLink();
    }



    @When("^I Delete the booking with FlightID \"([^\"]*)\"$")
    public void i_Delete_the_booking_with_FlightID(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        String fieldName = "Flight ID";

        List <WebElement> col = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td"));;
        List <WebElement> row = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr")); ;

        int col_size= col.size();;
        int row_size = row.size();

        flightDeleteID = arg1;

        for (int i = 1; i <= col_size; i++){
            String fieldValue;
            fieldValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td["+i+"]/b")).getText();
            if (fieldName.equalsIgnoreCase(fieldValue)) {
                System.out.println("yes value := "+ fieldValue );

                for(int rowcount = 1; rowcount <= row_size; rowcount++){
                    String cellValue;
                    cellValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td["+i+"]")).getText();

                    if (cellValue.equalsIgnoreCase(flightDeleteID)){
                        System.out.println("flight id= "+ cellValue);

                        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td[1]")).findElement(By.linkText("Delete")).click();



                        break;
                    }
                }
                break;
            }

        }

    }

    @Then("^the delete should be succesful$")
    public void the_delete_should_be_succesful() {
        // Write code here that turns the phrase above into concrete actions


        String fieldName = "Flight ID";

        List <WebElement> col = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td"));;
        List <WebElement> row = driver.findElements(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr")); ;

        int col_size= col.size();;
        int row_size = row.size();



        System.out.println("col size := " + col_size );
        System.out.println("Table size := " + row_size );


        System.out.println("flight id= " + flightDeleteID );

        for (int i = 1; i <= col_size; i++){
            String fieldValue;
            fieldValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr[1]/td["+i+"]/b")).getText();
            if (fieldName.equalsIgnoreCase(fieldValue)) {
                System.out.println("yes value := "+ fieldValue );

                for(int rowcount = 1; rowcount <= row_size; rowcount++){
                    String cellValue;
                    cellValue = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td["+i+"]")).getText();

                    if (cellValue.equalsIgnoreCase(flightDeleteID)){
                        System.out.println("flight id= "+ cellValue);

                        boolean ret =  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr["+rowcount+"]/td["+i+"]")).getText().contains(flightDeleteID);
                        assertThat(ret, is(false));


                        break;
                    }
                }
                break;
            }

        }


    }


}
