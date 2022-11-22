package Entities.UserDataClasses;

import Entities.User;

public class UserFactory {
    public class UserFactory {
        public User createUser(String username, String password) {
            return new User(username, password);
        }
    }
}
