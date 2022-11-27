package tests;

import http.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.users.BankUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitializePojoTest extends Post {

    @Test
    private void initializeData(){
        // Initializing BankUser list
        List<BankUser> listOfUsers = new ArrayList<>();


        log.info("Creating 10 Users");
        createMultipleUsers(10, listOfUsers);
        Assert.assertNotNull(listOfUsers);

        // Converting the list into a Set to avoid duplicates


        // Checking there's still 10 users in the list


        //Post Request
        log.info("Post request for each users created");
        postInitialUsers(listOfUsers);
    }
}
