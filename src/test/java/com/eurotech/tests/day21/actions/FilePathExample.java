package com.eurotech.tests.day21.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class FilePathExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void fileUpload() {
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("user.dir"));

        //C:\Users\Firez\IdeaProjects\batch3-selenium-testng ---> yukardidaki sout user.dir
        //src/test/resources/eurotech.text  ----> yandaki olusturdugumuz text dosyasindan (resources)sag tiklayip path kopyaladik 3. sü

        String projectPath=System.getProperty("user.dir");
        String filePath = "src/test/resources/eurotech.text";

        String fullPath = projectPath+"/"+filePath;
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys(fullPath);



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
