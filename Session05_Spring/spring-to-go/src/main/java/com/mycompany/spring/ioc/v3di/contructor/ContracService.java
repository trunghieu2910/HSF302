package com.mycompany.spring.ioc.v3di.contructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ContracService {
    // CCAANF 2 DEPENDENCY : REPO VÀ GENERATOR
    // Ở ĐÂY CHỈ CÙNG 1 ĐỂ DEMO THÔI
    private PdfGenerator gen;

    public ContracService() {
    }

    // new ở đâu không cần biêt
    // Constructor Injection
    @Autowired // trichs tiêm vafo 1 cái bean khác qua contructor   // ĐÁNH DẤU NƠI TIÊM / MANH MỐI TIÊM
    public ContracService(PdfGenerator gen){
        this.gen = gen;
    }
// NẾU NHƯ CLASS CÓ NHIỀU CTOR THÌ BẮT BUỘC PHẢI CÓ @Autowired
    public void processContract(){
        // todo : logic xu li hop dong
        gen.generateFile("( V3-DI )2025_15_19_00011_contract.pdf");// hardcode
    }
}
