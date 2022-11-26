package httpMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/***
 * Class: Get
 * Contains methods especially used with the get http request
 */
public class Get extends BaseMethod {

    /***
     * Gets the User's email
     * @param userID User ID
     * @return String with the user email
     */
    public String getUserEmail(int userID){
        return getResponseWithUserID(userID).jsonPath().get("Email");
    }
}
