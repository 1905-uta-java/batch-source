let employeeUrl = "http://localhost:8090/ManagerPro/Manager";

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

function displayEmployees(xhr){
	let employees = JSON.parse(xhr.response);
	let table = document.getElementById("table");
	
	for(i in employees){
		let newRow = document.createElement("tr");
		
		
		newRow.innerHTML = `<td>${employees[i].id}</td>
		<td>${employees[i].email}</td>
		<td>${employees[i].password}</td>
		<td>${employees[i].position}</td>
		<td>${employees[i].reimburstment}</td>
		<td>${employees[i].status}</td>`;
		
		table.appendChild(newRow);
		
	}
}

sendAjaxGet(employeeUrl, displayEmployees);
//http://localhost:8090/TestingProject/managerServlet