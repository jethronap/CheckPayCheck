package checkpay.dao;

import checkpay.models.Volunteer;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface VolunteerDao {
    
    Volunteer findById(int id);

    void saveVolunteer(Volunteer volunteer);

    public void saveOrUpdate(Volunteer volunteer);

    void deleteVolunteerById(int ssn);

    List<Volunteer> findAllVolunteers();

    Volunteer findVolunteerById(int ssn);
}
