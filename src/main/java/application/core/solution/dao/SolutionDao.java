package application.core.solution.dao;

import application.model.Solution;
import application.model.SolutionId;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface SolutionDao {

    /**
     * Given an solutionid, find it's respective Solution.
     *
     * @param id Id of the desired id.
     * @return The solution of the given id.
     */
    Solution findById(SolutionId id);

    Solution getRecommendedSolution(long exceptionId);

    /**
     * Return all solutions from our database.
     *
     * @return List of solution.
     */
    List<Solution> getAllSolutions();

    List<Solution> getAllSolutionsByException(long exceptionId);

    /**
     * Insert a new solution.
     *
     * @throws HibernateException Error inserting a new solution.
     */
    void insert(Solution solution) throws HibernateException;

    /**
     * Update a new solution.
     *
     * @throws HibernateException Error updating an existing solution.
     */
    void update(Solution solution) throws HibernateException;

    /**
     * Delete a new solution.
     *
     * @throws HibernateException Error deleting an existing solution.
     */
    void delete(Solution solution) throws HibernateException;

}

