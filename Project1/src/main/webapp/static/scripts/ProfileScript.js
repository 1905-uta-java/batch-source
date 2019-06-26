/**
 * Script to grab profile information
 */
window.onload = function () {
	document.getElementById("table").style.display = "none" 
	document.getElementById("tableEmp").style.display= "none"
	document.getElementById("tableAllReq").style.display= "none"


	document.getElementById("review").addEventListener("click", callAjax);
	document.getElementById("manage").addEventListener("click", manageEmps);
	document.getElementById("managereq").addEventListener("click", manageReqs);
	document.getElementById("logout").addEventListener("click", logout);
}
let token = sessionStorage.getItem("token");
if(!token){
	window.location.href = "http://localhost:8080/Project1/login";
} else {
	let tokenArr = token.split(":");
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/Project1/api/profile?username=";
		sendAjaxGet(baseUrl+tokenArr[1], displayProfile)
	} else {
		window.location.href="http://localhost:8080/Project1/invlogin";
	}
}

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		} else if(this.readyState === 4){
			window.location.href = "http://localhost:8080/Project1/invlogin";
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.send();
}
function sendAjaxPut(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 201){
			callback(this);
		}
	}
	if(arguments.length > 2){
		let event = arguments[2]
		let reqId = event.target.id.split(' ')[0]
		let resolvedBy = arguments[3].split(':')[0]
		let status = 0;
		if(event.target.id.split(' ')[1] === 'a'){
			status = 1;
		} else if(event.target.id.split(' ')[1] === 'r') { status = 2};
		xhr.setRequestHeader("Content-type", "text/plain");
		let reqbody = "reqId="+reqId+"&status="+status+"&resolvedBy="+resolvedBy
		
		xhr.send(reqbody);
	} else { xhr.send(); }
}
function displayProfile(xhr){
	let user = JSON.parse(xhr.response);
	document.getElementById("name-field").innerHTML = "Welcome "+ user.username;
	document.getElementById("id-field").innerHTML = "Employee ID: "+user.empId;
	document.getElementById("fullname-field").innerHTML = "Name: " +user.emp.fullnamme;
	document.getElementById("email-field").innerHTML = "Email: " +user.emp.email;
	if(user.emp.isManager === 1){
		document.getElementById("manager-field").innerHTML = "Manager status: Manager";
		document.getElementById("manage").style.display = "block";
		document.getElementById("managereq").style.display = "block";
	} else {
		document.getElementById("manager-field").innerHTML = "Reports to: " +user.emp.managerId;
	}

}
function callAjax(){
	url = "http://localhost:8080/Project1/api/request"
	sendAjaxGet(url, displayRequests);
}
function manageEmps(){
	url = "http://localhost:8080/Project1/api/employees"
	sendAjaxGet(url, displayEmps);
	
}
function manageReqs(){
	url = "http://localhost:8080/Project1/api/manage"
	sendAjaxGet(url, displayReqs);
	
}
function displayRequests(xhr){
	var rem = document.getElementById("table");
	var rows = rem.getElementsByTagName("tr");
	for(let x=rows.length-1; x>0; x--){
		rem.removeChild(rows[x]);
	}
	requests = JSON.parse(xhr.response);
	for(req of requests){
		let head = document.createElement("tr");
		var req2 = document.createElement("td")
		req2.innerHTML = req.reqId
		head.appendChild(req2);
		
		var req3 = document.createElement("td")
		req3.innerHTML = req.amount
		head.appendChild(req3);
		
		var req4 = document.createElement("td")
		if(req.status === 1){
			req4.innerHTML = 'Accepted'
		} else if(req.status === 0 && req.resolvedby != 0){
			req4.innerHTML = 'Rejected'
		} else {
			req4.innerHTML = 'Pending'
		}
		head.appendChild(req4);
		
		var req5 = document.createElement("td")
		req5.innerHTML = req.comments
		head.appendChild(req5);
		
		document.getElementById("table").appendChild(head);

	}
	document.getElementById("table").style.display= "block" 
}
function displayEmps(xhr){
	var rem = document.getElementById("tableEmp");
	var rows = rem.getElementsByTagName("tr");
	for(let x=rows.length-1; x>0; x--){
		rem.removeChild(rows[x]);
	}
	let employees = JSON.parse(xhr.response);
	for(emp of employees){
		let head = document.createElement("tr");
		var req2 = document.createElement("td")
		req2.innerHTML = emp.empNum
		head.appendChild(req2);
		
		var req3 = document.createElement("td")
		req3.innerHTML = emp.fullnamme
		head.appendChild(req3);
		
		var req4 = document.createElement("td")
		req4.innerHTML = emp.email
		head.appendChild(req4);
		
		var req5 = document.createElement("td")
		req5.innerHTML = emp.managerId
		head.appendChild(req5);
		
		var btn = document.createElement("button")
		btn.innerHTML = 'Employee Requests';
		btn.setAttribute("id", emp.empNum);
		btn.setAttribute("class", "btn btn-info");
		head.appendChild(btn);
		
		document.getElementById("tableEmp").appendChild(head);
		document.getElementById(emp.empNum).addEventListener("click", getEmpReqs);
	}
	document.getElementById("tableEmp").style.display= "block"
}

