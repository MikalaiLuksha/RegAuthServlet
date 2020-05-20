import java.util.ArrayList;
import java.util.List;

class UserStorage {

    private static List<User> userList = new ArrayList<>();

    void add(User user) {

        userList.add(user);
        System.out.println(userList);
    }

    User getUserByLogin(String login){
        for (User user: userList  ) {
            if (user.getLogin().equals(login)){
           return user;
            }
        }
        return null;
    }


}
