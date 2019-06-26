/**
 * 
 */
window.onload=function (){
document.getElementById("login-btn").addEventListener("click", requestLogin);}

function requestLogin(){
	let url = "http://localhost:8080/Project1/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function () {
		if(this.readyState === 4 && this.status === 200){
			let autho = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", autho);
			window.location.href = "http://localhost:8080/Project1/home";
		}
	}
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	let requestBody = "username="+user+"&password="+pass;
	xhr.send(requestBody);
}
