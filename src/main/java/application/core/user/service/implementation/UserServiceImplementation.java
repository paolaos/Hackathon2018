package application.core.user.service.implementation;

import application.core.user.dao.UserDao;
import application.core.user.service.UserService;
import application.model.User;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserDao userDao;


    /**
     * {@inheritDoc}
     */
    @Override
    public User findById(String userId) { return userDao.findById(userId); }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() { return userDao.getAllUsers(); }


    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(User user) throws HibernateException { userDao.insert(user); }
}
