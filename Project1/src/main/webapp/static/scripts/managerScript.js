document.getElementById("denyBtn");
document.getElementById("getCurReim").addEventListener("click", makeRequest);
let counter = 0;
document.getElementById("logoutBtn").addEventListener("click", logout);
document.getElementById("getEmpsBtn").addEventListener("click", viewAllEmps);
document.getElementById("getReimByEmp").addEventListener("click", viewReimByEmp);
document.getElementById("pastReimReqBtn").addEventListener("click", makeRequest);


function makeRequest(){
	console.log("Make request called")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('MakeRequest has succeeded')
			AddReimbursement(xhr);
			AddPastReimbursement(xhr);
		}
	}

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send();
}

function openPastRe(){
//	console.log("openPastRe called")
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
	//		console.log('openPastRe has succeeded')
			AddReimbursement(xhr);
		}
	}

	//console.log(xhr);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	xhr.send();
}

function AddPastReimbursement(xhr) {
	let parent = document.getElementById("pastReimTable");
	for(var i = parent.rows.length - 1; i > 0; i--)
	{
	    parent.deleteRow(i);
	};
	reimbursement = xhr.getResponseHeader("Reimbursement");
	console.log(xhr.getResponseHeader("Reimbursement"));
	console.log ('AddingReimbursement');
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	
	let status = "Pending";
	
	let tableValues = JSON.parse(reimbursement);
	console.log('Table Values: ' + tableValues);
	for (reim of tableValues) {
		if (reim.status === "Approved" || reim.status === "Denied") {
			empReimTable(reim.id, reim.num, reim.amount, reim.reason, reim.status);
		} 
	}
}

function approval() {
//	console.log("Approval called")
	let url = "http://localhost:8080/Project1/managerHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200){
			console.log("Approval has succeeded");
		};
	}
	let param = "statusA";
	
	xhr.send();
	
}

function deny(status) {
//	console.log("Approval called")
	let url = "http://localhost:8080/Project1/managerHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200){
			console.log("Deny has succeeded");
		};
	}
	reimbursement = xhr.getResponseHeader("Reimbursement");
	
	status = "Denied";

	xhr.send();
	
}

function AddReimbursement(xhr) {
	let parent = document.getElementById("pendingReTable");
	for(var i = parent.rows.length - 1; i > 0; i--)
	{
	    parent.deleteRow(i);
	}
	reimbursement = xhr.getResponseHeader("Reimbursement");
//	console.log(xhr.getResponseHeader("Reimbursement"));
//	console.log ('AddingReimbursement');
	let amount = document.getElementById("amountId").value;
	let reason = document.getElementById("reasonId").value;
	
	let status = "Pending";
	
	let tableValues = JSON.parse(reimbursement);
//	console.log('Table Values: ' + tableValues)
	rows = 0; 

	for (reim of tableValues) {
		if (reim.status === "Pending") {
			rows++;
			addRow(reim.num, reim.amount, reim.reason, reim.status, rows++);
		}  
	}
}

function changeStatus(xhr){
	reimbursement = xhr.getResponseHeader("Reimbursement");
	console.log(xhr.getResponseHeader("Reimbursement"));
	console.log ("changing status");
		
	let tableValues = JSON.parse(reimbursement);
//	console.log('Table Values: ' + tableValues)
	
	for (reim of tableValues) {
		addRow(reim.num, reim.amount, reim.reason, reim.status, rows++);
	}
}


function  getId() {
	console.log("GetId started")
	let table = document.getElementById("pastReTable");
	var x = document.getElementsByTagName("tr");
	var i;
	console.log(x);
//	console.log(table.x(this).data);
	for (i = 0; i < x.length; i++) {
	  console.log(x.rowIndex[i].data);
	}
}

function getReimbursement() {
	id = document.getElementById("")
}

