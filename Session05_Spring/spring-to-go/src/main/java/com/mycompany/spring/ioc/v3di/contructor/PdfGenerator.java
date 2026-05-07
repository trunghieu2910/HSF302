package com.mycompany.spring.ioc.v3di.contructor;

import org.springframework.stereotype.Component;

@Component // VÌ M KO TRẠNG THÁI NÊN TỰ NEW
public class PdfGenerator {
    public void generateFile(String fileName){
        //TODO : LOGIC XỬ LÝ IN RA FILE PDF
        System.out.println("(V3 DI IoC)The pdf file " +fileName+ " created successfully");
    }
}
