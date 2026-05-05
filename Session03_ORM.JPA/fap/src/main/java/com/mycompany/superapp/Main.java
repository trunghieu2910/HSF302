package com.mycompany.superapp;

import com.mycompany.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        selectAllStudent();
    }

    // INSERT / TẠO MỚI
    public static void insertStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");     // THÔNG SỐ CẤU HÌNH NHÀ THẦU JPA CHO JPA CLASS

        EntityManager em = emf.createEntityManager();
        // tạo ra 1 object để quản lý các Entity ~ map sang table . Class Student
        // em sẽ lo CRUD trên tâble nào đó
        // qua các hàm persist , merge , remove , find
        // TỰ SINH SQL NGẦM
        Student an = new Student("PH001", "Nguyen Van An", 2000, 8.5);
        Student binh = new Student("PH002", "Le Thi Binh", 2001, 8.0);
        Student cuong = new Student("PH003", "Tran Van Cuong", 2002, 7.5);
        // thêm @Nationalized để lưu unicode ( tiếng việt có dấu ) , nếu không có thì lưu bình thường ( tiếng anh )

        // transaction để đảm   bảo tính toàn vẹn dữ liệu , nếu có lỗi thì rollback về trạng thái trước đó
        em.getTransaction().begin(); // bắt đầu 1 transaction
        em.persist(an); //CREATE TÂBLE diễn ra ngầm
        em.persist(binh);// gọi là CODE FIRST
        em.persist(cuong);
        em.getTransaction().commit(); // kết thúc transaction

        //HOẶC CẢ 3 INSERT THÀNH CÔNG HOẶC KHÔNG AI THÂNHF CÔGN
        em.close();
        emf.close();
    }

    // SELECT * / ĐỂ LẤY HẾT DATA
    public static void selectAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery(" FROM Student", Student.class).getResultList();
        for (Student student : students) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getYob() + " - " + student.getGpa());
        }
    }
}