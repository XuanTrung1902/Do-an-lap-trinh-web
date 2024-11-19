
    function populateDays() {
        const daySelect = document.getElementById('day-select');
        for (let day = 1; day <= 31; day++) {
        const option = document.createElement('option');
        option.value = day;
        option.textContent = day;
        daySelect.appendChild(option);
        }
}

    function populateMonths() {
        const monthSelect = document.getElementById('month-select');
        for (let month = 1; month <= 12; month++) {
        const option = document.createElement('option');
        option.value = month;
        option.textContent = month;
        monthSelect.appendChild(option);
        }
}

    function populateYears() {
        const yearSelect = document.getElementById('year-select');
        for (let year = 2025; year >= 1950; year--) {
        const option = document.createElement('option');
        option.value = year;
        option.textContent = year;
        yearSelect.appendChild(option);
        }
}


    window.onload = function () {
    populateDays();
    populateMonths();
    populateYears();
};
    document.addEventListener("DOMContentLoaded", function () {
        const links = document.querySelectorAll(".link-toggle");

        links.forEach((link) => {
            link.addEventListener("click", function (e) {
                e.preventDefault();

                links.forEach((otherLink) => {
                    if (otherLink !== link) {
                        otherLink.classList.remove("active");
                    }
                });

                link.classList.toggle("active");
            });


            document.addEventListener("click", function (event) {
                if (!link.contains(event.target)) {
                    link.classList.remove("active");
                }
            });
        });
    });
