package com.eurotech.tests.day29.ddf;

import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile() {

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xls","Test Data");

        // How many rows in the sheet
        System.out.println("testData.rowCount() = " + testData.rowCount());

        //How many columns in the sheet
        System.out.println("testData.columnCount() = " + testData.columnCount());

        // gel all columns name
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());

        // get all data in list of MAPS

        List<Map<String, String>> dataList = testData.getDataList();

        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }

        // get methodu ile istedigimize ulasabiliriz
        // get oykü's password
        System.out.println("dataList.get(3).get(\"Password\") = " + dataList.get(3).get("Password"));

        // get havva's company
        System.out.println("dataList.get(7).get(\"Company\") = " + dataList.get(7).get("Company"));

        // get yusuf's username
        System.out.println("dataList.get(6).get(\"Username\") = " + dataList.get(6).get("Username"));


        //get array
        String [][] dataArray= testData.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));

        /*
        LoginPage loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(dataList.get(0).get("Username"));
         */

    }

}
