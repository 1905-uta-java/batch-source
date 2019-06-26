/**
 * 
 */

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

let empArrayUrl = "http://localhost:8080/ERS/api/allemployees";

function addOptions(xhr){
	let employees = JSON.parse(xhr.response);
	
	for(let i of employees){
		let newRow = document.createElement("tr");
		
		let dpt = employees[i].empName;
		
		newRow.innerHTML = `<td>${dpt}</td>`;
		
		table.appendChild(newRow);
		    
	}
}

sendAjaxGet(empArrayUrl, addOptions);