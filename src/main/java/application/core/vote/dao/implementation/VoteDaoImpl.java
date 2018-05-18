package application.core.vote.dao.implementation;

import application.core.vote.dao.VoteDao;
import application.model.Vote;
import application.model.VoteId;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
@Service
public class VoteDaoImpl implements VoteDao {

    // We are gonna use a session-per-request pattern, for each dta access object (dao).
    // In order to use it, we need an session factory, that will provide us with sessions for each request.
    @Autowired
    private SessionFactory factory;

    @Override
    public Vote findById(VoteId id) {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.get(Vote.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer countVotesByProcessMeasure(VoteId voteId) {
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery("select count(*) from Vote V where V.voteId.exceptionFk = :exceptionFk and V.voteId.solutionFk = :solutionFk");
            query.setParameter("exceptionFk", voteId.getExceptionFk());
            query.setParameter("solutionFk", voteId.getSolutionFk());
            return ((Long) query.iterate().next()).intValue();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Vote> getAllVotes() {
        // Almost always use getCurrentSession, instead of openSession.
        // Only in very odd cases, should the latter be used.
        // For more information, read the following docs.
        // http://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html#transactions-basics-uow
        Session session = factory.getCurrentSession();

        // Try to retrieve date from the DB. If we fail, then we return null.
        try {
            return session.createQuery("from Vote").list();
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Vote vote) throws HibernateException {
        this.factory.getCurrentSession().persist(vote);
    }

    @Override
    public void update(Vote vote) throws HibernateException {
        this.factory.getCurrentSession().update(vote);
    }

    @Override
    public void delete(Vote vote) throws HibernateException {
        this.factory.getCurrentSession().delete(vote);
    }
}
