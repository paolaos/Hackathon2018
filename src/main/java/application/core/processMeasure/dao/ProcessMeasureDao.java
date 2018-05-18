package application.core.processMeasure.dao;

import application.model.ProcessMeasure;
import application.model.ProcessMeasureId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface ProcessMeasureDao {
    /**
     * Given an processmeasureid, find it's respective process measure.
     *
     * @param id Id of the desired id.
     * @return The process measure of the given id.
     */
    ProcessMeasure findById(ProcessMeasureId id);

    /**
     * Return all process measures from our database.
     *
     * @return List of process measures.
     */
    List<ProcessMeasure> getAllProcessMeasure();

    /**
     * Insert a new Process Measure.
     *
     * @throws HibernateException Error inserting a new Process Measure.
     */
    void insert(ProcessMeasure processMeasure) throws HibernateException;
}
