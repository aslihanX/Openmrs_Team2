import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC404_Register extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;
    private DemoPage demoPage;
    private RegisterPage registerPage;
    private MenuPage menuPage;
    private PatientPage patientPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        demoPage = new DemoPage(driver);
        registerPage = new RegisterPage(driver);
        menuPage = new MenuPage(driver);
        patientPage = new PatientPage(driver);
    }


    @Test(priority = 1, description = "Verify user can login successfully before registration")
    public void loginBeforeRegister() {
        homePage.verifyPage();
        LOGGER.info("Home page opened");
        homePage.clickDemoButton();
        LOGGER.info("Demo button clicked");
        demoPage.verifyDemoPage();
        LOGGER.info("Demo page opened");
        demoPage.clickExploreButton();
        LOGGER.info("Explore button clicked");
        demoPage.clickEnterDemoButton();
        LOGGER.info("Enter demo button clicked");
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");
        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");
        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
        menuPage.verifyAdminLogin();
        LOGGER.info("Login successful");
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
        registerPage.enterName("John", "Doe");
        LOGGER.info("Name and Surname entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.selectGender("Male");
        LOGGER.info("Gender selected");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterAge("20");
        LOGGER.info("Age entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterAddress("Main St");
        LOGGER.info("Contact info entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterPhoneNumber("11111");
        LOGGER.info("Phone number entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.selectRelationship("Parent");
        LOGGER.info("Relationship data entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.clickConfirmButton();
        LOGGER.info("Confirm button clicked");

        patientPage.verifyPatientPage();
        LOGGER.info("Patient page opened successfully after registration");

        patientPage.verifyPatientNameAndIdDisplayed();
        LOGGER.info("Patient name and ID verified on patient page");
    }
}