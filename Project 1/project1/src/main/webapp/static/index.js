document.getElementById("login").addEventListener("click", login); 
document.getElementById("newEmp").addEventListener("click", newEmp);

function tokener(xhr){
	let token = xhr.getResponseHeader("Authentic");
	sessionStorage.setItem("token", token);
	

}

function test(sendTo){
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    let xhr = new XMLHttpRequest();
    let view = "http://localhost:8080" + sendTo;
    xhr.open("POST", sendTo);
    xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			tokener(this);
			window.location.href=view;
		}
		else if(this.readyState == 4 && this.status === 401){
			document.getElementById("username").style.border = " 5px solid red"; 
			document.getElementById("password").style.border = " 5px solid red"; 
		}
	}
    let requestBody = "username="+user+"&password="+pass;    
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(requestBody);
}

function windowCall(sendTo){
    let view = "http://localhost:8080" + sendTo;
	window.location.href=view;
}

function login (){
	let sendTo = "/login";
	test(sendTo);
}

function newEmp(){
	let sendTo = "/newEmp";
	windowCall(sendTo);
}



