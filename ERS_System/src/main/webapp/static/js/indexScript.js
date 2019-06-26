//get the token!
let token = sessionStorage.getItem(`token`);

//Grab user profile and user records
let reqRecords;
let user;

console.log("Hello");

//Select elements for manipulation
let pHome = document.querySelector(`.home`);
let pCreateReq = document.querySelector(`.createReq`);
let pViewUsers = document.querySelector(`.viewUsers`)
let pViewReq = document.querySelector(`.viewReq`);
let pProfile = document.querySelector(`.profile`);
let pLogout = document.querySelector(`.logout`);
//let wHome = document.querySelector(`.wHome`);
//let wCreateReq = document.querySelector(`.wCreateReq`);
//let wViewReq = document.querySelector(`.wViewReq`);
//let wProfile = document.querySelector(`.wProfile`);

//Toggle home
pHome.addEventListener(`click`, ()=>{
    window.location.href = "http://localhost:8080/ERS_System/index";
})

//Toggle create
pCreateReq.addEventListener(`click`, ()=>{
    window.location.href = "http://localhost:8080/ERS_System/create-req";
})

//Toggle view
pViewReq.addEventListener(`click`, ()=>{
    window.location.href = "http://localhost:8080/ERS_System/view-req";
})

//Toggle users
pViewUsers.addEventListener(`click`, ()=>{
    window.location.href = "http://localhost:8080/ERS_System/view-users";
})

//Toggle profile
pProfile.addEventListener(`click`, ()=>{
    window.location.href = "http://localhost:8080/ERS_System/profile";
})


//Logout event listener
pLogout.addEventListener(`click`, ()=>{
    sessionStorage.setItem(`token`, null);
    window.location.href = "http://localhost:8080/ERS_System/login";
})

//hide from regular employees
function hideViewUsers(){
    let userTokenPos = sessionStorage.getItem(`token`).split(":")[1];

    if(userTokenPos == 100){
        console.log("invisible");
        pViewUsers.style.display = `none`;
    }

}

hideViewUsers();