package checkpay.controller;

import checkpay.models.Employee;
import checkpay.models.User;
import checkpay.models.Volunteer;
import checkpay.service.EmployeeService;
import checkpay.service.UserService;
import checkpay.service.VolunteerService;
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
public class AdminController {

    @Autowired
    UserService service;
    
    @Autowired
    EmployeeService emplService;
    
    @Autowired
    VolunteerService volService;

    @Autowired
    MessageSource messageSource;

    /*
	 * List all existing Users.
     */
    @RequestMapping(value = {"admin/user/all"}, method = RequestMethod.GET,
            headers = "Accept=application/json")
    public ResponseEntity<List<User>> listUsers(ModelMap model) {

        List<User> users = service.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /*
        * Find User by id.
     */
    @RequestMapping(value = "admin/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = service.findById(id);

        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /*
	 * Add a new User.
     */
    @RequestMapping(value = "admin/user/add", method = RequestMethod.POST,
            headers = "Accept=application/json")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        service.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
	 * Update an existing User.
     */
    @RequestMapping(value = {"admin/user/update/{id}"}, method = RequestMethod.PUT,
            headers = "Accept=application/json")
    public ResponseEntity<Void> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        service.updateUser(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    /*
        * Delete a User by id.
     */
    @RequestMapping(value = "admin/user/delete/{id}", method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id, User user) {
        user.setId(id);
        service.deleteUserById(id);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
    
    /*
	 * List all existing Employees.
     */
    @RequestMapping(value = {"admin/employee/all"}, method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Employee>> listEmployees(ModelMap model) {

        List<Employee> employees = emplService.findAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    /*
        * Find Employee by id.
     */
    @RequestMapping(value = "admin/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = emplService.findById(id);

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    /*
	 * Add a new Employee.
     */
    @RequestMapping(value = "admin/employee/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        emplService.saveEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
	 * Update an existing Employee.
     */
    @RequestMapping(value = {"admin/employee/update/{id}"}, method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employee.setId(id);
        emplService.updateEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    /*
        * Delete an Employee by id.
     */
    @RequestMapping(value = "admin/employee/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id, Employee employee) {
        employee.setId(id);
        emplService.deleteEmployeeById(id);
       
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
    
    /*
	 * List all existing Volunteers.
     */
    @RequestMapping(value = {"admin/volunteer/all"}, method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Volunteer>> listVolunteers(ModelMap model) {

        List<Volunteer> volunteers = volService.findAllVolunteers();
        if (volunteers.isEmpty()) {
            return new ResponseEntity<List<Volunteer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Volunteer>>(volunteers, HttpStatus.OK);
    }

    /*
        * Find Volunteer by id.
     */
    @RequestMapping(value = "admin/volunteer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Volunteer> getVolunteer(@PathVariable("id") int id) {
        Volunteer volunteer = volService.findById(id);

        if (volunteer == null) {
            return new ResponseEntity<Volunteer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Volunteer>(volunteer, HttpStatus.OK);
    }

    /*
	 * Add a new Volunteer.
     */
    @RequestMapping(value = "admin/volunteer/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addVolunteer(@RequestBody Volunteer volunteer) {
        volService.saveVolunteer(volunteer);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
	 * Update an existing Volunteer.
     */
    @RequestMapping(value = {"admin/volunteer/update/{id}"}, method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateVolunteer(@PathVariable("id") int id, Volunteer volunteer) {
        volunteer.setId(id);
        volService.updateVolunteer(volunteer);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    /*
        * Delete a Volunteer by id.
     */
    @RequestMapping(value = "admin/volunteer/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable("id") int id, Volunteer volunteer) {
        volunteer.setId(id);
        volService.deleteVolunteerById(id);
       
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}
