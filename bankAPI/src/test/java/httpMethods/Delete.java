package httpMethods;

import java.util.List;

import static io.restassured.RestAssured.given;

/***
 *
 */
public class Delete extends BaseMethod {

    /***
     * Delete request
     * @param userID user ID to delete
     */
    public void deleteRequest(int userID){
        given()
                .when()
                .delete(url + userID)
                .then()
                .extract().response();
    }

    /***
     * Uses BaseMethod's getEmptyEndpoint and deleteRequest methods
     * to check if there's information in the endpoint and delete it
     */
    public void deleteAllUsers(){
        if (!getEmptyEndpoint()) {
            log.info("Endpoint already with user information");
            log.info("Deleting previous information...");

            List<String> userList = getListOfIds();

            for (int i = 0; i < userList.size(); i++) {
                deleteRequest(Integer.parseInt(userList.get(i)));
            }
        }
    }
}
