package application.core.dailymeasure.service;

import application.model.DailyMeasure;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface DailyMeasureService {
    /**
     * Given an id, find it's daily measure.
     *
     * @param id Id of the desired daily measure.
     * @return The daily measure of the given id.
     */
    DailyMeasure findById(long id);

    /**
     * Return all daily measure from our database.
     *
     * @return List of daily measure.
     */
    List<DailyMeasure> getAllUsers();

    /**
     * Insert a new Daily measure.
     *
     * @throws HibernateException Error inserting a new daily measure.
     */
    void insert(DailyMeasure dailyMeasure) throws HibernateException;
}
