package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {

        /**
         * ödev static metot olustur ismi getDriver olsun.
         * parametre browserType olsun. parametreye göre "chrome" yazarsam Chromedriver ,
         * firefox yazarsak Firefox driver olustursun. metodun return type i driver olacak
         */

        public static WebDriver getDriver(String browserType){
          WebDriver driver=null;
          browserType=browserType.toLowerCase();
          if (browserType.equals("firefox")){
              WebDriverManager.firefoxdriver().setup();
              driver=new FirefoxDriver();
          }else if (browserType.equals("chrome")){
              WebDriverManager.chromedriver().setup();
              driver=new ChromeDriver();
          }else if (browserType.equals("edge")){
              WebDriverManager.edgedriver().setup();
              driver=new EdgeDriver();
          }

          return driver;
        }

        public static WebDriver getDriver2(String browserType){
            WebDriver driver =null;

            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
            }

            return driver;
        }

}
