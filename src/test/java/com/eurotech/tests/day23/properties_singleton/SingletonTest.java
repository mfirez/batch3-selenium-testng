package com.eurotech.tests.day23.properties_singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;

public class SingletonTest {

    @Ignore
    @Test
    public void test1() {

        // Singleton u private yaptik ve get (ulasabilmemizi saglayan method) ile olusturdugumuz
        // bütün object lerin ayni olasini saglamis olduk
        // mesela driver diye olusturdugumuz bütün object lerin degerini ayni yapar
        // bu sekilde bütün testlerimiz ayni object üzerinden calismis olacak

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();
        String s3 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);


    }

    //@Test
    public void test2() {

        String s5 = Singleton.getInstance();
        String s6 = Singleton.getInstance();

        System.out.println("s5 = " + s5);
        System.out.println("s6 = " + s6);


    }


    @Test
    public void test3() {

        WebDriver driver = Driver.get();
        driver.get("https://www.google.com");


    }

    @Test
    public void test4() {

        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");


    }

    @Test
    public void DriverClassTest() throws InterruptedException {

        WebDriver driver = Driver.get();

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        Driver.closeDriver();

    }
}
