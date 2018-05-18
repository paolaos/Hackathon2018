package application.core.workprocess.dao.implementation;

import application.core.workprocess.dao.WorkProcessDao;
import application.model.WorkProcess;
import application.model.WorkProcessId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkProcessDaoImplementation implements WorkProcessDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(WorkProcess workProcess) throws HibernateException {
        sessionFactory.getCurrentSession().persist(workProcess);
    }

    @Override
    public void update(WorkProcess workProcess) throws HibernateException {
        sessionFactory.getCurrentSession().update(workProcess);
    }

    @Override
    public void delete(WorkProcess workProcess) throws HibernateException {
        sessionFactory.getCurrentSession().delete(workProcess);
    }

    @Override
    public WorkProcess findById(WorkProcessId workProcessId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(WorkProcess.class, workProcessId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<WorkProcess> getAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from WorkProcess ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
