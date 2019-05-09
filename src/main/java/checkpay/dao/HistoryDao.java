package checkpay.dao;

import checkpay.models.History;

/**
 *
 * @author jnap
 */
public interface HistoryDao {

    History findById(int id);

    void saveHistory(History history);

    public void saveOrUpdate(History history);

    void deleteHistoryById(int ssn);

    //List<History> findAllVolunteers();
    History findHistoryByEmployeeId(int ssn);
}
