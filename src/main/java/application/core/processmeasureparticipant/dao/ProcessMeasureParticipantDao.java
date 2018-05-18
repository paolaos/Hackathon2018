package application.core.processmeasureparticipant.dao;

import application.model.ProcessMeasureId;
import application.model.ProcessMeasureParticipant;
import application.model.ProcessMeasureParticipantId;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public interface ProcessMeasureParticipantDao {
    /**
     * Given an ProcessMeasureParticipantId, find it's respective ProcessMeasureParticipant.
     *
     * @param id Id of the desired id.
     * @return The ProcessMeasureParticipant of the given id.
     */
    ProcessMeasureParticipant findById(ProcessMeasureParticipantId id);

    /**
     * Return all ProcessMeasureParticipant from our database.
     *
     * @return List of ProcessMeasureParticipant.
     */
    List<ProcessMeasureParticipant> getAllProcessMeasureParticipants();

    /**
     * Insert a new ProcessMeasureParticipant.
     *
     * @throws HibernateException Error inserting a new ProcessMeasureParticipant.
     */
    void insert(ProcessMeasureParticipant processMeasureParticipant) throws HibernateException;

    /**
     * Delete a new ProcessMeasureParticipant.
     *
     * @throws HibernateException Error deleting a new ProcessMeasureParticipant.
     */
    void delete(ProcessMeasureParticipant processMeasureParticipant) throws HibernateException;

    List<ProcessMeasureParticipant> getParticipantByProcessMeasure(ProcessMeasureId processMeasureId);

    Integer countParticipantsByProcessMeasure(ProcessMeasureId processMeasureId);

}
