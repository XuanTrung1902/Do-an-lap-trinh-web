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
document.getElementById('add-user-form').addEventListener('submit', function(e) {
  e.preventDefault();
  const form = e.target;
  const formData = new FormData(form);

  fetch(form.action, {
    method: 'POST',
    body: formData,
    headers: {
      'X-Requested-With': 'XMLHttpRequest'
    }
  })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          const user = data.user;

          // ✅ Chèn hàng mới vào bảng
          dataTable.row.add([
            user.id,
            user.name,
            user.DOB,
            user.sex,
            user.address,
            user.phoneNum,
            user.role,
            user.locked,
            `<img src="${user.image}" style="width: 50px; height: 50px; border-radius: 50%;">`,
            `<a href="${data.contextPath}/updateUser?id=${user.id}" class="btn-edit">Sửa</a>
                 <form action="${data.contextPath}/deleteUser" method="post" style="display:inline;">
                     <input type="hidden" name="id" value="${user.id}">
                     <button type="submit" class="delete-button" onclick="return confirm('Bạn có chắc chắn muốn xóa người dùng ${user.name}?');">Xóa</button>
                 </form>`
          ]).draw(false);

          document.getElementById('modal').style.display = 'none';
          form.reset();
        } else {
          alert(data.message || 'Thêm người dùng thất bại');
        }
      })
      .catch(error => {
        console.error('Lỗi:', error);
      });
});
