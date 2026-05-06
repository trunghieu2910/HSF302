package com.mycompany.superapp.losecoupling.di.v1constructor;

public class UserService {
    // srp : chuyên về CRU
    // cần 2 denpendency  là :
    // 1 userRepo
    // 2 emailSender
    private UserRepo userRepo;  // có new là tight coupling nếu không thì là DI
    // lỏng ra @Autowired nghãi là DI , nghiax là khôgn full controll

    // @Autowired nghãi là DI , NGHÃI LÀ AI đó new và tự đôngj tiêm vào cho mình

    private EmailSender emailSender;// có new là tight coupling nếu không thì là DI
    // ở đây hkoong new thì tự đưa vào

    //CÓ NHIỀU CÁCH ĐƯA OBJ TỪ NGOÀI VÀO TRONG 1 CLASS
//1. TRỰC TIẾP QUA FIELD, BIẾN emailSender THÀNH PUBLIC - NGUY HIỂM VI PHẠM ENCAPSULATION. VẪN MUỐN QUA FIELD MÀ PRIVATE - DÙNG KĨ THUẬT NÂNG CAO REFLECTION!!!
//FIELD INJECTION (DÙNG REFLECTION, IOC FRAMEWORK)

//2. TRUYỀN VÀO QUA CONSTRUCTOR!!! MLEM NHẤT
//TẠO OBJECT CHÍNH MÌNH QUA CONSTRUCTOR VÀ NHẬN THÊM ĐỒ QUA THAM SỐ CONSTRUCTOR
//OBJECT DEPENDENCY ĐI QUA, ĐƯA QUA CONSTRUCTOR

//3. SETTER - TRUYỀN QUA HÀM SET() NHƯNG NẾU LƯỜI KO GỌI SET() THÌ DEPENDENCY BỊ NULL

    //4. DÙNG FRAMEWORK/THƯ VIỆN BÊN NGOÀI TỰ KIỂM SOÁT VIỆC TẠO OBJ DEPENDENCY
//VÀ TIÊM CHÍCH VÀO: SPRING/SPRINGBOOT!!!
    public UserService(UserRepo userRepo, EmailSender emailSender) {
        this.userRepo = userRepo;
        this.emailSender = emailSender;
    }

    // tâoj chung vào email sender thôi
    public UserService(EmailSender emailSender) {
        // this.userRepo = userRepo;
        this.emailSender = emailSender;
    }

    public void regissterAccount(Account account) {
        // gửi mail confirm dùng dependency emailSender
        // hardcode emaail de demo
        emailSender.senEmail("hieuabc@gmail.com", "Nhap ma xac nhaan OTP LAF ###");
        /// todo : luu xg db
    }
}
