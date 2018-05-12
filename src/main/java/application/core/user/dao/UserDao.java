package application.core.user.dao;

import application.model.User;
import org.hibernate.HibernateException;

import java.util.List;

public interface UserDao {

    /**
     * Given an id, find it's respective owner.
     * @param userId Id of the desired id.
     * @return The user of the given id.
     */
    User findById(String userId);

    /**
     * Return all user from our database.
     * @return List of users.
     */
    List<User> getAllUsers();

    /**
     * Insert a new User.
     * @throws HibernateException Error inserting a new user.
     */
    void insert(User user) throws HibernateException;

}
