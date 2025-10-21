package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickElement(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            LOGGER.debug("Element clicked");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .perform();
                LOGGER.debug("Element clicked with Actions");
            } catch (Exception e2) {
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                    LOGGER.debug("Element clicked with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("None of the click methods worked.");
                }
            }
        }
    }

    public void sendKeysToElement(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            element.clear();
            element.sendKeys(text);
            LOGGER.debug("Text sent to element");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .sendKeys(text)
                        .build()
                        .perform();
                LOGGER.debug("Text sent to element with Actions");
            } catch (Exception e2) {
                try {
                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].value = arguments[1];", element, text);
                    LOGGER.debug("Text sent to element with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("All sendKeys operations failed.");
                }
            }
        }
    }

    public void verifyDisplayed(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), text);
    }

    public void selectFromDropdownByVisibleText(final WebElement element, final String visibleText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            new Select(element).selectByVisibleText(visibleText);
            LOGGER.debug("Option selected by visible text");
        } catch (Exception e1) {
            try {
                new Actions(driver)
                        .moveToElement(element)
                        .click()
                        .perform();
                new Select(element).selectByVisibleText(visibleText);
                LOGGER.debug("Option selected with Actions");
            } catch (Exception e2) {
                try {
                    ((JavascriptExecutor) driver)
                            .executeScript(
                                    "for (let i = 0; i < arguments[0].options.length; i++) {" +
                                            " if (arguments[0].options[i].text === arguments[1]) {" +
                                            " arguments[0].selectedIndex = i;" +
                                            " arguments[0].dispatchEvent(new Event('change'));" +
                                            " break; } }",
                                    element, visibleText);
                    LOGGER.debug("Option selected with Javascript");
                } catch (Exception e3) {
                    throw new RuntimeException("All dropdown selection operations failed.");
                }
            }
        }
    }
}