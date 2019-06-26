let session = "http://localhost:8080/reimbursement/session";

function sendAjaxGet(url, func) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if(this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}
	xhr.open("GET", url);
	xhr.send();
}

function populateUser(xhr) {
	let r = JSON.parse(xhr.response);
	if(r.username != "null") {
		document.getElementById("username").innerHTML = r.username;
	} else {
		window.location = "http://localhost:8080/reimbursement/session";
	}
}

sendAjaxGet(session, populateUser);

