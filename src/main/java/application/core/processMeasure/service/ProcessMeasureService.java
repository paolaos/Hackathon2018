package application.core.processMeasure.service;

import application.model.ProcessMeasure;
import application.model.ProcessMeasureId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface ProcessMeasureService {
    /**
     * Given an id, find it's respective owner.
     *
     * @param id Id of the desired process Measure.
     * @return The process measure of the given id.
     */
    ProcessMeasure findById(ProcessMeasureId id);

    /**
     * Return all Process Measure from our database.
     *
     * @return List of Process Measures.
     */
    List<ProcessMeasure> getAllUsers();

    /**
     * Insert a new Process Measure.
     *
     * @throws HibernateException Error inserting a new Process Measure.
     */
    void insert(ProcessMeasure processMeasure) throws HibernateException;
}
