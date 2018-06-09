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
@Table(name = "worker", catalog = "vacancysystem")
public class Worker {

    private int workerId;
    private String fio;
    private String speciality;

    private AccountWorker account;

    public Worker() {
    }

    public Worker(String fio, String speciality) {
        this.fio = fio;
        this.speciality = speciality;

    }

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getWorkerId() {
        return this.workerId;
    }

    @Column(name = "FIO", unique = true, nullable = false, length = 20)
    public String getFio() {
        return this.fio;
    }

    @Column(name = "SPECIALITY", unique = false, nullable = false, length = 20)
    public String getSpeciality() {
        return this.speciality;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    public AccountWorker getAccount() {
        return this.account;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setAccount(AccountWorker account) {
        this.account = account;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Worker{" + "fio=" + fio + ", speciality=" + speciality + ", account=" + account + '}';
    }
    
    

}
