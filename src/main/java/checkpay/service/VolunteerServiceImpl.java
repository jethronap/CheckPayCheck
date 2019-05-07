package checkpay.service;

import checkpay.dao.VolunteerDao;
import checkpay.models.Volunteer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */
@Service("volunteerService")
@Transactional
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerDao dao;

    @Override
    public Volunteer findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveVolunteer(Volunteer volunteer) {
        dao.saveVolunteer(volunteer);
    }

    @Override
    public void updateVolunteer(Volunteer volunteer) {
        Volunteer entity = dao.findById(volunteer.getId());
        if (entity != null) {
            entity.setFname(volunteer.getFname());
            entity.setLname(volunteer.getLname());
            entity.setProfession(volunteer.getProfession());
            entity.setEmail(volunteer.getEmail());
            entity.setPassHashed(volunteer.getPassHashed());
            //dao.saveOrUpdate(trainer);
        }
    }

    @Override
    public void deleteVolunteerById(int ssn) {
        dao.deleteVolunteerById(ssn);
    }

    @Override
    public List<Volunteer> findAllVolunteers() {
        return dao.findAllVolunteers();
    }

    @Override
    public Volunteer findVolunteerById(int ssn) {
        return dao.findVolunteerById(ssn);
    }
}
