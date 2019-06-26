//let today = new Date().toISOString().substr(0, 10);
//document.querySelector("#today").value = today;
// send parameters with XMLHttpRequest object

document.getElementById("add-reimbursement-btn").addEventListener("click", addUser);


function addUser(){
	let url = "http://localhost:8080/reimburse/api/add";
	let xhr = new XMLHttpRequest();

	xhr.open("POST", url);
	let token = sessionStorage.getItem("token");
	xhr.setRequestHeader("token", token)
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			window.location.href="http://localhost:8080/reimburse/api/reimbursements";
		}
	}
	let category = document.getElementById("category").value;
	let amount = document.getElementById("amount").value;
	let dateSubmitted = document.getElementById("dateSubmitted").value;
	let employeeId = document.getElementById("employeeId").value;
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "category="+category+"&amount="+amount+"&dateSubmitted="+dateSubmitted+"&employeeId="+employeeId;
	xhr.send(requestBody);
}

function logout(){
	localStorage.clear();
}

let logoutLink = document.getElementById("logout");

logoutLink.addEventListener("click", logout);
