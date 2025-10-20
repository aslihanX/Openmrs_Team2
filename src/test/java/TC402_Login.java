import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;

public class TC402_Login extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;
    private DemoPage demoPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        demoPage = new DemoPage(driver);
    }

    @Test(priority = 1, description = "Verify that home page is visible successfully")
    public void verifyHomePage() {
        homePage.verifyPage();
        LOGGER.info("Home page opened");
    }

    @Test(priority = 2, description = "Verify that the demo page is visible")
    public void openDemoPage() {

        homePage.clickDemoButton();
        LOGGER.info("Demo button clicked");

        demoPage.verifyDemoPage();
        LOGGER.info("Demo page opened");

        demoPage.clickExploreButton();
        LOGGER.info("Explore button clicked");

        demoPage.clickEnterDemoButton();
        LOGGER.info("Enter demo button clicked");
    }

    @Test(priority = 3, description = "Verify that login page is visible")
    public void loginPage() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");

        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");

        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 4, description = "Verify successful login")
    public void adminLogin() {
        loginPage.verifyAdminLogin();
        LOGGER.info("Login successful");
    }
}