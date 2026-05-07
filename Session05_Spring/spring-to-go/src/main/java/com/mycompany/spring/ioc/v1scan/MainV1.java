package com.mycompany.spring.ioc.v1scan;

import org.springframework.context.ApplicationContext;

public class MainV1 {
    public static void main(String[] args) {
        // KHOIỬ TẠO THÙNG CHỨA BEAN
        ApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(AppConfig.class);
        // context thuộc class ApplicationContext là trùm cuối quản lí các object - bean , quản lý vc tiêm vào các object khác
        // --> ĐỨA NÀO MUỐN ĐC TIÊM VÀO , ĐỨA ĐÓ CŨNG Phải LÀ BEAN
        // trùm cuối giống như ENTITU -MANAGER-FACTORY ĐÃ HỌC   - CHƠI VỚI DB
        // TRÙM CUỐI CONTEXT CHƠI TRONG RAM

        //lây bean ra dùng
        PdfGenerator gen1 =(PdfGenerator) context.getBean("pdfGenerator");
        gen1.generateFile("test.pdf");

        PdfGenerator gen2 = context.getBean("pdfGenerator", PdfGenerator.class);
        gen2.generateFile("test2.pdf");

        PdfGenerator gen3 = context.getBean(PdfGenerator.class);
        gen3.generateFile("test3.pdf");

        // nếu muốn getbean vưới 1 ten của mình ==> ĐẾN VỚI VERSION 2 : NHỜ QUẢN LÝ NHƯNG MUỐN ĐẶT TÊN RIÊNG CỦA EM
    }
}
