## 🛠 Công nghệ sử dụng
🔹 Backend
Ngôn ngữ: Java (JDK 21).

Công nghệ cốt lõi: JSP & Servlet API (Jakarta EE).

Mô hình kiến trúc: MVC (Model - View - Controller).

Quản lý dự án & Build: Gradle.

🔹 Cơ sở dữ liệu & Tích hợp
Hệ quản trị CSDL: MySQL 8.0.

Kết nối DB: JDBC (Java Database Connectivity).

Thư viện bổ trợ: JSTL (JSP Standard Tag Library), Gson (Xử lý dữ liệu JSON cho API).

Thanh toán Trực tuyến: VNPay Sandbox API.

Dịch vụ vận chuyển: Giao Hàng Nhanh (GHN) API.

🔹 Frontend
Giao diện: HTML5, CSS3, JavaScript.

Framework CSS: Bootstrap 5.

🔹 Triển khai (DevOps)
Docker và Docker Compose (Quản lý cụm Container App và MySQL).

## 🏗️ Cấu trúc thư mục (Project Structure)
```
Webike/
├── src/main/
├── java/vn.edu.hcmuaf.fit.webike/
│   ├── controllers/ # Xử lý các HTTP Request (Servlet)
│   ├── dao/ # Data Access Object (Truy vấn DB)
│   ├── db/ # Cấu hình kết nối Database
│   ├── filters/ # Bộ lọc (Auth, Encoding, Security)
│   ├── GHN/ # Tích hợp API Giao Hàng Nhanh
│   ├── models/ # Các lớp đối tượng (POJO/Entities)
│   ├── services/ # Logic nghiệp vụ của hệ thống
│   ├── utils/ # Các hàm tiện ích (mã hóa, định dạng...)
│   └── vnpayConfig/ # Cấu hình thanh toán VNPay
├── resources/
│   └── db.properties # Thông số kết nối Database
└── webapp/ # Folder chứa giao diện
    ├── Admin/ # Giao diện admin
    ├── User/ # Giao diện người dùng
    ├── img/ # Kho lưu trữ hình ảnh dự án
    └── WEB-INF/ # Cấu hình hệ thống (web.xml)
```
