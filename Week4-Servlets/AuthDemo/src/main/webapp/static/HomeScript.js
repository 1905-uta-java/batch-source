/**
 *  check if there is a token in sessionStorage, send the user back to the login page if not
 */

//console.log("home script")

let token = sessionStorage.getItem("token");
if(!token){
	window.location.href = "http://localhost:8080/AuthDemo/login";
} else {
	let tokenArr = token.split(":");
	console.log(tokenArr);
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/AuthDemo/api/users?id=";
		sendAjaxGet(baseUrl+tokenArr[0], displayName)
	} else {
		window.location.href = "http://localhost:8080/AuthDemo/login";
	}
}


/**
 *  if we are not redirected, query for the user with the id stored in sessionStorage
 *  GET request to /api/users?id=[id from sessionStorage]
 */

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this)
		} else if(this.readyState===4){
			window.location.href = "http://localhost:8080/AuthDemo/login";
		}
	}
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function displayName(xhr){
	let user = JSON.parse(xhr.response);
	document.getElementById("user").innerHTML = user.username;
}


