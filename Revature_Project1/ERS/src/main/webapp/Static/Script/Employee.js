/**
 * 
 */
//document.getElementById("submit").addEventListener("click", getAllEmployees);




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
	let departments = JSON.parse(xhr.response);
	
	let dptSelect = document.getElementById("dpt-select");
	
	for(let dept of departments){
		let newOption = document.createElement("option");
		newOption.value = dept.id;
		newOption.innerHTML = dept.name;
		dptSelect.appendChild(newOption);
	}
}

sendAjaxGet(dptUrl, addOptions);