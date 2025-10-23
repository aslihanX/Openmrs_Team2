package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    @FindBy(xpath = "//div[@class='cds--tooltip-trigger__wrapper']//button[@name='User']")
    private WebElement myAccountPage;

    public MyAccountPage(WebDriver driver){super(driver);}

    public void clickMyAccountPage(){
        clickElement(myAccountPage);
        LOGGER.info("My Account clicked");
    }
}