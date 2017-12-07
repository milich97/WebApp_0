package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.Worker;
import system.service.WorkerService;

@Controller
@RequestMapping("")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView siftingUp(@ModelAttribute("dateFromServer") Worker w) {
        ModelAndView modelAndView = new ModelAndView("workers_date_page");
        modelAndView.addObject("workersFromDateFromServer", workerService.getResponse(w.getName()));
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getAllWorkers() {
        ModelAndView modelAndView = new ModelAndView("workers_page");
        modelAndView.addObject("workersFromServer", workerService.getResponse());
        modelAndView.addObject("dateFromServer", new Worker());
        return modelAndView;
    }


}
