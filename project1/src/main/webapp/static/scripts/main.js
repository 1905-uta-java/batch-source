document.getElementById("reburseNav").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = true;
    document.getElementById('remInfo').hidden = false;
    document.getElementById('remInfoLi').classList.toggle("active");
    document.getElementById('empInfoLi').classList.toggle("active");
});

document.getElementById("empInfoNav").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = false;
    document.getElementById('remInfo').hidden = true;
    document.getElementById('remInfoLi').classList.toggle("active");
    document.getElementById('empInfoLi').classList.toggle("active");
});

let token = sessionStorage.getItem("token");
if(!token || token == null){
	window.location.href = 'http://localhost:8080/login';
}


var empObj, remObj, remPendObj, usrObj;
//requestUserInfo('http://localhost:8080/Project1/empInfo');
requestEmpInfo();
function requestEmpInfo(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/empInfo';
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Status is 200 and ready state is 4, so I guess it's token time");
			empObj = JSON.parse(xhr.response);
			console.log(empObj);
			requestUserInfo('http://localhost:8080/userInfo');
			//return empObj;
		}
	}
	user = token.split(":")[0];

	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user;
	xhr.send(requestBody);
}




function requestUserInfo(url){
	let xhr = new XMLHttpRequest();
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Status is 200 and ready state is 4, so I guess it's token time");
			console.log(xhr);
			
			usrObj = JSON.parse(xhr.response);
			
			console.log(usrObj);
			//return usrObj;
			requestRemInfo('http://localhost:8080/remInfo');
		}
	}
	user = token.split(":")[0];

	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user;
	xhr.send(requestBody);
}



function requestRemInfo(url){
	let xhr = new XMLHttpRequest();
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Status is 200 and ready state is 4, so I guess it's token time");
			remObj = JSON.parse(xhr.response);
			console.log(remObj);
			//requestRemPend(url+"/pend");
			displayInfo();	
		}
	} 
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "userId="+token.split(":")[1];
	xhr.send(requestBody);
}

function displayInfo(){
	console.log(empObj);
	//emp info
	document.getElementById("fNameView").innerHTML = empObj.firstName;
	document.getElementById("lNameView").innerHTML = empObj.lastName;
	document.getElementById("bdayView").innerHTML = empObj.birthDate;
	document.getElementById("positionView").innerHTML = empObj.position;
	document.getElementById("emailView").innerHTML = empObj.email;

	document.getElementById("fNameIn").value= empObj.firstName;
	document.getElementById("lNameIn").value = empObj.lastName;
	document.getElementById("bDateIn").value = empObj.birthDate;
	document.getElementById("emailIn").value = empObj.email;
	
	//user
	document.getElementById("empIdView").innerHTML = usrObj.employeeId;
	document.getElementById("usernameView").innerHTML = usrObj.username;

	if (document.getElementById("manNameView") != null){
		document.getElementById("manNameView").innerHTML = empObj.managerId;		
	}
	
	let table = document.getElementById('resReqTable');
	let pendTable = document.getElementById('pendReqTable');
	
	pendTable.innerHTML = `<tr><th>ID</th><th>Description</th><th>Amount</th><th>Date Issued</th></tr>`;
	table.innerHTML = `<tr><th>ID</th> <th>Description</th> <th>Amount</th><th>Date Issued</th>\<th>Date Responded</th>\<th>Status</th></tr>`;
	
	let element;
	for(i in remObj){
		if(remObj[i].status === 'Pending'){
			pendTable.innerHTML += 
				`<tr><td>${remObj[i].rem_id}</td><td>${remObj[i].desc}</td><td>$ ${remObj[i].amount}</td><td>${remObj[i].issueDate}</td><td></tr>`
				
		} else {
			table.innerHTML += `<tr><td>${remObj[i].rem_id}</td><td>${remObj[i].desc}</td><td>$ ${remObj[i].amount}</td><td>${remObj[i].issueDate}</td><td>${remObj[i].fulfillDate}</td><td class = '${remObj[i].status}'>${remObj[i].status}</td></tr>`
		}
	}
}
