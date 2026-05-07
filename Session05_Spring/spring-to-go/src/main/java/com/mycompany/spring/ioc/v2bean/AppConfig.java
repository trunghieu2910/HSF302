package com.mycompany.spring.ioc.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // báo context biết đây là nơi chứa thông tin để new các bean , để quản lý chúng , tiêm chúng
//@ComponentScan("com.mycompany.spring.ioc.v2bean")
// ko scan luôn , mình tự new
public class AppConfig {
    // THÌ PHẢI NEW BEAN Ở ĐÂY
    @Bean("nguyenTrungHieu") // chủ động NEW (KHỞI TẠO ) nhưng đưa object cho IoC Container quản lý
    // TÊN HÀM PHÁ CHUẨN VERB + OBJECT TRUYỀN THÔNGS MÀ MANG Ý NGHĨA TÊN BIẾN OBJECT , ĐỂ ĐƯỢC DÙNG NGẦM TRONG CONTAINER
    public PdfGenerator pdfGenerator(){
        return new PdfGenerator();
    }
    // không thể dùng luuw tự động trong trường hợp CONTRUCTOR CÓ THAM SỐ
    //TODO : ĐIỀU GÌ XẢY RA NẾU TA CÓ 2 OBJECT CỦA CÙNG 1 CLASS ??
    // VD : pdfGenerartor , exelGenerator đều là (implament) Interface DocumentGenerator  --> xung đột 2 object cùng kiểu
    // @Primary , @Qualifier khi có nhiều bean cùng kiểu
    /*
    @Bean
    public DocumentGenerator pdfGenerator() {
         return new PdfGenerator();
    }

    @Bean
    public DocumentGenerator excelGenerator() {
        return new ExcelGenerator();
    }
*/
}
