package checkpay.controller;

import checkpay.models.Employee;
import checkpay.models.History;
import checkpay.service.EmployeeService;
import checkpay.service.HistoryService;
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
    HistoryService histService;

    @Autowired
    MessageSource messageSource;


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
    
    /*
	 * Add new History.
     */
    @RequestMapping(value = "/employee/{id}/history/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addHistory(@RequestBody History history) {
        histService.saveHistory(history);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
     /*
        * Find History by id.
    */
    @RequestMapping(value = "/employee/history/{id}", method = RequestMethod.GET)
    public ResponseEntity<History> getHistory(@PathVariable("id") int id) {
        History history = histService.findHistoryByEmployeeId(id);
        
        if (history == null) {
            return new ResponseEntity<History>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<History>(history, HttpStatus.OK);
    }

}

