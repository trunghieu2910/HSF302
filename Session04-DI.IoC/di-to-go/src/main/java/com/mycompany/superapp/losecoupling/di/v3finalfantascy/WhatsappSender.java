package com.mycompany.superapp.losecoupling.di.v3finalfantascy;
// open for EXXTENSION mowr cho theem moiws 1 option
public class WhatsappSender implements NotiService {

    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI-V3-OCP )Whatsapp Noti sent to " + to + " with message: " + message);
    }
}
