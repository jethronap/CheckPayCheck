package checkpay.controller;

import checkpay.models.Role;
import checkpay.models.User;
import checkpay.service.RoleService;
import checkpay.service.UserService;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author jnap
 */
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/admin/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/admin/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/admin/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
         */
        if (!userService.isUserUsernameUnique(user.getId(), user.getUsername())) {
            FieldError usernameError = new FieldError("user", "username", messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
            result.addError(usernameError);
            return "registration";
        }

        userService.save(user);

        model.addAttribute("success", "User " + user.getFname() + " " + user.getLname() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/admin/edit/user/{id}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/admin/edit/user/{id}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
        userService.updateUser(user);

        model.addAttribute("success", "User " + user.getFname() + " " + user.getLname() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = {"/admin/delete/user/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/admin/list";
    }

    /**
     * This method will provide Role list to views
     */
    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.findAll();
    }

    /**
     * This method handles login GET requests. If users is already logged-in and
     * tries to goto login page again, will be redirected to index page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/index";
        }
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            //persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method returns true if users is already authenticated [logged-in],
     * else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    @GetMapping(value = {"/", "/index"})
    public String showIntro() {
        return "welcome";
    }
}
