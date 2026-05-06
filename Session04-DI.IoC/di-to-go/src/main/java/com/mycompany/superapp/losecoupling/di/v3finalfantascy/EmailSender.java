package com.mycompany.superapp.losecoupling.di.v3finalfantascy;

public class EmailSender implements NotiService {
    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI - v3 OCP )Gửi mail thành công tới  : " + to + "vỚI NỘI DUNG  " + message);
    }
//    public void senEmail(String recipient, String message) {
//        //TODO: LOGIC GỬI MAIL : SETUPACCOUNT (ĐÓNG VAI NGƯỜI GỬI ) FORMAT EMAIL CHO PRO
//        System.out.println("(DI - v3 OCP )Gửi mail thành công tới  : " + recipient + "vỚI NỘI DUNG  " + message);
//    }
}
