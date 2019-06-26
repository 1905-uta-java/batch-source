//URL variable
let url = "http://localhost:8080/ERS_System/api/users";


//Functions

//function that asks for user profile from the server
function getUserProfiles(url, displayFunction) {
    console.log(`Getting user profile`);
    let xhr = new XMLHttpRequest();
    xhr.open(`GET`, url);
    //return the user profile when response received
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayFunction(this);
        }
    }
    xhr.send();
}

function displayUsers(xhr) {
    let users = JSON.parse(xhr.response);
    let table = document.querySelector(`#users-table`);

    for (let u in users) {
        let newRow = document.createElement("tr");
        newRow.innerHTML = `<td>${users[u].emp_id}</td><td>${users[u].lastname}</td><td>${users[u].firstname}</td><td>${users[u].username}</td><td>${users[u].email}</td>`;

        table.appendChild(newRow);
    }
}

getUserProfiles(url, displayUsers);