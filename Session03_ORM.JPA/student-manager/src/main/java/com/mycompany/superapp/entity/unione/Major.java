package com.mycompany.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

////@Entity
//@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "Id", columnDefinition = "char(2)")
    private String id;
    @Column(name = "Name", columnDefinition = "nvarchar(255)", nullable = false)
    private String name;
    // khong dangf @Nationalized đẻ dễ dầng chuyển sang nhà thi hành khác

    // 1 major có nhiều student
    // muốn lưu nhiều thông tin thì dùng list , objecct này lưu thông tin object kia
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // nhờ câu này thì bẳng table xuaats hiện và nó sẽ đòi FK
    @JoinColumn(name = "MajorId") // tự tạo bên tablle student 1 cột FK tên là majorId
    private List<Student> students = new ArrayList<>();

    // để có cụ thể bạn naof ta đùng student.add(student) để thêm student vào major
    //  để lấy thông tin student thì dùng major.getStudents() để lấy thông tin student trong major
    //                                    student.add(new Student (...))
    public  void addStudent(Student student) {
        // if để kiểm soát thêm student vào major
        students.add(student);
    }
    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
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
