package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login-form")
    private WebElement loginForm;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Inpatient Ward")
    private WebElement locationButton;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(css = "#navbarSupportedContent > ul > li.identifier")
    private WebElement adminText;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPage() {
        verifyDisplayed(loginForm, "Login page is not displayed");
        LOGGER.info("Verify login page is displayed");
    }

    public void fillLoginForm(final String username, final String password) {
        sendKeysToElement(usernameInput, username);
        LOGGER.info("Email entered");
        sendKeysToElement(passwordInput, password);
        LOGGER.info("Password entered");
    }

    public void clickLocationButton() {
        clickElement(locationButton);
        LOGGER.info("Location button clicked");
    }

    public void clickLoginButton() {
        clickElement(loginButton);
        LOGGER.info("Login button clicked");
    }

    public void verifyAdminLogin() {
        verifyDisplayed(adminText, "Login failed");
        LOGGER.info("Login successful");
    }
}