package com.mycompany.superapp.entity.unione;

import jakarta.persistence.*;

//@Entity
//@Table(name = "Student")
public class Student {
    @Id
    @Column(name="Id" , columnDefinition = "char(8)")
    private String id;

    @Column(name="Name" , columnDefinition = "nvarchar(255)",nullable = false)
    private String name;

    @Column(name="Yob", nullable = false)
    private int yob;
    @Column(name="Gpa" , nullable = false)
    private double gpa;

    // Gỉa sử có 1 thuộc tính kháo ngoại
    //private String majorId; ==> MẤT CẤU TRÚC OOP ĐÂY LAF TƯ DUY TABLE

    //NGHĨ ĐÚNG THEO TƯ DUY OOP
    // STUDENT THAM CHIẾU ĐẾN THỒN TIN CHUYÊN NGÀNH
    // CÓ CÁCH ĐỂ CONVERT OOP THÁNH TABLE /FK , JOIN COLUMN --> ORM MAPPING
    // CẦN 1 THẰNG GIÚP ẢNH XẠ 2 THẾ GIỚI ĐỂ CHO TƯNG THÍCH : JPS/HIBERNATE
    //private Major major;


    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
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
}
