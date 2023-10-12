package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static constants.Constant.URLs.START_PAGE_URL;

public class BasePage {
    private JavascriptExecutor jse;
    public static final String CHECK_BOX_LOCATOR = "//input[@type='checkbox'][following-sibling::span[contains(text(),'%s')]]";

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
    public List<WebElement> FindElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void Click(String locator){
        FindAndScrollElement(locator).click();
    }
    public void ClickOnElement(WebElement element){
        ScrollToElement(element);
        element.click();
    }

    public void WaitElementForDisplay(String locator,int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(d->FindAndScrollElement(locator).isDisplayed());
    }

    public void WaitElementForEnable(String locator,int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(d->FindAndScrollElement(locator).isEnabled());
    }

    public void WaitForSeconds(int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void WaitElementForDisplay(String locator){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(d->FindAndScrollElement(locator).isDisplayed());
    }

    public Boolean getCheckBoxState(String checkBoxName){
        String locator = String.format(CHECK_BOX_LOCATOR,checkBoxName);
        return FindAndScrollElement(locator).isSelected();
    }

    public void setCheckBox(String checkBoxName,boolean state){
        String locator = String.format(CHECK_BOX_LOCATOR,checkBoxName)+"/following-sibling::span[@class='rct-checkbox']";
        if (getCheckBoxState(checkBoxName) != state){
            Click(locator);
        }
    }

    public void ScrollToElement(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView()",element);
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
