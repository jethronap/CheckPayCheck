package checkpay.dao;

import checkpay.models.Employee;
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


@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
    @Override
	public Employee findById(int id) {
		return getByKey(id);
	}

        @Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}
	
        @Override
	public void saveOrUpdate(Employee employee){
		super.saveOrUpdate(employee);
	}
	
        @Override
	public void deleteEmployeeById(int id) {
		Query query = getSession().createNativeQuery("delete from employee where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
        @Override
	public List<Employee> findAllEmployees() {
		CriteriaQuery<Employee> criteria = createEntityCriteria();
                Root<Employee> root = criteria.from(Employee.class);
                criteria.select(root);
                Query query = getSession().createQuery(criteria);
		return (List<Employee>) query.getResultList();
	}

        @Override
	public Employee findEmployeeById(int id) {
                CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> root = criteria.from(Employee.class);
                criteria.select(root).where(builder.equal(root.get("id"), id));
                Query<Employee> q=getSession().createQuery(criteria);
		return (Employee) q.getSingleResult();
	}
}
