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
            info.innerHTML = "<h4>Your Profile</h4>";
            
            let profInfo = document.createElement("ul");
            profInfo.innerHTML = `<li>Id: ${profile.id}</li><li>First Name: ${profile.firstName} ${profile.lastName}</li><li>Username: ${profile.userName}</li><li>Email: ${profile.eMail}</li><li>Manager's Id: ${profile.managerId}</li>`;
            
            info.appendChild(profInfo);
        } else if(this.readyState === 4) {
            if(this.status === 405) {
                notifyUser(""+this.status, "Invalid Input");
            } if (this.status === 404) {
                notifyUser(""+this.status, "Page Not Found");
            }
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
            info.innerHTML = "<h4>Your Pending Reimbursement Requests</h4>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Amount</th><th>Reason</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.amount}</td><td>${item.reason}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        } else if(this.readyState === 4) {
            if(this.status === 405) {
                notifyUser(""+this.status, "Invalid Input");
            } if (this.status === 404) {
                notifyUser(""+this.status, "Page Not Found");
            }
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function getResolved() {
    let requestBod = "employeeId="+token;
    
    xhr.open("POST", empUrl + "/resolved");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h4>Your Resolved Reimbursement Requests</h4>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Amount</th><th>Reason</th><th>Result</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let result = "";
                if(item.approvedBy >= 20000) {
                    result = "Approved By: " + item.approvedBy;
                } else {
                    result = "Denied By: " + item.deniedBy;
                }
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.amount}</td><td>${item.reason}</td><td>${result}</td>`;
                
                table.appendChild(newRow);
            }
            
            info.appendChild(table);
        } else if(this.readyState === 4) {
            if(this.status === 405) {
                notifyUser(""+this.status, "Invalid Input");
            } if (this.status === 404) {
                notifyUser(""+this.status, "Page Not Found");
            }
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
            notifyUser("Success", "You have successfully submitted you Reimbursement Request!")
            document.getElementById("amount").value = "";
            document.getElementById("reason").value = "";
        } else if(this.readyState === 4) {
            if(this.status === 405) {
                notifyUser(""+this.status, "Invalid Input");
            } if (this.status === 404) {
                notifyUser(""+this.status, "Page Not Found");
            }
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function logOut() {
    sessionStorage.clear();
    window.location.href = "http://localhost:8080/Project1/static/index.html";
}

function updateInfo() {
    let uName = document.getElementById("uName").value;
    let pWord = document.getElementById("pWord").value;
    let eMail = document.getElementById("eMail").value;
    let requestBod = "employeeId="+token+"&userName="+uName+"&passWord="+pWord+"&eMail="+eMail;
    
    xhr.open("POST", empUrl + "/change");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            notifyUser("Success", "Your information was updated successfully!");
            document.getElementById("uName").value = "";
            document.getElementById("pWord").value = "";
            document.getElementById("eMail").value = "";
        } else if(this.readyState === 4) {
            if(this.status === 405) {
                notifyUser(""+this.status, "Invalid Input");
            } if (this.status === 404) {
                notifyUser(""+this.status, "Page Not Found");
            }
        }
    }
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBod);
}

function notifyUser(title, message) {
    document.getElementById("notifyTitle").innerHTML = title;
    document.getElementById("notifyMessage").innerHTML = message;
    $("#notifier").modal('toggle');
}

document.getElementById("profile").addEventListener("click", getProfile);
document.getElementById("requests").addEventListener("click", getRequests);
document.getElementById("resolved").addEventListener("click", getResolved);
document.getElementById("submitRequest").addEventListener("click", submitRequest);
document.getElementById("logout").addEventListener("click", logOut);
document.getElementById("update").addEventListener("click", updateInfo);