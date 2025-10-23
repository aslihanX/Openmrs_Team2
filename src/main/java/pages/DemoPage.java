package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {

    @FindBy(css = ".zak-page-header__title > .zak-page-title")
    private WebElement demoPageText;

    @FindBy(css = "a[href='#openmrs3'] > span[class='elementor-button-content-wrapper']" )
    private WebElement exploreButton;

    @FindBy(css = "#zak-content > div > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-10d1a96.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div.elementor-element.elementor-element-1294e92.elementor-align-center.elementor-widget.elementor-widget-button > div > div > a > span > span")
    private WebElement enterDemoButton;

    public DemoPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDemoPage(){
        verifyDisplayed(demoPageText, "Demo");
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