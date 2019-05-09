package checkpay.dao;

import checkpay.models.Role;

/**
 *
 * @author jnap
 */
public interface RoleDao {

    public Role findRoleByName(String name);
}
