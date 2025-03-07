// const menuLi = document.querySelectorAll(
//     ".admin__sidebar--content ul > li > a"
//   );
//   const subMenu = document.querySelectorAll(".sub-menu");
//   menuLi.forEach((item, index) => {
//     item.onclick = function (e) {
//       e.preventDefault();
//       // menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
//       for (let i = 0; i < subMenu.length; i++) {
//         subMenu[i].setAttribute("style", `height: 0px`);
//       }
//       const subMenuHeight =
//         menuLi[index].parentNode.querySelector("ul .sub-menu-items").offsetHeight;
//       menuLi[index].parentNode
//         .querySelector("ul")
//         .setAttribute("style", `height: ${subMenuHeight}px`);
//     };
//   });

document.addEventListener("DOMContentLoaded", function () {
  const menuLi = document.querySelectorAll(".admin__sidebar--content ul > li > a");
  const subMenu = document.querySelectorAll(".sub-menu");

  menuLi.forEach((item, index) => {
    item.onclick = function (e) {
      e.preventDefault();
      toggleSubMenu(index);
    };
  });

  function toggleSubMenu(index) {
    for (let i = 0; i < subMenu.length; i++) {
      subMenu[i].style.height = "0px";
    }
    const subMenuHeight = menuLi[index].parentNode.querySelector("ul .sub-menu-items").offsetHeight;
    menuLi[index].parentNode.querySelector("ul").style.height = `${subMenuHeight}px`;
  }

  // Đóng menu khi nhấp ra ngoài
  document.addEventListener("click", function (e) {
    if (!e.target.closest(".admin__sidebar")) {
      closeAllSubMenus();
    }
  });

  function closeAllSubMenus() {
    subMenu.forEach(menu => {
      menu.style.height = "0px";
    });
  }
});
