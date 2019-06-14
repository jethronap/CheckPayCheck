package checkpay.dao;

import checkpay.models.Role;
import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    Role findById(int id);

    void save(Role role);

    public void saveOrUpdate(Role role);

    void deleteRoleById(int ssn);

    Role findRoleById(int ssn);

    Role findByRoleName(String name);
}
