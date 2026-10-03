let form = document.getElementById("Form");

form.addEventListener("submit", function (event) {

    event.preventDefault();

    let name = document.getElementById("name").value;

    let email = document.getElementById("email").value;

    let phone = document.getElementById("phone").value;

    let message = document.getElementById("message").value;

    if (name === "" ||
        email === "" ||
        phone === "" ||
        message === "") {

        alert("All fields are required!");
        return;
    }

    if (!email.includes("@") ||
        !email.includes(".")) {

        alert("Wrong email!");
        return;
    }

    if (phone.length !== 10 ||
        isNaN(phone)) {

        alert("Wrong phone number!");
        return;
    }

    alert("Form submission is done.");
});

let stars = document.querySelectorAll(".star");

let ratingValue = document.getElementById("ratingValue");

stars.forEach(function (star) {

    star.addEventListener("click", function () {

        let value = this.getAttribute("data-value");

        ratingValue.textContent =
            // "Rating: " + value;

        stars.forEach(function (s) {

            s.classList.remove("active");

        });

        for (let i = 0; i < value; i++) {

            stars[i].classList.add("active");

        }
    });
});