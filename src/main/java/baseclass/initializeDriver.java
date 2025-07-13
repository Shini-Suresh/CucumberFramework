package baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.utilityFecthProperty;

import java.io.IOException;

public class initializeDriver
{
    @Before
    public static void initDriver() throws IOException {
        WebDriver driver = null;
        //browser value is fetched from property file
        String browsername = utilityFecthProperty.fetchPropertyValue("browser");
        switch (browsername) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();

        }
        driverContext.setDriver(driver);
        driverContext.Driver.get(utilityFecthProperty.fetchPropertyValue("url"));
        driverContext.Driver.manage().window().maximize();

    }
    @After
    public static void quitDriver() {
        driverContext.Driver.quit();
    }
}
