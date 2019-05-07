package checkpay.dao;


import checkpay.models.Volunteer;
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

@Repository("volunteerDao")
public class VolunteerDaoImpl extends AbstractDao<Integer, Volunteer> implements VolunteerDao {
    
    @Override
    public Volunteer findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveVolunteer(Volunteer volunteer) {
        persist(volunteer);
    }

    @Override
    public void saveOrUpdate(Volunteer volunteer) {
        super.saveOrUpdate(volunteer);
    }

    @Override
    public void deleteVolunteerById(int id) {
        Query query = getSession().createNativeQuery("delete from volunteer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Volunteer> findAllVolunteers() {
        CriteriaQuery<Volunteer> criteria = createEntityCriteria();
                Root<Volunteer> root = criteria.from(Volunteer.class);
                criteria.select(root);
                Query query = getSession().createQuery(criteria);
		return (List<Volunteer>) query.getResultList();
    }

    @Override
    public Volunteer findVolunteerById(int id) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Volunteer> criteria = builder.createQuery(Volunteer.class);
		Root<Volunteer> root = criteria.from(Volunteer.class);
                criteria.select(root).where(builder.equal(root.get("id"), id));
                Query<Volunteer> q=getSession().createQuery(criteria);
		return (Volunteer) q.getSingleResult();
    }
    
}
