import dao.CityDAO;
import dao.EmployeeDAO;
import impl.CityDAOImpl;
import impl.EmployeeDAOImpl;
import models.Employee;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDao = new EmployeeDAOImpl();
        CityDAO cityDao = new CityDAOImpl();

        Employee employeeP = new Employee("Slava", "Slavin", "man", 31, cityDao.findById(4) );
        employeeDao.create(employeeP);
        System.out.println(employeeDao.readAll());
        System.out.println(cityDao.findAll());

        List<Employee> employeeList = employeeDao.readAll();
        employeeList.stream()
                .forEach(System.out::println);

        Employee employeeA = new Employee("Egor", "Egorov", "man", 35, cityDao.findById(3) );
        employeeDao.updateEmployee(employeeA);
        employeeDao.delete(employeeA);
   }
}
