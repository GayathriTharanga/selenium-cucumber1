package com.orange.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Gayathri on 9/10/2017.
 */
public class LoginHRMTest_withXPath {

    private WebDriver webDriver;

    // BC M1 M2 M3
    final String URL = "http://opensource.demo.orangehrmlive.com";

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); // key and values

        webDriver = new FirefoxDriver();
        //webDriver.get("http://opensource.demo.orangehrmlive.com/");


    }

    @Test
    public void testLogin_Xpath1() {
        String errMessage;

        webDriver.get(URL);
        webDriver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        webDriver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("");
        webDriver.findElement(By.xpath("//input[@name='txtUsername']")).submit();
        errMessage = webDriver.findElement(By.id("spanMessage")).getText();

        //Assert.assertEquls(errMessage, S1:"Password cannot be empty");
       // Assert.assertEquals(errMessage, s1:"Password cannot be empty");
        Assert.assertEquals(errMessage,"Password cannot be empty");

    }

    @Test
    public void testLogin_Xpath2() throws InterruptedException {
        webDriver.get(URL);
        webDriver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        webDriver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//input[@name='txtUsername']")).submit();

       // Thread.sleep(10000);
        Thread.sleep(10000);
        //webDriver.findElement(By.xpath(".//*[@id='welcome']"))
       webDriver.findElement(By.xpath("//input[@id='welcome']")).click();

    }

    @Test
    public void testLogin_Xpath3() {


    }

   // @AfterClass

    public void afterClass() {
        if (webDriver != null) {
            webDriver.close();
        }

    }

}
