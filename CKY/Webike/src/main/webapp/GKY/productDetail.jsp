<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Webike: Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
        integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/homepage.css">
    <link rel="stylesheet" href="./assets/css/Chi tiet san pham.css">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-6.5.1-web/css/all.min.css">
    <link rel="stylesheet" href="./assets/font/themify-icons/themify-icons.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="assets/js/Chi tiet san pham.js">
</head>
<body>
<!-- header -->
<header class="header">
    <div class="grid__full-width">
        <a href="homepage.jsp" class="logo">
            <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo.png?158926651620200827" alt="Webike VN">
        </a>
        <nav class="header__navbar">
            <div class="header__navbar--top">
                <ul class="header__navbar--top_left">
                    <li class="header__navbar--item">
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="product.jsp">Chợ xe máy</a>
                    </li>
                    <li class="header__navbar--item">
                        <a href="news.jsp">Tin tức</a>
                    </li>
                    <!-- <li class="header__navbar--item">
                        <a href="#">Đại lí</a>
                    </li> -->
                    <li class="header__navbar--item">
                        <a href="contact.jsp">Liên hệ</a>
                    </li>
                </ul>

                <ul class="header__navbar--top_right">
                    <li class="header__navbar--icon">
                        <a href="#">
                            <i class="fa-brands fa-facebook m-r-8"></i>
                        </a>
                    </li>
                    <li class="header__navbar--icon">
                        <a href="#">
                            <i class="fa-brands fa-youtube m-r-8"></i>
                        </a>
                    </li>

                    <!-- <li class="header__navbar--item header__navbar--separate">
                        <a href="#"><i class="fa-solid fa-user m-r-8" ></i>Đăng nhập</a>
                    </li>
                    <li class="header__navbar--item"><a href="#">Đăng ký</a></li> -->

                    <li class="header__navbar--item header__navbar--user">
                        <img src="./assets/img/avt1.jpg" alt="" class="header__navbar--user-img">
                        <span class="header__navbar--user-name">Trí Đức</span>

                        <ul class="header__navbar--user-menu">
                            <li class="header__navbar--user-menu-item">
                                <a href="trangTTKhachHang.jsp"><i class="fa-solid fa-user m-r-8"></i>Thông tin cá nhân</a>
                            </li>
                            <li class="header__navbar--user-menu-item">
                                <a href="#"><i class="fa-solid fa-shopping-cart m-r-8"></i>Lịch sử mua hàng</a>
                            </li>
                            <li class="header__navbar--user-menu-item">
                                <a href="Dangnhap.jsp"><i class="fa-solid fa-sign-out m-r-8"></i>Đăng xuất</a>
                            </li>
                        </ul>
                    </li>
                    
                </ul>
            </div>

            <div class="header__navbar--bot">
                <div class="header__search">
                    <input type="text" class="header__search--input" placeholder="Nhập từ khoá tìm kiếm">
                    <div class="header__search-select">
                        <span class="header__search-select-label">Tìm xe</span>
                        <i class="header__search-select-icon "></i>

                        <!-- <ul class="header__search-option">
                            <li class="header__search-option-item">
                                <span >Tìm phụ tùng</span>
                            </li>
                        </ul> -->
                    </div>
                    <button class="header__search--btn">
                        <i class="header__search--btn-icon fa-solid fa-search"></i>
                    </button>
                </div>

                <div class="header__cart">
                    <a href="Gio hang.jsp" class="header__cart-link" >
                        <i class="header__cart-icon ti-shopping-cart"></i>
                        <span class="header__cart--text">Giỏ Hàng</span>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</header>

    <div class="main">
        <!-- chua hinh anh va thong tin sp: gia, mau... -->
        <div class="info">  
            <div class="info__img">
                <div class="img__container">
                    <img src="assets/img/ducati red.png" alt="ducati red img" id="img">
                </div>
            </div>
            <div class="info__description">
                <div class="name padding--bottom--8">DUCATI Panigale V4</div>    
                <div class="description">
                    <div class="price padding--bottom--8">
                        <span class="infoHeader">Giá: </span>
                        <span class="text--description">640.500.000 vnd</span>
                    </div>

                    <div class="enigne padding--bottom--8">
                        <span class="infoHeader">Phiên bản: </span>
                        <span class="text--description">Cơ bản</span>
                    </div>

                    <div class="brand padding--bottom--8">
                        <div class="brand__text">
                            <span class="infoHeader">Nhà sản xuất: </span>
                            <span class="text--type text--description">Ducati</span>
                        </div>
                    </div>

                    <div class="phanKhoi padding--bottom--8">
                        <span class="infoHeader">Phân khối: </span>
                        <span class="text--description">1.103cc</span>
                    </div>

                    <div class="enigne padding--bottom--8">
                        <span class="infoHeader">Loại xe: </span>
                        <span class="text--description">Moto</span>
                    </div>
                    <div class="enigne padding--bottom--8">
                        <span class="infoHeader">Tình trạng: </span>
                        <span class="text--description">Xe mới</span>
                    </div>

                    <div class="color padding--bottom--8">
                        <span class="infoHeader">Màu sắc: </span>
                        <div class="btnCointainer">
                            <div class="redbtn cursor__pointer" id="red" onclick="changeBikeColor(this.id)">
                                <div class="colorbtn"></div>
                                <span class="color--text text--description">Đỏ</span>
                            </div>
                            <div class="blackbtn cursor__pointer" id="black" onclick="changeBikeColor(this.id)">
                                <div class="colorbtn"></div>
                                <span class="color--text text--description">Đen</span>
                            </div>
                        </div>

                    </div>
                    <div class="remain padding--bottom--8">
                        <span class="infoHeader">Số lượng còn lại: </span>
                        <span class="text--description">18</span>
                    </div>

                </div>    
                <div class="container--button">
                    <a href="Thanh toan.jsp"><button class="buy">Mua ngay</button></a>
                    <a href="#"><button class="addToCart">Thêm vào giỏ hàng</button></a>    
                </div>

            </div>

        </div>

        <!-- tinh nang noi bat -->
        <div class="features mt-5 mb-5">
            <h1 class="features--header mb-5">TÍNH NĂNG NỔI BẬT</h1>
            <div class="img-warp ">
                <p class="img-background">
                    <img src="assets/img/street background.jpg" alt="">
                    <span class="img-text">DUCATI Panigale V4</span>
                </p>
                <p class="img-bike">
                    <img src="assets/img/ducati red.png" alt="">
                </p>
           </div> 
           <p class="des mb-3">Ducati Panigale V4 là siêu mô tô hiệu suất cao với động cơ V4 1.103cc mạnh 
            <br> mẽ. Thiết kế đẹp mắt và công nghệ tiên tiến, xe mang đến trải nghiệm lái 
            <br> đầy phấn khích và linh hoạt. Hoàn hảo cho người đam mê tốc độ</p>
        </div>

        <ul class="features-item d-flex p-0 m-0 ">
            <li class="fItem shadow">
                <img class="img-bound" src="assets/img/dong co panigale.png" alt="">
                <div class="m-4 mt-3 p-2 mb-0 pb-0 mb-0 pb-0">
                    <h2 class="fs-2">Động cơ tiên tiến, hiệu suất mạnh mẽ</h2>
                    <p class="fs-4">Ducati Panigale V4 được trang bị động cơ V4 1.103 cc mạnh mẽ, đem đến công suất và mô-men xoắn ấn tượng.
                        <br> Động cơ được thiết kế với công nghệ tiên tiến như hệ thống van desmodromic, giúp tối ưu hóa hiệu suất và độ bền. 
                        <br> Động cơ này không chỉ cung cấp hiệu suất vượt trội mà còn mang lại trải nghiệm lái xe đầy phấn khích và mượt mà.
                    </p>
                </div>
                
            </li>
            <li class="fItem shadow ">
                <img class="img-bound" src="assets/img/tke khi dong hoc.png" alt="">
                <div class="m-4 mt-3 p-2 mb-0 pb-0">
                    <h2 class="fs-2">Thiết kế khí động học tinh tế, sắc sảo</h2>
                    <p class="fs-4">Thiết kế khí động học của Panigale V4 được tối ưu hóa để giảm sức cản gió, tăng cường sự ổn định và hiệu suất trên đường đua. 
                    <br> Các đường nét sắc sảo và tinh tế không chỉ tạo nên vẻ ngoài cuốn hút mà còn cải thiện tính năng vận hành của xe.</p>
                </div>
            </li>
            <li class="fItem shadow">
                <img class="img-bound" src="assets/img/he thong dien tu panigale.png" alt="">
                <div class="m-4 mt-3 p-2 mb-0 pb-0">
                    <h2 class="fs-2">Hệ thống điện tử tiên tiến, chính xác</h2>
                    <p class="fs-4">Panigale V4 sở hữu hệ thống điện tử tiên tiến với nhiều chế độ lái, kiểm soát lực kéo, và hệ thống phanh ABS.
                    <br> Những tính năng này đảm bảo sự an toàn và kiểm soát tối đa, giúp người lái dễ dàng tinh chỉnh xe phù hợp với mọi điều kiện vận hành.</p>
                </div>
            </li>
        </ul>

        <!-- thông số kỹ thuật của sản phẩm: phân khối, khung xe... -->
        <div class="detail container mt-5 d-flex flex-column justify-content-between align-items-center">
            <h1 class="detail--header">THÔNG SỐ KỸ THUẬT</h1>
            <div class="accordion">
                <!-- dong co -->
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOpen2">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#open1" aria-expanded="false" aria-controls="open1">
                            <span class="accordionItem__Header">động cơ</span>
                        </button>
                    </h2>
                    <div id="open1" class="accordion-collapse collapse collapse" aria-labelledby="headingOpen1">
                        <div class="accordion-body p-0">
                            <ul class="list-group item--container">
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">LOẠI</h4>
                                    <small class="lead text-muted item--detail">Blue Core, 4 thì, 2 van, SOHC, Làm mát bằng không khí cưỡng bức</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">BỐ TRÍ XY LANH</h4>
                                    <small class="lead text-muted item--detail">Xy lanh đơn</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">DUNG TÍCH XY LANH(CC)</h4>
                                    <small class="lead text-muted item--detail">124.9 cc</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Đường kính và hành trình piston</h4>
                                    <small class="lead text-muted item--detail">52,4 mm x 57,9 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Tỷ số nén</h4>
                                    <small class="lead text-muted item--detail">9,5 : 1</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Công suất tối đa</h4>
                                    <small class="lead text-muted item--detail">7,0 kW (9,5 ps)/8.000 vòng/phút</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Mô men xoắn cực đại</h4>
                                    <small class="lead text-muted item--detail">9.6 Nm (1.0 kgf-m)/5500 vòng/phút</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Hệ thống khởi động</h4>
                                    <small class="lead text-muted item--detail">Điện</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Hệ thống bôi trơn</h4>
                                    <small class="lead text-muted item--detail">Các te ướt</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Dung tích dầu máy</h4>
                                    <small class="lead text-muted item--detail">0,84 L</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Dung tích bình xăng</h4>
                                    <small class="lead text-muted item--detail">4,2 L</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Mức tiêu thụ nhiên liệu (l/100km)</h4>
                                    <small class="lead text-muted item--detail">1,87</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Hệ thống đánh lửa</h4>
                                    <small class="lead text-muted item--detail">T.C.I (kỹ thuật số)</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Tỷ số truyền động</h4>
                                    <small class="lead text-muted item--detail">2,294 - 0,804 : 1</small>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- khung xe -->
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOpen2">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#open2" aria-expanded="true" aria-controls="open2">
                            <span class="accordionItem__Header">khung xe</span>
                        </button>
                    </h2>
                    <div id="open2" class="accordion-collapse collapse collapse" aria-labelledby="headingOpen2">
                        <div class="accordion-body p-0">
                            <ul class="list-group item--container">
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">loại khung</h4>
                                    <small class="lead text-muted item--detail">Underbone</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">hệ thống giảm xóc trước</h4>
                                    <small class="lead text-muted item--detail">Phuộc ống lồng</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Độ lệch phương trục lái</h4>
                                    <small class="lead text-muted item--detail">26°30 / 100 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Hệ thống giảm xóc sau</h4>
                                    <small class="lead text-muted item--detail">Giảm chấn lò xo dầu</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Phanh trước</h4>
                                    <small class="lead text-muted item--detail">Phanh đĩa đơn thủy lực</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Phanh sau</h4>
                                    <small class="lead text-muted item--detail">Phanh tang trống</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Lốp trước</h4>
                                    <small class="lead text-muted item--detail">80/80-14M/C 43P</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Lốp sau</h4>
                                    <small class="lead text-muted item--detail">110/70-14M/C 56P</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Đèn trước</h4>
                                    <small class="lead text-muted item--detail">Halogen 12V 35W / 35W x 1</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Đèn sau</h4>
                                    <small class="lead text-muted item--detail">LED</small>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- kích thước -->
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOpen3">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#open3" aria-expanded="true" aria-controls="open3">
                            <span class="accordionItem__Header">kích thước</span>
                        </button>
                    </h2>
                    <div id="open3" class="accordion-collapse collapse collapse" aria-labelledby="headingOpen3">
                        <div class="accordion-body p-0">
                            <ul class="list-group item--container">
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Kích thước (dài x rộng x cao)</h4>
                                    <small class="lead text-muted item--detail">1850 mm x 705 mm x 1120 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Độ cao yên xe</h4>
                                    <small class="lead text-muted item--detail">769 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Độ cao gầm xe</h4>
                                    <small class="lead text-muted item--detail">135 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Khoảng cách giữa 2 trục bánh xe</h4>
                                    <small class="lead text-muted item--detail">1260 mm</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Trọng lượng ướt</h4>
                                    <small class="lead text-muted item--detail">99 kg</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Dung tích bình xăng</h4>
                                    <small class="lead text-muted item--detail">4,2 L</small>
                                </li>
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">Ngăn chứa đồ</h4>
                                    <small class="lead text-muted item--detail">14.2</small>
                                </li>            
                            </ul>
                        </div>
                    </div>
                </div>
                <!--bao hanh-->
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOpen4">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#open4" aria-expanded="true" aria-controls="open4">
                            <span class="accordionItem__Header">chính sách bảo hành</span>
                        </button>
                    </h2>
                    <div id="open4" class="accordion-collapse collapse collapse" aria-labelledby="headingOpen4">
                        <div class="accordion-body p-0">
                            <ul class="list-group item--container">
                                <li class="list-group-item d-flex">
                                    <h4 class="item--header">thời gian bảo hành</h4>
                                    <small class="lead text-muted item--detail">3 năm/ 30.000 km (Tùy điều kiện nào đến trước)</small>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

       
        <div class="container d-flex flex-column justify-content-between align-items-center" style="width: 90%;">
            <h1 class="">CÓ THỂ BẠN QUAN TÂM</h1>
            <div class="container--card row">
                <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/future blue.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">honda future</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">85.050.000 vnd</span>
                    </div>
                </a>
                <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/honda harley.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">honda harley</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">374.000.000 vnd</span>
                    </div>
                </a>
                <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/kawasaki black harley.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">kawasaki sora</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">1.069.000.000 vnd</span>
                    </div>
                </a>
                <a href="#" class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/kawasaki green 1.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">kawasaki ninjas</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">3.111.000.000 vnd</span>
                    </div>
                </a>
            </div>
            <!-- <div class="container--card row">
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/sym electric red.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">xe diện sym</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">87.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/vinfast felis z.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">vinfast felis z</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">237.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/wave alpha black.png" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">honda wave alpha</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">89.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/yamaha freego black.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">yamaha freego</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">301.000.000 vnd</span>
                    </div>
                </div>
            </div>
            <div class="container--card row">
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/yamaha lexi black.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">yamaha lexi</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">520.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/yamaha motor blue.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">yamaha climber</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">2.066.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/yamaha motor purple.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">yamaha climber</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">120.000.000 vnd</span>
                    </div>
                </div>
                <div class="card col m-3 bg-light cursor__pointer shadow" style="width: 300px; padding: 0px;">
                    <img src="assets/img/yamaha nvx.webp" class="card-img-top img__modi" alt="???">
                    <div class="card--body">
                        <h3 class="card-title">
                            <span class="uppercase padding__5px__8px text__white">yamaha nvx</span>
                        </h3>
                        <span class="card-text padding__5px__8px text__white">83.000.000 vnd</span>
                    </div>
                </div>
            </div> -->
          </div>
           
        
    </div>
    <script src="assets/js/Chi tiet san pham.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    <!-- footer -->
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
                      <img class="footer__banking" src="./assets/img/bankcard1.png" alt="">
                      <img class="footer__banking" src="./assets/img/bankcard2.png" alt="">
                      <img class="footer__banking" src="./assets/img/bankcard3.png" alt="">
                      <img class="footer__banking" src="./assets/img/bankcard4.png" alt="">
                      <img class="footer__banking" src="./assets/img/bankcard5.png" alt="">
                      <img class="footer__banking" src="./assets/img/bankcard6.png" alt="">
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

</body>
</html>