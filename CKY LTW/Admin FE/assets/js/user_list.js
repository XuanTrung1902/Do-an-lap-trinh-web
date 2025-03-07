const menuLi = document.querySelectorAll(
  ".admin__sidebar--content ul > li > a"
);
const subMenu = document.querySelectorAll(".sub-menu");
menuLi.forEach((item, index) => {
  item.onclick = function (e) {
    e.preventDefault();
    // menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
    for (let i = 0; i < subMenu.length; i++) {
      subMenu[i].setAttribute("style", `height: 0px`);
    }
    const subMenuHeight =
      menuLi[index].parentNode.querySelector("ul .sub-menu-items").offsetHeight;
    menuLi[index].parentNode
      .querySelector("ul")
      .setAttribute("style", `height: ${subMenuHeight}px`);
  };
});

var table;
function initTableData() {
  // var data = [
  //   {
  //     id: 1,
  //     name: "LeTriDuc",
  //     password: "123456",
  //     birthday: "11/6/2004",
  //     address: "Đồng Nai",
  //     phone: "0123456789",
  //   },
  //   {
  //     id: 2,
  //     name: "TongXuanTrung",
  //     password: "147258",
  //     birthday: "11/6/2004",
  //     address: "Đà Nẵng",
  //     phone: "0123456789",
  //   },
  //   {
  //     id: 3,
  //     name: "NguyenQuocTan",
  //     password: "258369",
  //     birthday: "11/6/2004",
  //     address: "Hà Nội",
  //     phone: "0123456789",
  //   },
  //   {
  //     id: 4,
  //     name: "TranNhutAnh",
  //     password: "145678",
  //     birthday: "11/6/2004",
  //     address: "Long An",
  //     phone: "0123456789",
  //   },
  //   {
  //     id: 5,
  //     name: "DoDucDuong",
  //     password: "145789",
  //     birthday: "11/6/2004",
  //     address: "Đồng Tháp",
  //     phone: "0123456789",
  //   },
  // ];
  // var jsonData = JSON.stringify(data);
  // console.log(jsonData);
  table = $("#list-user").DataTable({
    processing: true,
    data,
    columns: [
      { data: "id" },
      { data: "name" },
      { data: "password" },
      { data: "birthday" },
      { data: "address" },
      { data: "phone" },
      {
        data: null,
        render: function (data, type, row) {
          return `
                                <a href="#" class="btn-edit">Sửa</a>
                                <a href="#" class="delete-button">Xóa</a>
                            `;
        },
      },
    ],
    paging: true,
    searching: true,
    info: true,
    lengthChange: true,
    pageLength: 5,
    dom: '<"top"f>rt<"bottom"ip><"clear">',
    language: {
      search: "Tìm kiếm:",
      paginate: {
        first: "Đầu",
        last: "Cuối",
        next: "Sau",
        previous: "Trước",
      },
      info: "Hiển thị _START_ đến _END_ của _TOTAL_ mục",
      infoEmpty: "Không có dữ liệu",
      infoFiltered: "(lọc từ _MAX_ mục)",
      zeroRecords: "Không tìm thấy kết quả",
    },
  });
}

// Search logic
// document.getElementById('searchInput').addEventListener('keyup', function() {
//     var searchValue = this.value.toLowerCase();
//     var filterType = document.getElementById('filterType').value;
//     var tableRows = document.querySelectorAll('.admin-content-main-container table tbody tr');

//     tableRows.forEach(function(row) {
//         var cells = row.getElementsByTagName('td');
//         var match = false;

//         switch (filterType) {
//             case 'name':
//                 if (cells[1].innerText.toLowerCase().includes(searchValue)) {
//                     match = true;
//                 }
//                 break;
//             case 'address':
//                 if (cells[4].innerText.toLowerCase().includes(searchValue)) {
//                     match = true;
//                 }
//                 break;
//             case 'phone':
//                 if (cells[5].innerText.toLowerCase().includes(searchValue)) {
//                     match = true;
//                 }
//                 break;
//         }

//         if (match) {
//             row.style.display = '';
//         } else {
//             row.style.display = 'none';
//         }
//     });
// });


// MODAL JS
document.querySelector('.btn-add__user').addEventListener('click', function() {
  document.getElementById('modal').style.display = 'block';
});

document.querySelector('.close-button').addEventListener('click', function() {
  document.getElementById('modal').style.display = 'none';
});

document.getElementById('add-user-form').addEventListener('submit', function(e) {
  e.preventDefault();
  // Add user logic here
  document.getElementById('modal').style.display = 'none';
});

window.addEventListener('click', function(event) {
  const modal = document.getElementById('modal');
  if (event.target === modal) {
      modal.style.display = 'none';
  }
});