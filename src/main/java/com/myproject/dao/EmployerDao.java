package com.myproject.dao;

import com.myproject.model.Employer;
import java.util.List;

public interface EmployerDao {

    void saveToDatabase(Employer employer);

    public int checkAccount(String login, String password);

    public Employer returnEmployer(int id);

    public List getWorkerByVacancy(String vacancy);

    public void removeEmployer(Employer employer);
}
