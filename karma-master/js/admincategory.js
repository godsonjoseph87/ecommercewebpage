// Get the input element for searching
const searchInput = document.getElementById('searchInput');

// Get the unordered list for categories
const categoryUl = document.getElementById('categoryUl');

// Function to filter categories based on the search input
function filterCategories() {
    const filterValue = searchInput.value.toLowerCase();
    const categories = categoryUl.getElementsByTagName('li');

    for (const category of categories) {
        const categoryName = category.getElementsByTagName('span')[0].textContent.toLowerCase();
        if (categoryName.includes(filterValue)) {
            category.style.display = 'flex';
        } else {
            category.style.display = 'none';
        }
    }
}

// Attach keyup event to the search input
searchInput.addEventListener('keyup', filterCategories);


window.onload = function () {
    getCategories();
};

function AddNewFlightDetails(){
    const data = {
        name: document.getElementById("flightName").value,
        capacity: document.getElementById("capacity").value,
        sourceid: document.getElementById("source").value,
        airlineid: document.getElementById("airline").value,
        destinationid: document.getElementById("destination").value,
        time: document.getElementById("date").value,
        price: document.getElementById("price").value
    }

    fetch("http://localhost:9192/flights", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            console.log(response)
            if (!response.ok) {
                throw new Error("Network response was not ok.");
            }
            return response.json();
        })
        .then(data => {
            if(data.status_code == 200){
                closeAddFlightForm();
                clearAddFlightForms();
                getAllFlightDetails();
            }else{
                alert("Authentication failed!");
            }
        })
        .catch(error => {
            console.log(error)
            alert("Something went wrong!");
        });

}

function deleteFlight(id) {
    fetch("http://localhost:9192/flight/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => {
            console.log(response)
            if (!response.ok) {
                throw new Error("Network response was not ok.");
            }
            return response.json();
        })
        .then(data => {
            if(data.status_code == 200){
                getAllFlightDetails();
            }else{
                alert("Authentication failed!");
            }
        })
        .catch(error => {
            alert("Something went wrong!");
        });
}

function getCategories(){
    fetch("http://localhost:9192/airlines", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => {
            console.log(response)
            if (!response.ok) {
                throw new Error("Network response was not ok.");
            }
            return response.json();
        })
        .then(data => {
            if(data.status_code == 200){
                const selectElement = document.getElementById('airline');
                selectElement.innerHTML = '';
                data.data.forEach((airline) => {
                    const option = document.createElement('option');
                    option.textContent = airline.airlinename;
                    option.value = airline.id;
                    selectElement.appendChild(option);
                });
            }else{
                alert("Authentication failed!");
            }
        })
        .catch(error => {
            alert("Something went wrong!");
        });
}

function openAddCategoryForm(){
    const modal = document.getElementById("passwordChangeModal");
    modal.style.display = "block";
}


function openPage(pagename){
    switch (pagename){
        case "category":
            window.location.href = "./admincategory.html";
            break;
        case "products":
            window.location.href = "./adminproducts.html";
            break;
        case "orders":
            window.location.href = "./adminorders.html";
            break;
        case "customers":
            window.location.href = "./admincustomers.html";
            break;
        case "dashboard":
            window.location.href = "./adminhomepage.html";
            break;
    }
}