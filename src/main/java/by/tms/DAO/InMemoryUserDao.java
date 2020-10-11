package by.tms.DAO;

import by.tms.entity.User;
import by.tms.exceptions.NoUserException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserDao implements UserDao{

    private List<User> users = new ArrayList<>();

    {
        users.add(new User( "Test1", "test1", "123456"));
        users.add(new User( "Test2", "test2", "1234567"));
        users.add(new User( "Test3", "test3", "12345678"));
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public User getUserById(long id) throws NoUserException {
        for (User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        throw new NoUserException();
    }

    @Override
    public User getUserByLogin(String login) throws NoUserException {
        for (User user: users){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        throw new NoUserException();
    }

    @Override
    public List<User> showAll() {
        return users;
    }

    @Override
    public void deleteUserById(long id) {
        users.remove(id);
    }

    @Override
    public void updateUser(User user) {
        users.set((int) user.getId(), user);
    }

    @Override
    public boolean containsUserById(long id) {
        for (User user: users){
            if (user.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsUserByLogin(String login) {
        for (User user: users){
            if (user.getLogin().equals(login))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsUserByPassword(String password) {
        for (User user: users){
            if (user.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
