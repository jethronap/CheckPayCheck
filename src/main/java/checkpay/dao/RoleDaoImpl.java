package checkpay.dao;

import checkpay.models.Role;
import java.util.List;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        CriteriaQuery<Role> criteria = createEntityCriteria();
        Root<Role> root = criteria.from(Role.class);
        criteria.select(root);
        Query query = getSession().createQuery(criteria);
        return (List<Role>) query.getResultList();
    }
}
