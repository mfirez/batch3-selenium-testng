package com.eurotech.tests.day29.ddf;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object [][] userData(){

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xls","Test Data");

        String [][] dataArray = testData.getDataArrayWithoutFirstRow();// ilk de column name ler var isimize yaramaz

        return dataArray;

    }

    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username,String password,String tittle,String company,String name){

        extentLogger=report.createTest(username+"'s login test");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Click understand Button");
        loginPage.understandBtn.click();
        extentLogger.info("Click Login Button");
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Enter username and password");
        loginPage.login(username,password);
        extentLogger.info("Click Login Button");
        loginPage.loginBtnLoginPage.click();


        String expectedMessage = "Welcome " + name;
        String actualMessage = dashboardPage.welcomeMessage.getText();

        extentLogger.info("Verify welcome message that "+expectedMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Verify Title that "+ tittle);
        String actualTitle  = dashboardPage.getTitle(company);
        Assert.assertEquals(actualTitle,tittle);

        extentLogger.info("Verify Company name that "+ company);
        String actualCompany = dashboardPage.getCompany(tittle);
        Assert.assertEquals(actualCompany,company);

        extentLogger.pass("Passed");



    }


}
