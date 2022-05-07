package com.eurotech.tests.day16.typeOfElements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class NonSelectDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testName() {
        driver.get("https://demo.aspnetawesome.com/");

        // once dropdown menünün acilmasi icin click yapmaliyiz(manuel deki gibi düsünmeliyiz)
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        //bütün elemntleri gören locator bulunur ve list elemente atanir
        List<WebElement> papaya = driver.findElements(By.cssSelector(".o-itm.o-nod.o-nv.o-ditm"));
        //List<WebElement> papaya = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));

        System.out.println("papaya.size() = " + papaya.size());

        for (WebElement webElement : papaya) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }
        System.out.println(papaya.get(1).getText());
        papaya.get(1).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
