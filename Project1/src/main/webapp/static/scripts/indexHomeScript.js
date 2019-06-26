document.getElementById("login-btn").addEventListener("click", requestLogin);

function requestLogin(){
	//console.log("Request Login Function Running")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	let auth;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			auth = xhr.getResponseHeader("Authorization");
			//console.log(xhr.getResponseHeader("Authorization"));
			sessionStorage.setItem("token", auth);
			let managerCheck = auth.split(":");
			let isManager = false;
			console.log('Manager Check : ' + managerCheck);
			if (managerCheck.includes('1')){
				console.log("Hi the manager check has a one inside it yay")
				isManager = true;
			}
			if (auth != null && !isManager) {
				window.location.href='http://localhost:8080/Project1/employeeHome';
			} else if (auth != null && isManager) {
				window.location.href='http://localhost:8080/Project1/managerHome';
			}
		}
	}
	let user = document.getElementById("usernameId").value;
	let pass = document.getElementById("passwordId").value;
	let requestBody = "username="+user+"&password="+pass;

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log('Authorization in : ' + auth);

	console.log(user + pass);
	xhr.send(requestBody);
}
	
