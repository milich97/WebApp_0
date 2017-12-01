package system.dao;

import org.springframework.stereotype.Repository;
import system.model.Worker;

import java.util.Arrays;
import java.util.List;

@Repository
public class WorkerDao {             //тут дб бд
    private List<Worker> workers = Arrays.asList(new Worker("worker1", 123, 0, 10),
            new Worker("worker2", 122, 3, 15));

    public List<Worker> getWorkers() {
        return workers;
    }
}
