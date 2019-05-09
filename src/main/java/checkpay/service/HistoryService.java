package checkpay.service;

import checkpay.models.History;

/**
 *
 * @author jnap
 */
public interface HistoryService {

    History findById(int id);

    void saveHistory(History history);

    void updateHistory(History history);

    void deleteHistoryById(int id);

    //List<History> findAllHistory();
    History findHistoryByEmployeeId(int id);
}
