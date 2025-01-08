<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
    integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="assets/css/homepage.css">
    <link rel="stylesheet" href="assets/css/Payment.css">
    <link rel="stylesheet" href="assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
    <title>Webike: Thanh toán</title>
</head>
<body>
    <!-- chua toan bo noi dung trang -->
    <div class="main"> 
        <div class="header d-flex align-items-center">
            <img class="logo-img" src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
            <div class="separator"></div>
            <h1 class="header__text">thanh toán</h1>
        </div>

        <div class="head__line"></div>   
        <nav class="breadcrumb--container" aria-label="breadcrumb" style="--bs-breadcrumb-divider: ''; background-color: rgb(234, 234, 234);">
            <ol class="breadcrumb mb-0">
                <li class="breadcrumb-item pe-4"><a href="#" class="noTextDecoration"><h2>Giỏ hàng </h2></a></li>
                <li class="breadcrumb-item pe-4"><a href="#" class="noTextDecoration"><h2>  Thông tin đặt hàng </h2></a></li>
                <li class="breadcrumb-item pe-4 active" aria-current="page"><h2 class="d-inline"> Xác nhận thông tin</h2></li>


            </ol>
        </nav>
        <div class="info-container d-flex justify-content-center">
                <div class="left-container shadow">
                    <div class="noti d-flex align-items-center gap-3 mt-3 ps-5">
                        <i class="fa-solid fa-circle-check"></i>
                        <span class="noti--header">Đặt hàng thành công</span>
                    </div>
                    <div class="d-flex m-3 mb-5 ms-0 ps-5">
                        <div class="title-code pe-4">Mã đơn hàng: </div>
                        <div class="code">#SP0371</div>
                    </div>
                    <div class="cus-info ms-5 me-5 p-5">
                        <div class="d-flex align-items-center"> 
                            <div class="title">Họ tên: </div>
                            <div class="content">Nguyễn Văn Tèo</div>
                        </div>
                        <div class="d-flex  align-items-center"> 
                            <div class="title">Email: </div>
                            <div class="content">teo@gmail.com</div>
                        </div>
                        <div class="d-flex  align-items-center"> 
                            <div class="title">SDT liên hệ:</div>
                            <div class="content">0123456789</div>
                        </div>
                        <div class="d-flex  align-items-center"> 
                            <div class="title">Địa chỉ: </div>
                            <div class="content">128 Trần Hưng Đạo, phường 3, quận 1, TP.HCM</div>
                        </div>
                        <div class="d-flex  align-items-center"> 
                            <div class="title">Phương thức thanh toán: </div>
                            <div class="content">Chuyển khoản toàn bộ</div>
                        </div>
                        <div class="d-flex  align-items-center"> 
                            <div class="title">Trạng thái đơn hàng: </div>
                            <div class="content">Đã thanh toán</div>
                        </div>
                    </div>

                    <a href="homepage.jsp">
                        <button class="button shadow p-5 pt-0 pb-0 me-5">
                            <h3 class="m-0 p-4" style="color: white;">Tiếp tục</h3>
                        </button>
                    </a>
                </div>
    
                <div class="right-container shadow">
                    <div class="product d-flex flex-column">
                        <div class="product--header pt-4 pb-4">
                            <div class="product--name">
                                <h3 class="display-6">DUCATI Panigale V4</h3>
                                <div class="">
                                    <h3 class="pColor d-inline">Màu: </h3>
                                    <h3 class="pColor d-inline">Đỏ</h3>
                                </div>
                            </div>
                            <div class="product--price">
                                <h3 class="" style="font-size: 2.5rem;">640.500.000 vnd</h3>
                            </div>
                        </div>
                        <div class="product--shipping d-flex flex-column pt-4 pb-4">
                            <div class="" id="shipping">
                                <h3 class="float-left">Phí vận chuyển</h3>
                                <h3 class="float-right">340.000 vnd</h3>
                            </div>
                            <div class="" id="deposit" style="display: none;">
                                <h3 class="float-left">Phí đặt cọc</h3>
                                <h3 class="float-right">5.000.000 vnd</i></h3>
                            </div>
                        </div>
                        <div class="product--total pt-4 pb-4">
                            <h3 class="float-left">Tổng cộng</h3>
                            <h3 class="float-right">640.500.000 vnd</h3>
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
                      <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Bản quyền</a></li> -->
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Liên hệ</a></li>
                    </ul>
                  </div>
            
                  <div class="col-6 col-md-2 mb-3">
                    <h5>Tin tức xe máy</h5>
                    <ul class="nav flex-column">
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Trang chủ</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Tin tức - sự kiện</a></li>
                      <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Thông tin xe máy</a></li>
                      <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Kinh nghiệm</a></li> -->
                      <!-- <li class="nav-item mb-2"><a href="#" class="nav-link p-0">Video giải trí</a></li> -->
                    </ul>
                  </div>
            
                  <div class="col-md-5 offset-md-1 mb-3">
                    <form>
                      <h5>Phương thức thanh toán</h5>
                      <!-- <p>Monthly digest of what's new and exciting from us.</p> -->
                      <div class="d-flex flex-column flex-sm-row w-100 gap-2">
                          <img class="footer__banking" src="assets/img/bankcard1.png" alt="">
                          <img class="footer__banking" src="assets/img/bankcard2.png" alt="">
                          <img class="footer__banking" src="assets/img/bankcard3.png" alt="">
                          <img class="footer__banking" src="assets/img/bankcard4.png" alt="">
                          <img class="footer__banking" src="assets/img/bankcard5.png" alt="">
                          <img class="footer__banking" src="assets/img/bankcard6.png" alt="">
                      </div>
                      <div class="footer__rectangle">
                          <img src="assets/img/Rectangle.png" alt="">
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

    
    <script src="assets/js/Thanh toan.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>