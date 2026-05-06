package com.mycompany.superapp.entity.unione;

import com.mycompany.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {

    public static void main(String[] args) {
        createMajor();
    }

    public static void createMajor() {
        Major seMajor = new Major("SE", "Software Engineering/Kỹ thuật phầm mềm ");
        Student student = new Student("S001", "Alice", 2000, 3.5);
        Student student2 = new Student("S002", "Bob", 1999, 3.8);
        // seMajor  : phải add sv vào list
        // ĐỂ LIST là public --> nguy hiểm
        //seMajor.students().add(student);
        seMajor.addStudent(student);
        seMajor.addStudent(student2);

        // OOP ĐÃ XONG VỀ RELATIONSHIP GIỮA 2 CLASS
        // XUONG TABLE , DDỎ DOMILO - CASCADE  1 MAJOR -- N STUDENT ĐI THEO
        // LƯU MAJOR THÌ STUDENT DDI THEO ĐẺ LUƯ VÀO DB


        // GỌI ĐÓIO TƯỢNG THỰC THI ĐỂ ĐẤY DỮ LIỆU XUỐNG DB
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(seMajor);
        em.getTransaction().commit();
        em.close();
    }
}
