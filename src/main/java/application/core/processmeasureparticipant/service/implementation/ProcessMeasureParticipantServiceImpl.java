package application.core.processmeasureparticipant.service.implementation;

import application.core.processmeasureparticipant.dao.ProcessMeasureParticipantDao;
import application.core.processmeasureparticipant.service.ProcessMeasureParticipantService;
import application.model.ProcessMeasureParticipant;
import application.model.ProcessMeasureParticipantId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class ProcessMeasureParticipantServiceImpl implements ProcessMeasureParticipantService {

    @Autowired
    private ProcessMeasureParticipantDao processMeasureParticipantDao;

    @Override
    public ProcessMeasureParticipant findById(ProcessMeasureParticipantId id) {
        return this.processMeasureParticipantDao.findById(id);
    }

    @Override
    public List<ProcessMeasureParticipant> getAllProcessMeasureParticipants() {
        return this.processMeasureParticipantDao.getAllProcessMeasureParticipants();
    }

    @Override
    public void insert(ProcessMeasureParticipant processMeasureParticipant) throws HibernateException {
        this.processMeasureParticipantDao.insert(processMeasureParticipant);
    }

    @Override
    public void delete(ProcessMeasureParticipant processMeasureParticipant) throws HibernateException {
        this.processMeasureParticipantDao.delete(processMeasureParticipant);
    }
}
