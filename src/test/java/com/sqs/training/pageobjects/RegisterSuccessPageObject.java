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

public class RegisterSuccessPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='Login.html']")
    @CacheLookup
    private WebElement homepage;

    private final String pageLoadedText = "Registration Successful";

    private final String pageUrl = "/mysql/Main/Register.php";

    public RegisterSuccessPageObject() {
    }

    public RegisterSuccessPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public RegisterSuccessPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public RegisterSuccessPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Homepage Link.
     *
     * @return the RegisterSuccessPageObject class instance.
     */
    public RegisterSuccessPageObject clickHomepageLink() {
        homepage.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the RegisterSuccessPageObject class instance.
     */
    public RegisterSuccessPageObject verifyPageLoaded() {
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
     * @return the RegisterSuccessPageObject class instance.
     */
    public RegisterSuccessPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
