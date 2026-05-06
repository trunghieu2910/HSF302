package com.mycompany.superapp.losecoupling.di.v3finalfantascy;

public class MainV3 {
    public static void main(String[] args) {
        SmsSender smsSender = new SmsSender();
        EmailSender emailSender = new EmailSender();

        UserService u = new UserService(emailSender);
        u.registerUser("email@gmail.com", "Welcome to our service!");

        u.setNoti(smsSender);
        u.registerUser("0987654321", "Welcome to our service!");


        // theem 1 option mới không sử code cũ
        WhatsappSender whatsappSender = new WhatsappSender();
        u.setNoti(whatsappSender);
        u.registerUser("+11987654321", "Welcome to our service!");


        // TUYỆT ĐỈNH KUNGFU : GỬI TIN NHẮN QUA TELEGRAM
        // THƯƠNG LÀ CODE THÊM CLASS LẺ - CONCRETE CLASS VÀ IMPLIMENT CÁI NOTISERVICE
        // PRO : CLASS ON THE GO , TAKEA AWAY , ANONYMOUS CLASS
        // NEW LUÔN INTERFACE , IMPLIMENT NGAY CODE NGAY LUC NEW INTERFACE

        NotiService telegramSender = new NotiService() {
            @Override
            public void sendNoti(String to, String message) {
                System.out.println(" ANNONYMOUS CLASS ,(DI - v3 OCP )Gửi Telegram thành công tới  : " + to + "vỚI NỘI DUNG  " + message);
            }
        };// VIP ==> KO PHẢI BIỂU THỨC LAMDA
        u.setNoti(telegramSender);
        u.registerUser("Telegram của tele ", "Welcome to our service!");
    }

}
