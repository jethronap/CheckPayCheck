package checkpay.dao;

import checkpay.models.User;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface UserDao {

    User findById(int id);

    void saveUser(User user);

    public void saveOrUpdate(User user);

    void deleteUserById(int ssn);

    List<User> findAllUsers();

    User findUserById(int ssn);
}
