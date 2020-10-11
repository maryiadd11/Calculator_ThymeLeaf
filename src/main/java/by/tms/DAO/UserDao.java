package by.tms.DAO;

import by.tms.entity.User;
import by.tms.exceptions.NoUserException;

import java.util.List;


public interface UserDao {

    void createUser(User user);
    User getUserById(long id) throws NoUserException;
    User getUserByLogin(String login);
    List<User> showAll();
    void deleteUserById(long id);
    void updateUser(User user);
    boolean containsUserById(long id);
    boolean containsUserByLogin(String login);
    boolean containsUserByPassword(String password);
}
