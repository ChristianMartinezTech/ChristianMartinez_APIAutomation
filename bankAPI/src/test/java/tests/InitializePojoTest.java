package tests;

import httpMethods.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.users.BankUser;
import java.util.List;

public class InitializePojoTest extends Post {

    @Test
    private void initializeData(){
        List<BankUser> users = createUsers();
        System.out.println(users);
        Assert.assertNotNull(users);
    }
}
