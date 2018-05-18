package application.core.finasolution.service;

import application.model.FinalSolution;
import application.model.FinalSolutionId;
import org.hibernate.HibernateException;

import java.util.List;

public interface FinalSolutionService {

    void insert(FinalSolution finalSolution) throws HibernateException;

    void update(FinalSolution finalSolution) throws HibernateException;

    void delete(FinalSolution finalSolution) throws HibernateException;

    FinalSolution findById(FinalSolutionId id);

    List<FinalSolution> getAll();
}
