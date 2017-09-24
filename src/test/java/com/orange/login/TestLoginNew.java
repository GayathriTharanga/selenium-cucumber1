package com.orange.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Gayathri on 9/3/2017.
 * <p>
 * 1. valid login
 * 2. invalid username/ invalid passwword
 * 3. valid username / invalid password
 * 4. invalid username / valid passwd
 * 5. blank user name
 * 6. blank password
 * 7. blank username/bank password
 * 8. special charactors in th epassword
 * 9. user name/ password in capital
 * 10. user name password in camel case
 * 11. user name password in small letters
 * 12. alphanumeric entry
 * 13. Check for alternate lower and uppercase characters (Example:if username is Admin Type like AdMiN)
 * 14. maximum length in Textboxes
 * 15. Check by giving space between username and password
 */
public class TestLoginNew {

    private WebDriver webDriver;

    @Test
    public void testLogin_withCredentials(){


    }


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe"); // key and values
        webDriver = new FirefoxDriver();
        webDriver.get("http://opensource.demo.orangehrmlive.com/");
        System.out.println("before_class");
    }


    // 1. valid login
    @Test (priority = 15)

    public void testValidUserLogin() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");

        // type password
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");

        // sumbit login form
        webDriver.findElement(By.id("btnLogin")).click();
        //webDriver.close();
        //webDriver.findElement(By.id("welcome")).click();
        //webDriver.findElement(By.xpath(".//*[@id='welcome']")).click();

       // webDriver.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[2]/a")).click();

    }


    //2. invalid username/ invalid passwword
    @Test (priority = 1)
    public void testInvalidLogin() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("1AdminWronf");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin123");
        webDriver.findElement(By.id("btnLogin")).click();



    }

    //3. valid username / invalid password
    @Test (priority = 2)
    public void validUserNameInvalidPsw() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("gayathri");
        webDriver.findElement(By.id("btnLogin")).click();
        System.out.println("2");

    }

    //* 4. invalid username / valid passwd
    @Test (priority = 3)
    public void testInvalidUserNameValidPsw() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin123");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.id("btnLogin")).click();
        System.out.println("3");
    }
//* 5. blank user name

    @Test (priority = 4)
    public void blanklogin() {
        webDriver.findElement(By.id("txtPassword")).sendKeys("1");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.id("btnLogin")).click();

    }


    //* 6. blank password
    @Test (priority = 5)

    public void testBlankPassword() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("");
        webDriver.findElement(By.id("btnLogin")).click();


    }


    //* 7. blank username/bank password
    @Test (priority = 6)
    public void testBlankUsernamePasswd() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("");
        webDriver.findElement(By.id("txtPassword")).sendKeys("");
        webDriver.findElement(By.id("btnLogin")).click();


    }

    //* 8. special charactors in th epassword
    @Test (priority = 7)
    public void testSpecialCharatorsinPsw() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin@#$");
        webDriver.findElement(By.id("btnLogin")).click();


    }


    //* 9. user name/ password in capital
    @Test (priority = 8)
    public void testCapitalUsernamePasswd() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("ADMIN");
        webDriver.findElement(By.id("txtPassword")).sendKeys("ADMIN");
        webDriver.findElement(By.id("btnLogin")).click();


    }


    //* 10. user name password in camel case
    @Test (priority = 9)
    public void testCamelCase() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("ADmin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("aDmin");
        webDriver.findElement(By.id("btnLogin")).click();

    }

    // * 11. user name password in small letters
    @Test (priority = 10)
    public void testSimpleUserLogin() {
        webDriver.findElement(By.id("txtUsername")).sendKeys(" admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("ADMIN" );
        webDriver.findElement(By.id("btnLogin")).click();

    }

    //* 12. alphanumeric entry


    @Test (priority = 11)
    public void testAlphaNumeric() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("6Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("ad66min");
        webDriver.findElement(By.id("btnLogin")).click();

    }

    //* 13. Check for alternate lower and uppercase characters (Example:if username is Admin Type like AdMiN)
    @Test (priority = 12)
    public void testUpperLowercasemix() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("AdMin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("aDMin");
        webDriver.findElement(By.id("btnLogin")).click();


    }

    //* 14. maximum length in Textboxes
     @Test (priority = 13)
    public void testMaximimlength() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("daddsdasdasdasd");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admindgajsjgddjhasgd");
        webDriver.findElement(By.id("btnLogin")).click();


    }

    //* 15. Check by giving space between username and password


    @Test (priority = 14)
    public void testSpaceUserLogin() {

        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("a dim");// put space
        webDriver.findElement(By.id("btnLogin")).click();


    }


   @AfterClass
    public void afterClass() {

        webDriver.close();

    }


}




