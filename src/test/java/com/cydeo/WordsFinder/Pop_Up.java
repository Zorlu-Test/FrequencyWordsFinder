package com.cydeo.WordsFinder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Pop_Up {


    WebDriver driver;


    @BeforeMethod
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void pop_Up() throws InterruptedException {

          driver.get("http://the-internet.herokuapp.com/basic_auth");

          // https://username:password@URL
        driver.get("http:// admin:admin @the-internet.herokuapp.com/basic_auth");

/*

// Alert Try

driver.get("http://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]")).click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);


        alert.accept();


        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]")).click();

        Thread.sleep(2000);

        alert.dismiss();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("ensa");
        Thread.sleep(2000);
        alert.accept();
*/






    }

}
