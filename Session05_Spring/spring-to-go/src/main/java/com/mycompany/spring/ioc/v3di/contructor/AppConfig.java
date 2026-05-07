package com.mycompany.spring.ioc.v3di.contructor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mycompany.spring.ioc.v3di.contructor") // TỰ ĐỘNG NEW BEAN
public class AppConfig {
    // CHHỦ ĐỘNG NEW BEAN : ĐẶC BIỆT CÁC BEAN CÓ THAM SỐ ĐẦU VÀO   : CHỦ ĐỘNG ĐẶT TÊN LUÔN
}
