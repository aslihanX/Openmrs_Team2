package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(css = "h2")
    private WebElement registerPatientHeader;

    @FindBy(name = "givenName")
    private WebElement firstNameInput;

    @FindBy(name = "familyName")
    private WebElement lastNameInput;

    @FindBy(id = "gender-field")
    private WebElement genderSelect;

    @FindBy(id = "birthdateDay-field")
    private WebElement birthDayInput;

    @FindBy(id = "birthdateMonth-field")
    private WebElement birthMonthSelect;

    @FindBy(id = "birthdateYear-field")
    private WebElement birthYearInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(name = "phoneNumber")
    private WebElement phoneInput;

    @FindBy(id = "relationship_type")
    private WebElement relationshipSelect;

    @FindBy(css = "input[id*='person']")
    private WebElement relationshipNameInput;

    @FindBy(id = "confirmation_label")
    private WebElement confirmButton;

    @FindBy(css = "#coreapps-diagnosesList > div.info-header > h3")
    private WebElement patientDiagnoses;

    @FindBy(css = "span.PersonName-givenName")
    private WebElement patientName;

    @FindBy(css = "span.patient-id")
    private WebElement patientId;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void verifyRegisterPatientPage() {
        verifyDisplayed(registerPatientHeader, "Register a patient");
        LOGGER.info("Verify Register Patient page is displayed");
    }

    public void enterDemographics(final String firstName, final String lastName, final String gender,
                                  final String day, final String month, final String year) {
        sendKeysToElement(firstNameInput, firstName);
        LOGGER.info("First name entered");
        sendKeysToElement(lastNameInput, lastName);
        LOGGER.info("Last name entered");
        selectFromDropdownByVisibleText(genderSelect, gender);
        LOGGER.info("Gender selected");
        sendKeysToElement(birthDayInput, day);
        sendKeysToElement(birthMonthSelect, month);
        sendKeysToElement(birthYearInput, year);
        LOGGER.info("Birthdate entered");
    }

    public void enterContactInfo(final String address, final String phone) {
        sendKeysToElement(addressInput, address);
        LOGGER.info("Address entered");
        sendKeysToElement(phoneInput, phone);
        LOGGER.info("Phone number entered");
    }

    public void enterRelationship(final String relationship) {
        selectFromDropdownByVisibleText(relationshipSelect, relationship);
        LOGGER.info("Relationship type selected");
        sendKeysToElement(relationshipNameInput, "Relative Name");
        LOGGER.info("Relationship name entered");
    }

    public void clickConfirmButton() {
        clickElement(confirmButton);
        LOGGER.info("Confirm button clicked");
    }

    public void verifyPatientPage() {
        verifyDisplayed(patientDiagnoses, "DIAGNOSES");
        LOGGER.info("Verify patient page is displayed");
    }

    public void verifyPatientNameAndIdDisplayed() {
        verifyDisplayed(patientName, patientName.getText());
        verifyDisplayed(patientId, patientId.getText());
        LOGGER.info("Patient name and ID are displayed successfully");
    }
}
