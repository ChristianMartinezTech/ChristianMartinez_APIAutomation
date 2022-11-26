package util.users;

import java.util.ArrayList;
import java.util.List;

public class ListBankUsers {
    private static List<BankUser> listOfUsers;

    public ListBankUsers(){
        listOfUsers = new ArrayList<>();
    }

    public static List<BankUser> getListOfUsers() {
        return listOfUsers;
    }

    public static void addUser(BankUser user){
        listOfUsers.add(user);
    }
}
