import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC405_My_Account extends BaseGUITest {

    private HomePage homePage;
    private LoginPage loginPage;
    private DemoPage demoPage;
    private MenuPage menuPage;
    private MyAccountPage myAccountPage;


    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        demoPage = new DemoPage(driver);
        menuPage = new MenuPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully before test")
    public void loginBeforeTest() {
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
        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
        menuPage.verifyAdminLogin();
        LOGGER.info("Login successful");
    }

    @Test(priority = 2, description = "Verify successful enter to my account")
    public void myAccountPage() {
        myAccountPage.clickMyAccountPage();
        LOGGER.info("My Account menu opened");
    }
}