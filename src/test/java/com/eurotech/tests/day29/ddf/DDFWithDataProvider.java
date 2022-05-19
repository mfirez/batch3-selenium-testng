package com.eurotech.tests.day29.ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object [][] testData(){

        String [][] data = {{"Turkey","Ankara"},
                {"Germany","Berlin"},
                {"Scotland","Edinburgh"},
                {"Netherlands","Amsterdam"},
                {"Saudi Arabia","Riad"},
                {"United Arab Emirates","Abu Dabi"}
        };

        return data;
    }

    @Test(dataProvider = "testData")
    public void testCity(String country,String capitalCity){
        System.out.println("Country = "+country+" Capital City = "+capitalCity);
    }


}
