package application.core.exception.service.implementation;

import application.core.exception.dao.ExceptionDao;
import application.core.exception.service.ExceptionService;
import application.model.Exception;
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
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    private ExceptionDao exceptionDao;

    @Override
    public Exception findById(long id) {
        return this.exceptionDao.findById(id);
    }

    @Override
    public List<Exception> getAllExceptions(String status) {
        return this.exceptionDao.getAllExceptions(status);
    }

    @Override
    public void insert(Exception exception) throws HibernateException {
        this.exceptionDao.insert(exception);
    }

    @Override
    public void update(Exception exception) throws HibernateException {
        this.exceptionDao.update(exception);
    }

    @Override
    public void delete(Exception exception) throws HibernateException {
        this.exceptionDao.delete(exception);
    }
}
