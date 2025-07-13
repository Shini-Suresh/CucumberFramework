package Pages;

import baseclass.driverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.commonMethods;

public class AdminPage {
    commonMethods methods=new commonMethods();
    public AdminPage() {
        PageFactory.initElements(driverContext.Driver, this);
    }
    private @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin_label;

    public void navigateToAdminPage()
    {
        methods.clickOnAnElement(admin_label);


    }
}
