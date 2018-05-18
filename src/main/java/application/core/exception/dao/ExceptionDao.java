package application.core.exception.dao;

import application.model.Exception;
import application.model.ExceptionStatusEnum;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface ExceptionDao {

    /**
     * Given an exception, find it's respective exception.
     *
     * @param id Id of the desired id.
     * @return The exception of the given id.
     */
    Exception findById(long id);

    /**
     * Return all exceptions from our database.
     *
     * @param exceptionStatus
     * @return List of exceptions.
     */
    List<Exception> getAllExceptions(String exceptionStatus);

    /**
     * Insert a new exception.
     *
     * @throws HibernateException Error inserting a new exception.
     */
    void insert(Exception exception) throws HibernateException;

    /**
     * Update a new exception.
     *
     * @throws HibernateException Error updating an existing exception.
     */
    void update(Exception exception) throws HibernateException;

    /**
     * Delete a new exception.
     *
     * @throws HibernateException Error deleting an existing exception.
     */
    void delete(Exception exception) throws HibernateException;
}
