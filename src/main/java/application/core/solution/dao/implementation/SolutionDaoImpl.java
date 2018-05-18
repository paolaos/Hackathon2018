package application.core.solution.dao.implementation;

import application.core.solution.dao.SolutionDao;
import application.model.Solution;
import application.model.SolutionId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
@Service
public class SolutionDaoImpl implements SolutionDao {

    // We are gonna use a session-per-request pattern, for each dta access object (dao).
    // In order to use it, we need an session factory, that will provide us with sessions for each request.
    @Autowired
    private SessionFactory factory;

    @Override
    public Solution findById(SolutionId id) {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.get(Solution.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Solution> getAllSolutions() {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.createQuery("from Solution").list();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Solution solution) throws HibernateException {
        factory.getCurrentSession().persist(solution);
    }

    @Override
    public void update(Solution solution) throws HibernateException {
        factory.getCurrentSession().update(solution);
    }

    @Override
    public void delete(Solution solution) throws HibernateException {
        factory.getCurrentSession().delete(solution);
    }
}
