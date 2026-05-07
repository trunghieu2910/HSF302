package com.mycompany.spring.ioc.v2bean;

import com.mycompany.spring.ioc.v2bean.PdfGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PdfGenerator gen1 =(PdfGenerator) context.getBean("nguyenTrungHieu");
        gen1.generateFile("(V2)test.pdf");


       PdfGenerator gen2 = context.getBean("nguyenTrungHieu", PdfGenerator.class);
        gen2.generateFile("(V2)test2.pdf");

        PdfGenerator gen3 = context.getBean(PdfGenerator.class);
        gen3.generateFile("(V3)test3.pdf");
    }
}
