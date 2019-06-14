package checkpay.dao;

import checkpay.models.User;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        persist(user);

    }

    @Override
    public void saveOrUpdate(User user) {
        super.saveOrUpdate(user);
    }

    @Override
    public void deleteUserById(int id) {
        Query query = getSession().createNativeQuery("delete from user where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        CriteriaQuery<User> criteria = createEntityCriteria();
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        Query query = getSession().createQuery(criteria);
        return (List<User>) query.getResultList();
    }

    @Override
    public User findUserById(int id) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("id"), id));
        Query<User> q = getSession().createQuery(criteria);
        return (User) q.getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        Query<User> q = getSession().createQuery(criteria);
        // this line is used to avoid 'no entity found for query' that comes from getSingleResult() exceptions
        User user = (User) q.getResultList().stream().findFirst().orElse(null);
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }
}
