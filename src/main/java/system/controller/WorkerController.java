package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.hibernate.ReportCommonView;
import system.model.Worker;
import system.service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("")
public class WorkerController {
    @Autowired
    private WorkerService workerService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
//    List<ReportCommonView> getWorkers() {
//        System.out.println("Hello from controller");
//
//        return workerService.getResponse(true);
//    }
    ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView("workers_page");
        modelAndView.addObject("workersFromServer", workerService.getResponse());
        return modelAndView;
    }

    //    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public @ResponseBody
//    String checkUser(@ModelAttribute("userFromServer") Worker worker) {
//        if ("admin".equals(worker.getName()) && "admin".equals(worker.getSurname())) {
//            return "valid";
//        }
//        return "invalid";
//    }
    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public @ResponseBody
    String hello() {
        return "hello";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkUser(@ModelAttribute("workersFromServer") Worker worker) {
        if ("admin".equals(worker.getName()) && "admin".equals(worker.getSurname())) {
            return "valid";
        }
        return "invalid";
    }


    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportCommonView> getResponse1() {
        System.out.println("DELETEmE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return workerService.getResponse();
    }


}
