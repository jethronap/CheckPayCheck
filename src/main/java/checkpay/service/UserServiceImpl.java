package checkpay.service;

import checkpay.models.User;
import checkpay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;
//    @Autowired
//    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findById(int id) {
        return userdao.findById(id);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleDao.findAll()));
        userdao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userdao.findByUsername(username);
    }

    /*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
     */
    @Override
    public void updateUser(User user) {
        User entity = userdao.findById(user.getId());
        if (entity != null) {
            entity.setUsername(user.getUsername());
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            entity.setFname(user.getFname());
            entity.setLname(user.getLname());
            entity.setEmail(user.getEmail());
            entity.setRoles(user.getRoles());
        }
    }

    @Override
    public void deleteUserById(int id) {
        userdao.deleteUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userdao.findAllUsers();
    }

    @Override
    public boolean isUserUsernameUnique(Integer id, String username) {
        User user = findByUsername(username);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
