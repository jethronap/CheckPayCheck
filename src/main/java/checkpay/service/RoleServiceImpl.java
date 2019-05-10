package checkpay.service;

import checkpay.dao.RoleDao;
import checkpay.models.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public Role findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return dao.findByRoleName(name);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }
}
