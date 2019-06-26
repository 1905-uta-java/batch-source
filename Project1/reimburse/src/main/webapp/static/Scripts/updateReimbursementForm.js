/*this page lists one reimbursement
 * for manager approval via
 * radio button
 * 
 * once checked the approval cannot be undone
 * 
 * 
 * */
let reimbursementUrl = "http://localhost:8080/reimburse/api/reimbursements";
let idOfReimbursement = localStorage.getItem("idToFindLocalStorage");
let allReimbursements = {};
let approvingManagerId = "";
let notYetApproved = document.getElementById("notYetApproved");
let approved = document.getElementById("approved");


// the following subtraction alleviates numbering issue
// for global object to determine id for query
idOfReimbursement = idOfReimbursement - 1;


// initial request for all reimbursements
function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET",url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		}
	}
	xhr.send();
}

function displayTheReimbursement(xhr){
	allReimbursements= JSON.parse(xhr.response);
	let table = document.getElementById("table");
	
		let newRow = document.createElement("tr");
	
		newRow.innerHTML = `<td id="id">${allReimbursements[idOfReimbursement].id}</td>
							<td id="category">${allReimbursements[idOfReimbursement].category}</td>
							<td id="status">${allReimbursements[idOfReimbursement].status}</td>
							<td id="amount">${allReimbursements[idOfReimbursement].amount}</td>
							<td id="dateSubmitted">${allReimbursements[idOfReimbursement].dateSubmitted}</td>
							<td id="approvingManagerId">${allReimbursements[idOfReimbursement].approvingManagerId}</td>
							<td id="dateApproved">${allReimbursements[idOfReimbursement].dateApproved}</td>
							<td id="employeeId">${allReimbursements[idOfReimbursement].employeeId}</td>
							`;
		table.appendChild(newRow);
		approvingManager = allReimbursements[idOfReimbursement].approvingManagerId;
		// ensures values have been populated
		xhr.onload = populateCorrectRadioButton();

}

sendAjaxGet(reimbursementUrl, displayTheReimbursement);
function populateCorrectRadioButton(){
	// do not call this function until AJAX request has values
	if (approvingManager === 0 || approvingManager === ""){
		notYetApproved.checked = true;
	} else {
		approved.checked = true;
		notYetApproved.disabled = true;
	}
}

function approveButton() {
	// get manager id to use send with request
	let token = sessionStorage.getItem("token");
	let tokenArr = token.split(":");
	
	let loggedInEmployeeId = tokenArr[0]; // 2
	let loggedInEmployeeRole = token[1]; // manager
	
	console.log(tokenArr);
	
	
	// send HTTP post request to servlet
	let reimbursementApprovalUrl = "http://localhost:8080/reimburse/api/approveButton"; 
	// initial request for all reimbursements
	let xhr = new XMLHttpRequest();

	xhr.open("POST", reimbursementApprovalUrl);

	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			// after change show user all reimbursements again
			location.reload();
		}
	}
	let id = document.getElementById("id").innerHTML;
	let category = document.getElementById("category").innerHTML;
	let status = document.getElementById("status").innerHTML;
	let amount = document.getElementById("amount").innerHTML;
	let dateSubmitted = document.getElementById("dateSubmitted").innerHTML;
	approvingManagerId = document.getElementById("approvingManagerId").innerHTML;
	let dateApproved = document.getElementById("dateApproved").innerHTML;
	let employeeId = document.getElementById("employeeId").innerHTML; 
	
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	
	let requestBody = "id="+id+"&category="+category+"&amount="+amount+
	"&dateSubmitted="+dateSubmitted+"&approvingManagerId="+approvingManagerId+"&dateApproved="+dateApproved+
	"&employeeId="+employeeId+"&loggedInEmployeeId="+loggedInEmployeeId;
	
	console.log(requestBody);
	xhr.send(requestBody);

}

// execute query when user click radio button
approved.addEventListener("click", approveButton, populateCorrectRadioButton);

// update radio buttons
// to disable all buttons after change
//xhr.onload(populateCorrectRadioButton);
function logout(){
	localStorage.clear();
}

let logoutLink = document.getElementById("logout");

logoutLink.addEventListener("click", logout);



