package com.mycompany.superapp.tightcoupling;
// gui --- controller --- service ---- repo(jpautil) ---table
public class UserService {
    // có ít nhất 2 dêpndency service
      // user-repo
      // gửi email  confirm
      private UserRepo userRepo = new UserRepo();
      private EmailSender emailSender = new EmailSender() ;

      // chủ đọng tạo object tronng lòng ==> găn skeets chặt chẽ
    // new Service có 2 tk này được tạo luôn
   // ==> ko muốn gửi email nữa thì phải đổi code luôn
    // hardcode dependency
    // full-controll , direct-control dependency :  TU KHAI BAO TU NEW
    // vấn đề sau này đổi phương thức confirm thì phải sửa code trong service luôn


    // CÓ NHIỀU HÀM LIÊN QUAN ĐẾN TABLE USER
    // nhạn vào Account hơacj A ccountDTO chứa email
    public void regissterAccount(Account account) {
        // gửi mail confirm dùng depen      dency emailSender
        // hardcode emaail de demo
        emailSender.senEmail("hieuabc@gmail.com", "Nhap ma xac nhaan OTP LAF ###");
        // todo : lưu xg table
    }
}
// Class A : dùng class B
// Class B : là de  pendency của class A
