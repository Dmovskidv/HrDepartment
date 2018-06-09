package com.myproject.controller;

import com.myproject.model.AccountEmployer;
import com.myproject.model.Employer;
import com.myproject.model.Worker;
import com.myproject.service.EmployerService;
import com.myproject.service.EmployerServiceImpl;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployerController {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
    //ObjectService objectService = context.getBean(ObjectServiceImpl.class);

    EmployerService employerService = context.getBean(EmployerServiceImpl.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "mainpage";
    }

    @RequestMapping(value = "/formEmployer", method = RequestMethod.POST)
    public ModelAndView addEmployer(@ModelAttribute Employer employer) {
        ModelAndView mev = new ModelAndView();
        mev.setViewName("formEmployer");
        mev.addObject("employer", employer);
        return mev;
    }

    @RequestMapping(value = "/formEmployer/save", method = RequestMethod.POST)
    public String saveEmployer(@ModelAttribute("employer") Employer employer) {

        if (employer.getEmployerId() == 0) {
            employerService.saveToDatabase(employer);
        }
        String redirectUrl = "http://localhost:8080/system/";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/login-employer", method = RequestMethod.POST)
    public ModelAndView loginEmployer(@ModelAttribute("accountemployer") AccountEmployer accountemployer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formLoginEmployer");
        modelAndView.addObject(accountemployer);
        return modelAndView;
    }

    @RequestMapping(value = "/login-employer/check", method = RequestMethod.POST)
    public ModelAndView checkAccountEmployer(@ModelAttribute("accountemployer") AccountEmployer accountemployer) {
        ModelAndView modelAndView = new ModelAndView();
        int idclient = employerService.checkAccount(accountemployer.getLogin(), accountemployer.getPassword());
        if (idclient != 0) {
            Employer empl = employerService.returnEmployer(idclient);
            accountemployer.setEmployer(empl);
            modelAndView.setViewName("sessionEmployer");
            modelAndView.addObject("employer", empl);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/*/{id}/workers-list", method = RequestMethod.POST)
    public ModelAndView selectWorkers(@PathVariable(value = "id") int idworker) {
        int id = idworker;
        Employer empl = employerService.returnEmployer(id);
        ModelAndView modelAndView = new ModelAndView();
        List<Worker> list = employerService.getWorkerByVacancy(empl.getVacancy());

        modelAndView.setViewName("listWorkers");
        modelAndView.addObject("workers", list);
        return modelAndView;
    }
}
