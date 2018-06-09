package com.myproject.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "accountEmployer", catalog = "vacancysystem")
public class AccountEmployer implements Serializable {

    private int id;
    private String login;
    private String password;

    private Employer employer;

    public AccountEmployer() {
    }

    public AccountEmployer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "LOGIN", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    @Column(name = "PASSWORD", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountEmployer{" + "login=" + login + ", password=" + password + ", employer=" + employer + '}';
    }
    
    
}
