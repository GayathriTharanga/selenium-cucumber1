package ddtexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Gayathri on 9/24/2017.
 * <p>
 * Data driven testing
 * we we will not open driver here.
 */
public class Ddtexample {

    private final String BASEURL = "http://opensource.demo.orangehrmlive.com/";
    private WebDriver webDriver;


    @BeforeClass
    public void beforeclass() {
        webDriver = new HtmlUnitDriver(true);  // opening broswr take log of time so no dribver
        // we put (true) to enable java script.  remove this true and see the error
        // defaul client site paswword, so we make it true to enable it
    }


    // datasource
    @DataProvider(name = "usercredentilas")  // step 1
    private Object[][] usercredentilas() {   // Step 2 define teh pubic array with meeaning ful name.no oneed to be same as before name = "usercredentilas"
        return new Object[][]{   // step 3 - retuen name
                {"admin", "", "Password cannot be empty"}, // user name , password, expected result
                {"", "admin", "Username cannot be empty"},  // user name , password, expected result  crrl + d to duplicate
                {"Admin1234", "admin", "Invalid credentials"},  // user name , password, expected result  crrl + d to duplicate
                 {"", "", "Username cannot be empty"}, // user name , password, expected result  crrl + d to duplicate


        };


    }

    @BeforeMethod
        public void beforeMethod() {

            webDriver.get(BASEURL);
    }

    @Test(dataProvider = "usercredentilas")  // data provider not the class
    public void testInvalidUserLogin(CharSequence username, String password, String expectedMessage) {

        webDriver.findElement(By.id("txtUsername")).sendKeys(username); // clicked on the red bulb , error see video

        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrormessage(), expectedMessage);

    }

// this data source is from ' datasource' file. we call it here
    @Test(dataProvider = "usercredentilas2", dataProviderClass = DataSource.class)  // data provider not the class
    public void testInvalidUserLogin2(CharSequence username, String password, String expectedMessage) {

        webDriver.findElement(By.id("txtUsername")).sendKeys(username); // clicked on the red bulb , error see video

        webDriver.findElement(By.id("txtPassword")).sendKeys(password);
        webDriver.findElement(By.id("txtPassword")).submit();
        Assert.assertEquals(getErrormessage(), expectedMessage);

    }
    private String getErrormessage() {
        return webDriver.findElement(By.id("spanMessage")).getText();

    }

}
