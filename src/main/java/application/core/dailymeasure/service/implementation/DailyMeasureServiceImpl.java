package application.core.dailymeasure.service.implementation;

import application.core.dailymeasure.dao.DailyMeasureDao;
import application.core.dailymeasure.service.DailyMeasureService;
import application.model.DailyMeasure;
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
public class DailyMeasureServiceImpl implements DailyMeasureService {

    @Autowired
    private DailyMeasureDao dailyMeasureDao;

    @Override
    public DailyMeasure findById(long id) {
        return this.dailyMeasureDao.findById(id);
    }

    @Override
    public List<DailyMeasure> getAllUsers() {
        return this.dailyMeasureDao.getAllDailyMeasure();
    }

    @Override
    public void insert(DailyMeasure dailyMeasure) throws HibernateException {
        this.dailyMeasureDao.insert(dailyMeasure);
    }
}
