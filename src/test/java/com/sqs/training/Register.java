package com.sqs.training;

import com.sqs.training.pageobjects.LoginPageObject;
import com.sqs.training.pageobjects.RegisterPageObject;
import com.sqs.training.pageobjects.RegisterSuccessPageObject;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

public class Register {
    private WebDriver  driver;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;

    private RegisterSuccessPageObject registerSuccessPage;


    //private WebDriverWait wait;
    private Map<String, String> data;

    private Map<String, String> logindata;


    public Register(){
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        logindata = new HashMap<String, String>();
        logindata.put("EMAIL_ADDRESS", "riquelmea@sqs.com");
        logindata.put ("PASSWORD","rjrjrj");
        loginPage = new LoginPageObject(driver, logindata);

        data = new HashMap<String, String>();
        data.put("first_name", "Riquelmea");
        data.put("last_name", "john");
        data.put("email", "riquelmea@sqs.com");
        data.put("password", "rjrjrj");
        registerPage = new RegisterPageObject(driver, data);
        //registerPage.fill();

        registerSuccessPage = new RegisterSuccessPageObject(driver);



    }

    @Test
    public void doRegister () throws InterruptedException {
        driver.get("http://10.9.10.6/mysql/Main/Login.html");
        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        Thread.sleep(3000);

        loginPage.clickRegisterLink();
        registerPage.verifyPageLoaded();
        PageFactory.initElements(driver, registerPage);
        registerPage.fill();
        registerPage.clickRegisterButton();

        Thread.sleep(3000);

        registerSuccessPage.verifyPageLoaded();
        PageFactory.initElements(driver, registerSuccessPage);
        Thread.sleep(3000);

        registerSuccessPage.clickHomepageLink();

        loginPage.verifyPageLoaded();
        PageFactory.initElements(driver, loginPage);
        loginPage.fill();
        Thread.sleep(3000);
        loginPage.clickSignInButton();
        Thread.sleep(3000);



    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
