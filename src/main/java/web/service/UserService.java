package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void addUser(User user);
    User getUser(long id);
    void remove(long id);
    void update(long id, User user);
}
