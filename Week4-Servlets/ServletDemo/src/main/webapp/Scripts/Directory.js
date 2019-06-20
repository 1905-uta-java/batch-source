/**
 *  JavaScript used to render employee information on Directory.html
 */

// make an AJAX request to http://localhost:8080/ServletDemo/employees to get all of our employee records

//console.log("Hello world from directory.js")

let employeeUrl = "http://localhost:8080/ServletDemo/employees";

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
		
		let dpt = "n/a";
		if(employees[i].department){
			dpt = employees[i].department.name;
		}
		
		newRow.innerHTML = `<td>${employees[i].name}</td><td>${dpt}</td>`;
		
		table.appendChild(newRow);
		
	}
}

sendAjaxGet(employeeUrl, displayEmployees);
