package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.Worker;
import system.service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Worker> getWorkers() {
        return workerService.getWorkers();
    }
}
