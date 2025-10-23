package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(css = "div.JGea75oGL3rl8HguRCx48Q\\=\\= > div > p:nth-child(1)")
    private WebElement clinicText;

    @FindBy(css = "div:nth-child(3) > span > div > button")
    private WebElement addPatientButton;

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
        verifyDisplayed(clinicText, "Clinic");
        LOGGER.info("Login successful");
    }

    public void clickAddPatientButton(){
        clickElement(addPatientButton);
        LOGGER.info("Add Patient button clicked");
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