document.querySelector(`#submit-login-btn`).addEventListener(`click`, requestLogin);

function requestLogin() {
    let url = `http://localhost:8080/ERS_System/login`;
    let xhr = new XMLHttpRequest();
    console.log("posting3");
    xhr.open(`POST`, url);
    xhr.onreadystatechange = function() {
    	console.log("posting");
        if(this.readyState === 4 && this.status === 200){
            let auth = xhr.getResponseHeader(`Token`);
            console.log(auth);
            sessionStorage.setItem(`token`, auth);
            window.location.href="http://localhost:8080/ERS_System/index";
        }
    }
    console.log("posting");
    let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user+"&password="+pass;
	xhr.send(requestBody);
}