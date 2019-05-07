package checkpay.dao;

import checkpay.models.Employee;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface EmployeeDao {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    public void saveOrUpdate(Employee employee);

    void deleteEmployeeById(int ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int ssn);
}
