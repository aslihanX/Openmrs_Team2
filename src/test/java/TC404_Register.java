import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.RegisterPage;

public class TC404_Register extends BaseGUITest {

    private RegisterPage registerPage;
    private MenuPage menuPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        registerPage = new RegisterPage(driver);
        menuPage = new MenuPage(driver);
    }


    @Test(priority = 1, description = "Verify user can login successfully before registration")
    public void loginBeforeRegister() {
        TC402_Login loginTest = new TC402_Login();
        loginTest.login();
    }

    @Test(priority = 2, description = "Verify that user can open Register a Patient form")
    public void openRegisterPatientForm() {
        menuPage.clickRegisterPatientButton();
        LOGGER.info("Register a Patient button clicked");

        registerPage.verifyRegisterPatientPage();
        LOGGER.info("Register a Patient form opened");
    }

    @Test(priority = 3, description = "Verify that user can fill patient details and register successfully")
    public void registerNewPatient() {
        registerPage.enterDemographics("John", "Doe", "Male", "01", "January", "1990");
        LOGGER.info("Demographics data entered");

        registerPage.enterContactInfo("123 Main St", "555-1234");
        LOGGER.info("Contact info entered");

        registerPage.enterRelationship("Father");
        LOGGER.info("Relationship data entered");

        registerPage.clickConfirmButton();
        LOGGER.info("Confirm button clicked");

        registerPage.verifyPatientPage();
        LOGGER.info("Patient page opened successfully after registration");

        registerPage.verifyPatientNameAndIdDisplayed();
        LOGGER.info("Patient name and ID verified on patient page");
    }
}
