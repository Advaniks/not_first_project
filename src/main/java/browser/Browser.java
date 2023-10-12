package browser;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;

import java.time.Duration;

import static browser.Config.BROWSER_TYPE;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static constants.Constant.URLs.START_PAGE_URL;

public class Browser {
    public static WebDriver driver;
    public static WebDriver CreateDriver(){
        switch (BROWSER_TYPE){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().window().maximize();
        return driver;
    };
}
