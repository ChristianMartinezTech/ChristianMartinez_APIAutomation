package tests;

import http.Put;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

/***
 * Class that makes and API call and updates the users' AccountNumber
 */
public class UpdateAccNumberTest extends Put {

    /***
     * Test that validates if a user exists
     * And then makes a put request with a new User Id
     */
    @Test
    public void updateAccountNumber(){
        int userId = 1;

        log.info("Validating that user with id 1 exits");
        Assert.assertTrue(confirmUserExists(userId));

        log.info("Getting the old Account number");
        String oldAccNumber = getResponseWithUserID(userId).body().jsonPath().getString("AccountNumber");

        log.info("Updating the Account Number of user with id: 1");
        Response response = updateAccNumber(1);

        String newAccNumber = response.jsonPath().getString("AccountNumber");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
