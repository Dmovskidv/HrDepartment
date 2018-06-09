package com.myproject.controller;

import com.myproject.model.AccountWorker;
import com.myproject.model.Employer;
import com.myproject.model.Worker;
import com.myproject.service.WorkerService;
import com.myproject.service.WorkerServiceImpl;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkerController {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
    WorkerService workerService = context.getBean(WorkerServiceImpl.class);

    @RequestMapping(value = "/formWorker", method = RequestMethod.POST)
    public ModelAndView addWorker(@ModelAttribute Worker worker) {
        ModelAndView mev = new ModelAndView();
        mev.setViewName("formWorker");
        mev.addObject("worker", worker);
        return mev;
    }

    @RequestMapping(value = "/formWorker/save", method = RequestMethod.POST)
    public String saveEmployer(@ModelAttribute Worker worker) {
        workerService.saveToDatabase(worker);
        String redirectUrl = "http://localhost:8080/system/";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/login-worker", method = RequestMethod.POST)
    public ModelAndView loginEmployer(@ModelAttribute("accountworker") AccountWorker accountworker) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formLoginWorker");
        modelAndView.addObject(accountworker);
        return modelAndView;
    }

    @RequestMapping(value = "/login-worker/check", method = RequestMethod.POST)
    public ModelAndView checkAccountWorker(@ModelAttribute("accountworker") AccountWorker accountworker) {
        ModelAndView modelAndView = new ModelAndView();
        int idclient = workerService.checkAccount(accountworker.getLogin(), accountworker.getPassword());
        if (idclient != 0) {
            Worker worker = workerService.returnWorker(idclient);
            accountworker.setWorker(worker);
            modelAndView.setViewName("sessionWorker");
            modelAndView.addObject(accountworker);

        }
        return modelAndView;
    }

    @RequestMapping(value = "/worker/{id}/employers-list", method = RequestMethod.POST)
    public ModelAndView selectEmployers(@PathVariable(value = "id") int idempl) {
        int id = idempl;
        Worker worker = workerService.returnWorker(id);
        ModelAndView modelAndView = new ModelAndView();
        List<Employer> list = workerService.getEmployerBySpeciality(worker.getSpeciality());

        modelAndView.setViewName("listEmployers");
        modelAndView.addObject("employers", list);
        return modelAndView;
    }

}
