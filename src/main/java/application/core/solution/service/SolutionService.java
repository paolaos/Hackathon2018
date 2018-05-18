package application.core.solution.service;

import application.model.Solution;
import application.model.SolutionId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface SolutionService {
    /**
     * Given an solutionid, find it's solution.
     *
     * @param id Id of the desired solution.
     * @return The solution of the given id.
     */
    Solution findById(SolutionId id);

    /**
     * Return all solution from our database.
     *
     * @return List of solution.
     */
    List<Solution> getAllSolutions();

    /**
     * Insert a new solution.
     *
     * @throws HibernateException Error inserting a new solution.
     */
    void insert(Solution solution) throws HibernateException;

    /**
     * Update a new solution.
     *
     * @throws HibernateException Error updating a new solution.
     */
    void update(Solution solution) throws HibernateException;

    /**
     * Delete a new solution.
     *
     * @throws HibernateException Error deleting a new solution.
     */
    void delete(Solution solution) throws HibernateException;
}
