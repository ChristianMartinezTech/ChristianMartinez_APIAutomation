package http;

import util.users.BankUser;
import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

/***
 * Class that gather methods related with POST requests
 */
public class Post extends BaseMethod {

    /***
     * Method that received a List of Bank users, iterated through it and
     * makes a post request for each one of them
     * @param usersList List of users
     */
    public void postInitialUsers(List<BankUser> usersList) {
        int i = 0;
        while (usersList.size() > i) {
            given()
                    .when()
                    .body(usersList.get(i))
                    .post(url)
                    .then()
                    .extract().response();
            i++;
        }
    }

    /***
     * Method that creates one user
     * @return BakUser instance created
     */
    public BankUser createUser() {
        Faker generator = new Faker();

        String name = generator.name().firstName();
        String lastName = generator.name().lastName();
        int accountNumber = generator.number().numberBetween(10000001, 99999998);
        double amount = generator.number().randomDouble(2, 1, 99999);
        String transactionType = generator.options().option("deposit", "payment", "invoice", "withdrawal");
        String email = generator.internet().emailAddress();
        boolean active = generator.bool().bool();
        String country = generator.address().country();
        String telephone = generator.phoneNumber().phoneNumber();

        return new BankUser(name, lastName, accountNumber, amount, transactionType, email, active,
                country, telephone);
    }

    /***
     * Method that recieves X number of users and creates them by using createUser()
     * @param noUsers Number of users
     * @param listOfUsers ArrayList of users
     */
    public void createMultipleUsers(int noUsers, List<BankUser> listOfUsers) {
        if (noUsers > 0) {
            for (int i = 0; i < noUsers; i++) {
                BankUser newUser = createUser();

                listOfUsers.add(newUser);
            }
            log.info("Users Created");
        }
    }

    /***
     * Checking that none of the users have the sema email
     */
    public Set<BankUser> turnListIntoSet(List<BankUser> listOfUsers){
        Set<BankUser> setOfUsers = new HashSet<>(listOfUsers);

        if(setOfUsers.size() != listOfUsers.size()){
            int usersToCreate = listOfUsers.size() - setOfUsers.size();
            createMultipleUsers(usersToCreate, listOfUsers);
        }
        return setOfUsers;
    }
}
