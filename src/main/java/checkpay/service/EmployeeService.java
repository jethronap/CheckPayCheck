package checkpay.service;

import checkpay.models.Employee;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface EmployeeService {

    Employee findById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();

    Employee findEmployeeById(int id);

    boolean isEmployeeCodeUnique(Integer id, int emplId);

}
