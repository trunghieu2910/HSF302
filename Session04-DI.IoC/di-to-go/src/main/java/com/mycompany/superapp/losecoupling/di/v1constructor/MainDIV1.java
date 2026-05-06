package com.mycompany.superapp.losecoupling.di.v1constructor;

public class MainDIV1 {
    public static void main(String[] args) {
        // muốn có service cần có email-sender truyền vềao
        EmailSender emailSender = new EmailSender();
        // tiêm vào service
        UserService userService = new UserService(emailSender);
        userService.regissterAccount(new Account());
        //MAIN CLASS CHỦ ĐỘNG TẠO OBJ CLASS B, DEPENDENCY, ĐƯA VÀO CLASS CHÍNH
        //THẰNG CHỨA, TẠO CÁC DEPENDENCY ĐC GỌI LÀ CONTAINER
        //CHỦ ĐỘNG TẠO DEPENDENCY, ĐƯA VÀO TRONG SERVICE CLASS CHÍNH A
        //THÌ KĨ THUẬT NÀY CODE Ở TRÊN GỌI LÀ IoC, ĐẢO NGƯỢC VIỆC KIỂM SOÁT TẠO OBJECT
        //SERVICE MẤT BỚT QUYỀN, TRAO QUYE52N, ĐẢO QUYỀN KIỂM SOÁT DEPENDENCY
        // SPRINGBOOT SẼ THAY MAIN TẠO , KIỂM SOÁT , TIÊM CHÍCH DEPENDENCY  CHO CLASS CHÍNH
        // SPRING , SPRING BOOT GỌI LÀ ioC CONTAINER
    }
}
