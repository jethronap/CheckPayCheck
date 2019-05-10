package checkpay.service;

import checkpay.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
