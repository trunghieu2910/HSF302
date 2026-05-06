package com.mycompany.superapp.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

// CLASS NÀY SẼ ẢNH XẠ MAPPING THÀNH TABLE TƯƠNG ỨNG TRON DB
@Entity
@Table(name = "Student") // TÊN BẢNG TRONG DB
// nếu không có khai abos này thì lấy tên class lầ tên table
public class Student {
    @Id
    @Column(name = "Id" , columnDefinition = "CHAR(8)")// camelcase thì phải khai báo tên cột trong db, nếu không thì lấy tên biến làm tên cột
    // id tự nhập (id tự tang tính sau )
    private String id; //camelcase


    @Column(name = "Name" , nullable  =  false , length = 50 , columnDefinition = "NVARCHAR(50)")
    // không được null )
    //@Nationalized // để lưu unicode ( tiếng việt có dấu ) , nếu không có thì lưu bình thường ( tiếng anh ) --> NẾU CHUYỂN SANG ECLISELINK THÌ KO ĐC VÍ NÓ DÍNH TỚI HIBERNATE  , CHỈ THUỘC VỀ HIBERNATE
    // MẤT ĐI TÍNH KAHR CHUYỂN KHÔNG THỂ CHƠI ĐA NAHF THẦU
    //M ĐỘ VARCHAR CHƠI VỚI NHIỀU NHÀ CUNG CẤO ORM/JPA QUA COLUMNDEFINITION
    private String name;

    @Column(name = "Yob" , nullable  =  false)
    private int yob;

    @Column(name = "Gpa" )
    private  double gpa;

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
        return "Student [id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + "]";
    }
}
