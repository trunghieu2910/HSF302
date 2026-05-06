package com.mycompany.superapp.losecoupling.di.v3finalfantascy;

public interface NotiService {
    // LÀ 1 CLASS CHA , KHÔNG CÓ CODE
    // VỀ LÝ THUYẾT KHÔNG CÓ CODE THÌ KHÔNNG NEW ĐƯỢC OBJECT
    // VÊF THƯC TẾ INTERFFACE GIỐNG NHƯ 1 CAAU LẠC BỘ , KHI NÁO TỤ TAAPJ ANH EM CÙNG CHÍ HƯSNGM , CUNNGF THEO MỘI NỘI QUY AE TUÂN THỦ LÀM THEO CÁCH RIENG  MÔIX NG THÌ GỌI LÀ IMPLIMENTS
    // NÓ SẼ ÓC SANG NGUEYEN LÝ ĐA HÌNH POLIMORPHISM
    // HỢP ĐỒNG TUÂN THỦ CONSTRUCT
    public void sendNoti(String to, String message);
}
