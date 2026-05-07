package com.mycompany.spring.ioc.v3di.contructor;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// v1 2 phục vụ cho v3
public class MainV3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 2 bean :
        ContracService service = context.getBean(ContracService.class);
        service.processContract();
    }
}
