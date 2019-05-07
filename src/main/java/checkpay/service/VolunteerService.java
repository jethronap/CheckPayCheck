/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpay.service;

import checkpay.models.Volunteer;
import java.util.List;

/**
 *
 * @author jnap
 */
public interface VolunteerService {

    Volunteer findById(int id);

    void saveVolunteer(Volunteer volunteer);

    void updateVolunteer(Volunteer volunteer);

    void deleteVolunteerById(int id);

    List<Volunteer> findAllVolunteers();

    Volunteer findVolunteerById(int id);

//    boolean isVolunteerCodeUnique(Integer id, int volId);
}
