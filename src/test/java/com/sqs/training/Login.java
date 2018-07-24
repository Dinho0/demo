package com.sqs.training;

import com.sqs.training.pageobjects.BookFlightPageObject;
import com.sqs.training.pageobjects.ItineraryPageObject;
import com.sqs.training.pageobjects.LoginPageObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

public class Login {
    private WebDriver driver;
    private LoginPageObject loginpage;
    private ItineraryPageObject itinerarypage;
    private BookFlightPageObject bookflightpage;
    private Map<String, String> logindata;
    private Map<String, String> bookingdata;





    public Login(){
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        itinerarypage = new ItineraryPageObject(driver);

       /* bookingdata = new HashMap<String, String>();
        bookingdata.put("ORIGIN", "Chicago");
        bookingdata.put("DESTINATION", "Durban");
        bookingdata.put("SEAT", "24");
        bookingdata.put("sCLASS", "First");
       bookingdata = new BookFlightPageObject (driver, bookingdata);
 */


        logindata = new HashMap<String, String>();
        logindata.put("EMAIL_ADDRESS", "riquelmea@sqs.com");
        logindata.put ("PASSWORD","rjrjrj");
        loginpage = new LoginPageObject(driver, logindata);
       // loginpage.fill();


    }

    @Test
    public void doLogin() throws InterruptedException {
        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginpage.verifyPageLoaded();
        PageFactory.initElements(driver, loginpage);
        loginpage.fill();
        Thread.sleep(3000);

        loginpage.clickSignInButton();

        itinerarypage.verifyPageLoaded();
        PageFactory.initElements(driver, itinerarypage);
        Thread.sleep(3000);
        itinerarypage.clickBookFlightLink();



    }

    @After
    public void tearDown(){

    }
}
