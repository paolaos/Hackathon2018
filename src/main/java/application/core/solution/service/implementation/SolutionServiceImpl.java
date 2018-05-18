package application.core.solution.service.implementation;

import application.core.exception.service.ExceptionService;
import application.core.processMeasure.service.ProcessMeasureService;
import application.core.processmeasureparticipant.service.ProcessMeasureParticipantService;
import application.core.solution.dao.SolutionDao;
import application.core.solution.service.SolutionService;
import application.core.vote.service.VoteService;
import application.model.Solution;
import application.model.SolutionId;
import application.model.Vote;
import application.model.VoteId;
import application.security.AppUser;
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
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionDao solutionDao;

    @Autowired
    private VoteService voteService;

    @Override
    public Solution findById(SolutionId id) {
        return this.solutionDao.findById(id);
    }

    @Override
    public List<Solution> getAllSolutions() {
        return this.solutionDao.getAllSolutions();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Solution solution, AppUser appUser) throws HibernateException {
        this.solutionDao.insert(solution);
    }

    @Override
    public void update(Solution solution) throws HibernateException {
        this.solutionDao.update(solution);
    }

    @Override
    public void delete(Solution solution) throws HibernateException {
        this.solutionDao.delete(solution);
    }
}
