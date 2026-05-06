package com.mycompany.superapp;

import com.mycompany.superapp.entity.Student;
import com.mycompany.superapp.service.StudentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // coi là phần UI
    public static void main(String[] args) {
        // FLOW UI (ĐÂY)-------SERVICE -------ROPO ---------JPAUTIL (ENTITYMANAGER VÀ FACTORY ) --- TABLE
        StudentService studentService = new StudentService();


        //1. TẠO MỚI HỒ SƠ SINH VIÊN
//        Student an = new Student(3.5, 2000, "Nguyễn Văn An","SEHE1234" );
//        studentService.createStudent(an);
//        studentService.createStudent(new Student(3.8, 1999, "Trần Thị B","SEHE5678" ));
//        studentService.createStudent(new Student(3.2, 2002, "Lê Văn C", "SEHE1235"));
//        studentService.createStudent(new Student(3.9, 2000, "Phạm Thị D", "SEHE1236"));
//        studentService.createStudent(new Student(3.4, 2001, "Hoàng Văn E", "SEHE1237"));
//        studentService.createStudent(new Student(3.6, 2002, "Đỗ Thị F", "SEHE1238"));
//        studentService.createStudent(new Student(3.7, 2000, "Vũ Văn G", "SEHE1239"));
//        studentService.createStudent(new Student(3.3, 2001, "Nguyễn Thị H", "SEHE1240"));
//        studentService.createStudent(new Student(3.1, 2002, "Trần Văn I", "SEHE1241"));
//        studentService.createStudent(new Student(3.8, 2000, "Lê Thị K", "SEHE1242"));
        //2. SHOWW ALL
        System.out.println("Danh sách sinh viên:");
        studentService.getAllStudents().forEach(x -> System.out.println(x));
        //3.update hồ sơ sinh viên
//        Student an1 = new Student(9.2, 2000, "Nguyễn Văn An mới","SEHE1234" );
//        studentService.updateStudent(an1);
//         System.out.println("Danh sách sinh viên sau khi update:");
//        studentService.getAllStudents().forEach(x -> System.out.println(x));


        //4.remove hồ sơ sinh viên
        studentService.deleteStudent("SEHE1235");
        System.out.println("Danh sách sinh viên sau khi xóa:");
        studentService.getAllStudents().forEach(x -> System.out.println(x));

    }
}