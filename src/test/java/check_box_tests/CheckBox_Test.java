package check_box_tests;

import browser.Browser;
import main_pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox_Test {
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
        mainPage.OpenUrl("https://demoqa.com/checkbox");
        mainPage.setCheckBox("Home",true);
        mainPage.setCheckBox("Home",true);
        Assert.assertTrue(mainPage.getCheckBoxState("Home"));
        Assert.assertTrue(mainPage.getText("//div[@id='result']/span[1]").contains("You have"));
    }

}
