package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FindPatientPage extends BasePage {

    @FindBy(css = "tbody tr td:nth-child(2)")
    private List<WebElement> patientIdCells;

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    public FindPatientPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyPageLoaded() {
        verifyDisplayed(pageTitle, "Find Patient Record");
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    public String getFirstPatientID() {
        String id1 = patientIdCells.get(0).getText();
        LOGGER.info("First patient ID captured: " + id1);
        return id1;
    }

    public String getSecondPatientID() {
        String id2 = patientIdCells.get(1).getText();
        LOGGER.info("Second patient ID captured: " + id2);
        return id2;
    }
}
