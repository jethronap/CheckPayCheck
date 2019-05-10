package checkpay.dao;

import checkpay.models.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */
@Repository("userDao")
public abstract class UserDaoImpl  extends AbstractDao<Integer, User> implements UserDao {
    
    @Override
    public User findByUsername(String username) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(builder.equal(root.get("username"), username));
        Query<User> q = getSession().createQuery(criteria);
        return (User) q.getSingleResult();
    }
}
