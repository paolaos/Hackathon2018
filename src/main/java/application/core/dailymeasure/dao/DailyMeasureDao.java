package application.core.dailymeasure.dao;

import application.model.DailyMeasure;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface DailyMeasureDao {
    /**
     * Given an id, find it's daily measure.
     *
     * @param id Id of the desired id.
     * @return The Daily measure of the given id.
     */
    DailyMeasure findById(long id);

    /**
     * Return all daily measures from our database.
     *
     * @return List of daily measures.
     */
    List<DailyMeasure> getAllDailyMeasure();

    /**
     * Insert a new daily measure.
     *
     * @throws HibernateException Error inserting a new daily measure.
     */
    void insert(DailyMeasure dailyMeasure) throws HibernateException;
}
