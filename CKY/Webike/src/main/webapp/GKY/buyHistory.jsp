<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/homepage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/css/buyHistory.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/GKY/assets/bootstrap/css/bootstrap.css">
    <title>Webike: lịch sử mua hàng</title>
</head>
<body>
    <!-- chua toan bo noi dung trang -->
    <div class="main"> 
        <div class="header d-flex align-items-center">
            <a href="homepage.html">
                <img class="logo-img" src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
            </a>
            <div class="separator"></div>
            <h1 class="header__text">Lịch sử mua hàng</h1>
        </div>

        <div class="head__line"></div>   
        
        <div class="order-container container">
            <div class="order-item">
                <img src="GKY/assets/img/xe1.png" alt="Product Image" class="product-image">
                <div class="product-details">
                    <div class="product-name">SH MODE 165i</div>
                    <div class="product-meta">Phân loại hàng: MÀU TRẮNG x 1</div>
                    <div class="product-status">ĐÃ ĐÁNH GIÁ</div>
                    <div class="product-price">Tổng số tiền: ₫182.400</div>
                    <div class="product-actions">
                        <button class="buy-again"><a href="#">Mua Lần Nữa</a></button>
                        <button class="view-details"><a href="#">Xem Chi Tiết Đơn Hàng</a></button>
                        <button class="view-details"><a href="#">Đánh Giá</a></button>
                    </div>
                </div>
            </div>
    
            <div class="order-item">
                <img src="GKY/assets/img/xe2.jpg" alt="Product Image" class="product-image">
                <div class="product-details">
                    <div class="product-name">Winner X 2023</div>
                    <div class="product-meta">Phân loại hàng: x 1</div>
                    <div class="product-status">ĐÃ ĐÁNH GIÁ</div>
                    <div class="product-price">Tổng số tiền: ₫732.400</div>
                    <div class="product-actions">
                        <button class="buy-again"><a href="#">Mua Lần Nữa</a></button>
                        <button class="view-details"><a href="#">Xem Chi Tiết Đơn Hàng</a></button>
                        <button class="view-details"><a href="#">Đánh Giá</a></button>
                    </div>
                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container">
              <footer class="py-5">
                <div class="row">
                  <div class="col-6 col-md-2 mb-3">
                    <h5>Chợ xe máy</h5>
                    <ul class="nav flex-column">
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Phân khối lớn</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hãng xe</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Loại xe</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thịnh hành</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Cửa hàng</a></li>
                    </ul>
                  </div>
            
                  <div class="col-6 col-md-2 mb-3">
                    <h5>Thông tin khác</h5>
                    <ul class="nav flex-column">
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Quy chế hoạt động</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Chính sách bảo mật</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Hỗ trợ khách hàng</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Liên hệ</a></li>
                    </ul>
                  </div>
            
                  <div class="col-6 col-md-2 mb-3">
                    <h5>Tin tức xe máy</h5>
                    <ul class="nav flex-column">
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Trang chủ</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Tin tức - sự kiện</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thông tin xe máy</a></li>

                    </ul>
                  </div>
            
                  <div class="col-md-5 offset-md-1 mb-3">
                    <form>
                      <h5>Phương thức thanh toán</h5>
                      <div class="d-flex flex-column flex-sm-row w-100 gap-2">
                          <img class="footer__banking" src="GKY/assets/img/bankcard1.png" alt="">
                          <img class="footer__banking" src="GKY/assets/img/bankcard2.png" alt="">
                          <img class="footer__banking" src="GKY/assets/img/bankcard3.png" alt="">
                          <img class="footer__banking" src="GKY/assets/img/bankcard4.png" alt="">
                          <img class="footer__banking" src="GKY/assets/img/bankcard5.png" alt="">
                          <img class="footer__banking" src="GKY/assets/img/bankcard6.png" alt="">
                      </div>
                      <div class="footer__rectangle">
                          <img src="./assets/img/Rectangle.png" alt="">
                      </div>
                    </form>
                  </div>
                </div>
            
                <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
                  <p>&copy; 2024 Company, Inc. All rights reserved.</p>
                  <ul class="list-unstyled d-flex">
                    <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
                    <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
                    <li class="ms-3"><a class="link-body-emphasis" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
                  </ul>
                </div>
              </footer>
            </div>
      </footer>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>