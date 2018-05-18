package application.core.indicator.service.implementation;

import application.core.indicator.dao.IndicatorDao;
import application.core.indicator.service.IndicatorService;
import application.model.Indicators;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IndicatorServiceImplementation implements IndicatorService {

    @Autowired
    IndicatorDao indicatorDao;

    @Override
    public void insert(Indicators indicators) throws HibernateException {
        indicatorDao.insert(indicators);
    }

    @Override
    public void update(Indicators indicators) throws HibernateException {
        indicatorDao.update(indicators);
    }

    @Override
    public void delete(Indicators indicators) throws HibernateException {
        indicatorDao.delete(indicators);
    }

    @Override
    public Indicators findBy(Integer id) {
        return indicatorDao.findBy(id);
    }

    @Override
    public List<Indicators> getIndicators() {
        return indicatorDao.getIndicators();
    }
}
