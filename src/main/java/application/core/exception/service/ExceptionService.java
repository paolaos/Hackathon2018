package application.core.exception.service;

import application.model.Exception;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface ExceptionService {
    /**
     * Given an id, find it's exception.
     *
     * @param id Id of the desired exception.
     * @return The exception of the given id.
     */
    Exception findById(long id);

    /**
     * Return all exception from our database.
     *
     * @return List of exception.
     */
    List<Exception> getAllExceptions(String status);

    /**
     * Insert a new exception.
     *
     * @throws HibernateException Error inserting a new exception.
     */
    void insert(Exception exception) throws HibernateException;

    /**
     * Update a new exception.
     *
     * @throws HibernateException Error updating a new exception.
     */
    void update(Exception exception) throws HibernateException;

    /**
     * Delete a new exception.
     *
     * @throws HibernateException Error deleting a new exception.
     */
    void delete(Exception exception) throws HibernateException;
}
