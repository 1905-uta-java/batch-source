let xhr = new XMLHttpRequest();
let empUrl = "http://localhost:8080/Project1/api/emp";

let token = sessionStorage.getItem("token");

function getProfile() {
    
    let requestBod = "employeeId="+token;
       
    xhr.open("POST", empUrl + "/profile");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let profile = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center'>Your Profile</h2>";
            
            let profInfo = document.createElement("ul");
            profInfo.innerHTML = `<li>Id: ${profile.id}</li><li>First Name: ${profile.firstName} ${profile.lastName}</li><li>Username: ${profile.userName}</li><li>Email: ${profile.eMail}</li><li>Manager's Id: ${profile.managerId}</li>`;
            
            info.appendChild(profInfo);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function getRequests() {
    let requestBod = "employeeId="+token;
    
    xhr.open("POST", empUrl + "/requests");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center>Your Reimbursement Requests</h2>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Amount</th><th>Reason</th><th>Approved</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let approved = "No";
                if(item.approvedBy !== 0) {
                    approved = "Approved by: " + item.approvedBy;
                }
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.amount}</td><td>${item.reason}</td><td>${approved}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function getApproved() {
    let requestBod = "employeeId="+token;
    
    xhr.open("POST", empUrl + "/approved");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center>Your Approved Reimbursement Requests</h2>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Amount</th><th>Reason</th><th>Approved By</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.amount}</td><td>${item.reason}</td><td>${item.approvedBy}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function submitRequest() {
    let amount = document.getElementById("amount").value;
    let reason = document.getElementById("reason").value;
    let requestBod = "employeeId="+token+"&amount="+amount+"&reason="+reason;
    
    xhr.open("POST", empUrl + "/submit");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            console.log("Success");
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function logOut() {
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/Project1/static/index.html";
}

document.getElementById("profile").addEventListener("click", getProfile);
document.getElementById("requests").addEventListener("click", getRequests);
document.getElementById("approved").addEventListener("click", getApproved);
document.getElementById("submitRequest").addEventListener("click", submitRequest);
document.getElementById("logout").addEventListener("click", logOut);