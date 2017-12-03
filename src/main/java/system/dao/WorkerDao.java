package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Worker;

import java.util.Arrays;
import java.util.List;

@Repository
public class WorkerDao {             //тут дб бд
    private List<Worker> workers;

    public List<Worker> getWorkers() {
        return workers;
    }
}
