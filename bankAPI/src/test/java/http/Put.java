package http;

import java.util.Map;
import java.util.HashMap;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/***
 * Class that stores methods to perform put requests
 */
public class Put extends BaseMethod {

    /***
     * Updates the Account number of user with id userId
     * @param userId User id
     * @return Response object
     */
    public Response updateAccNumber(int userId){
        Faker generator = new Faker();

        int accountNumber = generator.number().numberBetween(10000000, 99999999);
        Map<String, Integer> newAccount = new HashMap<String, Integer>();

        newAccount.put("accountNumber", accountNumber);

        return given()
                .when()
                .body(newAccount)
                .put(url + userId)
                .then()
                .extract().response();
    }

    /***
     * Method that confirms if a user exists
     * @param userId id of the user to confirm (if exists)
     * @return true if the user exists
     */
    public boolean confirmUserExists(int userId){
        Response response = getResponseWithUserID(userId);
        return response.getStatusCode() == 200;
    }
}
