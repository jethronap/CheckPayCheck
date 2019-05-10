package checkpay.service;

import checkpay.models.User;
import java.util.List;

public interface UserService {

    User findById(int id);

    User findByUsername(String username);

    void save(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> findAllUsers();

    boolean isUserUsernameUnique(Integer id, String username);
}
