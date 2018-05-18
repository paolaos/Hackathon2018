package application.core.vote.service.implementation;

import application.core.vote.dao.VoteDao;
import application.core.vote.service.VoteService;
import application.model.Vote;
import application.model.VoteId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao voteDao;

    @Override
    public Vote findById(VoteId id) {
        return this.voteDao.findById(id);
    }

    @Override
    public List<Vote> getAllVotes() {
        return this.voteDao.getAllVotes();
    }

    @Override
    public void insert(Vote vote) throws HibernateException {
        this.voteDao.insert(vote);
    }

    @Override
    public void update(Vote vote) throws HibernateException {
        this.voteDao.update(vote);
    }

    @Override
    public void delete(Vote vote) throws HibernateException {
        this.voteDao.delete(vote);
    }
}
