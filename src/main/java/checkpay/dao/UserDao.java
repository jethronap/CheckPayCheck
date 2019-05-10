package checkpay.dao;

import checkpay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    //void save(User user);
    User findByUsername(String username);
}
