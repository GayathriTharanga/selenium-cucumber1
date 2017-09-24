package ddtexamples;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Gayathri on 9/24/2017.
 * <p>
 * This data source is in thisi file we call this data source from diferent file.  We call this usercredentilas2  in DataSource class file.
 */
public class DataSource {


    // get the dt example cpy f
    @DataProvider(name = "usercredentilas2")  // step 1
    private static Object[][] usercredentilas() {   //  **** change to STATIC ************
                              // Step 2 define teh pubic array with meeaning ful name.no oneed to be same as before name = "usercredentilas"
        return new Object[][]{   // step 3 - retuen name
                {"admin", "", "Password cannot be empty"}, // user name , password, expected result
                {"", "admin", "Username cannot be empty"},  // user name , password, expected result  crrl + d to duplicate
                {"Admin1234", "admin", "Invalid credentials"},  // user name , password, expected result  crrl + d to duplicate
                {"", "", "Username cannot be empty"}, // user name , password, expected result  crrl + d to duplicate


        };


    }


}