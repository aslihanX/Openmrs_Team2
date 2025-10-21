package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PatientPage extends BasePage {

    @FindBy(css = "#coreapps-diagnosesList > div.info-header > h3")
    private WebElement patientDiagnoses;

    @FindBy(className = "PersonName-givenName")
    private WebElement patientName;

    @FindBy(css = "#content > div.patient-header.row > div.identifiers.mt-2.col-12.col-sm-5.col-md-4 > div > span")
    private WebElement patientId;

    public PatientPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPatientPage() {
        verifyDisplayed(patientDiagnoses, "DIAGNOSES");
        LOGGER.info("Verify patient page is displayed");
    }

    public void verifyPatientNameAndIdDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(patientName));
        Assert.assertTrue(patientName.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(patientId));
        Assert.assertTrue(patientId.isDisplayed());
        LOGGER.info("Patient name and ID are displayed successfully");
    }
}