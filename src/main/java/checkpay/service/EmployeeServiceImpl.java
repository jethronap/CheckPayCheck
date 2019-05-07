package checkpay.service;

import checkpay.dao.EmployeeDao;
import checkpay.models.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeDao dao;
    
    @Override
    public Employee findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee entity = dao.findById(employee.getId());
        if (entity != null) {
            entity.setFname(employee.getFname());
            entity.setLname(employee.getLname());
            entity.setProfession(employee.getProfession());
            entity.setEmail(employee.getEmail());
            entity.setPassHashed(employee.getPassHashed());
        }
    }

    @Override
    public void deleteEmployeeById(int ssn) {
        dao.deleteEmployeeById(ssn);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    @Override
    public Employee findEmployeeById(int ssn) {
        return dao.findEmployeeById(ssn);
    }

    @Override
    public boolean isEmployeeCodeUnique(Integer id, int ssn) {
        Employee employee = findEmployeeById(ssn);
        return (employee == null || ((id != null) && (employee.getId() == id)));
    }
}
