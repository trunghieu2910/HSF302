package com.mycompany.superapp;

import com.mycompany.superapp.entity.Lecturer;
import com.mycompany.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany.orm_eclipselink-PU");     // THÔNG SỐ CẤU HÌNH NHÀ THẦU JPA CHO JPA CLASS

    public static void main(String[] args) {
    insertStudent();
        insertLecturers();
        selectAllStudent();
        selectAllLecturers();
        //System.out.println("Search : "  );
        //searchLecturers();
        // remove();
        // findById();
        // update();
    }
    // EntityManager  là ông xếp quản lí các Entity --> Có thể CRUD  ==> Quản lý các Object tạo từ class Entity, sếp có thể thêm persit() , xóa remove() , cập nhật merge() , tìm kiếm theo key  : find() ==> vì ta luôn có nhu cầu thao tác trên 1 dòng cụ thể trong table    , truy vấn JPQL createQuery() --> để tìm linh hoạt theo tổ hợp điều kiện

    // SWP có màn hình quản lí user , phân loại , showtable nhiều donngf  , phân trnag fillter  cuối mỗi record có dòng update|delete  --> xử lý 1 dòng đnag select theo khóa chính
    // KHI LÀM CÁC HÀNH ĐỘNG XOÁ / SỬA THÊM
    // TÂ PHẢI NHÉT NÓ VÀO TRANSACTION ĐỂ THEO DÕI : HOẶC  TẤT CẢ HOẶC KHÔNG GÌ CẢ
    // NGUYÊN LÝ : DO OR NOTHING
    public static void update() {
        // KỸ THUẬT UPDATE ĐƠN GIẢN NHẤT / CÒN 1 KỸ THUẬT NỮA LÀ MERGE TÍNH SAU
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
            Lecturer x = em.find(Lecturer.class, 2);
             Student y = em.find(Student.class, "PH002");
             x.setSalary(25000);
                y.setGpa(9.0);
        em.getTransaction().commit(); // nó kiểm tra có sự thay đổi j khoong và nó sửa

        System.out.println("UPDATE SUCCESS");
    }

    public static void remove() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Lecturer x = em.find(Lecturer.class, 1);
        Student y = em.find(Student.class, "PH001");
        em.remove(x);
        em.remove(y);
        em.getTransaction().commit();
        System.out.println("DELETE SUCCESS");
    }

    public static void findById() {
        EntityManager em = emf.createEntityManager();
        Lecturer x = em.find(Lecturer.class, 1);
        //   Student y = em.find(Student.class,"PH001"); //NẾU TÌM SINH VIỆN
        System.out.println("Lec in4 : " + x);
    }

    public static void insertLecturers() {

        // ĐI LÀM THẬT CẤM DÙNG CẤU HÌNH CREATE TRÊN MÁY KHÁCH HÀNG VID SẼ MẤT HẾT DATA
        EntityManager em = emf.createEntityManager();
        //VÌ CÓ THAY ĐỔI TRÊN CSDL NÊN TA CẦN THEO DÕI CHAẶT CHẼ CÁC CÂU LỆNH  --> DÙNG KHÁI NIỆM TRANSACTION
        em.getTransaction().begin();
        em.persist(new Lecturer("Nguyen Van A", 1980, 1000));
        em.persist(new Lecturer("Le Thi B", 1985, 1200));
        em.persist(new Lecturer("Tran Van C", 1990, 1500));
        em.getTransaction().commit();
        em.close();
    }

    public static void selectAllLecturers() {
        EntityManager em = emf.createEntityManager();
        //HQL JPQL khá giống sql nhưng làm  vc trên ọbject  trên Entity chứ không quan tâm trên cột tronng table
        List<Lecturer> lecturers = em.createQuery("SELECT lec FROM Lecturer lec ", Lecturer.class).getResultList();
        // --> WHERE hardcode
        //HỌC THÊM VỀ JPQL (JAVA PERSISTENCE QUERY LANGUAGE) HQL (HIBERNATE QUERY LANGUAGE)  - NGÔN NGỮ TRUY VẤN CỦA JPA , HIBERNATE
        // phiên bản độ từ sql dành cho oop , object
        // hibernate cũng có rrieng cho nó là HQL nhưung không học vì nó không đa hình được

        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.getId() + " - " + lecturer.getName() + " - " + lecturer.getYob() + " - " + lecturer.getSalary());
        }
        // biểu thức lambda - LAMBDA EXPRESSION  : SWT  DÍNH DÁNG CHẶT CHẼ VỚI SPRING API , CƠ CHẾ SỬ LÝ NHIỀU DỮ LIỆU OQWR TRONG RAM
        // DÍNH ĐÁNG ĐẾN KHÁI NIỆM LẬP TRÌNH HÀM  - FUNTIONAL PROGRAMMING
        // HÀM ĐC XEM LÀ THAM SỐ ĐỂ TRUEYENF VÀO HÀM KHÁC


        // sql : SELECT * FROM Lecturers
        //JPQL : FROM Lecturer
        //       SELECT lec FORM LECTURER  lec
        //với mỗi dòng/record lấy từ table Lecturer
        //ta new nó trong RAM, new Lecturer() và gọi vùng new này là
        //lec, tức là lec = new Lecturer()
        //và lặp lại cho toàn bộ record trong table Lecturer
        // ADD KẾT QUẢ CUỐI CÙNG ĐỌC TỪ TABLE VÀO DÙNG LỆNH SELECT lec
        // SELECT lec  tức là lấy từng object lec được new từ từng dòng trong table Lecturer

        //WHERE
        //SQL: SELECT * FROM Lecturer WHERE salary = 2000000 //tên cột trong table
        //JPQL: SELECT x FROM Lecturer x WHERE x.salary = 2000000 //tên field trong class
        // X NÀY LÀ OBJECT , không phải cột trong table
        //QUERY ĐỘNG THAM SỐ WHAERE TRUYỀN TỪ WEB FORM ĐẾN ĐẤY CÓ 1 VALUE NÀO ĐÓ
        // JPQL  : SELECT x FROM Lecturer x WHERE x.salary = :pSalary
        // có quyền dùng OR , LIKE AND như sql chuẩn
        //CÓ DÙNG TOÁN TỬ LIKE SO SÁNH GẦN ĐÚNG GIÁ TRỊ CHUỖI
        //SQL CHUẨN: SELECT * FROM Lecturer WHERE Name LIKE '%AN%'  -- TÊN CHỨA CHỮ AN
        //                                        LIKE 'AN%' -- TÊN BẮT ĐẦU CHỮ AN
        //PSQL: SELECT lec FROM Lecturer lec WHERE lec.name LIKE :pName
        //setParameter("pName", "%AN%")


