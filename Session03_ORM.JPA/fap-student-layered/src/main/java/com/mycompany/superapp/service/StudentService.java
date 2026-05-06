package com.mycompany.superapp.service;

import com.mycompany.superapp.entity.Student;
import com.mycompany.superapp.repository.StudentRepo;

import java.util.List;

public class StudentService {
    //CLASS NÀY ĐỨNG GIỮA HỨNG INFOR TỪ NGƯỜI DÙNG SAU ĐÓ TẠO OBJECT ĐẤY XUỐNG REPO

    // NÓ CŨNG NHỪO REPO LẤY OBJECT TỪ TABLE ĐẨY NGƯỢC NÊN UI
    // chỉ cần 1 biến repo dùng chung có các hàm , do minhg gọi bên trong repo.SAVE() .FINDALL() ..

    // FLOW UI -------SERVICE (ĐÂY)-------ROPO---------JPAUTIL (ENTITYMANAGER VÀ FACTORY ) --- TABLE

    // tên hàm class này thường đặt gần gũi với User hơn vì gần USER HƠN VD :  addStudent() , getAllStudents() , updateStudent() , deleteStudent() , getStudentById() ...
    private StudentRepo repoStudent = new StudentRepo();

    public void createStudent(Student obj) {
        // todo : check trùng key mail information
        // todo : cần try catch thông báo ...
        repoStudent.save(obj);
    }

    public List<Student> getAllStudents() {
        return repoStudent.findAll();
    }

    public void updateStudent(Student obj) {
        repoStudent.update(obj);
    }

    public void deleteStudent(String id) {
        repoStudent.delete(id);
    }

    public void deleteStudent(Student obj) {
        repoStudent.delete(obj);
    }
}
