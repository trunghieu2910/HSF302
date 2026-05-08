package com.mycompany.sb.springboottogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // MANG 2 Ý NGHĨA NÓ GỘP BÊN TRONG BAO GỒM @Configuration + @ComponentScan (...)
public class SpringbootToGoApplication { // bản chất thì class này là class AppConfig trong dự án Spring trước --> class AppConfig phiên bản Springboot

    public static void main(String[] args) {
        // câu lệnh này tạo ta IoC Container Chức các bean
        // câu lệnh này xong là các bean đã được đọc xong
      ApplicationContext ctx= SpringApplication.run(SpringbootToGoApplication.class, args);  // --> bản chất hàm này trả về context

        // được quyền sài Bean sau câu lệnh này
        exelGenerator exelGen= (exelGenerator) ctx.getBean("nguyenTrungHieu"); // lấy bean ra để sử dụng
        exelGen.generateFile("report.xlsx");
    }
   // có thể tạo bean ơr đây
    @Bean("nguyenTrungHieu")
    public exelGenerator getExelGenerator(){
        return new exelGenerator();
    }
}
