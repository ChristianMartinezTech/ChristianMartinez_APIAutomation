package tests;

import http.Get;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

/***
 * Class that test the GET http method
 * And checks if all the user emails are unique
 */
public class GetRequestTest extends Get {

    /***
     * Test that makes a get request to the database
     * And check if all the user email addresses are unique
     */
    @Test
    public void getUserInfo(){

        log.info("Getting all the user information");
        Response response = getAllUsers();
        Assert.assertNotNull(response);

        log.info("Checking if all users have unique email accounts");
        Assert.assertTrue(checkUniqueEmails(response));
    }
}
