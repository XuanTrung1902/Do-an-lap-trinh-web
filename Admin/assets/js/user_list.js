const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// 
const menuLi = $$('.admin__sidebar--content ul > li > a');
const subMenu = $$('.sub-menu');
menuLi.forEach((item, index) => {
    item.onclick = function(e) {
        e.preventDefault();
        // menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
        for (let i = 0; i < subMenu.length; i++) {
            subMenu[i].setAttribute('style',`height: 0px`);
        }
        const subMenuHeight = menuLi[index].parentNode.querySelector('ul .sub-menu-items').offsetHeight;
        menuLi[index].parentNode.querySelector('ul').setAttribute('style',`height: ${subMenuHeight}px`);
    }
});


