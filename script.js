let form = document.getElementById("Form");

let selectedRating = 0;

form.addEventListener("submit", function (event) {

   

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let message = document.getElementById("message").value;

    if (name === "" ||
        email === "" ||
        phone === "" ||
        message === "") {
			event.preventDefault();
        alert("All fields are required!");
        return;
    }

    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
		event.preventDefault();
        alert("Please enter a valid email address!");
        return;
    }

    if (!/^[0-9]{10}$/.test(phone)) {
		event.preventDefault();
        alert("Please enter a valid 10-digit phone number!");
        return;
    }

    if (selectedRating === 0) {
		event.preventDefault();
        alert("Please select a rating!");
        return;
    }


});

let stars = document.querySelectorAll(".star");

stars.forEach(function (star) {

    star.addEventListener("click", function () {

        let value = this.getAttribute("data-value");

        selectedRating = value;
        document.getElementById("rating").value = value;

        stars.forEach(function (s) {
            s.classList.remove("active");
        });

        for (let i = 0; i < value; i++) {
            stars[i].classList.add("active");
        }

    });

});
