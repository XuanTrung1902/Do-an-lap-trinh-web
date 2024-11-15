const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// slider for product
const products = $$(".box__bike--item");
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

// filter for product
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

  let visibleCount = 0;

  if (selectedAttributes.length === 0 && selectedAttributes1.length === 0) {
    images.forEach((image) => {
      image.style.display = "block";
    });
    visibleCount = images.length;
  } else {
    images.forEach((image) => {
      const imageAttributes = image
        .getAttribute("data-attributes")
        .split(", ")
        .map((attr) => attr.trim());
      const matchesGroup1 =
        selectedAttributes.length === 0 ||
        selectedAttributes.some((attr) => imageAttributes.includes(attr));
      const matchesGroup2 =
        selectedAttributes1.length === 0 ||
        selectedAttributes1.some((attr) => imageAttributes.includes(attr));

      if (matchesGroup1 && matchesGroup2) {
        image.style.display = "block";
        visibleCount++;
      } else {
        image.style.display = "none";
      }
    });
  }
  const itemHeight = 430;
  const rows = Math.ceil(visibleCount / 5);
  detailList.style.height = `${rows * itemHeight}px`;
  detailList.style.backgroundColor = "#f6f6f6";
  detailList.style.marginBottom = "40px";
}

// pagination for product
const productItems = $$(".list-bike .grid__column-2");
const itemsPerPage = 10;
let currentProductPage = 1;

function renderProductItems() {
  productItems.forEach((product, index) => {
    if (index >= (currentProductPage - 1) * itemsPerPage && index < currentProductPage * itemsPerPage) {
      product.style.display = "block";
    } else {
      product.style.display = "none";
    }
  });
}

function renderProductPagination() {
  const paginationContainer = $(".pagination");
  paginationContainer.innerHTML = "";
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

function handleLeftButtonClick() {
  if (currentProductPage > 1) {
    currentProductPage--;
    renderProductItems();
    renderProductPagination();
  }
}

function handleRightButtonClick() {
  const totalPages = Math.ceil(productItems.length / itemsPerPage);
  if (currentProductPage < totalPages) {
    currentProductPage++;
    renderProductItems();
    renderProductPagination();
  }
}

document.addEventListener("DOMContentLoaded", () => {
  renderProductItems();
  renderProductPagination();

  const leftButton = document.querySelector(".btn--left");
  const rightButton = document.querySelector(".btn--right");
//   console.log(leftButton, rightButton);

    leftButton.addEventListener("click", handleLeftButtonClick);
    rightButton.addEventListener("click", handleRightButtonClick);
});