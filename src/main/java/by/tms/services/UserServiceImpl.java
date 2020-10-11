package by.tms.services;

import by.tms.DAO.UserDao;
import by.tms.entity.User;
import by.tms.exceptions.DuplicateUserException;
import by.tms.exceptions.NoUserException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void createUser(User user){
        if (userDao.containsUserByLogin(user.getLogin())){
            throw new DuplicateUserException();
        } else {
            userDao.createUser(user);
        }
    }

    @Override
    public User getUserById(long id) {
        if (userDao.containsUserById(id)) {
            return userDao.getUserById(id);
        }
        throw new NoUserException();
    }

    @Override
    public User getUserByLogin(String login) {
        if (userDao.containsUserByLogin(login)){
            return userDao.getUserByLogin(login);
        }
        throw new NoUserException();
    }

    @Override
    public List<User> getAll() {
        return userDao.showAll();
    }

    @Override
    public boolean containsUserByLogin(String login) {
        if (userDao.containsUserByLogin(login)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsUserByPassword(String password) {
        if (userDao.containsUserByPassword(password)) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
