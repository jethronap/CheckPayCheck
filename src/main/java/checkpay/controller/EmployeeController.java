package checkpay.controller;

import checkpay.models.Employee;
import checkpay.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jnap
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    MessageSource messageSource;

    /*
	 * List all existing Employees.
     */
    @RequestMapping(value = {"/employee/all"}, method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Employee>> listEmployees(ModelMap model) {

        List<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    /*
        * Find Employee by id.
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = service.findById(id);

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    /*
	 * Add a new Employee.
     */
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
	 * Update an existing Employee.
     */
    @RequestMapping(value = {"/employee/update/{id}"}, method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employee.setId(id);
        service.updateEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    /*
        * Delete an Employee by id.
     */
    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id, Employee employee) {
        employee.setId(id);
        service.deleteEmployeeById(id);
       
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}

