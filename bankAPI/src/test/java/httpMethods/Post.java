package httpMethods;

import io.restassured.response.Response;
import util.users.BankUser;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Post extends BaseMethod{

    public void postInitialUsers(List<BankUser> usersList){
        int i = 0;
        while (usersList.size() > i){
            Response response = given()
                    .when()
                    .body(usersList.get(i))
                    .post(url)
                    .then()
                    .extract().response();
            i++;
        }
    }

    /***
     * User Construction method
     * First, the users are created
     * Secondly, all the users are added to the Users ArrayList
     */
    public static List<BankUser> createUsers(){
        List<BankUser> users = new ArrayList<>();

        // Creating the users
        BankUser user1 = new BankUser("Braden", "Rice", 39556041,
                988.68f, "invoice","Xavier_Aufderhar80@hotmail.com", false,
                "Kuwait", "(883) 531-6913 x926", 1);

        BankUser user2 = new BankUser("Reva", "Dietrich", 49517721,
                311.82f, "withdrawal","Leo_Orn@gmail.com", true,
                "Palau", "832-601-9847", 2);

        BankUser user3 = new BankUser("Rowland", "Kohler", 15388525,
                883.81f, "invoice","Jerel.West93@yahoo.com", true,
                "Malaysia", "755.416.7979 x825", 3);

        BankUser user4 = new BankUser("Dena", "Kulas", 57127316,
                139.24f, "invoice","Albin_Kuhlman@yahoo.com", true,
                "Grenada", "953-472-0014 x3723", 4);


        BankUser user5 = new BankUser("Marjolaine", "Grimes", 61858693,
                850.98f, "withdrawal","Brielle.Kutch@gmail.com", false,
                "Mexico", "(513) 297-5677", 5);

        BankUser user6 = new BankUser("Oma", "Legros", 77257958,
                325.99f, "deposit","Rosalee.Kuhlman@hotmail.com", true,
                "Nigeria", "994.651.9520 x798", 6);

        BankUser user7 = new BankUser("Donny", "Kirlin", 36316121,
                870.69f, "deposit","Arnold.Torp79@gmail.com", true,
                "Mozambique", "1-289-730-7263 x62290", 7);

        BankUser user8 = new BankUser("Frankie", "Rolfson", 72217409,
                419.79f, "deposit","Kelsie83@yahoo.com", true,
                "Ghana", "1-454-848-3334", 8);

        BankUser user9 = new BankUser("Holden", "Lockman", 79148941,
                895.59f, "withdrawal","Carmel_Hoeger99@gmail.com", true,
                "Iraq", "967.651.4003 x089", 9);

        BankUser user10 = new BankUser("Alex", "Mraz", 45657046,
                2895.59f, "payment","Carmel_Hoeger99@gmail.com", false,
                "Saint Lucia", "1-839-347-2718 x775", 10);

        return users;
    }

}
