package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

   // @FindBy(id = "login-form")
  //  private WebElement loginForm;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Inpatient Ward")
    private WebElement locationButton;

    @FindBy(xpath = "//form/div/button")
    private WebElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPage() {
       // verifyDisplayed(loginForm, "LOGIN");
       // LOGGER.info("Verify login page is displayed");
    }

    public void fillLoginForm(final String username, final String password) {
        sendKeysToElement(usernameInput, username);
        LOGGER.info("Email entered");
        clickElement(loginButton);
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
}