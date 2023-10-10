package text_box_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
    private WebDriver driver;
    private JavascriptExecutor jse;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com");
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void step_01(){

        WebElement elementsButton = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][div[div[@class='card-body'][h5[contains(text(),'Elements')]]]]"));
        jse.executeScript("arguments[0].scrollIntoView()",elementsButton);
        elementsButton.click();
        WebElement textElement = driver.findElement(By.xpath("//div[contains(text(),'Please select an')]"));
        jse.executeScript("arguments[0].scrollIntoView()",textElement);
        String resultText = textElement.getText();
//        if (resultText.equals("Please select an item from left to start practice.")){
//            System.out.println("Тест успешно пройден!");
//        }
//        else{
//            System.out.println("Тест провален!");
//        }
        Assert.assertTrue(resultText.equals("Please select an item from left to start practice."));
    }
}
