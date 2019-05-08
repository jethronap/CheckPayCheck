package checkpay.controller;

import checkpay.models.User;
import checkpay.service.UserService;
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
}
