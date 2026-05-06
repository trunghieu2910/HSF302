package com.mycompany.superapp.losecoupling.di.v2setter;

public class EmailSender {

    public void senEmail(String recipient, String message) {
        //TODO: LOGIC GỬI MAIL : SETUPACCOUNT (ĐÓNG VAI NGƯỜI GỬI ) FORMAT EMAIL CHO PRO
        System.out.println("(DI - v2 setter )Gửi mail thành công tới  : " + recipient);
    }
}
