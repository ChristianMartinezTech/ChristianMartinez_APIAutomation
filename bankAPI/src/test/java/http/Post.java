package http;

import java.util.Set;
import util.users.BankUser;
import static io.restassured.RestAssured.given;

/***
 * Class that gather methods related with POST requests
 */
public class Post extends BaseMethod {

    /***
     * Method that received a List of Bank users, iterated through it and
     * makes a post request for each one of them
     * @param setOfUsers List of users
     */
    public void postInitialUsers(Set<BankUser> setOfUsers) {
        for (BankUser setOfUser : setOfUsers) {
            given()
                    .when()
                    .body(setOfUser)
                    .post(url)
                    .then()
                    .extract().response();
        }
    }

    /***
     * Method that recieves X number of users and creates them by using createUser()
     * @param noUsers Number of users
     * @param setOfUsers Set Of Users
     */
    public void createMultipleUsers(int noUsers, Set<BankUser> setOfUsers) {
        if (noUsers > 0) {
            for (int i = 0; i < noUsers; i++) {
                BankUser newUser = createUser();
                setOfUsers.add(newUser);
            }
            log.info("Users Created");
        }
    }
}
