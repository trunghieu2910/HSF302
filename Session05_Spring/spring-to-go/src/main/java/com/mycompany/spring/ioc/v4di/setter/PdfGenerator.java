package com.mycompany.spring.ioc.v4di.setter;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generateFile(String fileName){
        //TODO : LOGIC XỬ LÝ IN RA FILE PDF
        System.out.println("(V4 DI IoC SETTER )The pdf file " +fileName+ " created successfully");
    }
}
