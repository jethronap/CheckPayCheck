package checkpay.service;

import checkpay.dao.UserDao;
import checkpay.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    
    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setFname(user.getFname());
            entity.setLname(user.getLname());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());
            
        }
    }

    @Override
    public void deleteUserById(int ssn) {
        dao.deleteUserById(ssn);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public User findUserById(int ssn) {
        return dao.findUserById(ssn);
    }

    @Override
    public boolean isUserCodeUnique(Integer id, int ssn) {
        User user = findUserById(ssn);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
