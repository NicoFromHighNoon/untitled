package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.dao.UserDao;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
    @Transactional
    @Override
    public void remove(long id) {
        userDao.remove(id);
    }
    @Transactional
    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }
}
