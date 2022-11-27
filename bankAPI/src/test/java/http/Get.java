package http;

import java.util.List;
import java.util.ArrayList;
import io.restassured.response.Response;

/***
 * Class: Get
 * Contains methods especially used with the get http request
 */
public class Get extends BaseMethod {

    /***
     * Gets all the user information
     * @return Response object
     */
    public Response getAllUsers(){
        return getResponse();
    }

    /***
     * Check if all the emails are unique
     * @param response Response object
     * @return true if all user emails are unique
     */
    public boolean checkUniqueEmails(Response response){
        List<String> listOfEmails = response.jsonPath().get("Email");
        List<String> newList = new ArrayList<>();

        for (String listOfEmail : listOfEmails) {
            if (!newList.contains(listOfEmail)) {
                newList.add(listOfEmail);
            }
        }
        return listOfEmails.size() == newList.size();
    }
}
