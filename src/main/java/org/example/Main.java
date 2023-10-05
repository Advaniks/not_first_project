package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebElement currentElement = driver.findElement(By.xpath("//input[@id=\'userName\']"));
        currentElement.sendKeys("Nikita");
        currentElement = driver.findElement(By.xpath("//input[@id=\'userEmail\']"));
        currentElement.sendKeys("shaymardanovnikita@gmail.com");
        currentElement = driver.findElement(By.xpath("//textarea[@id=\'currentAddress\']"));
        currentElement.sendKeys("ул. Пушкина, д. Колотушкина");
        currentElement = driver.findElement(By.xpath("//textarea[@id=\'permanentAddress\']"));
        currentElement.sendKeys("ул. Колотушкина, д. Пушкина");
        currentElement = driver.findElement(By.xpath("//button[@id=\'submit\']"));
        currentElement.click();
    }
}