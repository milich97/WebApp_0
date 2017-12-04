package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.WorkerDao;
import system.hibernate.ReportCommonView;
import system.model.Worker;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerDao workerDao;

    public List<Worker> getWorkers() {
        return workerDao.getWorkers();
    }

    public List<ReportCommonView> getResponse(boolean b) {
        return workerDao.getReport(b);
    }


}
