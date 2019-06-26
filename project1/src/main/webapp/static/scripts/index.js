/**
 * 
 */
var userRole

document.getElementById("login_btn").addEventListener("click", requestLogin);
let response = "";

function requestLogin(){
	let url = 'http://localhost:8080/login';
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url); //POST
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Status is 200 and ready state is 4, so I guess it's token time");
			let auth = xhr.getResponseHeader("Authorization");
			
			sessionStorage.setItem("token", auth);
			console.log(auth.split(":")[2]);
			if(auth.split(":")[2] === 'admin'){
				window.location.href='http://localhost:8080/admin';
			} else {
				window.location.href='http://localhost:8080/home';				
			}
		}
	}
	let user = document.getElementById("username").value;
	let pass = document.getElementById("password").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user+"&password="+pass;
	xhr.send(requestBody);
}

