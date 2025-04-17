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
      {data: "id"},
      {data: "name"},
      {data: "password"},
      {data: "birthday"},
      {data: "address"},
      {data: "phone"},
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

function closeModal(id) {
  document.getElementById(id).style.display = "none";
}

window.onclick = function (event) {
  const modal = document.getElementById("assignPermissionModal");
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

document.getElementById('add-user-form').addEventListener('submit', function (e) {

  function openAssignPermissionModal(userId) {
  document.getElementById("assignUserId").value = userId;
  document.getElementById("assignPermissionModal").style.display = "block";
}

  function closeModal(id) {
  document.getElementById(id).style.display = "none";
}

  window.onclick = function(event) {
  const modal = document.getElementById("assignPermissionModal");
  if (event.target == modal) {
  modal.style.display = "none";
}
}

document.getElementById('add-user-form').addEventListener('submit', function (e) {
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

function openAssignPermissionModal(userId) {
  console.log("Mở modal phân quyền cho userId =", userId); // ✅ Thêm dòng này

  document.getElementById("assignUserId").value = userId;

  // Reset checkbox
  document.querySelectorAll("#assignPermissionModal input[type='checkbox']").forEach(cb => cb.checked = false);
  // Gọi API lấy quyền
  fetch(`getUserPermissions?userId=${userId}`)
      .then(res => res.json())
      .then(data => {
        console.log("Quyền đang có:", data);
        data.forEach(item => {
          const value = `${item.resourceId}-${item.permissionId}`;
          const checkbox = document.querySelector(`input[type='checkbox'][value='${value}']`);
          if (checkbox) checkbox.checked = true;
        });
      });

  document.getElementById("assignPermissionModal").style.display = "block";
}

document.getElementById("submitAssignPermission").addEventListener("click", function () {
  console.log("Đã vào");

  const userId = document.getElementById("assignUserId").value;
  console.log("userId gửi đi:", userId);

  const checkboxes = document.querySelectorAll("#assignPermissionModal input[type='checkbox']:checked");

  if (checkboxes.length === 0) {
    alert("Vui lòng chọn ít nhất một quyền.");
    return;
  }

  const formData = new FormData();
  formData.append("userId", userId); // 🔥 Thêm dòng này nếu thiếu

  checkboxes.forEach(cb => {
    formData.append("permissions", cb.value);
  });

  fetch("assignPermission", {
    method: "POST",
    body: formData
  })
      .then(res => {
        if (!res.ok) throw new Error("Lỗi từ server");
        return res.json();
      })
      .then(data => {
        console.log("Phân quyền thành công:", data);
        document.getElementById("assignPermissionModal").style.display = "none";
      })
      .catch(err => {
        console.error("Lỗi khi lưu phân quyền:", err);
        alert("Có lỗi xảy ra khi lưu phân quyền.");
      });
});
