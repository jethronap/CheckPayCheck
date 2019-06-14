package checkpay.dao;

import checkpay.models.Role;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    @Override
    public Role findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Role role) {
        persist(role);
    }

    @Override
    public void saveOrUpdate(Role role) {
        super.saveOrUpdate(role);
    }

    @Override
    public void deleteRoleById(int id) {
        Query query = getSession().createNativeQuery("delete from role where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> findAll() {
        CriteriaQuery<Role> criteria = createEntityCriteria();
        Root<Role> root = criteria.from(Role.class);
        criteria.select(root);
        Query query = getSession().createQuery(criteria);
        return (List<Role>) query.getResultList();
    }

    @Override
    public Role findRoleById(int id) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        Root<Role> root = criteria.from(Role.class);
        criteria.select(root).where(builder.equal(root.get("id"), id));
        Query<Role> q = getSession().createQuery(criteria);
        return (Role) q.getSingleResult();
    }

    @Override
    public Role findByRoleName(String name) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        Root<Role> root = criteria.from(Role.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        Query<Role> q = getSession().createQuery(criteria);
        return (Role) q.getSingleResult();
    }
}
