package com.myproject.service;

import com.myproject.model.Worker;
import java.util.List;

public interface WorkerService {

    void saveToDatabase(Worker worker);

    public int checkAccount(String login, String password);

    public Worker returnWorker(int id);

    public List getEmployerBySpeciality(String speciality);

    public void removeWorker(Worker worker);

}