//        System.out.println("The list Lecturers with lambda expression : ");
//        lecturers.forEach(x ->{
//            System.out.println(x);
//        });

//        lecturers.forEach( x ->{
//            for (int i = 0; i < 10; i++) {
//                System.out.print( i);
//            }
//        });

        em.close();
    }

    public static void searchLecturers() {
        EntityManager em = emf.createEntityManager();
        List<Lecturer> lecturers = em.createQuery("SELECT lec FROM Lecturer lec WHERE lec.salary= :x", Lecturer.class).setParameter("x", 1200.0).getResultList();
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.getId() + " - " + lecturer.getName() + " - " + lecturer.getYob() + " - " + lecturer.getSalary());
        }
    }

    // INSERT / TẠO MỚI
    public static void insertStudent() {
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");     // THÔNG SỐ CẤU HÌNH NHÀ THẦU JPA CHO JPA CLASS

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
        // emf.close(); // VS CẤU HỈNH CREATE THÌ KHI SHUTDOWN APP thì đóng
    }

    // SELECT * / ĐỂ LẤY HẾT DATA
    public static void selectAllStudent() {
        //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery("SELECT x FROM Student x", Student.class).getResultList();
        // QUERY NÀY GẦN GIỐNG SQL NHƯNG THEO STYLE OOP , GỌI LÀ JPQL HQL

        for (Student student : students) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getYob() + " - " + student.getGpa());
        }
    }
}