package com.mycompany.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// EnableAutoConfiguration: Tự động cấu hình, tự new  : JPA / Hibernate , Tomcat , MVC
@SpringBootApplication
public class JavaCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCoffeeApplication.class, args);
    }
// CHỦ ĐỘNG NEW BEAN --> GỬI CHO IoC CONTAINER --> IoC CONTAINER QUẢN LÝ VÒNG ĐỜI CỦA BEAN
}
