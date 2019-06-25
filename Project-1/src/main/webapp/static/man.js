let xhr = new XMLHttpRequest();
let manUrl = "http://localhost:8080/Project1/api/man";
document.getElementById("profile").addEventListener("click", getProfile);
document.getElementById("request").addEventListener("click", getRequests);
//document.getElementById("approved").addEventListener("click", getApproved());
document.getElementById("emps").addEventListener("click", getEmployees);
document.getElementById("approve").addEventListener("click", approveReq);
document.getElementById("logout").addEventListener("click", logOut);

let token = sessionStorage.getItem("token");

function getProfile() {
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/profile");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let profile = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center'>Your Profile</h2>";
            
            let profInfo = document.createElement("ul");
            profInfo.innerHTML = `<li>Id: ${profile.id}</li><li>Name: ${profile.firstName} ${profile.lastName}</li><li>Username: ${profile.userName}</li><li>Email: ${profile.eMail}</li>`;
            
            info.appendChild(profInfo);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function getRequests() {
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/requests");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center>Reimbursement Requests</h2>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Employee Id</th><th>Amount</th><th>Reason</th><th>Approved</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let isApproved = "";
                let approveMan = "No";
                let newRow = document.createElement("tr");
                if(item.approvedBy !== 0) {
                    isApproved = "disabled";
                    approveMan = "Approved by: " + item.approvedBy;
                }
                newRow.innerHTML = `<td>${item.id}</td><td>${item.empId}</td><td>${item.amount}</td><td>${item.reason}</td><td>${approveMan}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

//function getApproved() {
//    let requestBod = "managerId="+token;
//    
//    xhr.open("GET", manUrl + "/approved");
//    xhr.onreadystatechange = function() {
//        if(this.readyState === 4 && this.status === 200) {
//            
//        }
//    }
//    xhr.send(requestBod);
//}

function getEmployees() {
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/employees");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let employees = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h2 class='text-center'>Your Employees</h2>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Employee Id</th><th>Name</th><th>Username</th><th>Email</th>";
            table.appendChild(tableHead);
            
            for(item of employees) {
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.firstName} ${item.lastName}</td><td>${item.userName}</td><td>${item.eMail}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function approveReq() {
    let requestBod = "managerId="+token+"&requestId="+document.getElementById("reqId").value;
    
    xhr.open("POST", manUrl + "/approve");
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