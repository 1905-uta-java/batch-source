let xhr = new XMLHttpRequest();
let loginUrl = "http://localhost:8080/Project1/api/log";
let createUrl = "http://localhost:8080/Project1/api/cre";


function tokenize(xhr) {
    let token = xhr.getResponseHeader("Authentic");
    sessionStorage.setItem("token", token);
}

function login() {
    let userName = document.getElementById("username").value;
    let passWord = document.getElementById("password").value;
    let requestBod = "userName="+userName+"&passWord="+passWord;
    
    xhr.open("POST", loginUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            tokenize(xhr);
            if(sessionStorage.getItem("token") >= 10000 && sessionStorage.getItem("token") < 20000) {
                window.location.href = "http://localhost:8080/Project1/static/employeePage.html";
            } else if(sessionStorage.getItem("token") >= 20000) {
                window.location.href = "http://localhost:8080/Project1/static/managerPage.html";
            }
        }
        else if(this.readyState === 4) {
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

function createUser() {
    let uName = document.getElementById("newUserName").value;
    let pWord = document.getElementById("newPassWord").value;
    let fName = document.getElementById("firstName").value;
    let lName = document.getElementById("lastName").value;
    let eMail = document.getElementById("email").value;
    let manId = document.getElementById("managerId").value;
    let requestBod = "userName="+uName+"&passWord="+pWord+"&firstName="+fName+"&lastName="+lName+"&email="+eMail+"&managerId="+manId;
    
    xhr.open("POST", createUrl);
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            tokenize(xhr);
            if(sessionStorage.getItem("token") >= 10000 && sessionStorage.getItem("token") < 20000) {
                window.location.href = "http://localhost:8080/Project1/static/employeePage.html";
            } else if(sessionStorage.getItem("token") >= 20000) {
                window.location.href = "http://localhost:8080/Project1/static/managerPage.html";
            }
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

document.getElementById("login").addEventListener("click", login);
document.getElementById("newuser").addEventListener("click", createUser);