package com.mycompany.superapp.losecoupling.di.v2setter;

//---GUI --------CONTROLLER------SERVICE ----------REPO------TABLE
public class UserService {
    // Chuyên sử lí data trong ram sau đói gọi reppo để luuw xuống table
    // cần trọ giú từ 2 dêpndency đưa dịch vụ bên ngoài vào có 4 cách

    private EmailSender emailSender;
    private UserRepo userRepo;


    public UserService() {
    }

    // SETTER
    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // CACHS NAYF DEE HIỂU NƯHUXNG NẾU KO GỌI SET( ) THID SAEX BỊ NULLL
    // thường ưu tiên dùng contructor injection để không bị null nhưu v 1


    public void registerUser(Account accountDTO) {
        System.out.println(" đói tượng email sender " + emailSender );

        emailSender.senEmail("email@gmail.com", "Welcome to our service!");

    }
}
