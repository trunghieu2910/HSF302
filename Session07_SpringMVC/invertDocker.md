\# ☕ Hướng Dẫn Triển Khai Dự Án Java Coffee Bằng Docker



Tài liệu này hướng dẫn chi tiết cách đóng gói (build) và chạy dự án `java-coffee` bằng Docker. 



\---



\## 📋 Điều Kiện Tiên Quyết

\* Đã xem qua và nắm chắc cấu trúc code trong dự án `java-coffee`.

\* Máy tính đã cài đặt và đang chạy ứng dụng \*\*Docker Desktop\*\*.



\---



\## 🛠️ Chuẩn Bị

1\. Tạo một bản sao của thư mục dự án `java-coffee` gốc.

2\. Đổi tên thư mục bản sao thành `java-coffee-docker`.

3\. Mở thư mục bản sao đó trên IDE (khuyến nghị IntelliJ IDEA).

4\. Khởi động ứng dụng \*\*Docker Desktop\*\* (đợi trạng thái chuyển sang xanh lá - Engine running).



\---



\## ⚙️ Cấu Hình Môi Trường



\### 1. Tạo file `Dockerfile`

Tại thư mục gốc của dự án `java-coffee-docker` (ngang hàng với file `pom.xml`), tạo một file không có phần mở rộng, đặt tên chính xác là `Dockerfile` và dán nội dung sau:



```dockerfile

\# 1. Chọn môi trường cơ sở (Base Image) có sẵn Java.

\# Lấy bản Java 21 nhẹ gọn (alpine) làm chuẩn.

FROM eclipse-temurin:21-jre-alpine



\# 2. Đặt thư mục làm việc bên trong chiếc "thùng" container này

WORKDIR /app



\# 3. Copy file .jar từ thư mục target vào trong container và đổi tên thành app.jar

\# (Dấu \* giúp copy file .jar bất kỳ sinh ra trong target)

COPY target/\*.jar app.jar



\# 4. Mở cửa (Expose) cổng 8080 (cổng Tomcat mặc định)

EXPOSE 8080



\# 5. Lệnh khởi chạy app khi container được bật lên

ENTRYPOINT \["java", "-jar", "app.jar"]

