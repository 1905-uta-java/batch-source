/**
 * 
 */

document.getElementById("loginButton").addEventListener("click",goManager);

/*
function requestLogin(){
	let url = "http://localhost:8080/AuthDemo/login";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			let auth = xhr.getResponseHeader("Authorization");
			sessionStorage.setItem("token", auth);
			window.location.href="http://localhost:8080/AuthDemo/home";
		
		
		}
	}
	
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user+"&password="+pass;
	xhr.send(requestBody);
}
*/

function goManager(){
	window.location.href="http://localhost:8080/ERS/manager";
}