/**
 * 
 */

document.getElementById("reburseNav").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = true;
    document.getElementById('remInfo').hidden = false;
    document.getElementById('allEmps').hidden = true;
    
	document.getElementById("allRems").style.display = 'none';
	document.getElementById("allEmpRems").style.display = 'none';

 
   document.getElementById('remInfoLi').classList.toggle("active", true);
   document.getElementById('empInfoLi').classList.toggle("active", false);
    document.getElementById('allEmpLi').classList.toggle("active", false);
});

document.getElementById("empInfoNav").addEventListener("click", function(){
	document.getElementById('empInfo').hidden = false;
	document.getElementById('remInfo').hidden = true;
	document.getElementById('allEmps').hidden = true;
	
	document.getElementById("allRems").style.display = 'none';
	document.getElementById("allEmpRems").style.display = 'none';
	
	document.getElementById('remInfoLi').classList.toggle("active", false);
	document.getElementById('empInfoLi').classList.toggle("active", true);
	document.getElementById('allEmpLi').classList.toggle("active", false);
});
document.getElementById("allEmpLi").addEventListener("click", function(){
    document.getElementById('empInfo').hidden = true;
    document.getElementById('remInfo').hidden = true;
    document.getElementById('allEmps').hidden = false;
    
	document.getElementById("allRems").style.display = 'none';
	document.getElementById("allEmpRems").style.display = 'none';

    document.getElementById('remInfoLi').classList.toggle("active", false);
    document.getElementById('empInfoLi').classList.toggle("active", false);
    document.getElementById('allEmpLi').classList.toggle("active", true);
});



document.getElementById("save-admin-req-btn").addEventListener("click", pushToDBADMIN);
document.getElementById("addEmpInfo").addEventListener("click", addingEmployee);
document.getElementById("selectView").addEventListener("change", selectViews);


let token = sessionStorage.getItem("token");
if(!token || token == null){
	window.location.href = 'http://localhost:8080/login';
}

var empObj, remObj, remPendObj, usrObj, allUsrObj, allRemObj;


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
			requestRemInfo();
		}
	}
	user = token.split(":")[0];

	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "username="+user;
	xhr.send(requestBody);
}


function requestRemInfo(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/adminRemReq';
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			remObj = JSON.parse(xhr.response);
			console.log(remObj);
			//displayInfo();
			requestAllUsers();
		}
	} 
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "manId="+token.split(":")[1];
	xhr.send(requestBody);
}

function requestAllUsers(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/allEmps';
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log(xhr);
			
			allUsrObj = JSON.parse(xhr.response);			
			console.log(allUsrObj);
			requestAllRems();
		}
	}
	
	xhr.send();
	
}

function requestAllRems(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/allRems';
	let user;
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log(xhr);
			allRemObj = JSON.parse(xhr.response);			
			console.log(allRemObj);
			displayInfo();
		}
	}
	
	xhr.send();
	
}




function displayInfo(){
	//console.log(empObj);
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
	
	
	drawDefaultTable();
	drawAllTables();
	drawAllRemTable();
}

function drawAllTables(){
	
	let empTable = 	document.getElementById("empTable");
	empTable.innerHTML = `<tr>
			<th>Name</th>
			<th>ID</th>
			<th>Email</th>
			<th>Position</th>
			<th>Manager</th>
		</tr>`;
	
	for(let i = 0; i < allUsrObj.length; i++){
		empTable.innerHTML += `<tr><td>${allUsrObj[i].firstName} ${allUsrObj[i].lastName}</td>
		<td>${allUsrObj[i].id}</td><td>${allUsrObj[i].email}</td><td>${allUsrObj[i].position}</td><td>${allUsrObj[i].managerId}</td></tr>`;
	}
}

function drawAllRemTable(){
	let remAllTable = document.getElementById("allRemTable");
	let exists = [];
	let existsInArr = false;
	remAllTable.innerHTML = `<tr>
		<th>ID</th>
		<th>Amount</th>
		<th>EmpID</th>
		<th>Issue Date</th>
		<th>Fulfill Date</th>
		<th>Man ID</th>
		<th>Status</th>
	</tr>`;
	
	for(let i = 0; i < allRemObj.length; i++){
		existsInArr = false;
		for(let j = 0; j < exists.length; j++){
			if(allRemObj[i].rem_id == exists[j]){
				existsInArr = true;
				break;
			}
		}
		
		if(allRemObj.status != "Pending" && !existsInArr){
			exists.push(allRemObj[i].rem_id);
			remAllTable.innerHTML += `<tr><td>${allRemObj[i].rem_id}</td><td>${allRemObj[i].amount}</td>
				<td>${allRemObj[i].empId}</td><td>${allRemObj[i].issueDate}</td><td>${allRemObj[i].fulfillDate}</td>
				<td>${allRemObj[i].manId}</td><td>${allRemObj[i].status}</td></tr>`;			
		}
	}
}




function approve(id){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/approveRem';
	let user;
	xhr.open("POST", url);
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "remId="+id;
	xhr.send(requestBody);
	
	
	document.getElementById("a"+id).innerHTML = 'Approved';
	document.getElementById("d"+id).innerHTML = 'Deny';
	document.getElementById("d"+id).style.backgroundColor = 'lightgrey';
	document.getElementById("a"+id).style.backgroundColor = 'green';

}


function deny(id){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/denyRem';
	let user;
	xhr.open("POST", url);
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "remId="+id;
	xhr.send(requestBody);
	
	document.getElementById("a"+id).innerHTML = 'Approve';
	document.getElementById("d"+id).innerHTML = 'Denied';
	document.getElementById("a"+id).style.backgroundColor = 'lightgrey';
	document.getElementById("d"+id).style.backgroundColor = 'red';
}



