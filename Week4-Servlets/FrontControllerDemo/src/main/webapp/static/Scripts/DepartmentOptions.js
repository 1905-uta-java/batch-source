

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

let dptUrl = "http://localhost:8080/FrontControllerDemo/api/departments";

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