package com.mycompany.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    // CLASS NÀY CHỊUT RCHAS NHGIEEMJ KẾT NOOIS COW SỞ DỮ LIỆU THÔNG QUA ĐỐI TƯỢNG   --> TỐN THỜI GIAN ĐỂ TẠO KÊNH KẾT NỐI VƯỚI SQLSERVER   --> HEAVY CLASSENTITY-MANAGER-FACTORY
    // NÓ NÊN ĐƯỢC TẠO SỚM , 1 LẦN M 1 INSTANCE , 1 VÙNG RAM , 1 OBJECT , SINGLETON

    // KỸ THUTAAJ VIẾT CODE KHIẾN CHO CLASS KHÔNG NEW ĐUWOCJ ALANF THỨ 2 , LỠ MAY GOI NHIỀU LẦN CÂIAS CLASS NÀY THÌ VẪN CHỈ CÓ 1 VÙNG RAM
    // STATIC + PRIVATE CONSTRUCTOR
    //Như đã biết :  1 CLASS KHÔNG CÓ CONSTRUCTOR --> JVM SẼ TẠO RA 1 CONSTRUCTOR RỖNG , VẪN NEW BÌNH THƯỜNG
    //Ký tuật này cấm tạo object tuwf mọi contructor  : CLASS KHÔNG CÓ CTOR VÀ CTOR RỖNG MÌNH PHẾ LUÔN bằng cách

    private static final EntityManagerFactory emf ;
    // heavy LOAD ANMWF Ở BIẾN NÀY !!!
    static {
        try {
         emf= Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");
         // LOAD THÔNG TIN SERVER TUWF FILE PERSISTENCE.XML
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // KỸ THUẬT SINGLETON PARTERN  -- VẤN ĐÊF SINGLETON KHI CHẠY ĐA LUỒNG NHƯ THẾ NÀO
    // cấm new class này
    //    // Biến emf Factory chỉ có 1 con đường đc khởi tọa , khởi tạo 1 lần duy nhât qua đoạn lệnh trôi nổi static  {} ở trên
      private JpaUtil() {
    }

    // CUNG CẤP 1 PHƯƠNG THỨC ĐỂ LẤY RA ENTITY-MANAGER
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // HÀM NÀY  SẼ ĐƯỢC repository gọi để lấy ra 1 đối tượng entity-manager , mỗi lần gọi sẽ tạo ra 1 entity-manager mới , nhưng chỉ có 1 entity-manager-factory duy nhất
   // JpaUtil.getEntityManager() ; GỌI NGHÌN LẦN Ở BẤT CỨ ĐÂU THÌ CŨNG CHỈ TẠO BIẾN emf 1 LẦN TRONG RAM

    // đóng cửa nhà máy / KHÔNG DUY TRÌ KẾT NỐI NỮA KHI APP SHUTDOWN
    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
