package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(css = "#navbarSupportedContent > ul > li.identifier")
    private WebElement adminText;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    private WebElement registerPatientButton;

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    private WebElement findPatientRecordButton;

    @FindBy(id = "org-openmrs-module-coreapps-datamanagement-homepageLink-org-openmrs-module-coreapps-datamanagement-homepageLink-extension")
    private WebElement dataManagementButton;

    @FindBy(id = "org-openmrs-module-coreapps-mergepatientdataapp-homepageLink-org-openmrs-module-coreapps-mergepatientdataapp-homepageLink-extension")
    private WebElement mergePatientRecordsButton;


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

    public void clickFindPatientRecord() {
        clickElement(findPatientRecordButton);
        LOGGER.info("Find Patient Record button clicked");
    }

    public void clickDataManagementLink() {
        clickElement(dataManagementButton);
        LOGGER.info("Data Management button clicked");
    }

    public void clickMergePatientRecordsButton() {
        clickElement(mergePatientRecordsButton);
        LOGGER.info("Merge Patient Electronic Records button clicked");
    }
}