package application.core.finasolution.dao;

import application.model.FinalSolution;
import application.model.FinalSolutionId;
import application.model.Indicators;
import org.hibernate.HibernateException;

import java.util.List;

public interface FinalSolutionDao {

    void insert(FinalSolution finalSolution) throws HibernateException;

    void update(FinalSolution finalSolution) throws HibernateException;

    void delete(FinalSolution finalSolution) throws HibernateException;

    FinalSolution findById(FinalSolutionId id);

    List<FinalSolution> getAll();
}
