package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.WorkerDao;
import system.hibernate.ReportCommonView;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerDao workerDao;


    public List<ReportCommonView> getResponse() {
        return workerDao.getReport();
    }


    public List<ReportCommonView> getResponse(long time) {
        return workerDao.getReport(time);
    }
}
