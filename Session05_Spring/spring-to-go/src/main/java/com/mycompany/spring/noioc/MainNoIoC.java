package com.mycompany.spring.noioc;
// NO IOC ow day co nghia la khong cos ioc cuar springv ma la ioc thu coong
public class MainNoIoC {
    public static void main(String[] args) {
    // noiw taoj ra object taaoj ra denpendecy (bean) tieem trich vafo object chinhs
        //--> IoC CONTAINER
        //IoC CONTAINER kiem soat nhung dua phu thuoc , em trich vao cho anh service

        PdfGenerator gen = new PdfGenerator();
        ContractService service = new ContractService(gen);
        service.processContract();
    }
}
