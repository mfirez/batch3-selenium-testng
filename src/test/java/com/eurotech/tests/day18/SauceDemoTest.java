package com.eurotech.tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.Random;

public class SauceDemoTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase1() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "verify that Url");

    }

    @Test
    public void testCase2() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();

        driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).click();

        String expectedProductName = "Sauce Labs Fleece Jacket";
        String actualProductName = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")).getText();

        Assert.assertEquals(actualProductName, expectedProductName, "verify that Product Name");

        driver.navigate().back();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));

        // veya

        String actualTittle = driver.findElement(By.xpath("//*[text()='Products']")).getText();
        String expectedTittle = "PRODUCTS";
        Assert.assertEquals(actualTittle,expectedTittle,"verify that product page");

    }


    @Test
    public void testCase3() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();

        Random random = new Random();
        int num =random.nextInt(6)+1;
        driver.findElement(By.xpath("(//*[text()='Add to cart'])["+num+"]")).click();


        String actualText = driver.findElement(By.cssSelector(".shopping_cart_link>span")).getText();
        Assert.assertEquals(actualText,"1");

        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        String cartText = driver.findElement(By.cssSelector(".shopping_cart_link")).getText();
        Assert.assertEquals(cartText,"");

    }

    @Test
    public void testCase4() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();

        WebElement orderMenu = driver.findElement(By.cssSelector(".product_sort_container"));

        Select select = new Select(orderMenu);

        String expectedResult = "Name (A to Z)";
        String actualResult = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult);

        select.selectByValue("lohi");
        String actualOrder = driver.findElement(By.cssSelector(".active_option")).getText();
        Assert.assertEquals(actualOrder,"PRICE (LOW TO HIGH)");

    }

    @Test
    public void testCase5() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Murat");
        driver.findElement(By.id("last-name")).sendKeys("Abi");
        driver.findElement(By.id("postal-code")).sendKeys("12357");
        driver.findElement(By.id("continue")).click();

        String expectedPrice = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
        String actualPrice=driver.findElement(By.cssSelector(".summary_subtotal_label")).getText();

        System.out.println("expectedPrice = " + expectedPrice);
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertTrue(actualPrice.contains(expectedPrice));


        driver.findElement(By.xpath("//*[text()='Finish']")).click();

        String expectedResult="THANK YOU FOR YOUR ORDER";
        String actualResult=driver.findElement(By.tagName("h2")).getText();

        Assert.assertEquals(actualResult,expectedResult);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}
