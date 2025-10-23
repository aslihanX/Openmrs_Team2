package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = "div:nth-child(1) > div > h4")
    private WebElement createNewPatientHeader;

    @FindBy(id = "givenName")
    private WebElement firstNameInput;

    @FindBy(name = "familyName")
    private WebElement lastNameInput;

    @FindBy(css = "label[for='gender-option-male'] > span.cds--radio-button__appearance")
    private WebElement genderSelect;

    @FindBy(xpath = "//div[3]/div[1]/div[2]/button[2]/span")
    private WebElement birthdayNoClick;

    @FindBy(id = "monthsEstimated")
    private WebElement monthsEstimatedInput;

    @FindBy(css = "button.-esm-patient-registration__patient-registration__submitButton___Ps1do.cds--btn.cds--btn--primary")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCreateNewPatientPage() {
        verifyDisplayed(createNewPatientHeader, "Create new patient");
        LOGGER.info("Verify Create New Patient page is displayed");
    }

    public void enterName(final String firstName, final String lastName) {
        sendKeysToElement(firstNameInput, firstName);
        LOGGER.info("First name entered");
        sendKeysToElement(lastNameInput, lastName);
        LOGGER.info("Last name entered");
    }

    public void selectGender() {
        clickElement(genderSelect);
        LOGGER.info("Gender selected");
    }

    public void clickBirthdayNo() {
        clickElement(birthdayNoClick);
        LOGGER.info("No selected");
    }

    public void enterAge(final String age) {
        sendKeysToElement(monthsEstimatedInput, age);
        LOGGER.info("Age entered");
    }

    public void clickRegisterButton() {
        clickElement(registerButton);
        LOGGER.info("Confirm button clicked");
    }
}