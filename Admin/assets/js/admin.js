const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

// 
const menuLi = $$('.admin__sidebar--content ul > li > a');
console.log(menuLi);
menuLi.forEach((item, index) => {
    item.onclick = function(e) {
        e.preventDefault();
        menuLi[index].parentNode.querySelector('ul').classList.toggle('active');
        // console.log(menuLi[index].parentNode.querySelector('ul'));
    }
});
