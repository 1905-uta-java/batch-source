document.querySelector(`#submit-login-btn`).addEventListener(`click`, () => {
    let url = `http://localhost:8080/ERS/login`;
    let xhr = new XMLHttpRequest();
    console.log("posting");
    xhr.open(`POST`, url);
    xhr.onreadystatechange = () => {
        console.log(this.readyState + " " + this.status);
        if(this.readyState === 4 && this.status === 200){
            let auth = xhr.getResponseHeader(`Token`);
            sessionStorage.setItem(`token`, auth);
            window.location.href="http://localhost:8080/ERS/index";
        }
    }
    console.log("posting");
    let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user+"&password="+pass;
	xhr.send(requestBody);
})