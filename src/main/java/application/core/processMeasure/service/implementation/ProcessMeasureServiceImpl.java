package application.core.processMeasure.service.implementation;

import application.core.processMeasure.dao.ProcessMeasureDao;
import application.core.processMeasure.service.ProcessMeasureService;
import application.model.ProcessMeasure;
import application.model.ProcessMeasureId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
@Transactional
@Service
public class ProcessMeasureServiceImpl implements ProcessMeasureService {

    @Autowired
    private ProcessMeasureDao processMeasureDao;

    @Override
    public ProcessMeasure findById(ProcessMeasureId id) {
        return this.processMeasureDao.findById(id);
    }

    @Override
    public List<ProcessMeasure> getAllUsers() {
        return this.processMeasureDao.getAllProcessMeasure();
    }

    @Override
    public void insert(ProcessMeasure processMeasure) throws HibernateException {
        this.processMeasureDao.insert(processMeasure);
    }
}