function displayReqs(xhr){
	let requests = JSON.parse(xhr.response);
	var rem = document.getElementById("tableAllReq");
	var rows = rem.getElementsByTagName("tr");
	for(let x=rows.length-1; x>0; x--){
		rem.removeChild(rows[x]);
	}
	for(req of requests){
		let head = document.createElement("tr");
		var req2 = document.createElement("td")
		req2.innerHTML = req.empId
		head.appendChild(req2);
		
		var req3 = document.createElement("td")
		req3.innerHTML = req.reqId
		head.appendChild(req3);
		
		var req6 = document.createElement("td")
		req6.innerHTML = req.amount
		head.appendChild(req6)
		
		var req4 = document.createElement("td")
		if(req.status === 1){
			req4.innerHTML = 'Accepted'
		} else if(req.status === 0 && req.resolvedby !== 0){
			req4.innerHTML = 'Rejected'
		} else {
			req4.innerHTML = 'Pending'
		}
		head.appendChild(req4);
		
		var req7 = document.createElement("td")
		req7.innerHTML = req.comments
		head.appendChild(req7);
		
		var req5 = document.createElement("td")
		if(req.resolvedby === 0){
		req5.innerHTML = 'n/a'
		} else { req5.innerHTML = req.resolvedby}
		head.appendChild(req5);
		
		var btn = document.createElement("button")
		btn.innerHTML = 'Approve'
		btn.setAttribute("id", req.reqId+' a');
		btn.setAttribute("class", "btn btn-info");
		head.appendChild(btn);
		var btn2 = document.createElement("button")
		btn2.innerHTML = 'Reject'
		btn2.setAttribute("id", req.reqId+' r');
		btn2.setAttribute("class", "btn btn-info");
		head.appendChild(btn2);
		
		if(req.resolvedby !== 0){
			btn.disabled = true;
			btn2.disabled = true;
		}
		
		
		document.getElementById("tableAllReq").appendChild(head);
		document.getElementById(req.reqId+' a').addEventListener("click", changeStatus);
		document.getElementById(req.reqId+' r').addEventListener("click", changeStatus);



	}
	document.getElementById("tableAllReq").style.display= "block";
}
function changeStatus(event){
	let url = "http://localhost:8080/Project1/api/request"
	sendAjaxPut(url, manageReqs, event, token)
}
function getEmpReqs(event){
	empId = event.target.id
	let url = "http://localhost:8080/Project1/api/emprequests"
	let xhr = new XMLHttpRequest()
	
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			displayReqs(this)
		} else {
			console.log("Error getting employee requests")
		}
	}
	xhr.setRequestHeader("Authorization", token);
	xhr.setRequestHeader("EmployeeID", empId);
	xhr.send();
	
}
function logout(){
	sessionStorage.clear();
	window.location.href = "http://localhost:8080/Project1/login";
}

