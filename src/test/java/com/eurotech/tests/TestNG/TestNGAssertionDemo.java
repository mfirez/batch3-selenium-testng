package com.eurotech.tests.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @BeforeMethod
    public void setup(){
        System.out.println("Web driver open, browser setup");
    }


    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title");

        System.out.println("Second Assertion");
        Assert.assertEquals("URL","URL");
    }

    @Test
    public void test2(){
        Assert.assertEquals("Test2","Test2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Driver");
    }

}
