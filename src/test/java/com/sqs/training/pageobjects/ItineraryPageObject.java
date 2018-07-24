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

public class ItineraryPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlight;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement cloud9Airlines;

    @FindBy(css = "a[href='Itinerary.php']")
    @CacheLookup
    private WebElement itinerarycurrent;

    @FindBy(css = "a[href='Logout.php']")
    @CacheLookup
    private WebElement logout;

    private final String pageLoadedText = "Itinerary";

    private final String pageUrl = "/mysql/Main/Itinerary.php";

    @FindBy(css = "button.navbar-toggle.collapsed")
    @CacheLookup
    private WebElement toggleNavigation;

    public ItineraryPageObject() {
    }

    public ItineraryPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ItineraryPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ItineraryPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Flight Link.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject clickBookFlightLink() {
        bookFlight.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Itinerarycurrent Link.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject clickItinerarycurrentLink() {
        itinerarycurrent.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject verifyPageLoaded() {
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
     * @return the ItineraryPageObject class instance.
     */
    public ItineraryPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
