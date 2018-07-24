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

public class RegisterPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    private final String pageLoadedText = "Cloud9 - Register";

    private final String pageUrl = "/mysql/Main/Register.html";

    @FindBy(id = "inputfirstname")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "inputlastname")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "inputEmail")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "inputPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(css = "button.btn.btn-lg.btn-primary.btn-block")
    @CacheLookup
    private WebElement register;

    public RegisterPageObject() {
    }

    public RegisterPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public RegisterPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public RegisterPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Register Button.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject clickRegisterButton() {
        register.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject fill() {
        setfirstNameTextField();
        setlastNameTextField();
        setemailField();
        setpasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Password Text field
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setfirstNameTextField() {
        return setfirstNameTextField(data.get("first_name"));
    }

    /**
     * Set value to Password Text field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setfirstNameTextField(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set default value to Password Text field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setlastNameTextField() {
        return setlastNameTextField(data.get("last_name"));
    }

    /**
     * Set value to Password Text field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setlastNameTextField(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set default value to Password Email field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setemailField() {
        return setemailField(data.get("email"));
    }

    /**
     * Set value to Password Email field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setemailField(String emailValue) {
       email.sendKeys(emailValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setpasswordPasswordField() {
        return setpasswordPasswordField(data.get("password"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject setpasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject submit() {
        clickRegisterButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject verifyPageLoaded() {
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
     * @return the RegisterPageObject class instance.
     */
    public RegisterPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
