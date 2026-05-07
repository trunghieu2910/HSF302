package com.mycompany.spring.ioc.v5di.field;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generateFile(String fileName){
        //TODO : LOGIC XỬ LÝ IN RA FILE PDF
        System.out.println("(V5 DI IoC FIELD )The pdf file " +fileName+ " created successfully");
    }
}
