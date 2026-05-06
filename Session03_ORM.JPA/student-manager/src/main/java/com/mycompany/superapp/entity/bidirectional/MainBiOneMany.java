package com.mycompany.superapp.entity.bidirectional;

import com.mycompany.superapp.infra.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {
    public static void main(String[] args) {
      //  createMajor();
        getAll();
    }

    // LẤY DANH SÁCH SINH VIÊN , DS CHUYÊN NGÀNH
    // EM ENTITY MANAGER có hàm find() --> trả về 1 dòng duy nhất the key
    //                         createQuery() --> trả về list , NHƯNG LIST CHỈ 1 DÒNG TÙY VFAO ĐK WHERE
    public static void getAll() {
        // CHỈ CẦN VÀO MAJOR LẤY LIST SINH VIÊN RA LÀ OK
        EntityManager em = JpaUtil.getEntityManager();
        Major major = em.find(Major.class, "GD");
        System.out.println("Chuyên ngành : " + major);
        List<Student> stuList = major.getStuList();
        System.out.println("Danh sách sinh viên : ");
        stuList.forEach(x-> System.out.println(x));
    }

    public static void createMajor() {
        Major se = new Major("SE", "Software Engineering/Kỹ thuật phầm mềm ");
        Major gd = new Major("GD", "Graphic Design/Thiết kế đồ họa ");

        Student student = new Student("S0010000", "Alice", 2000, 3.5);
        Student student2 = new Student("S0020000", "Bob", 1999, 3.8);

        Student student3 = new Student("G0030000", "Charlie", 2001, 4.0);
        Student student4 = new Student("G0040000", "David", 2002, 3.9);


        // KẾT NỐI CHUYÊ NGÀNH

        se.addStudent(student);
        se.addStudent(student2);
        gd.addStudent(student3);
        gd.addStudent(student4);

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se); // đổ domilo
        em.persist(gd);// đổ domilo
        em.getTransaction().commit();
        em.close();
    }
}
