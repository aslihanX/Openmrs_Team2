package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PatientPage extends BasePage {

    @FindBy(css = "div:nth-child(1) > div > a > span > span")
    private WebElement patientSummary;

    @FindBy(css = "span[class='_3QvC113UMQvMOBhW+z79+Q==']")
    private WebElement patientName;

    @FindBy(css = "span[class='_7O7gKi8oSk8dU4N7z9kfrQ==']")
    private WebElement patientId;

    public PatientPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPatientPage() {
        verifyDisplayed(patientSummary, "Patient summary");
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