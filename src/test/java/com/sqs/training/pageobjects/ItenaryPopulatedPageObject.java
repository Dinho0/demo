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

public class ItenaryPopulatedPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlight;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement cloud9Airlines;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10206']")
    @CacheLookup
    private WebElement delete1;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10212']")
    @CacheLookup
    private WebElement delete2;

    @FindBy(css = "a[href='Itinerary.php']")
    @CacheLookup
    private WebElement itinerarycurrent;

    @FindBy(css = "a[href='Logout.php']")
    @CacheLookup
    private WebElement logout;

    private final String pageLoadedText = "";

    private final String pageUrl = "/mysql/Main/Itinerary.php";

    @FindBy(css = "button.navbar-toggle.collapsed")
    @CacheLookup
    private WebElement toggleNavigation;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10206']")
    @CacheLookup
    private WebElement update1;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10212']")
    @CacheLookup
    private WebElement update2;

    public ItenaryPopulatedPageObject() {
    }

    public ItenaryPopulatedPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ItenaryPopulatedPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ItenaryPopulatedPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Flight Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickBookFlightLink() {
        bookFlight.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickDelete1Link() {
        delete1.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickDelete2Link() {
        delete2.click();
        return this;
    }

    /**
     * Click on Itinerarycurrent Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickItinerarycurrentLink() {
        itinerarycurrent.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickUpdate1Link() {
        update1.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject clickUpdate2Link() {
        update2.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject verifyPageLoaded() {
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
     * @return the ItenaryPopulatedPageObject class instance.
     */
    public ItenaryPopulatedPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
