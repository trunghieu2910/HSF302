package com.mycompany.superapp.repository;

import com.mycompany.superapp.entity.Student;
import com.mycompany.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepo {
    // CLASS NÀY SẼ CHƯÁ CÁC HÀM TRỰC TIẾP CRUD VỚI TABEL  - REPO : NAHF KHÓ DỮU LIỆU
    // MUỐN LÀM ĐIỀU NÀY THÌ PẢI DÓN ENTITYMANAGER TỪ CLASS JPAUTIL ĐỂ LẤY RA KÊNH KẾT NỐI VỚI SQLSERVER
    // FLOW UI -------SERVICE -------ROPO (ĐÂY)---------JPAUTIL (ENTITYMANAGER VÀ FACTORY ) --- TABLE

    // CÁC HÀM CRUD Ở ĐÂY HƯỜNG ĐẶT TÊ NGẮN NGỌN HƯỚNG HÀNH ĐỘNG  GIÔGS NHƯ LỆNH SQL CHUẨN
    // TÊN HÀM GỢI Ý  :  save() , update() , remove() , find() ,findAll( )..
    // TÙY TÙNG HÀM , NHƯUNG NẾU CÓ THAY ĐỔI (INSERT , UPDATE   , DELETE) THÌ HÀM SẼ NHẬN VÀO OBJECT (innssert , update), HƠACJ KEY (delete hưoacj key )
    // NHỨO : dùng transaction dành cho (insert upadate delete )

    public void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        em.getTransaction().begin(); // bắt đầu 1 transaction
        em.persist(student);
        em.getTransaction().commit(); // commit transaction
        em.close(); // đóng kênh kết nối
    }

    // hàm lấy tất cả sinh viên
    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        List<Student> results = em.createQuery("FROM Student", Student.class).getResultList();
        em.close(); // đóng kênh kết nối
        return results;
    }

    // SỬA THÔNG TIN SINH VIÊN  : PHƯƠNG PHÁP MERGE()
    public void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        em.getTransaction().begin(); // bắt đầu 1 transaction
        em.merge(student); // NGHĨA LÀ TÍCH HỢP CÁI OBJJECT ĐƯA VÀO EM
        //EM nó sẽ đổ ngang, copy ngang obj vào TRONG obj ứng với dòng trong tabl
        //nếu bạn cố tình đưa object mà key ko tồn tại trong table, sẽ insert mới
        em.getTransaction().commit(); // commit transaction
        em.close(); // đóng kênh kết nối
    }

    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        em.getTransaction().begin(); // bắt đầu 1 transaction
        Student x = em.find(Student.class, id); // tìm sinh viên có id  và xóa nó
        if (x != null) {
            em.remove(x);
        }
        em.getTransaction().commit(); // commit transaction
        em.close(); // đóng kênh kết nối
    }

    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        em.getTransaction().begin(); // bắt đầu 1 transaction
        em.remove(obj);
        em.getTransaction().commit(); // commit transaction
        em.close(); // đóng kênh kết nối
    }

    // TODO: LÀM THÊM HÀM WHERE THEO CÁI THAM SỐ NÀO ĐÓ
    // TODO : LÀM THÊM FINDBYID TRẢ VỀ 1 SINH VIÊN
    public Student find(String id) {
        EntityManager em = JpaUtil.getEntityManager(); // đoạn lệnh trôi nổi static{} được chạyd uy nhất 1 lần
        Student student = em.find(Student.class, id);
        em.close(); // đóng kênh kết nối
        return student;
    }
}
