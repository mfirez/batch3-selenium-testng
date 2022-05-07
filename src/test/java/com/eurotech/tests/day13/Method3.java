package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class Method3 {

    // ---> //tagName[text()='exact text'] or //tagName[.='exact text']

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://www.booking.com/");

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Griechische Inseln");
        driver.findElement(By.xpath("//span[@class='js-sb-submit-text ']")).click();
        String actuelText=driver.findElement(By.cssSelector(".e1f827110f.d3a14d00da")).getText();
        System.out.println("actuelText = " + actuelText);
    }

    @Test
    public void test2() {
        driver.get("https://www.amazon.de/");

        WebElement categoriesDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //select classindan obje olusturduk
        Select categoriesList = new Select(categoriesDropDown);

        // select classina bagli tüm elementleri list olarak döndürür.
        List<WebElement> options = categoriesList.getOptions();

        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }

        int expectedSizeAlleCategories= 47;
        System.out.println("alleCategories.size() = " + options.size());
        int actualSizeAlleCategories=options.size();

        Assert.assertEquals(actualSizeAlleCategories,expectedSizeAlleCategories,"verify that alle categories size");



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
