
const menuLi = document.querySelectorAll(".admin__sidebar--content ul > li > a");
const subMenu = document.querySelectorAll(".sub-menu");

menuLi.forEach((item, index) => {
  item.onclick = function (e) {
    e.preventDefault();
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

window.onclick = function (event) {
  const modal = document.getElementById("assignPermissionModal");
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

function closeModal(id) {
  document.getElementById(id).style.display = "none";
}

function openAssignPermissionModal(userId) {
  console.log("Mở modal phân quyền cho userId =", userId);
  document.getElementById("assignUserId").value = userId;

  document
      .querySelectorAll("#assignPermissionModal input[type='checkbox']")
      .forEach((cb) => (cb.checked = false));

  fetch(`getUserPermissions?userId=${userId}`)
      .then((res) => res.json())
      .then((data) => {
        console.log("Quyền đang có:", data);
        data.forEach((item) => {
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

  const checkboxes = document.querySelectorAll(
      "#assignPermissionModal input[type='checkbox']:checked"
  );

  if (checkboxes.length === 0) {
    alert("Vui lòng chọn ít nhất một quyền.");
    return;
  }

  const formData = new FormData();
  formData.append("userId", userId);

  checkboxes.forEach((cb) => {
    formData.append("permissions", cb.value);
  });

  fetch("assignPermission", {
    method: "POST",
    body: formData,
  })
      .then((res) => {
        if (!res.ok) throw new Error("Lỗi từ server");
        return res.json();
      })
      .then((data) => {
        console.log("Phân quyền thành công:", data);
        document.getElementById("assignPermissionModal").style.display = "none";
      })
      .catch((err) => {
        console.error("Lỗi khi lưu phân quyền:", err);
        alert("Có lỗi xảy ra khi lưu phân quyền.");
      });
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
              <a href="#" class="delete-button">Xóa</a>`;
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
