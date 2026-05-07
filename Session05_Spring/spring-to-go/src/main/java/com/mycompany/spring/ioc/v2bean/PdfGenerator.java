package com.mycompany.spring.ioc.v2bean;

import org.springframework.stereotype.Component;

//@Component // Để m đc new bới IoC Container của Spring , nếu ko có @Component thì sẽ ko đc new và quản lí bởi Spring , mà phải tự new bằng tay

// Bây giờ không ,muốn nz nữa
public class PdfGenerator {
        public void generateFile(String fileName){
            //TODO : LOGIC XỬ LÝ IN RA FILE PDF
            System.out.println("(V1)The pdf file " +fileName+ " created successfully");
        }

    }
