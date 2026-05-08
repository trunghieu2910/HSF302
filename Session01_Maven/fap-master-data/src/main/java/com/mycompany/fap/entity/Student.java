package com.mycompany.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id ;
    private String name;
    private int yob ;
    private double gpa ;


    // BOILERPLATE CODE
    // TA DÙNG KỸ THUẬT GIÚP TÂ GEN RA CÁC PHƯƠNG THỨC GETTER, SETTER, CONSTRUCTOR, TO STRING  --> LOMBOK DEPENDENCY (ĐÂY LÀ HÀNG TRÊN MẠNG KO PHẢI CHÍNH HÃNG )


}
