package com.sqs.training.pageobjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "inputEmail")
    @CacheLookup
    private WebElement emailAddress;

    private final String pageLoadedText = "Cloud9 - Sign in";

    private final String pageUrl = "/mysql/Main/Login.html";

    @FindBy(id = "inputPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(css = "a[href='Register.html']")
    @CacheLookup
    private WebElement register;

    @FindBy(css = "button.btn.btn-lg.btn-primary.btn-block")
    @CacheLookup
    private WebElement signIn;

    public LoginPageObject() {
    }

    public LoginPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public LoginPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LoginPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Register Link.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject clickRegisterLink() {
        register.click();
        return this;
    }

    /**
     * Click on Sign In Button.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject clickSignInButton() {
        signIn.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject fill() {
        setEmailAddressEmailField();
        setPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Email Address Email field.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject setEmailAddressEmailField() {
        return setEmailAddressEmailField(data.get("EMAIL_ADDRESS"));
    }

    /**
     * Set value to Email Address Email field.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject setEmailAddressEmailField(String emailAddressValue) {
        emailAddress.sendKeys(emailAddressValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject submit() {
        clickSignInButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the LoginPageObject class instance.
     */
    public LoginPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
