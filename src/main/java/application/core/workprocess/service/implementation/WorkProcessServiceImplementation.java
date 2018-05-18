package application.core.workprocess.service.implementation;

import application.core.workprocess.dao.WorkProcessDao;
import application.core.workprocess.service.WorkProcessService;
import application.model.WorkProcess;
import application.model.WorkProcessId;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class WorkProcessServiceImplementation implements WorkProcessService {

    @Autowired
    WorkProcessDao workProcessDao;

    @Override
    public void insert(WorkProcess workProcess) throws HibernateException {
        workProcessDao.insert(workProcess);
    }

    @Override
    public void update(WorkProcess workProcess) throws HibernateException {
        workProcessDao.update(workProcess);
    }

    @Override
    public void delete(WorkProcess workProcess) throws HibernateException {
        workProcessDao.delete(workProcess);
    }

    @Override
    public WorkProcess findById(WorkProcessId workProcessId) {
        return workProcessDao.findById(workProcessId);
    }

    @Override
    public List<WorkProcess> getAll() {
        return workProcessDao.getAll();
    }
}
