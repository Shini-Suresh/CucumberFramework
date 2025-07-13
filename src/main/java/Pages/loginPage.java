package Pages;

import baseclass.driverContext;
import constants.constant;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.commonMethods;

import java.util.List;
import java.util.Map;

public class loginPage
{
    commonMethods common=new commonMethods();
    public loginPage() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//input[@name='username']")
    WebElement username_field;
    private @FindBy(xpath = "//input[@name='password']")
    WebElement password_field;
    private @FindBy(xpath = "//*[@type='submit']")
    WebElement login_button;
    private @FindBy(xpath = "(//img[@alt='profile picture'])[1]")
    WebElement profileImage;
    private @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;


    public void   performLogin(String username, String password) throws InterruptedException {
        Thread.sleep(10000);
        common.enterText(username_field,username);
        common.enterText(password_field,password);
        common.waitUntilWebElementToBeClickable(login_button);
        login_button.click();
    }
    public String getLoginTitle()
    {
        return driverContext.Driver.getTitle();
    }
    public void  verifyPageTitle() throws InterruptedException {
        Thread.sleep(10000);
        String actualTitle=driverContext.Driver.getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(constant.DASHBOARD_URL),"URL of the page is not as expected");
    }

    public void multipleLogin(DataTable userDetails) throws InterruptedException {
        List<Map<String, String>> userDetailsData =userDetails.asMaps(String.class, String.class);
        Thread.sleep(10000);
        for(Map<String, String> loginDetails: userDetailsData)
        {
            common.enterText(username_field,loginDetails.get("username"));
            common.enterText(password_field,loginDetails.get("password"));
            common.waitUntilWebElementToBeClickable(login_button);
            common.clickOnAnElement(login_button);
            common.clickOnAnElement(profileImage);
            common.clickOnAnElement(logoutButton);
        }

    }
}
