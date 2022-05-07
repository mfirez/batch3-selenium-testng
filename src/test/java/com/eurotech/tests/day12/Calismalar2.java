package com.eurotech.tests.day12;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calismalar2 {
    public static void main(String[] args) throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://demoqa.com/text-box");
       driver.manage().window().maximize();

       Faker faker = new Faker();

       WebElement userName = driver.findElement(By.id("userName"));
       String userNameFake=faker.name().fullName();
       userName.sendKeys(userNameFake);

       WebElement eMail = driver.findElement(By.id("userEmail"));
       String fakeEmail = faker.internet().emailAddress();
       eMail.sendKeys(fakeEmail);

       WebElement currentAddress = driver.findElement(By.id("currentAddress"));
       String fakeCurrentAddress = faker.address().fullAddress();
       currentAddress.sendKeys(fakeCurrentAddress);

       WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
       String fakePermanentAddress = faker.address().fullAddress();
       permanentAddress.sendKeys(fakePermanentAddress);

       driver.findElement(By.id("submit")).click();
       Thread.sleep(2000);

       driver.close();
    }
}
