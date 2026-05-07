package com.mycompany.spring.ioc.v5di.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV5 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ContractService cs = (ContractService) context.getBean("nguyenTrungHieu");
        cs.processContract();
    }

}
