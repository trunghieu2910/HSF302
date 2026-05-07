package com.mycompany.spring.noioc;

public class ContractService {

    // nho vien tro thu PDF Generator --> Pdf Generator laf dependency va tu new o day hoac truyen vao - trich vao tiem vao DI
    private PdfGenerator gen;

    // Constructor Injection
    public ContractService(PdfGenerator gen){
       this.gen = gen;
    }

    public void processContract(){
        // todo : logic xu li hop dong
        gen.generateFile("2025_15_19_00011_contract.pdf");// hardcode
    }

    // thang service nay thay vi co gang tap chung kiem soat viec tao ra doi tuong dependency thif baay h no chi tap chung vao vc xu ly thoi
// Full of control
    // ---> Dao viec kiem soat doi tuong dependency cho UI để code dễ dàng hơn dễ bảo trì hơn
    //--> Inversion of Control (IoC) : Dao nguoc viec kiem soat doi tuong dependency cho UI

}
