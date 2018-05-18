package application.core.finasolution.dao.implementation;

import application.core.finasolution.dao.FinalSolutionDao;
import application.model.FinalSolution;
import application.model.FinalSolutionId;
import application.model.Indicators;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalSolutionDaoImplementation implements FinalSolutionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(FinalSolution finalSolution) throws HibernateException {
        sessionFactory.getCurrentSession().persist(finalSolution);
    }

    @Override
    public void update(FinalSolution finalSolution) throws HibernateException {
        sessionFactory.getCurrentSession().update(finalSolution);
    }

    @Override
    public void delete(FinalSolution finalSolution) throws HibernateException {
        sessionFactory.getCurrentSession().delete(finalSolution);
    }

    @Override
    public FinalSolution findById(FinalSolutionId id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(FinalSolution.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FinalSolution> getAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from FinalSolution").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
