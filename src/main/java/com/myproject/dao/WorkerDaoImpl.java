package com.myproject.dao;

import com.myproject.model.Employer;
import com.myproject.model.Worker;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveToDatabase(Worker worker) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public int checkAccount(String login, String password) {

        int resultRequest = 0;
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query2 = session.createQuery("SELECT W.id FROM AccountWorker W WHERE W.login=:login AND W.password=:pass");
        query2.setParameter("login", login);
        query2.setParameter("pass", password);
        if (query2.uniqueResult() != null) {
            resultRequest = (int) query2.uniqueResult();
        }
        session.close();
        return resultRequest;
    }

    @Override
    public Worker returnWorker(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Worker worker = session.get(Worker.class, id);
        session.close();
        return worker;
    }

    @Override
    public List getEmployerBySpeciality(String speciality) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employer> list;
        session.beginTransaction();
        Query query = session.createQuery("select E FROM Employer E WHERE E.vacancy=:vacancy");
        query.setParameter("vacancy", speciality);
        list = query.list();
        return list;
    }

    @Override
    public void removeWorker(Worker worker) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
        System.out.println("Профиль удалён");
    }

}
