package checkpay.service;

import checkpay.models.User;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface UserService {
    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> findAllUsers();

    User findUserById(int id);

    boolean isUserCodeUnique(Integer id, int userId);
}
