package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(css = "#navbarSupportedContent > ul > li.identifier")
    private WebElement adminText;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    private WebElement registerPatientButton;

    public MenuPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyAdminLogin() {
        verifyDisplayed(adminText, "admin");
        LOGGER.info("Login successful");
    }

    public void clickRegisterPatientButton(){
        clickElement(registerPatientButton);
        LOGGER.info("Register a Patient button clicked");
    }
}