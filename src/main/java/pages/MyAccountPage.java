package pages;

import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class MyAccountPage extends BasePage{
    @FindBy(xpath = "//div[@class='cds--tooltip-trigger__wrapper']//button[@name='User']")
    private WebElement myAccountPage;

    public MyAccountPage(WebDriver driver){super(driver);}

    public void clickMyAccountPage(){
        clickElement(myAccountPage);


    }




}
