document.getElementById("sendRequest").addEventListener("click", sendRequest);
document.getElementById("save-req-btn").addEventListener("click", pushToDb);
let remRet;
function sendRequest(){
	
	let url = 'http://localhost:8080/remReq';//req
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url); //POST
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log("Status is 200 and ready state is 4, so I guess it's token time");
			
			document.getElementById("save-req-btn").style.display = "inline";
			requestRems();

		}
	}
	let date = new Date();
	let dateStr = date.getDay() + "-" + date.getMonth()+"-"+date.getYear();
	let amount = document.getElementById("amtInput").value;
	let desc = document.getElementById("descInput").value;
	let empId = empObj.id;
	let manId = empObj.managerId
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	let requestBody = "date="+dateStr+"&amount="+amount+"&desc="+desc+"&empId="+empId+"&manId="+manId;
	xhr.send(requestBody);
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
	let table = document.getElementById('resReqTable');
	let pendTable = document.getElementById('pendReqTable');
	document.getElementById("pendReqTable").innerHTML = `<th>ID</th><th>Description</th><th>Amount</th><th>Date Issued</th>`;
	document.getElementById("resReqTable").innerHTML = `<th>ID</th><th>Description</th><th>Amount</th><th>Date Issued</th><th>Date Responded</th><th>Status</th>`;

	if(remRet != null){
		for(i in remRet){
			console.log(remRet[i]);
			if(remRet[i].status === 'Pending'){
				pendTable.innerHTML += `<tr><td>${remRet[i].rem_id}</td><td>${remRet[i].desc}</td><td>$ ${remRet[i].amount}</td><td>${remRet[i].issueDate}</td></tr>`;
			} else {
				table.innerHTML +=  `<tr><td>${remRet[i].rem_id}</td><td>${remRet[i].desc}</td><td>$ ${remRet[i].amount}</td><td>${remRet[i].issueDate}</td><td>${remRet[i].fulfillDate}</td><td class = '${remRet[i].status}'>${remRet[i].status}</td></tr>`;
			}
		}
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