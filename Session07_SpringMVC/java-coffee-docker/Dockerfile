# 1. Chọn môi trường cơ sở (Base Image) có sẵn Java.
# Ở video thầy dùng JDK 21 hoặc 24, mình sẽ lấy bản Java 21 nhẹ gọn (alpine) làm chuẩn.
FROM eclipse-temurin:21-jre-alpine

# 2. Đặt thư mục làm việc bên trong chiếc "thùng" container này
WORKDIR /app

# 3. Copy file .jar từ thư mục target (máy thật) vào trong container và đổi tên thành app.jar cho dễ gọi
# (Dấu * giúp copy file .jar bất kỳ sinh ra trong target để bạn đỡ phải gõ tên dài dòng)
COPY target/*.jar app.jar

# 4. Mở cửa (Expose) cổng 6969 - chính là cổng thầy giáo đã cấu hình cho Tomcat
EXPOSE 8080

# 5. Lệnh để chạy app khi container được bật lên (giống hệt cách thầy gõ trên CMD)
ENTRYPOINT ["java", "-jar", "app.jar"]