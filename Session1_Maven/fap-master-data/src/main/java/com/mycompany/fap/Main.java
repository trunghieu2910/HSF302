package com.mycompany.fap;

import com.mycompany.fap.entity.Student;
import com.mycompany.fap.entity.Subject;
import tools.jackson.databind.ObjectMapper;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject("CS101", "Introduction to Computer Science", 3, 45.0);
        Subject subject2 = new Subject("CS102", "Data Structures", 3, 45.0);

        System.out.println(subject);
        System.out.println(subject2);


        Student student = new Student("S001", "John Doe", 20, 9.0);
        System.out.println(student);


        //JSON : JavaScript Object Notation : Kỹ thuật biểu diễn thông tin của 1 object theo ngôn ngữ js
        // java c# oject diẽn tả như sau  :  new Student("S001", "John Doe", 20, 9.0);
        //==> nhìn text khó hiểu 20 , 9.0 là gì  ?
        // JS biểu diễn nhìn là hiểu liền
        // { "code  : "CS101", "name": "Introduction to Computer Science", "credit": 3, "hourse": 45.0 }

        //===> TRỞ THÀNH 1 CHUẨN TRUYỀN THÔNG TIN VÌ CNNHIFN PHÁT HIỂU LUÔN
        // TRONG MÔ HÌNH CODE BE VÀ FE GIAO TIẾP VS NHAU BẰNG JSON
        // THƯ VIỆN ĐỂ GIÚP CONVERT jAVA OBJECT SANG JSON VÀ NGƯỢC LẠI : JACKSON, GSON
        // FE ---------------JSON   ------------------BE
        //                  AXIOS(REACT API)   SPRING BOOT (REST API)
        ObjectMapper mapper = new ObjectMapper();
        try {
            // BE GỬI FE
                String json = mapper.writeValueAsString(student);
                System.out.println(json);
            // fe gửi BE
          //  String cuongjson = "{ \"id\": \"S002\", \"name\": \"Cuong\", \"yob\": 21, \"gpa\": 8.5 }";
            String cuongjson = """ 
                        {
                        "id": "S002",
                        "name": "Cuong",
                        "yob": 21,
                        "gpa": 8.5
                    }
                    """;
            Student cuong = mapper.readValue(cuongjson, Student.class);
            System.out.println("Cuong tu json" + cuong);
            } catch (Exception e) {
                e.printStackTrace();
        }

    }
}