function pushToDBADMIN(){
	document.getElementById("save-admin-req-btn").innerHTML = "Saving...";
	document.getElementById("save-admin-req-btn").style.disabled = true;
	
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/remPush';
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			document.getElementById("save-admin-req-btn").style.disabled = false;
			document.getElementById("save-admin-req-btn").innerHTML = "Save";
			requestRemInfo();
		}
	} 
	
	xhr.send();
	
}


function requestRems(){
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/api/remUpd';
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log(xhr.response);
			remRet = JSON.parse(xhr.response);
			refreshRems();
		}
	} 
	
	xhr.send();
}


function refreshRems(){
	console.log(remRet);
	drawDefaultTable();
}


function drawDefaultTable(){
	console.log(allUsrObj);
	let table = document.getElementById('resReqTable');
	let pendTable = document.getElementById('pendReqTable');
	
	pendTable.innerHTML = `<tr>
							<th>Emp ID</th>
							<th>Description</th>
							<th>Amount</th>
							<th>Date Issued</th>
							<th>ID</th>
							<th colspan=2>Action</th>
						</tr>`;
	table.innerHTML = `<tr>
							<th>Emp ID</th> 
							<th>Description</th> 
							<th>Amount</th>
							<th>ID</th> 
							<th>Date Issued</th>
							<th>Date Responded</th>
							<th>Status</th>
						</tr>`;
	
	let element;
	for(i in remObj){
		if(remObj[i].status === 'Pending'){
			pendTable.innerHTML += 
				`<tr>
					<td>${remObj[i].empId}</td>
					<td>${remObj[i].desc}</td>
					<td>$ ${remObj[i].amount}</td>
					<td>${remObj[i].issueDate}</td>
					<td>${remObj[i].rem_id}</td>
					<td><button id = 'a${remObj[i].rem_id}' onClick = 'approve(${remObj[i].rem_id})' class = 'btn btn-success'>Approve</button></td>
					<td><button id='d${remObj[i].rem_id}' onClick = 'deny(${remObj[i].rem_id})' class = 'btn btn-danger'>Deny</button></td>
				</tr>`;
				
		} else {
			table.innerHTML += `<tr>
									<td>${remObj[i].empId}</td>
									<td>${remObj[i].desc}</td>
									<td>$ ${remObj[i].amount}</td>
									<td>${remObj[i].rem_id}</td>
									<td>${remObj[i].issueDate}</td>
									<td>${remObj[i].fulfillDate}</td>
									<td class = '${remObj[i].status}'>${remObj[i].status}</td>
								</tr>`
		}
	}
}






function addingEmployee(){
	let newEmpObj = {
		fname: document.getElementById("newEmpFName").value,
		lname: document.getElementById("newEmpLName").value,
		bDate: document.getElementById("newEmpBDate").value,
		email: document.getElementById("newEmpEmail").value,
		postition: document.getElementById("newEmpPosition").value
	};
	let newUserObj = {
		username: document.getElementById("newEmpUsername").value,
		password: document.getElementById("newEmpPassword").value,
		manId: document.getElementById("newEmpManagerId").value,
		userRole: document.getElementById("newEmpUserRole").value,
	};
	
	
	console.log(newEmpObj);
	console.log(newUserObj);
	
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/newEmp';
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			
			document.getElementById("newEmpFName").value = "";
			document.getElementById("newEmpLName").value = "";
			document.getElementById("newEmpBDate").value = "";
			document.getElementById("newEmpEmail").value = "";
			document.getElementById("newEmpPosition").value = "";
			document.getElementById("newEmpUsername").value = "";
			document.getElementById("newEmpPassword").value = "";
			document.getElementById("newEmpManagerId").value = "";
			document.getElementById("newEmpUserRole").value = "";
			$('#myModal').modal('hide');

		}
	} 
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let responseBody = "fname="+newEmpObj.fname+"&lname="+newEmpObj.lname+"&bDate="+newEmpObj.bDate+
		"&email="+newEmpObj.email+"&pos="+newEmpObj.position+"&manId="+newEmpObj.manId+"&userRole="+newEmpObj.userRole;
		
	xhr.send(responseBody);
	
}

function selectViews(){
	console.log(document.getElementById("selectView").options[document.getElementById("selectView").selectedIndex].value);
	if(document.getElementById("selectView").options[document.getElementById("selectView").selectedIndex].value == "default"){
	    document.getElementById('requestMain').hidden = false;
		document.getElementById("allRems").style.display = 'none';
		document.getElementById("allEmpRems").style.display = 'none';
		//document.getElementById("allEmpRems").hidden = true;
	} else if (document.getElementById("selectView").options[document.getElementById("selectView").selectedIndex].value == "allReq"){
		document.getElementById("requestMain").hidden = true;//style.display = 'none';
		document.getElementById("allRems").style.display = 'block';
		document.getElementById("allEmpRems").style.display = 'none';
	} 

}




function pushToDb(){
	//document.getElementById("save-req-btn").style.display = 'inline';
	document.getElementById("save-req-btn").innerHTML = "Saving...";
	document.getElementById("save-req-btn").style.disabled = true;
	
	let xhr = new XMLHttpRequest();
	let url = 'http://localhost:8080/remPush';
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			//console.log(xhr.response);
			respond();
		}
	} 
	
	xhr.send();
	
}

function respond(){
	document.getElementById("save-req-btn").style.display = 'none';
	document.getElementById("save-req-btn").style.disabled = false;
	document.getElementById("save-req-btn").innerHTML = "Save";
}







