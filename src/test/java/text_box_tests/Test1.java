package text_box_tests;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.base.BasePage;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;
import static constants.Constant.URLs.START_PAGE_URL;

public class Test1 {

    private WebDriver driver;
    private BasePage basePage;

    @BeforeClass
    public void beforeClass(){
        driver = Browser.CreateDriver();
        basePage = new BasePage(driver);
        basePage.OpenStartPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void step_01(){

        basePage.Click("//div[@class='card mt-4 top-card'][div[div[@class='card-body'][h5[contains(text(),'Elements')]]]]");
        Assert.assertTrue(basePage.getText("//div[contains(text(),'Please select an')]").equals("Please select an item from left to start practice."));
    }
}
