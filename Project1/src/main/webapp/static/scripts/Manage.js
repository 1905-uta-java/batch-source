/**
 * 
 */
window.onload = function(){
	document.getElementById("newProfile").style.display = "none";
	document.getElementById("password-field").addEventListener("mouseover", sike)
	document.getElementById("password-field").addEventListener("mouseout", revert)
	document.getElementById("submit").addEventListener("click", submitPressed)
}
let token = sessionStorage.getItem("token");
if(!token){
	window.location.href = "http://localhost:8080/Project1/login";
}

function sike(){
	document.getElementById("password-field").innerHTML = "We can't show you this, better write it down next time"
}
function revert(){
	document.getElementById("password-field").innerHTML = "Password:"
}

function submitPressed(event){
	let url = "http://localhost:8080/Project1/api/manage"
	
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url)
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 201){
			alert("Reached")
			openNewProfile(this);
		}
	}

	//var username = document.getElementById("username").value
	var fullname = document.getElementById("fullname").value
	var email = document.getElementById("email").value
	var password = document.getElementById("password").value
	
	//let reqBod = `username=${username}&fullname=${fullname}&email=${email}&password=${password}`
	let reqBod = `fullname=${fullname}&email=${email}&password=${password}`



	xhr.setRequestHeader("Content-type", "text/plain");
	xhr.setRequestHeader("Authorization", token);
	
	xhr.send(reqBod);
}
function openNewProfile(xhr){
	let user = JSON.parse(xhr.response);
	console.log(user)
	
	document.getElementById("newProfile").style.display = "";
}
