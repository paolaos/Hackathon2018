package application.core.finasolution.service.implementation;

import application.core.finasolution.dao.FinalSolutionDao;
import application.core.finasolution.service.FinalSolutionService;
import application.model.FinalSolution;
import application.model.FinalSolutionId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FinalSolutionServiceImplementation implements FinalSolutionService {

    @Autowired
    FinalSolutionDao finalSolutionDao;

    @Override
    public void insert(FinalSolution finalSolution) throws HibernateException {
        finalSolutionDao.insert(finalSolution);
    }

    @Override
    public void update(FinalSolution finalSolution) throws HibernateException {
        finalSolutionDao.update(finalSolution);
    }

    @Override
    public void delete(FinalSolution finalSolution) throws HibernateException {
        finalSolutionDao.delete(finalSolution);
    }

    @Override
    public FinalSolution findById(FinalSolutionId id) {
        return finalSolutionDao.findById(id);
    }

    @Override
    public List<FinalSolution> getAll() {
        return finalSolutionDao.getAll();
    }
}
