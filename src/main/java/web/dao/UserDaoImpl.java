package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void remove(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void update(long id, User user) {
        String UPDATE = "UPDATE User user SET user.firstName = :firstname, user.lastName = :lastname, " +
                "user.email = :email WHERE user.id = :id";
        entityManager.createQuery(UPDATE)
                .setParameter("id", id)
                .setParameter("firstname", user.getFirstName())
                .setParameter("lastname", user.getLastName())
                .setParameter("email", user.getEmail()).executeUpdate();
    }
}