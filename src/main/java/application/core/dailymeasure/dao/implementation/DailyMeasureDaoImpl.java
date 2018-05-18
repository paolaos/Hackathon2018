package application.core.dailymeasure.dao.implementation;

import application.core.dailymeasure.dao.DailyMeasureDao;
import application.model.DailyMeasure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class DailyMeasureDaoImpl implements DailyMeasureDao {

    // We are gonna use a session-per-request pattern, for each dta access object (dao).
    // In order to use it, we need an session factory, that will provide us with sessions for each request.
    @Autowired
    private SessionFactory factory;

    @Override
    public DailyMeasure findById(long id) {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.get(DailyMeasure.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DailyMeasure> getAllDailyMeasure() {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.createQuery("from DailyMeasure").list();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public void insert(DailyMeasure dailyMeasure) throws HibernateException {
        factory.getCurrentSession().persist(dailyMeasure);
    }
}
