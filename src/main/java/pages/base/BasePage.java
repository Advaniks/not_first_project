package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static constants.Constant.URLs.START_PAGE_URL;

public class BasePage {
    private JavascriptExecutor jse;
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
    }

    public void OpenUrl(String url){
        driver.get(url);
    }
    public void OpenStartPage(){
        OpenUrl(START_PAGE_URL);

    }
    public WebElement FindAndScrollElement(String locator){
        WebElement resultElement = driver.findElement(By.xpath(locator));
        jse.executeScript("arguments[0].scrollIntoView()",resultElement);
        return resultElement;
    }
    public List<WebElement> findElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void Click(String locator){
        FindAndScrollElement(locator).click();
    }

    public void clear(String locator){
        FindAndScrollElement(locator).clear();
    }

    public void sendKeys(String locator,String text){
        FindAndScrollElement(locator).sendKeys(text);
    }

    public void sendKeysWithClear(String locator,String text){
        clear(locator);
        sendKeys(locator,text);
    }

    public String getText(String locator){
        return FindAndScrollElement(locator).getText();
    }
}
