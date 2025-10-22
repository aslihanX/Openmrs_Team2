package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MergePatientPage extends BasePage {

    @FindBy(id = "patient1")
    private WebElement firstPatientIdField;

    @FindBy(id = "patient2")
    private WebElement secondPatientIdField;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    @FindBy(css = ".alert.alert-warning")
    private WebElement mergeWarningMessage;

    @FindBy(css = "input[value='Yes, Continue']")
    private WebElement yesContinueButton;

    @FindBy(css = "#content span.identifier")
    private WebElement mergedPatientIdentifier;

    @FindBy(css = "input[name='patientMergeTarget']")
    private WebElement selectPatientRadio;

    public MergePatientPage(final WebDriver driver) {
        super(driver);
    }

    public void enterPatientIDs(String id1, String id2) {
        sendKeysToElement(firstPatientIdField, id1);
        sendKeysToElement(secondPatientIdField, id2);
        LOGGER.info("Entered patient IDs: " + id1 + ", " + id2);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
        LOGGER.info("Clicked Continue button");
    }

    public void verifyWarningMessage() {
        verifyDisplayed(mergeWarningMessage, "Merging cannot be undone! Please check records before continuing.");
        LOGGER.info("Warning message verified");
    }

    public void selectPatientToKeep() {
        clickElement(selectPatientRadio);
        LOGGER.info("Selected patient to merge into");
    }

    public void clickYesContinue() {
        clickElement(yesContinueButton);
        LOGGER.info("Clicked Yes, Continue button");
    }

    public void verifyMergedIDs(String id1, String id2) {
        verifyDisplayed(mergedPatientIdentifier, id1);
        verifyDisplayed(mergedPatientIdentifier, id2);
        LOGGER.info("Verified merged patient contains both IDs: " + id1 + ", " + id2);
    }
}