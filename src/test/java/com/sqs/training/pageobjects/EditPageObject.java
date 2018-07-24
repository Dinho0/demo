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

public class EditPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlight;

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
    private WebElement itinerarycurrent;

    @FindBy(css = "a[href='Logout.php']")
    @CacheLookup
    private WebElement logout;

    private final String pageLoadedText = "";

    private final String pageUrl = "/mysql/Main/EditFlight.php?FlightID=10223";

    @FindBy(id = "Origin")
    @CacheLookup
    private WebElement seat1;

    @FindBy(id = "seat")
    @CacheLookup
    private WebElement seat2;

    @FindBy(css = "button.navbar-toggle.collapsed")
    @CacheLookup
    private WebElement toggleNavigation;

    @FindBy(css = "button.btn.btn-primary")
    @CacheLookup
    private WebElement update;

    public EditPageObject() {
    }

    public EditPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public EditPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public EditPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Book Flight Link.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickBookFlightLink() {
        bookFlight.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Itinerarycurrent Link.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickItinerarycurrentLink() {
        itinerarycurrent.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Click on Update Button.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject clickUpdateButton() {
        update.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject fill() {
        setSeat1TextField();
        setDestinationDropDownListField();
        setClassDropDownListField();
        setSeat2TextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Class Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setClassDropDownListField() {
        return setClassDropDownListField(data.get("sCLASS"));
    }

    /**
     * Set value to Class Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setClassDropDownListField(String classValue) {
        new Select(sclass).selectByVisibleText(classValue);
        return this;
    }

    /**
     * Set default value to Destination Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setDestinationDropDownListField() {
        return setDestinationDropDownListField(data.get("DESTINATION"));
    }

    /**
     * Set value to Destination Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setDestinationDropDownListField(String destinationValue) {
        new Select(destination).selectByVisibleText(destinationValue);
        return this;
    }

    /**
     * Set default value to Seat Text field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setSeat1TextField() {
        return setSeat1TextField(data.get("SEAT_1"));
    }

    /**
     * Set value to Seat Text field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setSeat1TextField(String seat1Value) {
        new Select(seat1).selectByVisibleText(seat1Value);
        return this;
    }

    /**
     * Set default value to Seat Text field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setSeat2TextField() {
        return setSeat2TextField(data.get("SEAT_2"));
    }

    /**
     * Set value to Seat Text field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject setSeat2TextField(String seat2Value) {
        seat2.sendKeys(seat2Value);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject submit() {
        clickUpdateButton();
        return this;
    }

    /**
     * Unset default value from Class Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetClassDropDownListField() {
        return unsetClassDropDownListField(data.get("sCLASS"));
    }

    /**
     * Unset value from Class Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetClassDropDownListField(String classValue) {
        new Select(sclass).deselectByVisibleText(classValue);
        return this;
    }

    /**
     * Unset default value from Destination Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetDestinationDropDownListField() {
        return unsetDestinationDropDownListField(data.get("DESTINATION"));
    }

    /**
     * Unset value from Destination Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetDestinationDropDownListField(String destinationValue) {
        new Select(destination).deselectByVisibleText(destinationValue);
        return this;
    }

    /**
     * Unset default value from Seat Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetSeatDropDownListField() {
        return unsetSeatDropDownListField(data.get("SEAT"));
    }

    /**
     * Unset value from Seat Drop Down List field.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject unsetSeatDropDownListField(String seatValue) {
        new Select(seat2).deselectByVisibleText(seatValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the EditPageObject class instance.
     */
    public EditPageObject verifyPageLoaded() {
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
     * @return the EditPageObject class instance.
     */
    public EditPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
