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

public class BookFlightPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn.btn-primary")
    @CacheLookup
    private WebElement book;

    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlightcurrent;

    @FindBy(id = "Flightclass")
    @CacheLookup
    private WebElement sclass;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement cloud9Airlines;

    @FindBy(id = "Destination")
    @CacheLookup
    private WebElement destination;

    @FindBy(css = "a[href='Itinerary.php']")
    @CacheLookup
    private WebElement itinerary;

    @FindBy(css = "a[href='Logout.php']")
    @CacheLookup
    private WebElement logout;

    @FindBy(id = "Origin")
    @CacheLookup
    private WebElement origin;

    private final String pageLoadedText = "Book Flight";

    private final String pageUrl = "/mysql/Main/BookFlight.html";

    @FindBy(id = "seat")
    @CacheLookup
    private WebElement seat;

    @FindBy(css = "button.navbar-toggle.collapsed")
    @CacheLookup
    private WebElement toggleNavigation;

    public BookFlightPageObject() {
    }

    public BookFlightPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public BookFlightPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public BookFlightPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Button.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickBookButton() {
        book.click();
        return this;
    }

    /**
     * Click on Book Flightcurrent Link.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickBookFlightcurrentLink() {
        bookFlightcurrent.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Itinerary Link.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickItineraryLink() {
        itinerary.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject fill() {
        setOriginDropDownListField();
        setDestinationDropDownListField();
        setSeatTextField();
        setClassDropDownListField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Class Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setClassDropDownListField() {
        return setClassDropDownListField(data.get("sCLASS"));
    }

    /**
     * Set value to Class Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setClassDropDownListField(String classValue) {
        new Select(sclass).selectByVisibleText(classValue);
        return this;
    }

    /**
     * Set default value to Destination Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setDestinationDropDownListField() {
        return setDestinationDropDownListField(data.get("DESTINATION"));
    }

    /**
     * Set value to Destination Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setDestinationDropDownListField(String destinationValue) {
        new Select(destination).selectByVisibleText(destinationValue);
        return this;
    }

    /**
     * Set default value to Origin Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setOriginDropDownListField() {
        return setOriginDropDownListField(data.get("ORIGIN"));
    }

    /**
     * Set value to Origin Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setOriginDropDownListField(String originValue) {
        new Select(origin).selectByVisibleText(originValue);
        return this;
    }

    /**
     * Set default value to Seat Text field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setSeatTextField() {
        return setSeatTextField(data.get("SEAT"));
    }

    /**
     * Set value to Seat Text field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject setSeatTextField(String seatValue) {
        seat.sendKeys(seatValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject submit() {
        clickBookButton();
        return this;
    }

    /**
     * Unset default value from Class Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetClassDropDownListField() {
        return unsetClassDropDownListField(data.get("sCLASS"));
    }

    /**
     * Unset value from Class Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetClassDropDownListField(String classValue) {
        new Select(sclass).deselectByVisibleText(classValue);
        return this;
    }

    /**
     * Unset default value from Destination Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetDestinationDropDownListField() {
        return unsetDestinationDropDownListField(data.get("DESTINATION"));
    }

    /**
     * Unset value from Destination Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetDestinationDropDownListField(String destinationValue) {
        new Select(destination).deselectByVisibleText(destinationValue);
        return this;
    }

    /**
     * Unset default value from Origin Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetOriginDropDownListField() {
        return unsetOriginDropDownListField(data.get("ORIGIN"));
    }

    /**
     * Unset value from Origin Drop Down List field.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject unsetOriginDropDownListField(String originValue) {
        new Select(origin).deselectByVisibleText(originValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject verifyPageLoaded() {
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
     * @return the BookFlightPageObject class instance.
     */
    public BookFlightPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
