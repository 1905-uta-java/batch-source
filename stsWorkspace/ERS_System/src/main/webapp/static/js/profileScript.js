//URL variable
let url = "http://localhost:8080/ERS_System/api/profile";

//element selectors
let profButton = document.querySelector(`.profUpdate`);
let username = document.querySelector(`.proUsername`);
let password = document.querySelector(`.proPassword`);
let firstname = document.querySelector(`.proFirstname`);
let lastname = document.querySelector(`.proLastname`);
let email = document.querySelector(`.proEmail`);

function getUserProfile(url, displayFunction) {
    console.log(`Getting user profile`);
    let xhr = new XMLHttpRequest();
    xhr.open(`POST`, url);
    //return the user profile when response received
    xhr.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 200) {
            displayFunction(this);
        }
    }
    let userID = sessionStorage.getItem(`token`).split(":")[0];
    console.log("userID: " + userID);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = "emp_id=" + userID;
    xhr.send(requestBody);
}

function displayProfile(xhr) {
    let user = JSON.parse(xhr.response);
    console.log(user);
    console.log(user.username);
    username.value = `${user.username}`;
    password.value = `${user.password}`;
    firstname.value = `${user.firstname}`;
    lastname.value = `${user.lastname}`;
    email.value = `${user.email}`;
}

getUserProfile(url, displayProfile);

function updateProfile() {
    let updateURL = url + "/update";
    console.log(`Updating user profile ${updateURL}`);
    let xhr = new XMLHttpRequest();
    xhr.open(`POST`, updateURL);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            console.log(`success`);
            window.location.href = "http://localhost:8080/ERS_System/profile";
        }
    }
    
    let emp_pos = sessionStorage.getItem(`token`).split(":")[1];
    let emp_id = sessionStorage.getItem(`token`).split(":")[0];
    let newUsername = username.value;
    let newPassword = password.value;
    let newFirstname = firstname.value;
    let newLastname = lastname.value;
    let newEmail = email.value;

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = "username=" + newUsername + "&password=" + newPassword + "&firstname=" + newFirstname+ "&lastname=" + newLastname + "&email=" + newEmail + "&emp_pos=" + emp_pos + "&emp_id=" + emp_id;
    xhr.send(requestBody);
}

profButton.addEventListener(`click`, ()=>{
    updateProfile();
})