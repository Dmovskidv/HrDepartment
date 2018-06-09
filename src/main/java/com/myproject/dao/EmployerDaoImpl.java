package com.myproject.dao;

import com.myproject.model.Employer;
import com.myproject.model.Worker;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployerDaoImpl implements EmployerDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveToDatabase(Employer employer) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(employer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int checkAccount(String login, String password) {
        int resultRequest = 0;
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT E.id FROM AccountEmployer E WHERE E.login=:login AND E.password=:pass");
        query.setParameter("login", login);
        query.setParameter("pass", password);
        if (query.uniqueResult() != null) {
            resultRequest = (int) query.uniqueResult();
        }
        session.close();
        return resultRequest;
    }

    @Override
    public Employer returnEmployer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employer empl = (Employer) session.get(Employer.class, id);
        session.close();
        return empl;
    }

    @Override
    public List getWorkerByVacancy(String vacancy) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Worker> list;
        session.beginTransaction();
        Query query = session.createQuery("select W FROM Worker W WHERE W.speciality=:speciality");
        query.setParameter("speciality", vacancy);
        list = query.list();
        return list;
    }

    @Override
    public void removeEmployer(Employer employer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(employer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Профиль удалён");
    }

}
