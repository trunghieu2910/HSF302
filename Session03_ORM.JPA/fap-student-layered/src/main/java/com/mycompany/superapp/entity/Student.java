package com.mycompany.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Id", nullable = false, columnDefinition ="CHAR(8)")
    private String id ;
    // @Nationalize // hardcode với hibernate
    @Column(name = "Name", nullable = false, columnDefinition ="NVARCHAR(50)")
    private String name ;

    @Column(name = "Yob", nullable = false)
    private int yob ;

    @Column(name = "Gpa", nullable = false)
    private double gpa;

    // NẾU KEY TỰ TĂNG THÌ KEY KHÔNG ĐƯA VÀO CONTRUCTOR


    public Student() {

    }

    public Student(double gpa, int yob, String name, String id) {
        this.gpa = gpa;
        this.yob = yob;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + "]";
    }
}
