package checkpay.service;

import checkpay.dao.RoleDao;
import checkpay.dao.UserDao;
import checkpay.models.User;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
    
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleDao.findAll()));
        dao.saveUser(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return dao.findUserByEmail(email);
    }
/*
    @Override
    @Transactional
    public User findUserByEmail(String email) {
        // check the database if the user already exists
        return dao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFname(crmUser.getFirstName());
        user.setLname(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());

        // give user default role of "admin"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("admin")));

        // save user in the database
        dao.saveUser(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = dao.findUserByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    */
}
