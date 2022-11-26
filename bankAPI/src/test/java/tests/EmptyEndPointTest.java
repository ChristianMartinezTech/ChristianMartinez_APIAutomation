package tests;

import httpMethods.Delete;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

/***
 * Class: EmptyEndpointTest
 * Class that tests if the endpoint is empty
 */
public class EmptyEndPointTest extends Delete{

    /***
     * Test if the endpoint is empty
     *
     * In case the endpoint is not empty the method deleteAllUsers() will create a list
     * of the userIDs and delete all of them using delete http requests.
     */
    @Test
    public void verifyEmptyEndpointTest(){
        // Checking if the Endpoint is empty OR deleting its information
        log.info("Checking if there's Users Already created in the endpoint");
        deleteAllUsers();

        Assert.assertEquals(getResponse().asString(), "[]");
        Assert.assertFalse(getResponse().asString().isEmpty());
        log.info("There's no user information in this endpoint");
    }

}
