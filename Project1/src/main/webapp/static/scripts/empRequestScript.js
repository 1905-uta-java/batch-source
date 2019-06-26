document.getElementById("current-pend-btn").addEventListener("click", makeRequest);
document.getElementById("submitBtnId").addEventListener("click", submitReimbursement);
document.getElementById("pastRe-btn").addEventListener("click", openPastRe);
document.getElementById("editProfBtn").addEventListener("click", updateEmpInfo);
document.getElementById("logoutBtn").addEventListener("click", logout);
window.onload = displayEmployeeInfo();
let counter = 0;
let staticEmpId;

function makeRequest(){
	console.log("Make request called")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('MakeRequest has succeeded')
			AddReimbursement(xhr);
		}
	}

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send();
}

function openPastRe(){
	console.log("openPastRe called")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('openPastRe has succeeded')
			AddReimbursement(xhr);
		}
	}

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send();
}



function AddReimbursement(xhr) {
	let parent = document.getElementById("pendingReTable");
	for(var i = parent.rows.length - 1; i > 0; i--)
	{
	    parent.deleteRow(i);
	}
	reimbursement = xhr.getResponseHeader("Reimbursement");
	console.log(xhr.getResponseHeader("Reimbursement"));
	console.log ('AddingReimbursement');
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	
	let status = "Pending";
	
	let tableValues = JSON.parse(reimbursement);
	console.log('Table Values: ' + tableValues)
	
	console.log("EMP ID: " + staticEmpId);
		
	for (reim of tableValues) {
		counter++;
		if (reim.status === "Pending" && reim.id === staticEmpId) {
			addRow(reim.id, reim.num, reim.amount, reim.reason, reim.status);
		}  
	}
}

function AddPastReimbursement(xhr) {
	let parent = document.getElementById("pastReimTable");
	for(var i = parent.rows.length - 1; i > 0; i--)
	{
	    parent.deleteRow(i);
	}
	reimbursement = xhr.getResponseHeader("Reimbursement");
	console.log(xhr.getResponseHeader("Reimbursement"));
	console.log ('AddingReimbursement');
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	
	let status = "Pending";
	
	let tableValues = JSON.parse(reimbursement);
	console.log('Table Values: ' + tableValues)
	
	for (reim of tableValues) {
		if ((reim.status === "Approved" && reim.id === staticEmpId) || (reim.status === "Denied" && reim.id === staticEmpId)) {
			addRowPas(reim.id, reim.num, reim.amount, reim.reason, reim.status);
		} 
	}
}




function addRow(id, count, amount, reason, status){
	let table = document.getElementById("pendingReTable");
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");

	
	//row.addEventListener("mouseover", test(rows));
	
	cell1.innerHTML = id;
	cell2.innerHTML = count;
	cell3.innerHTML = "$" + amount;
	cell4.innerHTML = reason;
	cell5.innerHTML = status;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	
	table.appendChild(row);

}


function addRowPast() {
	let table = document.getElementById("pastReTable");
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	
	cell1.innerHTML = id;
	cell2.innerHTML = amount;
	cell3.innerHTML = reason;
	cell4.innerHTML = status;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	
	table.appendChild(row);
	
}

function submitReimbursement () {
	console.log("Submit Reimbursement called")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('Submit Reimbursement has succeeded')
			addNew();
		}
	}
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	let requestBody = "amount="+amount+"&reason="+reason;

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	console.log('Amount: ' + amount + ' ' + reason);
	xhr.send(requestBody);
}



function addNew(){
	counter = counter + 1;
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	let empId = staticEmpId;
	let status = "Pending";
	addRow(empId, counter, amount, reason, status);
	console.log(counter + amount + reason + status);
}

function displayEmployeeInfo(){
	console.log("DISPLAY Function Running")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	let empInfo;
	let parsedInfo;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			empInfo = xhr.getResponseHeader("EmployeeInfo");
			console.log(xhr.getResponseHeader("EmployeeInfo"));
			console.log(xhr.response);
			parsedInfo = JSON.parse(empInfo);
			
					let empId = parsedInfo.id;
					staticEmpId = empId;
					let empFirstName = parsedInfo.firstname;
					let empLastName = parsedInfo.lastname;
					let empEmail = parsedInfo.email;
					console.log(empId + empFirstName + empLastName + empEmail);
					
					document.getElementById("empName").innerHTML = (empFirstName + " " + empLastName);
					document.getElementById("empId").innerHTML = ("Employee ID: " + empId);
					document.getElementById("empEmail").innerHTML = empEmail;
		
		}
	}
	
	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send();
}

function updateEmpInfo(){
	console.log("Update Employee Info called");
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('Update Info has succeeded')
			
		
			displayEmployeeInfo();
			
		}
	}
	let firstName = document.getElementById("firstName").value;
	let lastName = document.getElementById("lastName").value;
	let email = document.getElementById("emailChange").value;
	let requestBody = "firstName="+firstName+"&lastName="+lastName+"&email="+email;
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send(requestBody);
	
}


function logout() {
	sessionStorage.removeItem("token");
	let logoutTrue = "active";
	let logoutParam = "logoutTrue="+logoutTrue;
	window.location.href='http://localhost:8080/Project1/static';
}
