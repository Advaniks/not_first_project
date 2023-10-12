package main_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import pages.elements.ElementsPage;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String HOME_BANNER = "//div[@class='home-banner'][a[@href='https://www.toolsqa.com/selenium-training/']]";
    public static final String BLOCK_XPATH = "//div[@class='card mt-4 top-card']";
    public static final String CATEGORY_BLOCKS_XPATH = BLOCK_XPATH + "[div[div[@class='card-body'][h5[contains(text(),'%s')]]]]";

    public void openCategory(String categoryName){
        Click(String.format(CATEGORY_BLOCKS_XPATH,categoryName));
    }

    public ElementsPage openCategoryElements(){
        WaitElementForDisplay(BLOCK_XPATH,10);
        List<WebElement> elements = FindElements(BLOCK_XPATH);
        ClickOnElement(elements.get(0));
        return new ElementsPage(driver);
    }
}
