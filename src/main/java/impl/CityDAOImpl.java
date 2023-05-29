package impl;

import config.HibernateSessionFactoryUtil;
import dao.CityDAO;
import models.City;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public City createCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City findById(Integer id) {
        City city = new City();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            city = session.get(City.class, id);
        }
        return city;
    }

    @Override
    public List<City> findAll() {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM City ").list();
        }
    }

    @Override
    public City updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City delete(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public List<Employee> findAllEmployeeByCityId(Integer id) {
        City city = new City();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
           city = session.get(City.class, id);
            transaction.commit();
        }
        return city.getEmployees();
    }

}
