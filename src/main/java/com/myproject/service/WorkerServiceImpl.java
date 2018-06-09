package com.myproject.service;

import com.myproject.dao.WorkerDao;
import com.myproject.model.Worker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerDao workerDao;

    public void setWorkerDao(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public void saveToDatabase(Worker worker) {
        workerDao.saveToDatabase(worker);
    }

    @Override
    public int checkAccount(String login, String password) {
        return workerDao.checkAccount(login, password);
    }

    @Override
    public Worker returnWorker(int id) {
        return workerDao.returnWorker(id);
    }

    @Override
    public List getEmployerBySpeciality(String speciality) {
        return workerDao.getEmployerBySpeciality(speciality);
    }

    @Override
    public void removeWorker(Worker worker) {
        workerDao.removeWorker(worker);
    }

}
