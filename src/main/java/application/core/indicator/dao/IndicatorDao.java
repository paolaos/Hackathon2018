package application.core.indicator.dao;

import application.model.Indicators;
import org.hibernate.HibernateException;

import java.util.List;

public interface IndicatorDao {

    void insert(Indicators indicators) throws HibernateException;

    void update(Indicators indicators) throws HibernateException;

    void delete(Indicators indicators) throws HibernateException;

    Indicators findBy(Integer id);

    List<Indicators> getIndicators();
}
