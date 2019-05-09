package checkpay.service;

import checkpay.models.CrmUser;
import checkpay.models.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author jnap
 */
public interface UserService extends UserDetailsService{
    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> findAllUsers();

    User findUserById(int id);

    boolean isUserCodeUnique(Integer id, int userId);
    
    User findUserByEmail(String email);
    
    void save(CrmUser crmUser);
}
