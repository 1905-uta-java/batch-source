/*this page lists all existing reimbursements
 * Each reimbursement has a link to a page
 * where manager can change status with radio button
 * 
 * 
 * */


let reimbursementUrl = "http://localhost:8080/reimburse/api/reimbursements";

// global object to determine id for query
let idCaptured;


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

function displayReimbursements(xhr){
	allReimbursements= JSON.parse(xhr.response);
	let table = document.getElementById("table");
	
	for(i in allReimbursements){
		let newRow = document.createElement("tr");
	
		newRow.innerHTML = `<td>${allReimbursements[i].id}</td>
							<td>${allReimbursements[i].category}</td>
							<td>${allReimbursements[i].status}</td>
							<td>${allReimbursements[i].amount}</td>
							<td>${allReimbursements[i].dateSubmitted}</td>
							<td>${allReimbursements[i].approvingManagerId}</td>
							<td>${allReimbursements[i].dateApproved}</td>
							<td>${allReimbursements[i].employeeId}</td>
							<td><a href="http://localhost:8080/reimburse/update" id="${allReimbursements[i].id}" onmousedown="captureID(${allReimbursements[i].id})">update</td>
							`;
		table.appendChild(newRow);
	}
}
sendAjaxGet(reimbursementUrl, displayReimbursements);

function captureID(idCaptured){
	localStorage.setItem("idToFindLocalStorage", idCaptured);
	console.log("id is " + idCaptured);
}

function logout(){
	localStorage.clear();
}

let logoutLink = document.getElementById("logout");

logoutLink.addEventListener("click", logout);

