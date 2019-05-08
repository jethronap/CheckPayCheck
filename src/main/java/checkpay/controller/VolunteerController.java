package checkpay.controller;


import checkpay.models.Volunteer;
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
public class VolunteerController {
    @Autowired
    VolunteerService service;

    @Autowired
    MessageSource messageSource;

    /*
	 * List all existing Volunteers.
     */
    @RequestMapping(value = {"/volunteer/all"}, method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Volunteer>> listVolunteers(ModelMap model) {

        List<Volunteer> volunteers = service.findAllVolunteers();
        if (volunteers.isEmpty()) {
            return new ResponseEntity<List<Volunteer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Volunteer>>(volunteers, HttpStatus.OK);
    }

    /*
        * Find Volunteer by id.
     */
    @RequestMapping(value = "/volunteer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Volunteer> getVolunteer(@PathVariable("id") int id) {
        Volunteer volunteer = service.findById(id);

        if (volunteer == null) {
            return new ResponseEntity<Volunteer>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Volunteer>(volunteer, HttpStatus.OK);
    }

    /*
	 * Add a new Volunteer.
     */
    @RequestMapping(value = "/volunteer/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Void> addVolunteer(@RequestBody Volunteer volunteer) {
        service.saveVolunteer(volunteer);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /*
	 * Update an existing Volunteer.
     */
    @RequestMapping(value = {"/volunteer/update/{id}"}, method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateVolunteer(@PathVariable("id") int id, Volunteer volunteer) {
        volunteer.setId(id);
        service.updateVolunteer(volunteer);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    /*
        * Delete a Volunteer by id.
     */
    @RequestMapping(value = "/volunteer/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> deleteVolunteer(@PathVariable("id") int id, Volunteer volunteer) {
        volunteer.setId(id);
        service.deleteVolunteerById(id);
       
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}
