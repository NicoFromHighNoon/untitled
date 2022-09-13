package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> listUsers();
    public void addUser(User user);
    public User getUser(long id);
    public void remove(long id);
    public void update(long id, User user);
}