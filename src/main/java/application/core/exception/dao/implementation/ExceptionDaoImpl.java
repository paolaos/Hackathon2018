package application.core.exception.dao.implementation;

import application.core.exception.dao.ExceptionDao;
import application.model.Exception;
import application.model.ExceptionStatusEnum;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
@Service
public class ExceptionDaoImpl implements ExceptionDao {

    // We are gonna use a session-per-request pattern, for each dta access object (dao).
    // In order to use it, we need an session factory, that will provide us with sessions for each request.
    @Autowired
    private SessionFactory factory;

    @Override
    public Exception findById(long id) {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.get(Exception.class, id);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Exception> getAllExceptions(String exceptionStatus) {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            Query query = session.createQuery("FROM Exception WHERE status = :exceptionStatus");
            query.setParameter("exceptionStatus", exceptionStatus);
            return query.list();
        } catch (java.lang.Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Exception exception) throws HibernateException {
        this.factory.getCurrentSession().persist(exception);

    }

    @Override
    public void update(Exception exception) throws HibernateException {
        this.factory.getCurrentSession().update(exception);
    }

    @Override
    public void delete(Exception exception) throws HibernateException {
        this.factory.getCurrentSession().delete(exception);
    }
}
