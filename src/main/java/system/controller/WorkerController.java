package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.EnterTime;
import system.service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("")
public class WorkerController {
    @Autowired
    private WorkerService workerService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getAllWorkers() {
        ModelAndView modelAndView = new ModelAndView("workers_page");
        modelAndView.addObject("workersFromServer", workerService.getResponse());
        return modelAndView;
    }

        @RequestMapping(value = "/date", method = RequestMethod.GET)        //or POST?
    public @ResponseBody
    ModelAndView checkUser(@ModelAttribute("dateFromServer") EnterTime time) {
            ModelAndView modelAndView = new ModelAndView("workers_date_page");
            modelAndView.addObject("workersFromDateFromServer", workerService.getResponse(time.getTime()));
        return modelAndView;
    }





}
