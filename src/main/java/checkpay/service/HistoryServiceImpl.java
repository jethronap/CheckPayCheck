package checkpay.service;

import checkpay.dao.HistoryDao;
import checkpay.models.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jnap
 */
@Service("historyService")
@Transactional
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao dao;

    @Override
    public History findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveHistory(History history) {
        dao.saveHistory(history);
    }

    @Override
    public void updateHistory(History history) {
        History entity = dao.findById(history.getId());
        if (entity != null) {
            entity.setDateOfWork(history.getDateOfWork());
            entity.setHoursWorked(history.getHoursWorked());
            entity.setOvertime(history.getOvertime());
            entity.setHoursSunday(history.getHoursSunday());
            entity.setSalary(history.getSalary());
        }
    }

    @Override
    public void deleteHistoryById(int ssn) {
        dao.deleteHistoryById(ssn);
    }


    @Override
    public History findHistoryById(int ssn) {
        return dao.findHistoryById(ssn);
    }
}
