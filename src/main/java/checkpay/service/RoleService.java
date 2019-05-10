package checkpay.service;

import checkpay.models.Role;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface RoleService {

    Role findById(int id);

    Role findByName(String name);

    List<Role> findAll();
}
