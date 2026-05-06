package com.mycompany.superapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Lecturers") // tên table có thể khác tên class , thì dùng @table // dòng này có cũng đc khôgn có cũng đc
public class Lecturer {
    @Id @Column(name = "Id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY) // chuỗi tự tang
    private Long id ;

    @Column(name="Name",nullable = false , columnDefinition = "NVARCHAR(50)")
    private String name ;

    @Column(name="Yob",nullable = false)
    private  int yob;

    @Column(name="Salary")
    private  double salary;

    //LOMBOK ĐỂ LOẠI BỎ BOILERPLATE CODE NHƯ CONSTRUCTOR , GETTER , SETTER , TO STRING

    public Lecturer() {
    }
// BỚT ĐI CỘT TỰ TĂNG
    public Lecturer( String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;
    }
    //GETTER SETTER

    public Long getId() {
        return id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", salary=" + salary +
                '}';
    }
}
