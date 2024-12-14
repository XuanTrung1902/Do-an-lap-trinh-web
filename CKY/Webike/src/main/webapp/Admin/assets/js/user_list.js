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



// Search logic
document.getElementById('searchInput').addEventListener('keyup', function() {
    var searchValue = this.value.toLowerCase();
    var filterType = document.getElementById('filterType').value;
    var tableRows = document.querySelectorAll('.admin-content-main-container table tbody tr');

    tableRows.forEach(function(row) {
        var cells = row.getElementsByTagName('td');
        var match = false;

        switch (filterType) {
            case 'name':
                if (cells[1].innerText.toLowerCase().includes(searchValue)) {
                    match = true;
                }
                break;
            case 'address':
                if (cells[4].innerText.toLowerCase().includes(searchValue)) {
                    match = true;
                }
                break;
            case 'phone':
                if (cells[5].innerText.toLowerCase().includes(searchValue)) {
                    match = true;
                }
                break;
        }

        if (match) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
});

