package com.mycompany.spring.ioc.v1scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// class này là nơi khai báo các object denpendency của riêng ta (bean)và ta gửi cho spring container tự nó giữ
// cũng là noi khai báo các thông tin  về các dêpndency khác mà ta không tự tạo , IoC hẳn cho Spring lo giùm
// TÓM LẠI : CLASS này là nơi lưu giữ các thông tin về các dêpndency mà ta nhừo spring quản lý giùm
//Các object dependency new PdfGenerator(), new ContractService(), new Repository() sẽ đc khai báo, và đc quản lí ở class này và sau đó chuyển giao cho Spring!!!
// Những object depndency từ nay về sau gọi là BEAN - HẠT ĐẠU THẦN
@Configuration // <=>  @SpringBootApplication
@ComponentScan("com.mycompany.spring.ioc.v1scan ") // Khai báo nơi (PACKAGE) các @Component, @Service, @Repository  @Controller , @RestController nó nằm --> để spring sacnn ra khi chạy code
// Scan tất cả  các  package  nào , xem xem class nào có  @Component, @Service, @Repository  @Controller , @RestController (lq đến API)..
//thì new chúng nó và gọi nó là bean
//@ComponentScan(basePackages = {"pkg1" , "pkg2"}) // có thể khai báo nhiều package
public class AppConfig {



}
