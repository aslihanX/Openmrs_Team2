package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {

    @FindBy(css = ".zak-page-header__title > .zak-page-title")
    private WebElement demoPageText;

    @FindBy(css = "a[href='#openmrs2'] > span[class='elementor-button-content-wrapper']" )
    private WebElement exploreButton;

    @FindBy(css = "div[data-id='255a6bc'] > div > div > a > span[class='elementor-button-content-wrapper']")
    private WebElement enterDemoButton;

    public DemoPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDemoPage(){
        verifyDisplayed(demoPageText, "Demo Page is not displayed");
        LOGGER.info("Verify demo page open");
    }

    public void clickExploreButton(){
        clickElement(exploreButton);
        LOGGER.info("Explore button clicked");
    }

    public void clickEnterDemoButton(){
        clickElement(enterDemoButton);
        LOGGER.info("Enter demo button clicked");
    }
}