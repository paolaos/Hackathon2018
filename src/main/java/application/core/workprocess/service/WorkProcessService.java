package application.core.workprocess.service;

import application.model.WorkProcess;
import application.model.WorkProcessId;
import org.hibernate.HibernateException;

import java.util.List;

public interface WorkProcessService {

    void insert(WorkProcess workProcess) throws HibernateException;

    void update(WorkProcess workProcess) throws HibernateException;

    void delete(WorkProcess workProcess) throws HibernateException;

    WorkProcess findById(WorkProcessId workProcessId);

    List<WorkProcess> getAll();
}
