package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement buttonElement = driver.findElement(By.xpath("//button[@id=\'submit\']"));
        new Actions(driver).scrollByAmount(0,800);
        WebElement inputUnElement = driver.findElement(By.xpath("//input[@id=\'userName\']"));
        WebElement inputUeElement = driver.findElement(By.xpath("//input[@id=\'userEmail\']"));
        WebElement currentAddressElement = driver.findElement(By.xpath("//textarea[@id=\'currentAddress\']"));
        WebElement permanentAddressElement = driver.findElement(By.xpath("//textarea[@id=\'permanentAddress\']"));
        inputUnElement.sendKeys("Nikita");
        inputUeElement.sendKeys("shaymardanovnikita@gmail.com");
        currentAddressElement.sendKeys("ул. Пушкина, д. Колотушкина");
        permanentAddressElement.sendKeys("ул. Колотушкина, д. Пушкина");
        buttonElement.click();
        String name;
        String email;
        String currentAddress;
        String permanentAddress;
        WebElement nameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement emailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        name = nameOutput.getText();
        email = emailOutput.getText();
        currentAddress = currentAddressOutput.getText();
        permanentAddress = permanentAddressOutput.getText();
        System.out.println(name.split(":")[1]+"-"+email.split(":")[1]+"-"+currentAddress.split(":")[1]+"-"+permanentAddress.split(":")[1]);
        currentAddressElement.sendKeys(" "+name.split(":")[1]);
    }
}