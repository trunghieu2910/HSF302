package com.mycompany.superapp.entity.bidirectional;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name="Id" , columnDefinition = "char(8)")
    private String id;

    @Column(name="Name" , columnDefinition = "nvarchar(255)")
    private String name;

    @Column(name="Yob", nullable = false)
    private int yob;

    @Column(name="Gpa")
    private double gpa;

    // SV THUỘC VỀ 1 CHUYÊN NGÀNH TẠI 1 THỜI ĐIỂM
    @ManyToOne
    @JoinColumn(name = "major_id")  // cả 2 bên đều có quyền khai báo joinColumn nếu dùng unione hay unimany , bâyh làm bidiectional thì 2 bên nhìn qua lại với nhau ==> để join column bên N cho giống như góc nhìn table
    private Major major;

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
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
//        return "Student{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", yob=" + yob +
//                ", gpa=" + gpa +
//                '}';
        return String.format("|%8s|%-20s|%4d|%4.2f|", id, name, yob, gpa);
    }
}
