package application.core.indicator.dao.implementation;

import application.core.indicator.dao.IndicatorDao;
import application.model.Indicators;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicatorDaoImplementation implements IndicatorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Indicators indicators) throws HibernateException {
        sessionFactory.getCurrentSession().persist(indicators);
    }

    @Override
    public void update(Indicators indicators) throws HibernateException {
        sessionFactory.getCurrentSession().update(indicators);
    }

    @Override
    public void delete(Indicators indicators) throws HibernateException {
        sessionFactory.getCurrentSession().delete(indicators);
    }

    @Override
    public Indicators findBy(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(Indicators.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Indicators> getIndicators() {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from Indicators ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
