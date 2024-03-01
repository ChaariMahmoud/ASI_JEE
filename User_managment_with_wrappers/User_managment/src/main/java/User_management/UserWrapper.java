package User_management;

import java.util.ArrayList;
import java.util.List;



public class UserWrapper {
    private List<User> users;

    public UserWrapper() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public boolean containsUser(User user) {
        return users.contains(user);
    }
}
