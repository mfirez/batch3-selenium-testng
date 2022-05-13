package com.eurotech.tests.day14.TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfter {

    @BeforeClass
    public void setUpClass(){
        System.out.println("-----BEFORE CLASS----");
        System.out.println("Her class dan önce bir kere calisir");
    }

    @Test
    public void testName(){

        System.out.println("Test Case");

    }

    @BeforeMethod  // Her method öncesi calisir
    public void setup(){
        System.out.println("Web driver setup, Opening Browser");
    }

    @AfterMethod    // Her method sonrasi calisir
    public void tearDown(){
        System.out.println("Closing Browser");
    }

    @Test
    public void test2(){
        System.out.println("Test Case 2");
    }

    @Test
    public void test3(){
        System.out.println("Test Case 3");
    }

    @Test
    public void test5() {
        String eMail = "test@gmail.com";
        Assert.assertTrue(eMail.contains("@")&eMail.contains(".com"),"verify email contains @ and .com");
    }

    @Ignore@Test // veya // basa koyarsak test in ognore olur calistirmaz
    public void test4(){
        System.out.println("IGNORE");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----AFTER CLASS-----");
        System.out.println("Soon Report");
    }


}
