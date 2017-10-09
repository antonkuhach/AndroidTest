package util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import scenarios.AndroidSetup;

import java.util.List;

public class Waiter {
    static final Logger logger = LogManager.getLogger(AbstractPage.class);
    private static WebDriverWait webDriverWait;
    private static WebDriverWait longWebDriverWait;

    static {
        int TIME_OUT = 15;
        int LONG_TIME_OUT = 30;
        webDriverWait = new WebDriverWait(AndroidSetup.getInstance().getDriver(), TIME_OUT);
        longWebDriverWait = new WebDriverWait(AndroidSetup.getInstance().getDriver(), LONG_TIME_OUT);
    }

    /***
     * Wait for the elements to be present on the page
     * @param locator
     */
    public static void waitForElementPresent(By locator) {
        logger.log(Level.INFO, "Wait for presence of element by locator: " + locator.toString());
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Wait for the elements to be visible on the page
     *
     * @param locator
     */
    public static void waitForElementVisible(By locator) {
        logger.log(Level.INFO, "Wait for visibility of element by locator: " + locator.toString());
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Wait for the element to be visible on the page
     *
     * @param element
     */
    public static void waitForElementVisible(WebElement element) {
        logger.log(Level.INFO, "Wait for presence of element: " + element.toString());
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for the element to be clickable
     *
     * @param locator
     */
    public static void waitForElementEnabled(By locator) {
        logger.log(Level.INFO, "Wait for element to be clickable by locator: " + locator.toString());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for the element to be clickable
     *
     * @param element
     */
    public static void waitForElementEnabled(WebElement element) {
        logger.log(Level.INFO, "Wait for element to be clickable: " + element.toString());
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementInvisible(By locator) {
        logger.log(Level.INFO, "Wait for invisibility of element by locator: " + locator.toString());
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    /**
     * @param locator : element to be waiting for any text length better than 0
     *                driver waiting and trying to find any text in element and it's child
     */
    public static void waitForTextPresent(By locator) {
        logger.log(Level.INFO, "Wait for the text presence of element by locator: " + locator.toString());
        webDriverWait.until(e -> e.findElement(locator).getText().length() > 0);
    }


    /**
     * driver waiting DOM to be fully loaded
     * !using JavaScript executor!
     */
    public static void waitForPageLoad() {
        logger.log(Level.INFO, "Wait for page to be loaded");
        webDriverWait.until(e -> (JavascriptExecutor) e).executeScript("return document.readyState").equals("complete");
    }

    public static void waitForListElementVisible(List<WebElement> element) {
        logger.log(Level.INFO, "Wait for visibility of all elements from list");
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void waitForElementInvisible(List<WebElement> element) {
        int TIME_OUT = 30;
        logger.log(Level.INFO, "Wait for invisibility of all elements from list");
        WebDriverWait waiter = new WebDriverWait(AndroidSetup.getInstance().getDriver(), TIME_OUT);
        waiter.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}
