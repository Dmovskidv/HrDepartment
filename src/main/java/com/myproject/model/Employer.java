package com.myproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employer", catalog = "vacancysystem")
public class Employer {

    private int employerId;
    private String company;
    private String vacancy;
   

    private AccountEmployer account;

    public Employer() {
    }

    public Employer(String company, String vacancy) {
        this.company = company;
        this.vacancy = vacancy;

    }

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEmployerId() {
        return employerId;
    }

    @Column(name = "COMPANY", unique = false, nullable = false, length = 20)
    public String getCompany() {
        return company;
    }

    @Column(name = "VACANCY", unique = false, nullable = false, length = 20)
    public String getVacancy() {
        return vacancy;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employer", cascade = CascadeType.ALL)
    public AccountEmployer getAccount() {
        return account;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public void setAccount(AccountEmployer account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Employer{" + "company=" + company + ", vacancy=" + vacancy + ", account=" + account + '}';
    }
    
    
}
