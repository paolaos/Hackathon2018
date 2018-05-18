package application.core.solution.service.implementation;

import application.core.solution.dao.SolutionDao;
import application.core.solution.service.SolutionService;
import application.model.Solution;
import application.model.SolutionId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class SolutionServiceImpl implements SolutionService {

    @Autowired
    private SolutionDao solutionDao;

    @Override
    public Solution findById(SolutionId id) {
        return this.solutionDao.findById(id);
    }

    @Override
    public List<Solution> getAllSolutions() {
        return this.solutionDao.getAllSolutions();
    }

    @Override
    public void insert(Solution solution) throws HibernateException {
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
