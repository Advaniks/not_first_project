package text_box_tests;

import browser.Browser;
import main_pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.base.BasePage;
import pages.elements.ElementsPage;

public class Test1 {

    private WebDriver driver;
    //private BasePage basePage;
    private MainPage mainPage;
    private ElementsPage elementsPage;

    @BeforeClass
    public void beforeClass(){
        driver = Browser.CreateDriver();
        //basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        mainPage.OpenStartPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void step_01(){
        elementsPage = mainPage.openCategoryElements();
        //basePage.Click("//div[@class='card mt-4 top-card'][div[div[@class='card-body'][h5[contains(text(),'Elements')]]]]");
        Assert.assertTrue(mainPage.getText("//div[contains(text(),'Please select an')]").equals("Please select an item from left to start practice."));
    }
}