function addRow( id, amount, reason, status, rows){
	let table = document.getElementById("pendingReTable");
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");
	let cell7 = document.createElement("td");
	let button = document.createElement("button");
	let button2 = document.createElement("button");
	
	
	console.log(rows);
	
	let approveButtonIdNum = 0;
	let denyButtonIdNum = 0;
	
	approveButtonIdNum++;
	denyButtonIdNum++;
	
	let aId = "approveId" + approveButtonIdNum;
	let dId = "denyButtonIdNum" + denyButtonIdNum;
	
	button.className = "btn btn-success";
	button.id = aId;
	button.innerHTML = "Approve";
	button.disabled = true;
	button2.className = "btn btn-danger";
	button2.innerHTML = "Deny";
	button2.id = dId;
	button2.disabled = true;
	
	row.addEventListener("click", function(){
		aId = "approveId" + row.rowIndex;
		dId = "denyButtonIdNum" + row.rowIndex;
		button.id = aId;
		button2.id = dId;
		if (document.getElementById(aId).disabled === true && document.getElementById(dId).disabled === true){
			document.getElementById(aId).disabled = false; 
			document.getElementById(dId).disabled = false;
		}
		else if (document.getElementById(aId).disabled === false && document.getElementById(dId).disabled === false) {
			document.getElementById(aId).disabled = true; 
			document.getElementById(dId).disabled = true;
		}
		
		document.getElementById(aId).addEventListener("click", function(){
			let url = "http://localhost:8080/Project1/changeStatus";
			let xhr = new XMLHttpRequest();
			xhr.open("POST", url);
			xhr.onreadystatechange = function() {
				if (this.readyState === 4 && this.status === 200){
					console.log("Approval has succeeded");
					
				}
			}
			let idA = id;
			let amountA = amount;
			let reasonA = reason;
			let statusA = "Approved";
			let rIndexA = row.rowIndex;
			let requestBodyA = "idA="+idA+"&amountA="+amountA+"&reasonA="+reasonA+"&statusA="+statusA+"&rIndexA="+rIndexA;

			
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			console.log(requestBodyA);
			xhr.send(requestBodyA);
		});
		document.getElementById(aId).addEventListener("click", function(){
			let url = "http://localhost:8080/Project1/changeStatus";
			let xhr = new XMLHttpRequest();
			xhr.open("POST", url);
			xhr.onreadystatechange = function() {
				if (this.readyState === 4 && this.status === 200){
					console.log("Deny has succeeded");
					
				}
			}
			let idA = id;
			let amountA = amount;
			let reasonA = reason;
			let statusA = "Denied";
			let rIndexA = row.rowIndex;
			let requestBodyA = "idA="+idA+"&amountA="+amountA+"&reasonA="+reasonA+"&statusA="+statusA+"&rIndexA="+rIndexA;

			
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

			console.log(requestBodyA);
			xhr.send(requestBodyA);
		});
		document.getElementById(dId).addEventListener("click", deny);
		

	})

	cell1.innerHTML = id;
	cell2.innerHTML = amount;
	cell3.innerHTML = reason;
	cell4.innerHTML = status;
	cell5 = button;
	cell7 = button2;
	
	console.log(status);

	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);
	row.appendChild(cell7);
	
	table.appendChild(row);

}


function addRowPast( id, amount, reason, status, rows) {
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

function updateReimbursement(){
	console.log("Update Reimbursement called");
	let url = "http://localhost:8080/Project1/employeeHome";
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('Update Info has succeeded')
						
		}
	}
	let status = document.getElementById
	
}

function addEmpRows(empId, empName, empEmail){
	let table = document.getElementById("empTable");
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	
	cell1.innerHTML = empId;
	cell2.innerHTML = empName;
	cell3.innerHTML = empEmail;
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	table.appendChild(row);
}

function viewAllEmps(){
	console.log("View Reimbursement called");
	let url = "http://localhost:8080/Project1/viewEmps";
	let xhr = new XMLHttpRequest();
	
	console.log()
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('Update Info has succeeded')
			
			let emp = xhr.getResponseHeader("Employees");
			
			let tableValues = JSON.parse(emp);
			console.log(tableValues);
			
			for (employee of tableValues) {
				addEmpRows(employee.id, employee.firstname + " " + employee.lastname, employee.email);
			}
						
		}
	}
	xhr.send();
}

function empReimTable(id, amount, reason, status, rows) {
	let table = document.getElementById("pastReimTable");
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

function byIdTable(id, amount, reason, status, rows) {
	let table = document.getElementById("empReimTable");
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

function viewReimByEmp(id){
	console.log("View Emp Reimbursement called");
	let url = "http://localhost:8080/Project1/managerHome";
	let xhr = new XMLHttpRequest();
	
	console.log()
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log('Update Info has succeeded')
			
			let emp = xhr.getResponseHeader("Reim");
			
			let tableValues = JSON.parse(emp);
			console.log(tableValues);
			
			id = document.getElementById("selectEmp").value;
			rows = 0;
			console.log("What is ID : " + id);
			
			for (employee of tableValues) {
				console.log(employee.id + " : " + id);
				if (employee.id == id) {
					console.log("Iterating");
					rows++;
					byIdTable(employee.id, employee.amount, employee.reason, employee.status, rows++);
					
					}
			}
						
		}
	}
	xhr.send();
}


function logout() {
	sessionStorage.removeItem("token");
	let logoutTrue = "active";
	let logoutParam = "logoutTrue="+logoutTrue;
	window.location.href='http://localhost:8080/Project1/static';
}
