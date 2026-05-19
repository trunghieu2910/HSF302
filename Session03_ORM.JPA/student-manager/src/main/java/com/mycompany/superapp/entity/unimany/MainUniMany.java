package com.mycompany.superapp.entity.unimany;

import com.mycompany.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniMany {
    public static void main(String[] args) {
        createMajor();
    }
// Chỉ có thể truy 1 chiều : tại đây 1 major ----N student , GÓC NHÌN TỪ PHÍA Student N ---->nên Major 1  , Vì vậy mà Student giữ 1 thuộc tính Major còn Major không giữ thuộc tính nào của Student vì vậy mà từ Student có thể tra ra Major nhưng từ Major không thể tra ra Student
    public static void createMajor() {
        Major se = new Major("SE", "Software Engineering | kỸ THUẬT PHẦN MỀM");
        Student student = new Student("S001", "Alice", 2000, 3.5);
        student.setMajor(se); // thiết lập mối quan hệ giữa student và major
        Student student2 = new Student("S002", "Bob", 1999, 3.8);
        student2.setMajor(se);

        //Xuoongs db phải dùng JPAUTIL , CẦN MƯỢN FACTORY VÀ LẤY ENTITY MANAGER CHUYÊN XỬ LÝ @ENTITY
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se); // lưu major trước
        em.persist(student);   // lưu student sau -- vì không đổ domino dược
        em.persist(student2);
        em.getTransaction().commit();
        em.close();
    }
}
