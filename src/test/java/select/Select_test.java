package select;

import browser.Browser;
import main_pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Select_test {
    private WebDriver driver;
    private MainPage mainPage;

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
        mainPage.OpenUrl("https://demoqa.com/select-menu");
        String locator = "//select[@id='oldSelectMenu']";
        Select colorSelect = new Select(mainPage.FindAndScrollElement(locator));
        colorSelect.selectByVisibleText("Purple");
        Assert.assertTrue(( colorSelect.getFirstSelectedOption().getText().equals("Purple")));
    }

    @Test
    public void step_02(){
        String locator = "//div[div[div[text()='Select Option']]]";
        mainPage.Click(locator);
            String locatorSelect = "//div[@class=' css-26l3qy-menu']";

        mainPage.WaitElementForDisplay(locatorSelect);
        mainPage.Click(locatorSelect+"/div[text()='Group 1, option 1']");

        //Assert.assertTrue();
    }
}
