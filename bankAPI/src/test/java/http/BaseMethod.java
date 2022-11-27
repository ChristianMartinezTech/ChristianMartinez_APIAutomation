package http;

import java.util.List;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.log4testng.Logger;
import static io.restassured.RestAssured.*;


/***
 * Class: Base Method
 * Class with methods and atribbutes that are inhrited from all other HTTP method classes
 */
public class BaseMethod {
    protected String url = "https://637f8f592f8f56e28e8ff957.mockapi.io/api/v1/bank/";
    public Logger log = Logger.getLogger(BaseMethod.class);

    /***
     * Gets the response to extract either body or headers
     * @return Response
     */
    public Response getResponse() {
        return given()
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    /***
     * Get request for a especific User ID
     * @param userID id of the user
     * @return Response
     */
    public Response getResponseWithUserID(int userID) {
        return given()
                .when()
                .get(url + userID)
                .then()
                .extract().response();
    }

    /***
     * Gets the Response headers
     * @param response Response data type
     * @return Headers
     */
    public Headers getResponseHeaders(Response response) {
        log.info("Getting http headers information");
        return response.headers();
    }

    /***
     * Confirms whether the endpoint is empty
     * @return true if the endpoint is empty
     */
    public boolean getEmptyEndpoint(){
        Response response = getResponse();
        String responseString = response.asString();

        return responseString.isEmpty();
    }

    /***
     * Gets a list of User IDs
     * @return List<String> of user IDs
     */
    public List<String> getListOfIds() {
        Response response = getResponse();
        return response.jsonPath().getList("ID");
    }
}

