package com.mycompany.superapp.losecoupling.di.v3finalfantascy;
// SRP : SINGLE RESSPONSIBILITY PRINCIPLE : NGUYÊN TẮC ĐƠN TRÁCH NHIỆM
public class SmsSender implements NotiService {
//    public void senSms(String phone, String message) {
//        //TODO: LOGIC GỬI SMS
//
//        System.out.println("(DI - v3 OCP )Gửi SMS thành công tới  : " + phone + "wtih contane " + message);
//    }

    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI - v3 OCP )Gửi SMS thành công tới  : " + to + "wtih contane " + message);

    }
    // CODE MỚI THÊM VÀO TRƯỚC ĐÓ CHƯA CÓ , THÊM KO SỬA SERVICE MƯỚI NGON
}
