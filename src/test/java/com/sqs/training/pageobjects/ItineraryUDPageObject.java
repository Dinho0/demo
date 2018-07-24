package com.sqs.training.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItineraryUDPageObject {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy (xpath = "/html/body/div/div/div[2]/div/table")
    @CacheLookup
    private  WebElement tablee;


    @FindBy(css = "a[href='BookFlight.html']")
    @CacheLookup
    private WebElement bookFlight;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement cloud9Airlines;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10224']")
    @CacheLookup
    private WebElement delete1;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10249']")
    @CacheLookup
    private WebElement delete2;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10250']")
    @CacheLookup
    private WebElement delete3;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10252']")
    @CacheLookup
    private WebElement delete4;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10253']")
    @CacheLookup
    private WebElement delete5;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10255']")
    @CacheLookup
    private WebElement delete6;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10256']")
    @CacheLookup
    private WebElement delete7;

    @FindBy(css = "a[href='DeleteFlight.php?FlightID=10263']")
    @CacheLookup
    private WebElement delete8;

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

    @FindBy(css = "a[href='EditFlight.php?FlightID=10224']")
    @CacheLookup
    private WebElement update1;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10249']")
    @CacheLookup
    private WebElement update2;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10250']")
    @CacheLookup
    private WebElement update3;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10252']")
    @CacheLookup
    private WebElement update4;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10253']")
    @CacheLookup
    private WebElement update5;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10255']")
    @CacheLookup
    private WebElement update6;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10256']")
    @CacheLookup
    private WebElement update7;

    @FindBy(css = "a[href='EditFlight.php?FlightID=10263']")
    @CacheLookup
    private WebElement update8;



    public ItineraryUDPageObject() {
    }

    public ItineraryUDPageObject(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ItineraryUDPageObject(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ItineraryUDPageObject(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**  public ItenaryPopulatedPageObject clickUpdateLink(){

        List < WebElement > rows_table = tablee.findElements(By.tagName("tr"));

        int rowcount = rows_table.size();

        for (int currentrow = 0; currentrow < rowcount; currentrow++){


            if(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table")).getText().contains("Origin")) {

            }

    }

     * Click on Book Flight Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickBookFlightLink() {
        bookFlight.click();
        return this;
    }

    /**
     * Click on Cloud9 Airlines Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickCloud9AirlinesLink() {
        cloud9Airlines.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete1Link() {
        delete1.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete2Link() {
        delete2.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete3Link() {
        delete3.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete4Link() {
        delete4.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete5Link() {
        delete5.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete6Link() {
        delete6.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete7Link() {
        delete7.click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickDelete8Link() {
        delete8.click();
        return this;
    }

    /**
     * Click on Itinerarycurrent Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickItinerarycurrentLink() {
        itinerarycurrent.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate1Link() {
        update1.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate2Link() {
        update2.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate3Link() {
        update3.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate4Link() {
        update4.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate5Link() {
        update5.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate6Link() {
        update6.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate7Link() {
        update7.click();
        return this;
    }

    /**
     * Click on Update Link.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject clickUpdate8Link() {
        update8.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject verifyPageLoaded() {
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
     * @return the ItineraryUDPageObject class instance.
     */
    public ItineraryUDPageObject verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
