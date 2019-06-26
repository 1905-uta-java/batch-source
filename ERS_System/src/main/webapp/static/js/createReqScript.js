//URL variable
let url = "http://localhost:8080/ERS_System/api/create-req";

//select elements
let amount = document.querySelector(`.amount`);
let comments = document.querySelector(`.comments`);
let btn = document.querySelector(`.create-req-btn`);

function createReq() {
    let xhr = new XMLHttpRequest();
    xhr.open(`POST`, url);
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
            console.log(`success`);
            window.location.href = "http://localhost:8080/ERS_System/create-req";
        }
    }
    
    let emp_id = sessionStorage.getItem(`token`).split(":")[0];
    let reqAmount = amount.value;
    let reqComments = comments.value;

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = "amount=" + reqAmount + "&comments=" + reqComments + "&emp_id=" + emp_id;
    xhr.send(requestBody);
}


btn.addEventListener(`click`, ()=>{
    createReq();
    console.log("clicking create req");
});