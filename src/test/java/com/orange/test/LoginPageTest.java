package com.orange.test;

import com.orange.pages.LandingPage;
import com.orange.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Gayathri on 9/17/2017.
 * <p>
 * use runTest.xml  to run this file.
 * go to report2 folder -> right click on index html
 * Open in Browser
 */
public class LoginPageTest {
    WebDriver webDriver;

    @BeforeClass

    public void beforeclss() {

        // create a browser instance


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // key and values
        webDriver = new ChromeDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");

    }


    @Test
    public void loginWithBlankUserName() {


        // acess the logini page
        //*************  majic code
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);


        // Login with  blank user
        loginPage.login("", "admin");

        // verify error message
        Assert.assertEquals(loginPage.getMessage(), "Username cannot be empty");
    }

    @Test
    public void loginWithInvalidusername() {


        //*************  majic code
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);

        // Login with  blank user
        loginPage.login("Admin123", "admin123");

        // verify error message
        Assert.assertEquals(loginPage.getMessage(), "Invalid credentials");
        Assert.assertEquals(loginPage.getMessage(), "");


    }

    @Test
    public void loginWithvalidusername() {


        //*************  majic code
        LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);


        // Login with  blank user
        loginPage.login("Admin", "admin");


        // verify error message
        LandingPage landingPage = PageFactory.initElements(webDriver, LandingPage.class);
        Assert.assertEquals(landingPage.getMessage(), "Welcome Admin");

    }

    @AfterClass
    public void afterClass() {

        webDriver.close();

    }

}












