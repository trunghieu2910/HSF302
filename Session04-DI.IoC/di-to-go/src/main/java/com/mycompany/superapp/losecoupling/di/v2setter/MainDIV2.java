package com.mycompany.superapp.losecoupling.di.v2setter;

public class MainDIV2 {
    public static void main(String[] args) {
        // DEPENDENCY ddax looj dienej thay vif harrdcode been trong
        EmailSender emailSender = new EmailSender();
        UserService userService = new UserService();

        userService.setEmailSender(emailSender);


        userService.setEmailSender(emailSender);
        userService.registerUser(new Account());
    }
// HÀM MAIN HAY CLASS MAIN NÀY LÀ NƠI CHƯÁ OBJ DEPENDENCY VÌ NÓ CHỦ ĐỘNG TẠO NEW EMAIL SENDER
    // NƠI CHỨA CÁC OBJECT DEPENDENCY ĐƯỢC NEW GỌI LÀ CONTAINER
    // và code chính của ta ko new object dêpndency ngầm mà chủ động để nơi khác new , ttiêm vào đảo ngược tiến trình quản lý object
    // TA KHÔNGN THAM LAM KIỂM SOÁT HẾT VIỆC TẠO RA OBJET DÊPNCY MÀ CHIA BƠT RA CCHO NGƯỜI KHÁC TẠO MÀ CHUEYENR QUYỀN KIỂM XOÁT TẠO OBJECT CHO NGƯỜI KHÁC  ==> THÌ GỌI LÀ IOC inversoiom of controll
    // IoC : là lời khuyên là nguyên lý
    // DI là cách làm cụ thể  , implimemtation
    //IOC CONTAINER , CONTAINER là  nơi chứa object DEPENDENCY
    //Spring chính là IoC Container thay cho Main , Nhưng chắc chắn dữ dằn hơn !!!!!!!!!

}
