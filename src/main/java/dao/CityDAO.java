package dao;

import models.City;
import models.Employee;

import java.util.List;

public interface CityDAO {
    City createCity(City city);

    City findById(Integer city_id);

    List<City> findAll();

    City updateCity(City city);

    City delete(City city);

    List<Employee> findAllEmployeeByCityId(Integer city_id);

}
