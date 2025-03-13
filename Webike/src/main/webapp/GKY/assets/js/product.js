
// slider for product
const products = document.querySelectorAll(".box__bike--item");
let counter = 0;

function sliderToLeft() {
  if (counter == 0) {
    counter = products.length / 3 - 1;
  } else {
    counter--;
  }
  scroll();
}

function sliderToRight() {
  if (counter == products.length / 3 - 1) {
    counter = 0;
  } else {
    counter++;
  }
  scroll();
}

function scroll() {
  products.forEach(function (item) {
    item.style.transform = `translateX(-${counter * 100}%)`;
  });
}

// pagination for product
const paginationLink = document.getElementsByClassName("pagination__link");
let currentPage = 1;

function backBtn() {
  if (currentPage == 1) {
    currentPage = paginationLink.length;
  } else {
    currentPage--;
  }
  paginationLink[currentPage - 1].click();
}

function nextBtn() {
  if (currentPage == paginationLink.length) {
    currentPage = 1;
  } else {
    currentPage++;
  }
  paginationLink[currentPage - 1].click();
}


//// pagination for product///
// Phân trang sản phẩm
let productItems = document.querySelectorAll(".list-bike .grid__column-2");
const itemsPerPage = 10; // Số sản phẩm mỗi trang
let currentProductPage = 1; // Trang hiện tại

// Hàm hiển thị sản phẩm theo trang
function renderProductItems() {
  productItems.forEach((product, index) => {
    if (
        index >= (currentProductPage - 1) * itemsPerPage &&
        index < currentProductPage * itemsPerPage
    ) {
      product.style.display = "block";
    } else {
      product.style.display = "none";
    }
  });
}

// Hàm render phân trang
function renderProductPagination() {
  const paginationContainer = document.querySelector(".pagination ul");
  paginationContainer.innerHTML = ""; // Xóa các liên kết phân trang cũ
  const totalPages = Math.ceil(productItems.length / itemsPerPage);

  for (let i = 1; i <= totalPages; i++) {
    const li = document.createElement("li");
    li.classList.add("pagination__link");
    if (i === currentProductPage) {
      li.classList.add("pagination__link--active");
    }
    li.textContent = i;
    li.addEventListener("click", () => {
      currentProductPage = i;
      renderProductItems();
      renderProductPagination();
    });
    paginationContainer.appendChild(li);
  }
}

// Hàm xử lý nút trái (trước)
function handleLeftButtonClick() {
  if (currentProductPage > 1) {
    currentProductPage--;
    renderProductItems();
    renderProductPagination();
  }
}

// Hàm xử lý nút phải (tiếp)
function handleRightButtonClick() {
  const totalPages = Math.ceil(productItems.length / itemsPerPage);
  if (currentProductPage < totalPages) {
    currentProductPage++;
    renderProductItems();
    renderProductPagination();
  }
}

// Khởi tạo phân trang ngay khi trang được tải
document.addEventListener("DOMContentLoaded", () => {
  // Đảm bảo rằng productItems được cập nhật sau khi JSTL render
  productItems = document.querySelectorAll(".list-bike .grid__column-2");

  // Render sản phẩm và phân trang ngay từ đầu
  renderProductItems();
  renderProductPagination();

  // Gán sự kiện cho các nút điều hướng
  const leftButton = document.querySelector(".btn--left");
  const rightButton = document.querySelector(".btn--right");

  leftButton.addEventListener("click", handleLeftButtonClick);
  rightButton.addEventListener("click", handleRightButtonClick);
});


////////////////////////////
// filter: product  //////
///////////////////////////
function filterImages() {
  const checkboxes = document.querySelectorAll(
    '#checkboxes input[type="checkbox"]'
  );
  const checkboxes1 = document.querySelectorAll(
    '#checkboxes1 input[type="checkbox"]'
  );
  const images = document.querySelectorAll(".list-bike .grid__column-2");
  const detailList = document.querySelector(".motor__detail-list");

  const selectedAttributes = Array.from(checkboxes)
    .filter((checkbox) => checkbox.checked)
    .map((checkbox) => checkbox.value);

  const selectedAttributes1 = Array.from(checkboxes1)
    .filter((checkbox) => checkbox.checked)
    .map((checkbox) => checkbox.value);

  let visibleImages = [];

  if (selectedAttributes.length === 0 && selectedAttributes1.length === 0) {
    visibleImages = Array.from(images);
  }
  else {
    images.forEach((image) => {
      const imageAttributes = image
        .getAttribute("data-attributes")
      //   .split(", ")
      //   .map((attr) => attr.trim());
      const matchesGroup1 =
        selectedAttributes.length === 0
          || selectedAttributes.some((attr) => imageAttributes.includes(attr));
      const matchesGroup2 =
        selectedAttributes1.length === 0
          || selectedAttributes1.some((attr) => imageAttributes.includes(attr));

      if (matchesGroup1 && matchesGroup2) {
        visibleImages.push(image);
      }
    });
  }

  const totalPages = Math.ceil(visibleImages.length / itemsPerPage);
  currentPage = Math.min(currentPage, totalPages);

  let start = (currentPage - 1) * itemsPerPage;
  let end = start + itemsPerPage;

  images.forEach((image) => {
    image.style.display = "none";
  });

  visibleImages.slice(start, end).forEach((image) => {
    image.style.display = "block";
  });

  renderPagination(totalPages);
  detailList.style.backgroundColor = "#f6f6f6";
  detailList.style.marginBottom = "40px";
}


///////////////////////////
// render product after filter
///////////////////////////
function renderPagination(totalPages) {
  const paginationContainer = document.querySelector(".pagination");
  paginationContainer.innerHTML = "";

  for (let i = 1; i <= totalPages; i++) {
    const li = document.createElement("li");
    li.classList.add("pagination__link");
    if (i === currentPage) {
      li.classList.add("pagination__link--active");
    }
    li.textContent = i;
    li.addEventListener("click", () => {
      currentPage = i;
      filterImages();
    });
    paginationContainer.appendChild(li);
  }
}

document.addEventListener("DOMContentLoaded", () => {
  filterImages();
});


