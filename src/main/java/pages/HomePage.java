package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "div > h1 > span")
    private WebElement homePageText;

    @FindBy(css = "a[class='zak-button']")
    private WebElement demoButton;

    public HomePage(final WebDriver driver){
       super(driver);
    }

    public void verifyPage() {
        verifyDisplayed(homePageText, "Home page is not displayed");
        LOGGER.info("Verify home page is displayed");
    }

    public void clickDemoButton() {
        clickElement(demoButton);
        LOGGER.info("Demo button clicked");
    }
}