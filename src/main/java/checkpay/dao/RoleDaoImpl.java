package checkpay.dao;

import checkpay.models.Role;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @Override
    public Role findRoleByName(String name) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        Root<Role> root = criteria.from(Role.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        Query<Role> q = getSession().createQuery(criteria);
        return (Role) q.getSingleResult();
    }
}
