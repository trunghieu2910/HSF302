package com.mycompany.superapp.tightcoupling;

public class EmailSender {
    // CHUYÊN GỬI EMAIL KHÔNG DÍNH DÁNG GÌ ĐẾN WHATSAPP , THỎA MÃ NGUYÊN LÍ S/SRP TRONG SOLID
    // CHỨA HÀM CHUEYEN XỬ LÝ EMAIL
    //SAU NÀY NÂNG CẤP CŨNG CHI XOAY QUANH 1 LÝ DO SỬA ĐỐI
    //to         content
    // hàm này gửi mail tới ngươid ăng ký accoount thông tin email nhập từ màn hình
    public void senEmail(String recipient, String message) {
        //TODO: LOGIC GỬI MAIL : SETUPACCOUNT (ĐÓNG VAI NGƯỜI GỬI ) FORMAT EMAIL CHO PRO
        System.out.println("Gửi mail thành công tới  : " + recipient);
    }
}
