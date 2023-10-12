package waits;

import browser.Browser;
import main_pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.elements.ElementsPage;

public class Wait_Test {

    private WebDriver driver;
    //private BasePage basePage;
    private MainPage mainPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void beforeClass(){
        driver = Browser.CreateDriver();
        mainPage = new MainPage(driver);
        mainPage.OpenStartPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void step_01(){
        String xpath = "//button[@id='visibleAfter']";
        elementsPage = mainPage.openCategoryElements();
        elementsPage.Click("//span[text()='Dynamic Properties']");
        elementsPage.WaitElementForDisplay(xpath,15);
        elementsPage.Click(xpath);
        Assert.assertTrue(elementsPage.FindAndScrollElement(xpath).isDisplayed());
    }

    @Test
    public void step_02(){
        String xpathProps = "//span[text()='Dynamic Properties']";

        mainPage.OpenStartPage();

        elementsPage = mainPage.openCategoryElements();
        elementsPage.WaitElementForDisplay(xpathProps,10);
        elementsPage.Click("//span[text()='Dynamic Properties']");

        String xpath = "//button[@id='enableAfter']";
        elementsPage.WaitElementForEnable(xpath,15);
        elementsPage.Click(xpath);
        Assert.assertTrue(elementsPage.FindAndScrollElement(xpath).isEnabled());
    }
}
