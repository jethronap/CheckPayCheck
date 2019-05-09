package checkpay.dao;

import checkpay.models.History;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jnap
 */
@Repository("historyDao")
public class HistoryDaoImpl extends AbstractDao<Integer, History> implements HistoryDao{
    
    @Override
    public History findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveHistory(History history) {
        persist(history);
    }

    @Override
    public void saveOrUpdate(History history) {
        super.saveOrUpdate(history);
    }

    @Override
    public void deleteHistoryById(int id) {
        Query query = getSession().createNativeQuery("delete from history where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public History findHistoryById(int id) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<History> criteria = builder.createQuery(History.class);
		Root<History> root = criteria.from(History.class);
                criteria.select(root).where(builder.equal(root.get("id"), id));
                Query<History> q=getSession().createQuery(criteria);
		return (History) q.getSingleResult();
    }
}
