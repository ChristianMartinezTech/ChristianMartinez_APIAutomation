package tests;

import http.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.users.BankUser;
import java.util.HashSet;
import java.util.Set;

public class InitializePojoTest extends Post {

    /***
     * Test created to initialize 10 Bank users' data
     * It also makes 10 post requests to the API endpoint with the user information
     *
     * Keep in mind that I used Sets (which don't allow repeated information
     * To avoid email verification in ArrayLists
     */
    @Test
    private void initializeData(){
        // initializing setOfUsers
        Set<BankUser> setOfUsers = new HashSet<>();

        log.info("Creating 10 unique Users");
        createMultipleUsers(10, setOfUsers);

        Assert.assertNotNull(setOfUsers);
        Assert.assertEquals(10, setOfUsers.size());

        //Post Request
        log.info("Post request for each users created");
        postInitialUsers(setOfUsers);
    }
}
