package application.core.vote.service.implementation;

import application.model.Exception;
import application.core.exception.service.ExceptionService;
import application.core.processmeasureparticipant.service.ProcessMeasureParticipantService;
import application.core.vote.dao.VoteDao;
import application.core.vote.service.VoteService;
import application.model.Vote;
import application.model.VoteId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
@Transactional
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao voteDao;

    @Autowired
    private ExceptionService exceptionService;

    @Override
    public Vote findById(VoteId id) {
        return this.voteDao.findById(id);
    }

    @Override
    public Integer countVotesByProcessMeasure(VoteId voteId) {
        return voteDao.countVotesByProcessMeasure(voteId);
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

    private boolean checkVotes(Vote vote) {
        Integer voteCount = voteDao.countVotesByProcessMeasure(vote.getVoteId());
        Exception exception = exceptionService.findById(vote.getVoteId().getExceptionFk());
        if(voteCount >= exception.getVoteCount()) return true;
        return false;
    }
}
