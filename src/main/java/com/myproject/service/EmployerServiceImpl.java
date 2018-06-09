package com.myproject.service;

import com.myproject.dao.EmployerDao;
import com.myproject.model.Employer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    EmployerDao employerDao;

    public void setEmployerDao(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public void saveToDatabase(Employer employer) {
        employerDao.saveToDatabase(employer);
    }

    @Override
    public int checkAccount(String login, String password) {
        return employerDao.checkAccount(login, password);
    }

    @Override
    public Employer returnEmployer(int id) {
        return employerDao.returnEmployer(id);
    }

    @Override
    public List getWorkerByVacancy(String vacancy) {
        return employerDao.getWorkerByVacancy(vacancy);
    }

    @Override
    public void removeEmployer(Employer employer) {
        employerDao.removeEmployer(employer);
    }

}
