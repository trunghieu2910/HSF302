package com.mycompany.fap.entity;
// class luuw thong tin các môn học
public class Subject {
    private String code;
    private String name;
    private int credit;
    private double hourse;

    public Subject() {
    }

    public Subject(String code, String name, int credit, double hourse) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.hourse = hourse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getHourse() {
        return hourse;
    }

    public void setHourse(double hourse) {
        this.hourse = hourse;
    }

    @Override
    public String toString() {
        return "Subject [code=" + code + ", name=" + name + ", credit=" + credit + ", hourse=" + hourse + "]";
    }
}
