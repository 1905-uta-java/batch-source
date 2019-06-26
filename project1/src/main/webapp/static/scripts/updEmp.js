/**
 * 
 */

document.getElementById("updEmpInfo").addEventListener("click", updateEmpInfo);



function updateEmpInfo(){
	
	if(document.getElementById("fNameIn").value != null){
		empObj.firstName = document.getElementById("fNameIn").value
	}
	if(document.getElementById("lNameIn").value != null){
		empObj.lastName = document.getElementById("lNameIn").value
	}
	if(document.getElementById("bDateIn").value != null){
		empObj.birthDate = document.getElementById("bDateIn").value
	}
	if(document.getElementById("passwordIn").value != null){
		usrObj.password = document.getElementById("passwordIn").value
	}
	
	console.log(empObj);
	
	
	let xhr = new XMLHttpRequest();
	let user;
	xhr.open("POST", "http://localhost:8080/updEmp");
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("heyyeeyeyyeeyeyeyyeye");
			
			requestEmpInfo();
		}
	}
	user = token.split(":")[0];

	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "firstname="+empObj.firstName+"&lastname="+empObj.lastName+
		"&empId="+empObj.id + "&birthDate="+empObj.birthDate +"&username="+usrObj.username+"&password="+usrObj.password;
	xhr.send(requestBody);
}



