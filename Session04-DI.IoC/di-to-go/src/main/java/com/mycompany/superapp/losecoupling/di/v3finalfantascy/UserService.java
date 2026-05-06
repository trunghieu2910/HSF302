package com.mycompany.superapp.losecoupling.di.v3finalfantascy;

public class UserService {
    //    private SmsSender smsSender;
//    private EmailSender emailSender;
    // ko new 2 cais treen maf chwo TIEM VAO
    private UserRepo userRepo;
    // KHAI BAO SMSender emailsender goij laf khai baos cuwnsg acis dependency
    // KHÔNG TỐT CHO TƯƠNG LAI
    // không nên phụ thuôvj vào cái cụ thể nhưu ửo trên
    // ta nên phụ thuôvj vào câis chung chug để sau này còn dễ bổ sung các hình thức guiwr khkacs mà không themf sưar code của chính class này
    private NotiService noti; // không new mà chờ tiêm vào
    // nói chung chung là phụ thuộc vào cái đám gửi

    public UserService(UserRepo userRepo, NotiService noti) {
        this.userRepo = userRepo;
        this.noti = noti;
    }


    // rrieneg biệt cho âbif này

    public UserService(NotiService noti) {
        this.noti = noti;
    }// tiêm từ bên ngoài vào

    public void registerUser(String to, String msg) {
        noti.sendNoti(to, msg);
    }
    // thật râ nó được trích từ thông tin account nhưung ở đây demo nên là để thế này cho tiện


    public void setNoti(NotiService noti) {
        this.noti = noti;
    }
}

