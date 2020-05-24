package storage;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> userList = new ArrayList<>();

    public void add(User user) {

        userList.add(user);
        System.out.println(userList);
    }

    public User getUserByLogin(String login){
        for (User user: userList  ) {
            if (user.getLogin().equals(login)){
           return user;
            }
        }
        return null;
    }

    public boolean checkUserByLogin (String login){
        for (User user: userList  ) {
            if (user.getLogin().equals(login)){
                return false;
            }
        }
        return true;
    }


}
