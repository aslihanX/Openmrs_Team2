package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = "#content > h2")
    private WebElement registerPatientHeader;

    @FindBy(name = "givenName")
    private WebElement firstNameInput;

    @FindBy(name = "familyName")
    private WebElement lastNameInput;

    @FindBy(css = "#next-button > icon")
    private WebElement nextButton;

    @FindBy(id = "gender-field")
    private WebElement genderSelect;

    @FindBy(id = "birthdateYears-field")
    private WebElement ageInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(name = "phoneNumber")
    private WebElement phoneInput;

    @FindBy(id = "relationship_type")
    private WebElement relationshipSelect;

    @FindBy(id = "submit")
    private WebElement confirmButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void verifyRegisterPatientPage() {
        verifyDisplayed(registerPatientHeader, "Register a patient");
        LOGGER.info("Verify Register Patient page is displayed");
    }

    public void enterName(final String firstName, final String lastName) {
        sendKeysToElement(firstNameInput, firstName);
        LOGGER.info("First name entered");
        sendKeysToElement(lastNameInput, lastName);
        LOGGER.info("Last name entered");
    }

    public void clickNext(){
        clickElement(nextButton);
        LOGGER.info("Next button clicked");
    }

    public void selectGender(final String gender) {
        selectFromDropdownByVisibleText(genderSelect, gender);
        LOGGER.info("Gender selected");
    }

    public void enterAge(final String age) {
        sendKeysToElement(ageInput, age);
        LOGGER.info("Birthdate entered");
    }

    public void enterAddress(final String address) {
        sendKeysToElement(addressInput, address);
        LOGGER.info("Address entered");
    }

    public void enterPhoneNumber(final String phone) {
        sendKeysToElement(phoneInput, phone);
        LOGGER.info("Phone number entered");
    }

    public void selectRelationship(final String relationship) {
        selectFromDropdownByVisibleText(relationshipSelect, relationship);
        LOGGER.info("Relationship type selected");
    }

    public void clickConfirmButton() {
        clickElement(confirmButton);
        LOGGER.info("Confirm button clicked");
    }
}