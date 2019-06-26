let xhr = new XMLHttpRequest();
let manUrl = "http://localhost:8080/Project1/api/man";
document.getElementById("profile").addEventListener("click", getProfile);
document.getElementById("request").addEventListener("click", getRequests);
document.getElementById("resolved").addEventListener("click", getResolved);
document.getElementById("emps").addEventListener("click", getEmployees);
document.getElementById("approve").addEventListener("click", approveReq);
document.getElementById("deny").addEventListener("click", denyReq);
document.getElementById("logout").addEventListener("click", logOut);
document.getElementById("update").addEventListener("click", updateInfo);
document.getElementById("empReqs").addEventListener("click", getEmployeeRequests);

let token = sessionStorage.getItem("token");

function getProfile() {
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/profile");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let profile = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h4>Your Profile</h4>";
            
            let profInfo = document.createElement("ul");
            profInfo.innerHTML = `<li>Id: ${profile.id}</li><li>Name: ${profile.firstName} ${profile.lastName}</li><li>Username: ${profile.userName}</li><li>Email: ${profile.eMail}</li>`;
            
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
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/requests");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h4>Pending Reimbursement Requests</h4>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Employee Id</th><th>Amount</th><th>Reason</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let newRow = document.createElement("tr");
                newRow.innerHTML = `<td>${item.id}</td><td>${item.empId}</td><td>${item.amount}</td><td>${item.reason}</td>`;
                
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
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/resolved");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let requests = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h4>Resolved Reimbursement Requests</h4>";
            let table = document.createElement("table");
            table.className = "table";
            let tableHead = document.createElement("tr");
            tableHead.innerHTML = "<th>Request Id</th><th>Employee Id</th><th>Amount</th><th>Reason</th><th>Result</th>";
            table.appendChild(tableHead);
            
            for(item of requests) {
                let result = "";
                let newRow = document.createElement("tr");
                if(item.approvedBy >= 20000) {
                    result = "Approved by: " + item.approvedBy;
                } else {
                    result = "Denied by: " + item.deniedBy;
                }
                newRow.innerHTML = `<td>${item.id}</td><td>${item.empId}</td><td>${item.amount}</td><td>${item.reason}</td><td>${result}</td>`;
                
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

function getEmployees() {
    let requestBod = "managerId="+token;
    
    xhr.open("POST", manUrl + "/employees");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let employees = JSON.parse(xhr.response);
            let info = document.getElementById("infoStuff");
            info.innerHTML = "<h4>Your Employees</h4>";
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

function getEmployeeRequests() {
    let info = document.getElementById("infoStuff");
    info.innerHTML = "";
    let handler = document.createElement("div");
    handler.className = "text-left";
    handler.innerHTML = `<h4>Get all of the Reimbursement Requests from one of your Employees</h4><label>Employee id</label><input type="text" id="empId"><br/><button class="btn btn-outline-secondary" id="getEmpReqs">Get Employee's Requests</button>`;
    info.appendChild(handler);
    document.getElementById("getEmpReqs").addEventListener("click", function() {
        let empId = document.getElementById("empId").value;
        let requestBod = "managerId="+token+"&employeeId="+empId;
    
        xhr.open("POST", manUrl + "/empreqs");
        xhr.onreadystatechange = function() {
            if(this.readyState === 4 && this.status === 200) {
                let requests = JSON.parse(xhr.response);
                let info = document.getElementById("infoStuff");
                info.innerHTML = `<h4>${empId}'s Reimbursement Requests</h4>`;
                let table = document.createElement("table");
                table.className = "table";
                let tableHead = document.createElement("tr");
                tableHead.innerHTML = "<th>Request Id</th><th>Amount</th><th>Reason</th><th>Resolved</th>";
                table.appendChild(tableHead);

                for(item of requests) {
                    let result = "";
                    let newRow = document.createElement("tr");
                    if(item.approvedBy >= 20000) {
                        result = "Approved by: " + item.approvedBy;
                    } else if (item.deniedBy >= 20000) {
                        result = "Denied by: " + item.deniedBy;
                    } else {
                        result = "Not Resolved";
                    }
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
    });
}

function approveReq() {
    let requestBod = "managerId="+token+"&requestId="+document.getElementById("reqId").value;
    
    xhr.open("POST", manUrl + "/approve");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            notifyUser("Success", "You have successfully approved the Reimbursement Request");
            document.getElementById("reqId").value = "";
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

function denyReq() {
    let requestBod = "managerId="+token+"&requestId="+document.getElementById("reqId").value;
    
    xhr.open("POST", manUrl + "/deny");
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            notifyUser("Success", "You have successfully denied the Reimbursement Request");
            document.getElementById("reqId").value = "";
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
    let requestBod = "managerId="+token+"&userName="+uName+"&passWord="+pWord+"&eMail="+eMail;
       
    xhr.open("POST", manUrl + "/change");
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