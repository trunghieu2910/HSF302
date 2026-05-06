package com.mycompany.superapp.entity.bidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    @Column(name="Id" , columnDefinition = "char(2)")
    private String id;

    @Column(name="Name" , columnDefinition = "nvarchar(255)")
    private String name;
    // 1 CHUYÊN NGÀNH CÓ NHIỀU SINH VIÊN VÌ VẬY NÓ PHẢI CHỨA 1 LIST STUDENT
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY ,mappedBy = "major") // biế major bên Student móc ngươcj về đây

    // mappedBy : để kết nối ngược  với bạn sinh viên để biết bạn đó có thuộc về mình hay không ? nghãi lầ có dữ cái major.id khớp với id đnag dứng không  ?

    private List<Student> stuList  = new ArrayList<>();
    // .add : để dduwa sinh viên vào
    // .remove : 1 sv đổi chuyên ngành
    // VIẾT CODE Ở ĐÂU VỚI 2 LỆNH NÀY  ??  NGUYÊN LÝ S TRONG SOLID
    //                                              SRP : Single Responsibility Principle
    // THÊM XÓA CHUYÊN NGÀNH LÀ VC CỦA MAJOR
    // 2 hàm xóa và nhập sv phải thuộc class này
    public void addStudent(Student student){
        stuList.add(student); // lưu thông tin sinh viên list của chuyên ngành
        student.setMajor(this); // viết thông tin chuyên ngành vào thông tin sinh vieen
    }
    public void removeStudent(Student student){
        stuList.remove(student); // 1 sv đã rời bỏ chuyên ngành này
        student.setMajor(null); // vì nó bỏ cn này nên thông tin chueye nnganhf cuẩ nó phải là null
    }

    // CHUYÊN NGANH X CÓ BN STUDENT ?


    public List<Student> getStuList() {
        return stuList;
    }

    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
//        return "Major [id=" + id + ", name=" + name + "]";
        return String.format("|%2s|%-40s|", id, name);
    }
}
