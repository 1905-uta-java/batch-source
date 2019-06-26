//URL variable
let url = "http://localhost:8080/ERS_System/api/requests";

//Functions

//function that asks for user profile from the server
function getRequests(url, displayFunction) {
    console.log(`Getting requests`);
    let xhr = new XMLHttpRequest();
    xhr.open(`GET`, url);
    //return the requests when response received
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayFunction(this);
        }
    }
    xhr.send();
}

function displayRequests(xhr) {
    let requests = JSON.parse(xhr.response);
    let table = document.querySelector(`#requests-table`);

    for (let r in requests) {
        let newRow = document.createElement("tr");
        let apprButton = document.createElement("button");
        let denyButton = document.createElement("button");
        let emp_id = sessionStorage.getItem(`token`).split(":")[0];
        let emp_pos = sessionStorage.getItem(`token`).split(":")[1];

        apprButton.classList.add("btn");
        apprButton.classList.add("btn-success");
        apprButton.innerHTML = `Approve`;
        denyButton.classList.add("btn");
        denyButton.classList.add("btn-danger");
        denyButton.innerHTML = `Deny`;

        apprButton.addEventListener(`click`, function () {
            let apprURL = "http://localhost:8080/ERS_System/api/requests/approve";
            let xhr2 = new XMLHttpRequest();
            xhr2.open(`POST`, apprURL);
            xhr2.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    window.location.href = "http://localhost:8080/ERS_System/view-req";
                }
            }

            xhr2.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            let requestBody = "emp_id=" + emp_id + "&emp_pos=" + emp_pos + "&req_id=" + requests[r].req_id;
            xhr2.send(requestBody);
        })

        denyButton.addEventListener(`click`, function () {
            let denyURL = "http://localhost:8080/ERS_System/api/requests/deny";
            let xhr3 = new XMLHttpRequest();
            xhr3.open(`POST`, denyURL);
            xhr3.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    window.location.href = "http://localhost:8080/ERS_System/view-req";
                }
            }

            xhr3.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            let requestBody = "emp_id=" + emp_id + "&emp_pos=" + emp_pos + "&req_id=" + requests[r].req_id;
            xhr3.send(requestBody);
        })



        newRow.innerHTML = `<td>${requests[r].req_id}</td><td>${requests[r].emp_id}</td><td>$${requests[r].amount}</td><td>${requests[r].status}</td><td>${requests[r].comments}</td>`;
        let td1 = document.createElement("td");
        let td2 = document.createElement("td");
        td1.appendChild(apprButton);
        td2.appendChild(denyButton);



        table.appendChild(newRow);
        table.appendChild(td1);
        table.appendChild(td2);
    }
}

//For regular employees
function getUserRequests(url, displayFunction) {
    console.log(`Getting user profile`);
    let xhr = new XMLHttpRequest();
    xhr.open(`POST`, url);
    //return the user profile when response received
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayFunction(this);
        }
    }
    let userID = sessionStorage.getItem(`token`).split(":")[0];
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = "emp_id=" + userID;
    xhr.send(requestBody);
}

function displayUserRequest(xhr){
    let requests = JSON.parse(xhr.response);
    let table = document.querySelector(`#requests-table`);

    for (let r in requests) {
        let newRow = document.createElement("tr");
        newRow.innerHTML = `<td>${requests[r].req_id}</td><td>${requests[r].emp_id}</td><td>$${requests[r].amount}</td><td>${requests[r].status}</td><td>${requests[r].comments}</td>`;
        table.appendChild(newRow);
    }
}

if (sessionStorage.getItem(`token`).split(":")[1] > 100){
    getRequests(url, displayRequests);
} else {
    getUserRequests(url, displayUserRequest);
}