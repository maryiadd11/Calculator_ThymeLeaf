package by.tms.services;

import by.tms.entity.User;

import java.util.List;


public interface UserService {

    void createUser (User user);
    User getUserById(long id);
    User getUserByLogin (String login);
    List<User> getAll();
    boolean containsUserByLogin(String login);
    boolean containsUserByPassword(String password);
    void deleteUserById (long id);
    void updateUser (User user);

}
