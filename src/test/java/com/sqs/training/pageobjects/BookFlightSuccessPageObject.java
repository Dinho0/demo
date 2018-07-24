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

public class BookFlightSuccessPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlightcurrent;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement cloud9Airlines;

    @FindBy(css = "a[href='Itinerary.php']")
    @CacheLookup
    private WebElement itinerary;

    @FindBy(css = "a[href='Logout.php']")
    @CacheLookup
    private WebElement logout;

    private final String pageLoadedText = "Flight Successfully Booked";

    private final String pageUrl = "/mysql/Main/BookFlight.php";

    @FindBy(css = "button.navbar-toggle.collapsed")
    @CacheLookup
    private WebElement toggleNavigation;

    public BookFlightSuccessPageObject() {
    }

    public BookFlightSuccessPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public BookFlightSuccessPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public BookFlightSuccessPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Flightcurrent Link.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject clickBookFlightcurrentLink() {
        bookFlightcurrent.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Itinerary Link.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject clickItineraryLink() {
        itinerary.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject verifyPageLoaded() {
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
     * @return the BookFlightSuccessPageObject class instance.
     */
    public BookFlightSuccessPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
