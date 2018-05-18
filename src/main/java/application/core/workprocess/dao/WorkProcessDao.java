package application.core.workprocess.dao;

import application.model.WorkProcess;
import application.model.WorkProcessId;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorkProcessDao {

    void insert(WorkProcess workProcess) throws HibernateException;

    void update(WorkProcess workProcess) throws HibernateException;

    void delete(WorkProcess workProcess) throws HibernateException;

    WorkProcess findById(WorkProcessId workProcessId);

    List<WorkProcess> getAll();
}
